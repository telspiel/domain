package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NgUserTemplateMap generated by hbm2java
 */
@Entity
@Table(name = "ng_user_template_map", catalog = "genesis")
public class NgUserTemplateMap implements java.io.Serializable {

	private static final long serialVersionUID = 5084918899285140047L;
	private int id;
	private NgMessageType ngMessageType;
	private NgUser ngUser;
	private String template;

	public NgUserTemplateMap() {
	}

	public NgUserTemplateMap(int id) {
		this.id = id;
	}

	public NgUserTemplateMap(int id, NgMessageType ngMessageType, NgUser ngUser, String template) {
		this.id = id;
		this.ngMessageType = ngMessageType;
		this.ngUser = ngUser;
		this.template = template;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_type")
	public NgMessageType getNgMessageType() {
		return this.ngMessageType;
	}

	public void setNgMessageType(NgMessageType ngMessageType) {
		this.ngMessageType = ngMessageType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public NgUser getNgUser() {
		return this.ngUser;
	}

	public void setNgUser(NgUser ngUser) {
		this.ngUser = ngUser;
	}

	@Column(name = "template", length = 1000)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
