package com.noesis.domain.persistence;
// Generated 31 Jul, 2018 12:08:37 AM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgQueueDetails generated by hbm2java
 */
@Entity
@Table(name = "ng_queue_details", catalog = "genesis")
public class NgQueueDetails implements java.io.Serializable {

	private static final long serialVersionUID = -6860253616786202698L;
	private int id;
	private String queueName;
	private String queueDesc;

	public NgQueueDetails() {
	}

	public NgQueueDetails(int id) {
		this.id = id;
	}

	public NgQueueDetails(int id, String queueName, String queueDesc) {
		this.id = id;
		this.queueName = queueName;
		this.queueDesc = queueDesc;
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

	@Column(name = "queue_name", length = 45)
	public String getQueueName() {
		return this.queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Column(name = "queue_desc", length = 45)
	public String getQueueDesc() {
		return this.queueDesc;
	}

	public void setQueueDesc(String queueDesc) {
		this.queueDesc = queueDesc;
	}

}
