package jw.workshop.spring.organizationservice.application.api;

import java.util.List;

import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;

/**
 * Business service.
 * 
 * @author jakub
 *
 */

public interface OrganizationBusinessService {

	OrganizationDO addNewOrganization(OrganizationDO inputData);

	UserExt assignUserToOrganization(UserExt user, OrganizationDO organization);

	List<OrganizationDO> listOrganizatoins();

}
