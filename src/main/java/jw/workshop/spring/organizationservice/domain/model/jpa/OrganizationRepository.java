package jw.workshop.spring.organizationservice.domain.model.jpa;

import java.util.List;

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
public interface OrganizationRepository {

	OrganizationEntity find(Long id);

	List<OrganizationEntity> findAll();

	OrganizationEntity store(OrganizationEntity entity);
}
