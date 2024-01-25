package in.ashokit.service;

import java.io.IOException;
import java.util.List;


import in.ashokit.bindings.ActivateAccount;
import in.ashokit.bindings.Login;
import in.ashokit.bindings.User;

public interface UserMgmtService 
{

	
	public boolean saveUser(User user);

	public boolean activateUserAcc(ActivateAccount activateAccount);
	
	public User getUserById(Integer userId);
	
	public List<User> getAllUsers();
	
	public boolean deleteUserById(Integer userId);
	
	public boolean changeAccontStatus(Integer userId,String accStatus);
	
	public String login(Login login);
	
	public String forgetPassword(String email) throws IOException;
	
	
}
