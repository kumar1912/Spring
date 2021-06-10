package com.tui.uk.domain;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A Contract.
 */
@Entity
@Table(name = "tr_contract")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Contract {
	@Id
	@Column(name="contract_id")
	private String contract_id;

	@Column(name="VERSION")
	private double version;

	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="start_date")
	private Date start_date;

	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="end_date")
	private Date end_date;

	@Column(name="STATUS")
	private String status;
	
	@Column(name="country_id")
	private String country_id;

	@Column(name="notes")
	private String notes;

	@Column(name="supplier_name")
	private String supplier_name;

	@Column(name="country_name")
	private String country_name;

	@Column(name="source_market_name")
	private String source_market_name;

	@Column(name="season")
	private String season;

	@Column(name="season_to")
	private String season_to;

	@Column(name="supplier_code")
	private String supplier_code;

	@Column(name="version_notes")
	private String version_notes;
	
	@Column(name="parent_contract_id")
	private String parent_contract_id;
	
	@Version
	@Column(name="jpa_version")
	private int jpa_version;
	
	public int getJpa_version() {
		return jpa_version;
	}

	public void setJpa_version(int jpa_version) {
		this.jpa_version = jpa_version;
	}
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="created_on")
	private Date created_on;

	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="modified_on")
	private Date modified_on;

	@Column(name="created_by")
	private String created_by;

	@Column(name="modified_by")
	private String modified_by;


	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getParent_contract_id() {
		return parent_contract_id;
	}

	public void setParent_contract_id(String parent_contract_id) {
		this.parent_contract_id = parent_contract_id;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSupplier_code() {
		return supplier_code;
	}

	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getSource_market_name() {
		return source_market_name;
	}

	public void setSource_market_name(String source_market_name) {
		this.source_market_name = source_market_name;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSeason_to() {
		return season_to;
	}

	public void setSeason_to(String season_to) {
		this.season_to = season_to;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVersion_notes() {
		return version_notes;
	}

	public void setVersion_notes(String version_notes) {
		this.version_notes = version_notes;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getModified_on() {
		return modified_on;
	}

	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	@Override
	public String toString() {
		return "Contract [contract_id=" + contract_id + ", version=" + version + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", status=" + status + ", country_id=" + country_id + ", notes=" + notes
				+ ", supplier_name=" + supplier_name + ", country_name=" + country_name + ", source_market_name="
				+ source_market_name + ", season=" + season + ", season_to=" + season_to + ", supplier_code="
				+ supplier_code + ", version_notes=" + version_notes + ", jpa_version=" + jpa_version
				+ ",  created_on=" + created_on + ", modified_on=" + modified_on
				+ ", created_by=" + created_by + ", modified_by=" + modified_by + "]";
	}

	public Contract() {
		super();
	}
	public Contract(Object[] contractData) throws ParseException {
		super();

		this.version = 1;
		this.start_date =  (Date) contractData[14];
		this.end_date =(Date) contractData[15];
		this.status="Draft";
		this.supplier_name = (String) contractData[1];
		this.country_name = (String) contractData[29];
		this.supplier_code = (String) contractData[2];
	}








}
