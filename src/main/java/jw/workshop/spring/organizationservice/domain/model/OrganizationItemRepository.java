package jw.workshop.spring.organizationservice.domain.model;

import java.util.List;
import java.util.Set;

import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemEntity;

/**
 * JPA domain repositories. In theory it should be infrastructure unrelated
 * (Entity). But as application in normal condition is never switched from
 * relational data model to other its safe to keep those interfaces here.
 * 
 * In general DO object should be used for Repository to keep it technology
 * agnostic.
 * 
 * @author jakub
 *
 */

public interface OrganizationItemRepository {

	// generic operations
	OrganizationItemEntity save(OrganizationItemEntity entity);

	OrganizationItemEntity find(Long ID);

	List<OrganizationItemEntity> findAll();

	void deleteAll(Iterable<OrganizationItemEntity> entities);

	// organization specific operations
	Set<OrganizationItemEntity> getUserOrganizationItems(UserExt user);

}
