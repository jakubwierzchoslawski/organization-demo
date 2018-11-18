package jw.workshop.spring.organizationservice.application.port.rest;

import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @RequestBody of
 * 
 * {@code OrganizationRESTService :: assignUserToOrganization() POST method }
 * 
 * @author jakub
 *
 */

@NoArgsConstructor
@Data
public class AssignUserToOrganizationReqPayload {
	private UserExt user;
	private OrganizationDO organization;
}
