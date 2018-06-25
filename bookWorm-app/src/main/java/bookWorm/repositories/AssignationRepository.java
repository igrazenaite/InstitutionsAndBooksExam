package bookWorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookWorm.assignation.model.Assignation;

@Repository
public interface AssignationRepository extends JpaRepository<Assignation, Long>{

	Assignation findByAssignationId(long assignationId);

}
