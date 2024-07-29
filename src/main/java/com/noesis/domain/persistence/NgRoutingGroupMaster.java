package com.noesis.domain.persistence;
// Generated 18 Dec, 2018 8:18:51 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NgRoutingGroupMaster generated by hbm2java
 */
@Entity
@Table(name = "ng_routing_group_master", catalog = "genesis")
public class NgRoutingGroupMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String groupName;
	private String submitterQueueName;
	private int userId;
	private int failOverGroupId;

	public NgRoutingGroupMaster() {
	}

	public NgRoutingGroupMaster(int id, String groupName, String submitterQueueName, int userId, int failOverGroupId) {
		this.id = id;
		this.groupName = groupName;
		this.submitterQueueName = submitterQueueName;
		this.userId = userId;
		this.failOverGroupId = failOverGroupId;
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

	@Column(name = "group_name", nullable = false, length = 100)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "submitter_queue_name", nullable = false, length = 150)
	public String getSubmitterQueueName() {
		return this.submitterQueueName;
	}

	public void setSubmitterQueueName(String submitterQueueName) {
		this.submitterQueueName = submitterQueueName;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "fail_over_routing_group", nullable = false)
	public int getFailOverGroupId() {
		return failOverGroupId;
	}

	public void setFailOverGroupId(int failOverGroupId) {
		this.failOverGroupId = failOverGroupId;
	}

	
	
}
