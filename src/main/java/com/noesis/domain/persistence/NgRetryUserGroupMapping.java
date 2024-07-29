package com.noesis.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ng_retry_user_group_mapping", catalog = "genesis")
public class NgRetryUserGroupMapping implements java.io.Serializable {
	
	private int id;
	private int userId;
	private int groupId;
	private int priority;
	
	public NgRetryUserGroupMapping( ) {
		
	}
	
	public NgRetryUserGroupMapping(int id, int userId, int groupId, int priority) {
		
		this.id = id;
		this.userId = userId;
		this.groupId = groupId;
		this.priority = priority;
	}
	
	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "user_id", nullable = false)
	public int getuserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "group_id", nullable = false)
	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	@Column(name = "priority", nullable = false)
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
