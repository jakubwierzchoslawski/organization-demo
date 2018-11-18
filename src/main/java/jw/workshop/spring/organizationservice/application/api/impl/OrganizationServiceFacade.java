package jw.workshop.spring.organizationservice.application.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jw.workshop.spring.organizationservice.application.api.OrganizationBusinessService;
import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationEntity;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemEntity;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemRepository;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationRepository;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationType;
import jw.workshop.spring.organizationservice.infrastructure.data.jpa.OrganizationModelMapper;

/**
 * Organization Service Facade.
 * 
 * Can use many Domain Services to fullfil business Use Cases. In this example
 * OrganizationService and OrganizationItemService could be used.
 * 
 * 
 * Implements OrganizationService interface from Domain Model. This one is
 * bounded to JPA (Entities and JPA repositories)
 * 
 * @author jakub
 *
 */

@Service
@Transactional
public class OrganizationServiceFacade implements OrganizationBusinessService {

	@Autowired
	private OrganizationModelMapper<OrganizationDO, OrganizationEntity> modelMapper;

	@Autowired
	private OrganizationRepository orgRepository;

	@Autowired
	private OrganizationItemRepository orgItemRepository;

	@Override
	public OrganizationDO addNewOrganization(OrganizationDO inputData) {
		return modelMapper.mapEntity(orgRepository.store(modelMapper.mapDomain(inputData)));
	}

	@Override
	public List<OrganizationDO> listOrganizatoins() {
		List<OrganizationEntity> orgEntities = new ArrayList<>();
		orgEntities = orgRepository.findAll();

		return modelMapper.mapEntities(orgEntities);
	}

	@Override
	public UserExt assignUserToOrganization(UserExt user, OrganizationDO organization) {

		OrganizationEntity orgEntity = orgRepository.find(organization.getID());
		OrganizationItemEntity userOrganizationItem = new OrganizationItemEntity();

		userOrganizationItem.setCustomerID(user.getExternalUserID());
		userOrganizationItem.setOrganization(orgEntity);
		userOrganizationItem.setType(OrganizationType.BRANCH);

		orgItemRepository.save(userOrganizationItem);

		user.getOrganizations().add(modelMapper.mapEntity(orgEntity));

		return user;
	}

}
