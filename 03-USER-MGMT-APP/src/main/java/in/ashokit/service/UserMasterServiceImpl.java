package in.ashokit.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.ashokit.bindings.ActivateAccount;
import in.ashokit.bindings.Login;
import in.ashokit.bindings.User;
import in.ashokit.enitity.UserMaster;
import in.ashokit.repository.UserMasterRepo;
import in.ashokit.utils.EmailUtils;

@Service
public class UserMasterServiceImpl implements UserMgmtService {

	private Logger  logger = LoggerFactory.getLogger(UserMasterServiceImpl.class);
	
	@Autowired
	private UserMasterRepo userMasterRepo;

	@Autowired
	private EmailUtils emailUtils;
	
	private Random random = new Random();

	@Override
	public boolean saveUser(User user) {
		UserMaster entity = new UserMaster();
		BeanUtils.copyProperties(user, entity);

		entity.setPassword(generateRandomPwd());
		entity.setAccStatus("IN-ACTIVE");

		UserMaster save = userMasterRepo.save(entity);

		String subject = "your registation success";
		String filename = "REG-EMAIL_BODY";
		String body = null;

		try {
			body = readEmailBody(entity.getFullName(), entity.getPassword(), filename);
			emailUtils.sendeMail(user.getEmail(), subject, body);
		} 
		catch (Exception e) 
		{
			 logger.error("Exception occured" ,e);
		}

		emailUtils.sendeMail(user.getEmail(), subject, body);

		return save.getUserId() != null;
	}

	@Override
	public boolean activateUserAcc(ActivateAccount activateAccount) {
		UserMaster entity = new UserMaster();

		entity.setEmail(activateAccount.getEmail());
		entity.setPassword(activateAccount.getTempPwd());

		Example<UserMaster> xx = Example.of(entity);

		List<UserMaster> findAll = userMasterRepo.findAll(xx);

		if (findAll.isEmpty()) {
			return false;
		} else {
			UserMaster userMaster = findAll.get(0);
			userMaster.setPassword(activateAccount.getConfirmPwd());
			userMaster.setAccStatus("ACTIVATED");
			userMasterRepo.save(userMaster);
			return true;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<UserMaster> findAll = userMasterRepo.findAll();

		List<User> users = new ArrayList<>();

		for (UserMaster entity : findAll) {
			User u = new User();
			BeanUtils.copyProperties(entity, u);
			users.add(u);
		}

		return users;
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<UserMaster> findById = userMasterRepo.findById(userId);
		if (findById.isPresent()) {
			User user = new User();
			UserMaster userMaster = findById.get();
			BeanUtils.copyProperties(userMaster, user);
			return user;
		}
		return null;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		try {
			userMasterRepo.deleteById(userId);
			return true;
		} catch (Exception e) 
		{
			 logger.error("Exception occured" ,e);
		}

		return false;
	}

	@Override
	public boolean changeAccontStatus(Integer userId, String accStatus) {
		Optional<UserMaster> findById = userMasterRepo.findById(userId);
		if (findById.isPresent()) {
			UserMaster userMaster = findById.get();
			userMaster.setAccStatus(accStatus);
			userMasterRepo.save(userMaster);
			return true;
		}
		return false;
	}

	@Override
	public String login(Login login) {
		String email = login.getEmail();
		String password = login.getPassword();

		UserMaster entity = new UserMaster();
		entity.setEmail(login.getEmail());
		entity.setPassword(login.getPassword());

		Example<UserMaster> of = Example.of(entity);

		List<UserMaster> findAll = userMasterRepo.findAll(of);

		if (findAll.isEmpty()) {
			return "INVALID CREDINTIALS";
		} else {
			UserMaster userMaster = findAll.get(0);
			if (userMaster.getAccStatus().equals("ACTIVATED")) {
				return "SUCCSESS";
			} else {
				return "Account not ACTIVATED";
			}
		}

	}

	@Override
	public String forgetPassword(String email) throws IOException {
		UserMaster findByEmail = userMasterRepo.findByEmail(email);

		if (findByEmail == null) {
			return "Invalid email";
		}

		String subject = "FORGET PASSWORD";
		String filename = "RECOVER-PWD.txt";
		String body = readEmailBody(findByEmail.getEmail(), findByEmail.getPassword(), filename);
		boolean sendeMail = emailUtils.sendeMail(filename, subject, body);
		if (sendeMail) {
			return "password send to email";
		}
		return null;
	}

	private String generateRandomPwd() 
	{
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		StringBuilder sb = new StringBuilder();
		
		int length = 6;

		for (int i = 0; i < length; i++) {
			int index = this.random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}

		return sb.toString();

	}

	public String readEmailBody(String fullname, String pwd, String filename) 
	{

		String mailBody = null;
		String url = "";
	
		try (FileReader fr = new FileReader(filename);BufferedReader br = new BufferedReader(fr);)
		{
	
			StringBuffer buffer = new StringBuffer();
			String line = br.readLine();

			while (line != null)
			{
				buffer.append(line);
				line = br.readLine();
			}
			
			br.close();
			mailBody = buffer.toString();
			mailBody = mailBody.replace("{FULLNAME}", fullname);
			mailBody = mailBody.replace("{TEMP-PWD}", pwd);
			mailBody = mailBody.replace("{URL}", url);
			mailBody = mailBody.replace("{PWD}", pwd);
		}
		catch (Exception e) 
		{
			 logger.error("Exception occured" ,e);
		} 
	return mailBody;
	}

}
