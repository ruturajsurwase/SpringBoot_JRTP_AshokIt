package in.ashokit.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.DcChildrenEntity;

@Repository
public interface DcChildrenRepo extends JpaRepository<DcChildrenEntity,Serializable>
{
public List<DcChildrenEntity> findByCaseNumber(long caseNumber);
}
