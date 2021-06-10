package com.tui.uk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Gateway Transfer Rate History.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_gateway_transfer_rates_history")
public class GatewayTransferRateHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sequence_number")
	private int sequence_number;

	@Column(name="gateway_transfer_rate_id")
	private int gateway_transfer_rate_id;

	@Column(name="transfer_type_id")
	private int transfer_type_id;

	@Column(name="contract_id")
	private String contract_id;

	@Column(name="contract_version")
	private double contract_version;

	@Column(name="destination")
	private String destination;

	@Column(name="`from`")
	private String from;

	@Column(name="`to`")
	private String to;

	@Column(name="transport_method")
	private String transport_method;

	@Column(name="transport_rating")
	private String transport_rating;

	@Column(name="charge_method")
	private String charge_method;

	@Column(name="max_seats")
	private String max_seats;

	@Column(name="ow_rtn")
	private String ow_rtn;
	
	@Column(name="ow_rtn_percentage")
	private Double ow_rtn_percentage;

	@Column(name="tax")
	private Double tax;

	@Column(name="vehicle_rate")
	private Double vehicle_rate;

	@Column(name="adult_rate")
	private Double adult_rate;

	@Column(name="child_rate")
	private Double child_rate;

	@Column(name="additional_adult")
	private Double additional_adult;

	@Column(name="commends")
	private String commends;

	@Column(name="confirmed")
	private String confirmed;


	/*@ManyToOne
	@JoinColumn(name = "transfer_type_id", insertable=false, updatable=false)
    private TransferTypeHistory transferTypeHistory;*/



	public int getTransfer_type_id() {
		return transfer_type_id;
	}

	public String getTransport_rating() {
		return transport_rating;
	}

	public void setTransport_rating(String transport_rating) {
		this.transport_rating = transport_rating;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public int getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(int sequence_number) {
		this.sequence_number = sequence_number;
	}

	public int getGateway_transfer_rate_id() {
		return gateway_transfer_rate_id;
	}

	public void setGateway_transfer_rate_id(int gateway_transfer_rate_id) {
		this.gateway_transfer_rate_id = gateway_transfer_rate_id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTransport_method() {
		return transport_method;
	}

	public void setTransport_method(String transport_method) {
		this.transport_method = transport_method;
	}

	public String getCharge_method() {
		return charge_method;
	}

	public void setCharge_method(String charge_method) {
		this.charge_method = charge_method;
	}

	public String getMax_seats() {
		return max_seats;
	}

	public void setMax_seats(String max_seats) {
		this.max_seats = max_seats;
	}

	public String getOw_rtn() {
		return ow_rtn;
	}

	public void setOw_rtn(String ow_rtn) {
		this.ow_rtn = ow_rtn;
	}

	public Double getOw_rtn_percentage() {
		return ow_rtn_percentage;
	}

	public void setOw_rtn_percentage(Double ow_rtn_percentage) {
		this.ow_rtn_percentage = ow_rtn_percentage;
	}

	public Double getVehicle_rate() {
		return vehicle_rate;
	}

	public void setVehicle_rate(Double vehicle_rate) {
		this.vehicle_rate = vehicle_rate;
	}

	public Double getAdult_rate() {
		return adult_rate;
	}

	public void setAdult_rate(Double adult_rate) {
		this.adult_rate = adult_rate;
	}

	public Double getChild_rate() {
		return child_rate;
	}

	public void setChild_rate(Double child_rate) {
		this.child_rate = child_rate;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public Double getAdditional_adult() {
		return additional_adult;
	}

	public void setAdditional_adult(Double additional_adult) {
		this.additional_adult = additional_adult;
	}

	public String getCommends() {
		return commends;
	}

	public void setCommends(String commends) {
		this.commends = commends;
	}

	public void setTransfer_type_id(int transfer_type_id) {
		this.transfer_type_id = transfer_type_id;
	}

	/*public TransferTypeHistory getTransferTypeHistory() {
		return transferTypeHistory;
	}

	public void setTransferTypeHistory(TransferTypeHistory transferTypeHistory) {
		this.transferTypeHistory = transferTypeHistory;
	}*/

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public double getContract_version() {
		return contract_version;
	}

	public void setContract_version(double contract_version) {
		this.contract_version = contract_version;
	}

	public GatewayTransferRateHistory() {
		super();
	}

	public GatewayTransferRateHistory(int sequence_number,int gateway_transfer_rate_id,  int transfer_type_id, String contract_id,
			double contract_version, String destination, String from, String to, String transport_method,
			String transport_rating, String charge_method, String max_seats, String ow_rtn,Double ow_rtn_percentage, Double tax,
			Double vehicle_rate, Double adult_rate, Double child_rate, Double additional_adult, String commends,
			String confirmed) {
		super();
		this.sequence_number = sequence_number;
		this.gateway_transfer_rate_id=gateway_transfer_rate_id;
		this.transfer_type_id = transfer_type_id;
		this.contract_id = contract_id;
		this.contract_version = contract_version;
		this.destination = destination;
		this.from = from;
		this.to = to;
		this.transport_method = transport_method;
		this.transport_rating = transport_rating;
		this.charge_method = charge_method;
		this.max_seats = max_seats;
		this.ow_rtn = ow_rtn;
		this.ow_rtn_percentage=ow_rtn_percentage;
		this.tax = tax;
		this.vehicle_rate = vehicle_rate;
		this.adult_rate = adult_rate;
		this.child_rate = child_rate;
		this.additional_adult = additional_adult;
		this.commends = commends;
		this.confirmed = confirmed;
		//this.transferTypeHistory = transferTypeHistory;
	}

	public GatewayTransferRateHistory(GatewayTransferRate gatewayTransferRate) {
		super();
		this.sequence_number = sequence_number;
		this.gateway_transfer_rate_id=gatewayTransferRate.getSequence_number();
		this.transfer_type_id = gatewayTransferRate.getTransfer_type_id();
		this.contract_id = contract_id;
		this.contract_version = contract_version;
		this.destination = gatewayTransferRate.getDestination();
		this.from = gatewayTransferRate.getFrom();
		this.to = gatewayTransferRate.getTo();
		this.transport_method = gatewayTransferRate.getTransport_method();
		this.transport_rating = gatewayTransferRate.getTransport_rating();
		this.charge_method = gatewayTransferRate.getCharge_method();
		this.max_seats = gatewayTransferRate.getMax_seats();
		this.ow_rtn = gatewayTransferRate.getOw_rtn();
		this.ow_rtn_percentage=gatewayTransferRate.getOw_rtn_percentage();
		this.tax = gatewayTransferRate.getTax();
		this.vehicle_rate = gatewayTransferRate.getVehicle_rate();
		this.adult_rate = gatewayTransferRate.getAdult_rate();
		this.child_rate = gatewayTransferRate.getChild_rate();
		this.additional_adult = gatewayTransferRate.getAdditional_adult();
		this.commends = gatewayTransferRate.getCommends();
		this.confirmed = gatewayTransferRate.getConfirmed();
		//this.transferTypeHistory = gatewayTransferRate.getTransferType();
	}



	@Override
	public String toString() {
		return "GatewayTransferRateHistory [sequence_number=" + sequence_number + ", gateway_transfer_rate_id="
				+ gateway_transfer_rate_id + ", transfer_type_id=" + transfer_type_id + ", contract_id=" + contract_id
				+ ", contract_version=" + contract_version + ", destination=" + destination + ", from=" + from + ", to="
				+ to + ", transport_method=" + transport_method + ", transport_rating=" + transport_rating
				+ ", charge_method=" + charge_method + ", max_seats=" + max_seats + ", ow_rtn=" + ow_rtn + ", tax="
				+ tax + ", vehicle_rate=" + vehicle_rate + ", adult_rate=" + adult_rate + ", child_rate=" + child_rate
				+ ", additional_adult=" + additional_adult + ", commends=" + commends + ", confirmed=" + confirmed
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contract_id == null) ? 0 : contract_id.hashCode());
		result = prime * result + gateway_transfer_rate_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GatewayTransferRateHistory other = (GatewayTransferRateHistory) obj;
		if (contract_id == null) {
			if (other.contract_id != null)
				return false;
		} else if (!contract_id.equals(other.contract_id))
			return false;
		if (gateway_transfer_rate_id != other.gateway_transfer_rate_id)
			return false;
		return true;
	}




}

