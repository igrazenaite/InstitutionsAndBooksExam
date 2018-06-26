package bookWorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bookWorm.institution.model.AddInstitution;
import bookWorm.institution.model.Institution;
import bookWorm.institution.model.InstitutionForClient;
import bookWorm.services.InstitutionService;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins="*")
public class InstitutionController {

	@Autowired 
	private InstitutionService institutionService;

	// get all institutions
	@RequestMapping(value = "/institutions", method = RequestMethod.GET)
	public List<InstitutionForClient> giveAllInstitutions() {
		return getInstitutionService().receiveAllInstitutions();
	}

	// get one institution
	@RequestMapping(value = "/singleInstitution/{institutionId}", method = RequestMethod.GET)
	public InstitutionForClient giveSingleInstitution(@PathVariable("institutionId") final Long institutionId) {
		return getInstitutionService().receiveInstitutionInfo(institutionId);
	}

	// create new institution
	@RequestMapping(value = "/newInstitution"/*/{assignationId}"*/, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createInstitution(@RequestBody final AddInstitution newInstitution/*, @PathVariable(value = "assignationId") long assignationId*/) {
		institutionService.addNewInstitution(newInstitution/*, assignationId*/);
	}

	// update institution
	@RequestMapping(path = "/singleInstitution/update/{institutionId}/{assignationId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateExistingInstitution(@RequestBody final Institution institution, @PathVariable final Long institutionId,
			@PathVariable(value = "assignationId") long assignationId) {
		institutionService.updateInstitution(institution, institutionId, assignationId);
	}

	// delete institution
	@RequestMapping(path = "/institution/delete/{institutionId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteInstitutionFromDatabase(@PathVariable final Long institutionId) {
		institutionService.deleteInstitution(institutionId);
	}
	
	public InstitutionService getInstitutionService() {
		return institutionService;
	}

	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	
}
