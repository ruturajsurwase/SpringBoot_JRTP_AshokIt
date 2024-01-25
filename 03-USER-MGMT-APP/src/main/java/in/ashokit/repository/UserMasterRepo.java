package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.bindings.User;
import in.ashokit.enitity.UserMaster;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster,Integer> 
{

	public UserMaster findByEmail(String email);

	

	
	
	
	
}
