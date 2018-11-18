package jw.workshop.spring.organizationservice.infrastructure.data.jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jw.workshop.spring.organizationservice.domain.model.OrganizationRepository;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationEntity;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemEntity;

/**
 * Repository JPA implementation.
 * 
 * @author jakub
 *
 */


@Repository
public class JPAOrganizationRepository implements OrganizationRepository {

	private static final Logger logger = Logger.getLogger(JPAOrganizationRepository.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public OrganizationEntity find(Long id) {
		OrganizationEntity organization;

		try {
			organization = entityManager.find(OrganizationEntity.class, id);
		} catch (NoResultException e) {
			logger.log(Level.FINE, "Find called on non-existant organization ID.", e);
			organization = null;
		}

		return organization;
	}

	@Override
	public List<OrganizationEntity> findAll() {
		return entityManager.createNamedQuery("Organization.findAll", OrganizationEntity.class).getResultList();
	}

	@Override
	public OrganizationEntity store(OrganizationEntity entity) {
		if (entity.getOrganizationItems() != null) {
			for (OrganizationItemEntity item : entity.getOrganizationItems()) {
				entityManager.persist(item);
			}
		}

		entityManager.persist(entity);
		entityManager.flush();

		return entity;

	}

}
