package jw.workshop.spring.organizationservice.domain.model.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrganizationItem - link between organization and user/customer
 * 
 * @author jakub
 *
 */

@Data
@Entity
@Table(name = "ORGANIZATION_ITEM")
@NoArgsConstructor
@NamedQueries({ @NamedQuery(name = "OrganizationItem.findAll", query = "Select oi from OrganizationItemEntity oi") })
public class OrganizationItemEntity extends BaseEntity<OrganizationItemEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OrganizationType type;
	private Long customerID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORGANIZATION_ID")
	private OrganizationEntity organization;

}
