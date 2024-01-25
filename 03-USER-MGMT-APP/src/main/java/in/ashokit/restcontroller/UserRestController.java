package in.ashokit.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ActivateAccount;
import in.ashokit.bindings.Login;
import in.ashokit.bindings.User;
import in.ashokit.service.UserMgmtService;

@RestController
public class UserRestController
{

	@Autowired
	private UserMgmtService userMgmtService;
	
	
	@PostMapping("/user")
	public ResponseEntity<String> userReg(@RequestBody User user)
	{
		boolean saveUser = userMgmtService.saveUser(user);
		
		if(saveUser)
		{
			return new ResponseEntity<>("Registration Success", HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/activate")
	public ResponseEntity<String>  activateAcc(@RequestBody ActivateAccount activateAccount)
	{
		
		boolean activateUserAcc = userMgmtService.activateUserAcc(activateAccount);
		
		if(activateUserAcc)
		{
			return new ResponseEntity<>("Account Activated", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Invalid temp pass", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		
		List<User> allUsers = userMgmtService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getuserById(@PathVariable Integer userId)
	{
		User userById = userMgmtService.getUserById(userId);
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId)
	{
		boolean isDeleted = userMgmtService.deleteUserById(userId);
		if(isDeleted)
		{
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/status/{userId}/{status}")
	public ResponseEntity<String> statuschange(@PathVariable Integer userId,@PathVariable String status)
	{
		boolean isChangeAccontStatus = userMgmtService.changeAccontStatus(userId, status);
		if(isChangeAccontStatus)
		{
			return new ResponseEntity<>("status changed", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("failed to change", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login login)
	{
		String status = userMgmtService.login(login);
		return  new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@GetMapping("/forgetpasswoed/{email}")
	public ResponseEntity<String> forgetPassword(@PathVariable String email) throws IOException
	{
		String status = userMgmtService.forgetPassword(email);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	
	
	
	
	
}
