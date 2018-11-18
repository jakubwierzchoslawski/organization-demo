package jw.workshop.spring.organizationservice.domain.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

/**
 * Domain object. Should contain business domain logic (not application logic)
 * 
 * @author jakub
 *
 */

@Data
public class OrganizationDO {
	private Long ID;
	private String name;
	private Long externalId;
	private Set<OrganizationItemDO> organizationItems;

	private OrganizationDO() {
		this.organizationItems = new HashSet<>();
	}

}
