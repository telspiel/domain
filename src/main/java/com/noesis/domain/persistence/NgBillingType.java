package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * NgBillingType generated by hbm2java
 */
@Entity
@Table(name = "ng_billing_type", catalog = "genesis")
public class NgBillingType implements java.io.Serializable {

	private static final long serialVersionUID = -2964006900003672271L;
	private int id;
	private String type;
	private String displayName;
	private String description;
	private Set<NgOrganisation> ngOrganisations = new HashSet<NgOrganisation>(0);

	public NgBillingType() {
	}

	public NgBillingType(int id) {
		this.id = id;
	}

	public NgBillingType(int id, String type, String displayName, String description,
			Set<NgOrganisation> ngOrganisations) {
		this.id = id;
		this.type = type;
		this.displayName = displayName;
		this.description = description;
		this.ngOrganisations = ngOrganisations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "display_name", length = 45)
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ngBillingType")
	public Set<NgOrganisation> getNgOrganisations() {
		return this.ngOrganisations;
	}

	public void setNgOrganisations(Set<NgOrganisation> ngOrganisations) {
		this.ngOrganisations = ngOrganisations;
	}

}
