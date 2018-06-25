package bookWorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookWorm.assignation.model.Assignation;
import bookWorm.institution.model.AddInstitution;
import bookWorm.institution.model.Institution;
import bookWorm.institution.model.InstitutionForClient;
import bookWorm.repositories.AssignationRepository;
import bookWorm.repositories.InstitutionRepository;

@Transactional
@Service
public class InstitutionService {

	@Autowired
	private InstitutionRepository institutionRepo;

	@Autowired
	private AssignationRepository assignationRepo;

	public List<InstitutionForClient> receiveAllInstitutions() {
		List<Institution> institutionsFromDatabase = getInstitutionRepo().findAll();
		List<InstitutionForClient> institutionsForClient = institutionsFromDatabase.stream().map((institution) -> {
			InstitutionForClient inst = new InstitutionForClient();
			inst.setInstitutionId(institution.getInstitutionId());
			inst.setInstitutionName(institution.getInstitutionName());
			inst.setCity(institution.getCity());
			inst.setCategory(institution.getCategory());
			inst.setInstitutionType(institution.getInstitutionType());
			inst.setSubcategory(institution.getSubcategory());
			//inst.setAssignationId(institution.getAssignation().getAssignationId());
			return inst;
		}).collect(Collectors.toList());
		return institutionsForClient;
	}

	public InstitutionForClient receiveInstitutionInfo(long institutionId) {
		Institution institution = institutionRepo.findByInstitutionId(institutionId);
		InstitutionForClient inst = new InstitutionForClient();
		inst.setInstitutionId(institution.getInstitutionId());
		inst.setInstitutionName(institution.getInstitutionName());
		inst.setCity(institution.getCity());
		inst.setCategory(institution.getCategory());
		inst.setInstitutionType(institution.getInstitutionType());
		inst.setSubcategory(institution.getSubcategory());
		inst.setAssignationId(institution.getAssignation().getAssignationId());
		return inst;
	}

	public void addNewInstitution(AddInstitution newInstitution/*, long assignationId*/) {
		Institution institution = new Institution();
		institution.setInstitutionName(newInstitution.getInstitutionName());
		institution.setCity(newInstitution.getCity());
		institution.setCategory(newInstitution.getCategory());
		institution.setInstitutionType(newInstitution.getInstitutionType());
		institution.setSubcategory(newInstitution.getSubcategory());
		// Assignation assignation = assignationRepo.findByAssignationId(assignationId);
		// institution.setAssignation(assignation);
		institutionRepo.save(institution);
	}

	public void updateInstitution(Institution institution, Long institutionId, long assignationId) {
		Institution inst = institutionRepo.findOne(institutionId);
		inst.setInstitutionName(institution.getInstitutionName());
		inst.setCity(institution.getCity());
		inst.setCategory(institution.getCategory());
		inst.setInstitutionType(institution.getInstitutionType());
		inst.setSubcategory(institution.getSubcategory());
		Assignation assignation = assignationRepo.findByAssignationId(assignationId);
		inst.setAssignation(assignation);
		institutionRepo.save(inst);
	}

	public void deleteInstitution(Long institutionId) {
		institutionRepo.delete(institutionId);
	}

	public InstitutionRepository getInstitutionRepo() {
		return institutionRepo;
	}

	public void setInstitutionRepo(InstitutionRepository institutionRepo) {
		this.institutionRepo = institutionRepo;
	}

	public AssignationRepository getAssignationRepo() {
		return assignationRepo;
	}

	public void setAssignationRepo(AssignationRepository assignationRepo) {
		this.assignationRepo = assignationRepo;
	}

}
