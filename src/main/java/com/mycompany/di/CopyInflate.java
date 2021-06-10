package com.tui.uk.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CopyInflate {

	private String contract_id;
	private double version;
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date start_date;
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date end_date;
	private String seasonFrom ;
	private String seasonTo ;
	private String supplier_name;
	private String supplier_code;
	private String country_name;
	private String status;
	private String notes;
	private double Inflate ;

	List<TransferTypeList> transferTypeArrayList = new ArrayList<>();
	
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getSeasonFrom() {
		return seasonFrom;
	}
	public void setSeasonFrom(String seasonFrom) {
		this.seasonFrom = seasonFrom;
	}
	public String getSeasonTo() {
		return seasonTo;
	}
	public void setSeasonTo(String seasonTo) {
		this.seasonTo = seasonTo;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public double getInflate() {
		return Inflate;
	}
	public void setInflate(double inflate) {
		Inflate = inflate;
	}
	

	public List<TransferTypeList> getTransferTypeArrayList() {
		return transferTypeArrayList;
	}
	public void setTransferTypeArrayList(List<TransferTypeList> transferTypeArrayList) {
		this.transferTypeArrayList = transferTypeArrayList;
	}
	@Override
	public String toString() {
		return "CopyInflate [contract_id=" + contract_id + ", version=" + version + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", seasonFrom=" + seasonFrom + ", seasonTo=" + seasonTo
				+ ", supplier_name=" + supplier_name + ", supplier_code=" + supplier_code + ", country_name="
				+ country_name + ", status=" + status + ", notes=" + notes + ", Inflate=" + Inflate + "]";
	}
}
