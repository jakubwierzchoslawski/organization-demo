package jw.workshop.spring.organizationservice.infrastructure.data.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Repository;

import jw.workshop.spring.organizationservice.domain.model.OrganizationItemRepository;
import jw.workshop.spring.organizationservice.domain.model.ext.UserExt;
import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationItemEntity;

/**
 * Repository JPA implementation
 * 
 * @author jakub
 *
 */


@Repository
public class JPAOrganizationItemRepository implements OrganizationItemRepository {

	private static final Logger logger = Logger.getLogger(JPAOrganizationItemRepository.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public OrganizationItemEntity save(OrganizationItemEntity entity) {
		entityManager.persist(entity);
		entityManager.flush();
		
		return entity;

	}

	@Override
	public OrganizationItemEntity find(Long ID) {
		OrganizationItemEntity organizationItem;

		try {
			organizationItem = entityManager.find(OrganizationItemEntity.class, ID);
		} catch (NoResultException e) {
			logger.log(Level.FINE, "Find called on non-existant organizationItem ID.", e);
			organizationItem = null;
		}

		return organizationItem;
	}

	@Override
	public List<OrganizationItemEntity> findAll() {
		List<OrganizationItemEntity> items = entityManager.createNamedQuery("OrganizationItem.findAll", OrganizationItemEntity.class).getResultList();
		
		return items;
	}

	@Override
	public void deleteAll(Iterable<OrganizationItemEntity> entities) {
		throw new NotYetImplementedException();
	}

	@Override
	public Set<OrganizationItemEntity> getUserOrganizationItems(UserExt user) {
		throw new NotYetImplementedException();
	}

}
