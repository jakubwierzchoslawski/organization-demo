package jw.workshop.spring.organizationservice.domain.model.ext;

import java.util.HashSet;
import java.util.Set;

import jw.workshop.spring.organizationservice.domain.model.OrganizationDO;
import lombok.Getter;
import lombok.Setter;

/**
 * Objects used within Organization BC but managed primary by other BCs
 * 
 * @author jakub
 *
 */

@Setter
@Getter
public class UserExt {

	private Long ID;
	private Long externalUserID;
	private String name;

	private Set<OrganizationDO> organizations;

	public UserExt() {
		this.organizations = new HashSet<>();
	}
}
