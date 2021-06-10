 package com.tui.uk.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Transfer Type
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_transfer_type")
public class TransferType  implements Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transfer_type_id")
	private int transfer_type_id;
	
	@Column(name="contract_id")
	private String contract_id;

	@Column(name="transfer_type")
	private String transfer_type;

	@Column(name="ow_rtn")
	private String ow_rtn;

	/*@Column(name="ow_percentage")
	private Double ow_percentage;*/
	
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="valid_from")
	private Date valid_from;

	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="valid_to")
	private Date valid_to;

	@Column(name="season_from")
	private String season_from;

	@Column(name="season_to")
	private String season_to;
	
	@Column(name="zone_resorts")
	private String zone_resorts;

	@Column(name="currency")
	private String currency;

	@Column(name="additional_adult_rates_required")
	private String additional_adult_rates_required;

	@Column(name="notes")
	private String notes;

	@Column(name="source_markets_rate_applies")
	private String source_markets_rate_applies;

	@Version
	@Column(name="jpa_version")
	private int jpa_version;

	@Column(name="highlight")
	private String highlight = "";

	@Column(name="confirm_all")
	private String confirm_all;
	
	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public int getJpa_version() {
		return jpa_version;
	}

	public void setJpa_version(int jpa_version) {
		this.jpa_version = jpa_version;
	}
	
	public String getConfirm_all() {
		return confirm_all;
	}

	public void setConfirm_all(String confirm_all) {
		this.confirm_all = confirm_all;
	}

	@OneToMany(mappedBy = "transferType", cascade = CascadeType.ALL)
	private List<GatewayExceptionRate> gatewayExceptionRates;

	@OneToMany(mappedBy = "transferType", cascade = CascadeType.ALL)
	private List<GatewayTransferRate> gatewayTransferRates;

	@OneToMany(mappedBy = "transferType", cascade = CascadeType.ALL)
	private List<InterHotelRate> interHotelRates;

	@OneToMany(mappedBy = "transferType", cascade = CascadeType.ALL)
	private List<MultiLegRate> multiLegRate =new ArrayList<>();

	public List<MultiLegRate> getMultiLegRate() {
		return multiLegRate;
	}

	public void setMultiLegRate(List<MultiLegRate> multiLegRate) {
		this.multiLegRate = multiLegRate;
	}

	@ManyToOne
    @JoinTable(
        name = "tr_contract",
        joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "contract_id")})


	public String getContract_id() {
		return contract_id;
	}

	public int getTransfer_type_id() {
		return transfer_type_id;
	}

	public void setTransfer_type_id(int transfer_type_id) {
		this.transfer_type_id = transfer_type_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}

	public String getOw_rtn() {
		return ow_rtn;
	}

	public void setOw_rtn(String ow_rtn) {
		this.ow_rtn = ow_rtn;
	}

	/*public Double getOw_percentage() {
		return ow_percentage;
	}

	public void setOw_percentage(Double ow_percentage) {
		this.ow_percentage = ow_percentage;
	}
*/
	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_to() {
		return valid_to;
	}

	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
	}

	public String getSeason_from() {
		return season_from;
	}

	public void setSeason_from(String season_from) {
		this.season_from = season_from;
	}

	public String getSeason_to() {
		return season_to;
	}

	public void setSeason_to(String season_to) {
		this.season_to = season_to;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAdditional_adult_rates_required() {
		return additional_adult_rates_required;
	}

	public void setAdditional_adult_rates_required(String additional_adult_rates_required) {
		this.additional_adult_rates_required = additional_adult_rates_required;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSource_markets_rate_applies() {
		return source_markets_rate_applies;
	}

	public void setSource_markets_rate_applies(String source_markets_rate_applies) {
		this.source_markets_rate_applies = source_markets_rate_applies;
	}

	public String getZone_resorts() {
		return zone_resorts;
	}

	public void setZone_resorts(String zone_resorts) {
		this.zone_resorts = zone_resorts;
	}

	@Override
	public String toString() {
		return "TransferType [transfer_type_id=" + transfer_type_id + ", contract_id=" + contract_id
				+ ", transfer_type=" + transfer_type + ", ow_rtn=" + ow_rtn + ", ow_percentage=" /*+ ow_percentage*/
				+ ", valid_from=" + valid_from + ", valid_to=" + valid_to + ", season_from=" + season_from
				+ ", season_to=" + season_to + ", zone_resorts=" + zone_resorts + ", currency=" + currency
				+ ", additional_adult_rates_required=" + additional_adult_rates_required + ", notes=" + notes
				+ ", source_markets_rate_applies=" + source_markets_rate_applies + ", jpa_version=" + jpa_version
				+ ", highlight=" + highlight + ", gatewayExceptionRates=" + gatewayExceptionRates
				+ ", gatewayTransferRates=" + gatewayTransferRates + ", interHotelRates=" + interHotelRates
				+ ", multiLegRate=" + multiLegRate + "]";
	}

	public TransferType(int transfer_type_id, String contract_id, String transfer_type, String ow_rtn, /*Double ow_percentage,*/
			Date valid_from, Date valid_to, String season_from, String season_to,String zone_resorts,String currency,
			String additional_adult_rates_required, String notes, String source_markets_rate_applies,int jpa_version,String confirm_all) {
		super();
		this.transfer_type_id = transfer_type_id;
		this.contract_id = contract_id;
		this.transfer_type = transfer_type;
		this.ow_rtn = ow_rtn;
		//this.ow_percentage = ow_percentage;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.season_from = season_from;
		this.season_to = season_to;
		this.zone_resorts=zone_resorts;
		this.currency = currency;
		this.additional_adult_rates_required = additional_adult_rates_required;
		this.notes = notes;
		this.source_markets_rate_applies = source_markets_rate_applies;
		this.jpa_version=jpa_version;
		this.confirm_all=confirm_all;
		
	}

	public TransferType() {
		super();
	}



	public List<GatewayExceptionRate> getGatewayExceptionRates() {
		return gatewayExceptionRates;
	}

	public void setGatewayExceptionRates(List<GatewayExceptionRate> gatewayExceptionRates) {
		this.gatewayExceptionRates = gatewayExceptionRates;
	}

	public List<GatewayTransferRate> getGatewayTransferRates() {
		return gatewayTransferRates;
	}

	public void setGatewayTransferRates(List<GatewayTransferRate> gatewayTransferRates) {
		this.gatewayTransferRates = gatewayTransferRates;
	}

	public List<InterHotelRate> getInterHotelRates() {
		return interHotelRates;
	}

	public void setInterHotelRates(List<InterHotelRate> interHotelRates) {
		this.interHotelRates = interHotelRates;
	}


	public Object clone()throws CloneNotSupportedException{
		TransferType transferType = new TransferType(  transfer_type_id,   contract_id,   transfer_type,   ow_rtn,  /* ow_percentage,*/
				  valid_from,   valid_to,   season_from,   season_to,zone_resorts,   currency,
				  additional_adult_rates_required,   notes,   source_markets_rate_applies,jpa_version,confirm_all);
		return transferType;
		}

	public TransferType(Object[] transferData) {
		super();
		this.transfer_type_id = (int) transferData[58];
		this.contract_id = (String) transferData[57];
		this.transfer_type = ((String) transferData[43]).trim().substring(0,1).toUpperCase()+((String) transferData[43]).trim().substring(1).toLowerCase();
		this.ow_rtn =  ((String) transferData[47]).toUpperCase();
		//this.ow_percentage = (Double) transferData[48];
		this.valid_from =   (Date) transferData[16];
		this.valid_to =(Date) transferData[17];
		this.season_from =  (String) transferData[26];
		this.season_to = (String) transferData[27];
		this.zone_resorts=(String) transferData[59];
		this.currency =  (String) transferData[28];
		this.additional_adult_rates_required =  "false";
		this.source_markets_rate_applies =  (String) transferData[60];
		
	}


}

