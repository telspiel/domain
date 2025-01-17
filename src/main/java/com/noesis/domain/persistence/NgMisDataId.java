package com.noesis.domain.persistence;
// Generated 10 Oct, 2018 1:18:37 AM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NgMisDataId generated by hbm2java
 */
@Embeddable
public class NgMisDataId implements java.io.Serializable {

	private String userName;
	private BigDecimal totalSubmitted;
	private BigDecimal totalRejected;
	private BigDecimal totalDelivered;
	private BigDecimal totalFalied;
	private int orgId;

	public NgMisDataId() {
	}

	public NgMisDataId(String userName) {
		this.userName = userName;
	}

	public NgMisDataId(String userName, BigDecimal totalSubmitted, BigDecimal totalRejected, BigDecimal totalDelivered,
			BigDecimal totalFalied, int orgId) {
		this.userName = userName;
		this.totalSubmitted = totalSubmitted;
		this.totalRejected = totalRejected;
		this.totalDelivered = totalDelivered;
		this.totalFalied = totalFalied;
		this.orgId = orgId;
	}

	@Column(name = "user_name", nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "total_submitted", precision = 23, scale = 0)
	public BigDecimal getTotalSubmitted() {
		return this.totalSubmitted;
	}

	public void setTotalSubmitted(BigDecimal totalSubmitted) {
		this.totalSubmitted = totalSubmitted;
	}

	@Column(name = "total_rejected", precision = 23, scale = 0)
	public BigDecimal getTotalRejected() {
		return this.totalRejected;
	}

	public void setTotalRejected(BigDecimal totalRejected) {
		this.totalRejected = totalRejected;
	}

	@Column(name = "total_delivered", precision = 23, scale = 0)
	public BigDecimal getTotalDelivered() {
		return this.totalDelivered;
	}

	public void setTotalDelivered(BigDecimal totalDelivered) {
		this.totalDelivered = totalDelivered;
	}

	@Column(name = "total_falied", precision = 23, scale = 0)
	public BigDecimal getTotalFalied() {
		return this.totalFalied;
	}

	public void setTotalFalied(BigDecimal totalFalied) {
		this.totalFalied = totalFalied;
	}
	
	@Column(name = "org_id")
	public int getOrgId() {
		return this.orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NgMisDataId))
			return false;
		NgMisDataId castOther = (NgMisDataId) other;

		return ((this.getUserName() == castOther.getUserName()) || (this.getUserName() != null
				&& castOther.getUserName() != null && this.getUserName().equals(castOther.getUserName())))
				&& ((this.getTotalSubmitted() == castOther.getTotalSubmitted())
						|| (this.getTotalSubmitted() != null && castOther.getTotalSubmitted() != null
								&& this.getTotalSubmitted().equals(castOther.getTotalSubmitted())))
				&& ((this.getTotalRejected() == castOther.getTotalRejected())
						|| (this.getTotalRejected() != null && castOther.getTotalRejected() != null
								&& this.getTotalRejected().equals(castOther.getTotalRejected())))
				&& ((this.getTotalDelivered() == castOther.getTotalDelivered())
						|| (this.getTotalDelivered() != null && castOther.getTotalDelivered() != null
								&& this.getTotalDelivered().equals(castOther.getTotalDelivered())))
				&& ((this.getTotalFalied() == castOther.getTotalFalied())
						|| (this.getTotalFalied() != null && castOther.getTotalFalied() != null
								&& this.getTotalFalied().equals(castOther.getTotalFalied())
				&& ((this.getOrgId() == castOther.getOrgId()))));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result + (getTotalSubmitted() == null ? 0 : this.getTotalSubmitted().hashCode());
		result = 37 * result + (getTotalRejected() == null ? 0 : this.getTotalRejected().hashCode());
		result = 37 * result + (getTotalDelivered() == null ? 0 : this.getTotalDelivered().hashCode());
		result = 37 * result + (getTotalFalied() == null ? 0 : this.getTotalFalied().hashCode());
		return result;
	}

}
