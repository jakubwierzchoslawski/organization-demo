package jw.workshop.spring.organizationservice.domain.model;

import jw.workshop.spring.organizationservice.domain.model.jpa.OrganizationType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object. Should contain business domain logic (anti-pattern: "Anemic
 * model" - questionable in my opinion but thats how DDD name it)
 * 
 * @author jakub
 *
 */

@NoArgsConstructor
@Data
public class OrganizationItemDO {
	private Long ID;
	private OrganizationType type;
	private Long customerID;
	private OrganizationDO organization;

}
