package bookWorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookWorm.assignation.model.AddAssignation;
import bookWorm.assignation.model.Assignation;
import bookWorm.assignation.model.AssignationForClient;
import bookWorm.repositories.AssignationRepository;

@Transactional
@Service
public class AssignationService {

	@Autowired
	private AssignationRepository assignationRepo;

	public List<AssignationForClient> receiveAllAssignations() {
		List<Assignation> assignationsFromDatabase = getAssignationRepo().findAll();
		List<AssignationForClient> assignationsForClient = assignationsFromDatabase.stream().map((assignation) -> {
			AssignationForClient assgn = new AssignationForClient();
			assgn.setAssignationId(assignation.getAssignationId());
			assgn.setPrice(assignation.getPrice());
			assgn.setCondition(assignation.getCondition());
			assgn.setQuantity(assignation.getQuantity());
			// instABook.setOwnerId(institution.getOwner().getOwnerId());
			// instABook.setStorageId(institution.getStorageFacility().getStorageId());
			return assgn;
		}).collect(Collectors.toList());
		return assignationsForClient;
	}

	public AssignationForClient receiveAssignationInfo(long assignationId) {
		Assignation assignation = assignationRepo.findByAssignationId(assignationId);
		AssignationForClient assgn = new AssignationForClient();
		assgn.setAssignationId(assignation.getAssignationId());
		assgn.setPrice(assignation.getPrice());
		assgn.setCondition(assignation.getCondition());
		assgn.setQuantity(assignation.getQuantity());
		// instAbook.setOwnerId(institution.getOwner().getOwnerId());
		// instAbook.setStorageId(institution.getStorageFacility().getStorageId());
		return assgn;
	}

	public void addNewAssignation(AddAssignation newAssignation/* , long ownerId, long storageId */) {
		Assignation assignation = new Assignation();
		assignation.setPrice(newAssignation.getPrice());
		assignation.setCondition(newAssignation.getCondition());
		assignation.setQuantity(newAssignation.getQuantity());
		// Owner owner = ownerRepository.findByOwnerId(ownerId);
		// institution.setOwner(owner);
		// Storage storageFacility = storageRepository.findByStorageId(storageId);
		// institution.setStorageFacility(storageFacility);
		assignationRepo.save(assignation);
	}

	public void updateAssignation(Assignation assignation, Long assignationId/* , long ownerId, long storageId */) {
		Assignation assgn = assignationRepo.findOne(assignationId);
		assgn.setPrice(assignation.getPrice());
		assgn.setCondition(assignation.getCondition());
		assgn.setQuantity(assignation.getQuantity());
		// Owner owner = ownerRepository.findByOwnerId(ownerId);
		// inst.setOwner(owner);
		// Storage storageFacility = storageRepository.findByStorageId(storageId);
		// inst.setStorageFacility(storageFacility);
		assignationRepo.save(assgn);
	}

	public void deleteAssignation(Long assignationId) {
		assignationRepo.delete(assignationId);
	}

	public AssignationRepository getAssignationRepo() {
		return assignationRepo;
	}

	public void setAssignationRepo(AssignationRepository assignationRepo) {
		this.assignationRepo = assignationRepo;
	}

}
