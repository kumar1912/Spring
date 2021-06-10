
package com.tui.uk.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "tr_contract_print_view")
public class PrintContractDetails implements Serializable,Comparable<PrintContractDetails> {

    private static final long serialVersionUID = 1L;

    
    
    public PrintContractDetails() {
		super();
	}

	@Id
    @NotNull
    @Column
    private String sl;


    @Column
    private String contract_id;
    
    @Column
    private String country_name;
    
    @Column
    private String currency;

    @Column
    private String season_from;
    
    @Column
    private String season_to;
    
    @Column
	private String zone_resorts;
    
    @Column
    private String transfer_type;
    
    @Column(name="rate_type")
	private String rate_type; 
    
    @Column
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date valid_from;

    @Column
	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date valid_to;
    
    @Column
    private String source_market_name;
    
    @Column
    private String from;
    
    @Column
    private String to;
    
    @Null
    @Column
	private String to_zone;

    @Column
    private String comments;
    
    @Column
    private String transport_method;
    
    @Column
    private String max_seats;
    
    @Column
    private String transfer_notes;
    
    @Column
    private String journey_type;
    
    @Column
    private String charge_method;
    
    @Column
    private String rate;

    @Column
    private String destination;
    
    @Column
    private String from_accommodation;
    
    @Column
    private String to_accommodation;

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getContract_id() {
		return contract_id;
	}
	

	public String getTo_zone() {
		return to_zone;
	}

	public void setTo_zone(String to_zone) {
		this.to_zone = to_zone;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getZone_resorts() {
		return zone_resorts;
	}

	public void setZone_resorts(String zone_resorts) {
		this.zone_resorts = zone_resorts;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}



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

	public String getSource_market_name() {
		return source_market_name;
	}

	public void setSource_market_name(String source_market_name) {
		this.source_market_name = source_market_name;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTransport_method() {
		return transport_method;
	}

	public void setTransport_method(String transport_method) {
		this.transport_method = transport_method;
	}

	public String getJourney_type() {
		return journey_type;
	}

	public void setJourney_type(String journey_type) {
		this.journey_type = journey_type;
	}

	public String getCharge_method() {
		return charge_method;
	}

	public void setCharge_method(String charge_method) {
		this.charge_method = charge_method;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMax_seats() {
		return max_seats;
	}

	public void setMax_seats(String max_seats) {
		this.max_seats = max_seats;
	}


	public String getTransfer_notes() {
		return transfer_notes;
	}

	public void setTransfer_notes(String transfer_notes) {
		this.transfer_notes = transfer_notes;
	}

	public String getFrom_accommodation() {
		return from_accommodation;
	}

	public void setFrom_accommodation(String from_accommodation) {
		this.from_accommodation = from_accommodation;
	}

	public String getTo_accommodation() {
		return to_accommodation;
	}

	public void setTo_accommodation(String to_accommodation) {
		this.to_accommodation = to_accommodation;
	}

	@Override
	public String toString() {
		return "PrintContractDetails [sl=" + sl + ", contract_id=" + contract_id + ", country_name=" + country_name
				+ ", currency=" + currency + ", season_from=" + season_from + ", season_to=" + season_to
				+ ", zone_resorts=" + zone_resorts + ", transfer_type=" + transfer_type + ", valid_from=" + valid_from
				+ ", valid_to=" + valid_to + ", source_market_name=" + source_market_name + ", from=" + from + ", to="
				+ to + ", comments=" + comments + ", transport_method=" + transport_method + ", max_seats=" + max_seats
				+ ", transfer_notes=" + transfer_notes + ", journey_type=" + journey_type + ", charge_method="
				+ charge_method + ", rate=" + rate + ", destination=" + destination + "]";
	}

	@Override
	public int compareTo(PrintContractDetails o) {

		return this.transfer_type.compareTo(o.transfer_type);
	}






}
