package in.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.DcCaseEntity;

@Repository
public interface DcCaseRepo extends JpaRepository<DcCaseEntity, Serializable> 
{

	
        public DcCaseEntity findByAppId(Integer appId);
	
}
