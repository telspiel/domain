package com.noesis.domain.persistence;
// Generated 13 Dec, 2018 1:40:39 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * NgNumberCarrierCircleMapping generated by hbm2java
 */
@Entity
@Table(name = "ng_number_carrier_circle_mapping", catalog = "genesis")
public class NgNumberCarrierCircleMapping implements java.io.Serializable {

	private int id;
	private NgCarrierMaster ngCarrierMaster;
	private NgCircleMaster ngCircleMaster;
	private String numSeries;
	private int carrierId;
	private int circleId;

	public NgNumberCarrierCircleMapping() {
	}

	public NgNumberCarrierCircleMapping(NgCarrierMaster ngCarrierMaster, NgCircleMaster ngCircleMaster,
			String numSeries, int carrierId, int circleId) {
		this.ngCarrierMaster = ngCarrierMaster;
		this.ngCircleMaster = ngCircleMaster;
		this.numSeries = numSeries;
		this.carrierId = carrierId;
		this.circleId = circleId;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ngCarrierMaster"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public NgCarrierMaster getNgCarrierMaster() {
		return this.ngCarrierMaster;
	}

	public void setNgCarrierMaster(NgCarrierMaster ngCarrierMaster) {
		this.ngCarrierMaster = ngCarrierMaster;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public NgCircleMaster getNgCircleMaster() {
		return this.ngCircleMaster;
	}

	public void setNgCircleMaster(NgCircleMaster ngCircleMaster) {
		this.ngCircleMaster = ngCircleMaster;
	}

	@Column(name = "num_series", nullable = false, length = 45)
	public String getNumSeries() {
		return this.numSeries;
	}

	public void setNumSeries(String numSeries) {
		this.numSeries = numSeries;
	}

	@Column(name = "carrier_id", nullable = false)
	public int getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}

	@Column(name = "circle_id", nullable = false)
	public int getCircleId() {
		return this.circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

}