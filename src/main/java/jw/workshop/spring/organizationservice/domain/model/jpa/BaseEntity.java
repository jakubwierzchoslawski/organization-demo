package jw.workshop.spring.organizationservice.domain.model.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base entity class for ORM.
 * 
 * It make sense to keep it in model for workshop - as long as application is
 * based on RDBMs. When working with Document DBs plain domain object (DO) model
 * will be sufficient. Then entities should be moved to infrastructure
 * data.jpa.entities and mapped there to DO an vice versa.
 * 
 * Implementation for different providers can be switched.
 * 
 * @author jakub
 *
 * @param <T>
 */

@NoArgsConstructor
@MappedSuperclass
@Data
class BaseEntity<T extends BaseEntity<T>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

}
