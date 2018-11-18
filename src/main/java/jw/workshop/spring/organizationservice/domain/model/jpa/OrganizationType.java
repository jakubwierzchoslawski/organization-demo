package jw.workshop.spring.organizationservice.domain.model.jpa;

/**
 * Type of Organization. In general one table is used for Organization definiton
 * by itself and for branches definition as well. This type is used to
 * distinguish what we are retrieving within the records retrieved from DB
 * 
 * @author jakub
 *
 */

public enum OrganizationType {

	BRANCH("BRANCH");

	private final String type;

	OrganizationType(String type) {
		this.type = type;
	}

	String getType() {
		return this.type;
	}
}
