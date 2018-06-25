package bookWorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bookWorm.assignation.model.AddAssignation;
import bookWorm.assignation.model.Assignation;
import bookWorm.assignation.model.AssignationForClient;
import bookWorm.services.AssignationService;

@RestController
public class AssignationController {

	@Autowired
	private AssignationService assignationService;

	// get all assignations
	@RequestMapping(value = "/assignedBooks", method = RequestMethod.GET)
	public List<AssignationForClient> giveAllAssignations() {
		return getAssignationService().receiveAllAssignations();
	}

	// get one assignation
	@RequestMapping(value = "/singleAssignation/{assignationId}", method = RequestMethod.GET)
	public AssignationForClient giveSingleAssignation(@PathVariable("assignationId") final Long assignationId) {
		return getAssignationService().receiveAssignationInfo(assignationId);
	}

	// create new assignation
	@RequestMapping(value = "/newAssignation"/*/{ownerId}/{storageId}"*/, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createAssignation(@RequestBody final AddAssignation newAssignation/*, @PathVariable(value = "ownerId") long ownerId,
			@PathVariable(value = "storageId") long storageId*/) {
		assignationService.addNewAssignation(newAssignation/*, ownerId, storageId*/);
	}

	// update assignation
	@RequestMapping(path = "/singleAssignation/update/{assignationId}"/*/{ownerId}/{storageId}"*/, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateExistingAssignation(@RequestBody final Assignation assignation, @PathVariable final Long assignationId/*,
			@PathVariable(value = "ownerId") long ownerId, @PathVariable(value = "storageId") long storageId*/) {
		assignationService.updateAssignation(assignation, assignationId/*, ownerId, storageId*/);
	}

	// delete assignation
	@RequestMapping(path = "/book/delete/{assignationId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAssignationFromDatabase(@PathVariable final Long assignationId) {
		assignationService.deleteAssignation(assignationId);
	}
	
	public AssignationService getAssignationService() {
		return assignationService;
	}

	public void setAssignationService(AssignationService assignationService) {
		this.assignationService = assignationService;
	}
	
}
