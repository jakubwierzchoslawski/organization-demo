package jw.workshop.spring.organizationservice.infrastructure.data.jpa;

import java.util.List;

/**
 * Organization mapper inteface. It can be a part of COMMON library.
 * 
 * Domain to Entity :: Entity to Domain. Also Collection of domain/entity
 * objects are handled
 * 
 * @author jakub
 *
 * @param <D> domain object
 * @param <E> entity object
 */

public interface OrganizationModelMapper<D, E> {

	D mapEntity(E entity);

	E mapDomain(D domain);

	List<D> mapEntities(List<E> entities);

	List<E> mapDomains(List<D> domains);

}
