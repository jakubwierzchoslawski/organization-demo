package jw.workshop.spring.organizationservice.infrastructure.data.jpa;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationEntity;

/**
 * ModelMapper LIBRARY used from modelmapper.org. Can be replaced or used in
 * parallel by other third party libraries.
 * 
 * @author jakub
 *
 */

@Service
public class JPAOrganizationModelMapper implements OrganizationModelMapper<OrganizationDO, OrganizationEntity> {

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public OrganizationDO mapEntity(OrganizationEntity entity) {
		return modelMapper.map(entity, OrganizationDO.class);
	}

	@Override
	public OrganizationEntity mapDomain(OrganizationDO domain) {
		return modelMapper.map(domain, OrganizationEntity.class);
	}

	@Override
	public List<OrganizationDO> mapEntities(List<OrganizationEntity> entities) {
		List<OrganizationDO> domains = new ArrayList<>();

		for (OrganizationEntity orgEntity : entities) {
			domains.add(mapEntity(orgEntity));
		}

		return domains;
	}

	@Override
	public List<OrganizationEntity> mapDomains(List<OrganizationDO> domains) {
		List<OrganizationEntity> entities = new ArrayList<>();

		for (OrganizationDO orgDO : domains) {
			entities.add(mapDomain(orgDO));
		}

		return entities;
	}
}
