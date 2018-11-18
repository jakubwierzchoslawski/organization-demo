package jw.workshop.spring.organizationservice.domain.model.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Core service entity with relation to OrganizationItem entity. For demo
 * purpose switched to FetchType.EAGER
 * 
 * @author jakub
 *
 */

@Data
@Entity
@Table(name = "ORGANIZATION")
@NamedQueries({ @NamedQuery(name = "Organization.findAll", query = "Select o from OrganizationEntity o") })
public class OrganizationEntity extends BaseEntity<OrganizationEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private Long externalId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // (mappedBy = "organization")
	@JoinTable(name = "ORG_ORGITEMS", joinColumns = {
			@JoinColumn(name = "ORG_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ORG_ITEM_ID", referencedColumnName = "ID", unique = true) })
	private Set<OrganizationItemEntity> organizationItems;

	public OrganizationEntity() {
		this.organizationItems = new HashSet<>();
	}

}
