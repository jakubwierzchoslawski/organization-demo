package jw.workshop.spring.organizationservice.application.port.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jw.workshop.spring.organizationservice.application.api.OrganizationBusinessService;
import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;


/**
 * Organization Service REST controller
 * 
 * @author jakub
 *
 */

@RestController
@RequestMapping("/org")
public class OrganizationRESTService{
	
	@Autowired
	private OrganizationBusinessService orgService;

	@PostMapping("/organizaton/user")
	public UserExt assignUserToOrganization(@RequestBody AssignUserToOrganizationReqPayload requestPayload) {
		return orgService.assignUserToOrganization(requestPayload.getUser(), requestPayload.getOrganization());
	}
	
	
	@PostMapping("/organization")
	public OrganizationDO addNewOrganization(@RequestBody OrganizationDO newOrganization) {
		return orgService.addNewOrganization(newOrganization);
	}


	@GetMapping("/organizations")
	public List<OrganizationDO> listOrganizatoins() {
		return orgService.listOrganizatoins();
	}

}
