package bookWorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookWorm.institution.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long>{

	Institution findByInstitutionId(long institutionId);
}
