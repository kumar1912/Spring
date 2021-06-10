
package com.tui.uk.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import java.io.Serializable;
import java.sql.Date;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_rates_view")
public class RatesInfo implements Serializable {

	private static final long serialVersionUID = 1L;

    public RatesInfo() {
		super();
	}

	@Id
    @NotNull
	@Column(name = "sl")
	private String sl;

	@Column(name = "supplier_name")
	private String dmc;

    @Null
    @Column(name = "contract_id")
    private String contract_id;

    @Null
	@Column(name = "country_name")
    private String country;



    public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}


	@Null
    @Column(name = "destination")
    private String destination;

    @Null
    @Column(name = "source_market_name")
    private String source_markets;


    @Null
    @Column(name = "transfer_type")
    private String transfer_type;

    @Null
    @Column(name = "note")
    private String note;
    
    @Null
    @Column(name = "cmd_code_from")
    private String cmd_code_from;

    @Null
    @Column(name = "cmd_code_to")
    private String cmd_code_to;

    public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Null
    @Column(name = "valid_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date valid_from;

    @Null
    @Column(name = "valid_to")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date valid_to;

    @Null
    @Column(name = "`from`")
    private String from;

    @Null
    @Column(name = "`to`")
    private String to;

    @Null
    @Column(name = "transport_method")
    private String transport_method;


    @Null
    @Column(name = "charge_method")
    private String charge_method;
    
    @Null
    @Column(name = "max_seats")
    private String max_seats;

    @Null
    @Column(name = "journey_type")
    private String journey_type;

    @Null
    @Column(name = "ow_rtn_percentage")
    private double ow_rtn_percentage;

    @Null
    @Column(name = "tax")
    private double tax;

    @Null
    @Column(name = "currency")
    private String currency;

    @Null
    @Column(name = "vehicle_rate")
    private double vehicle_rate;

    @Null
    @Column(name = "adult_rate")
    private double adult_rate;

    @Null
    @Column(name = "child_rate")
    private double child_rate;

	@Null
    @Column(name = "comments")
    private String comments;

    @Null
    @Column(name = "season_from")
    private String season_from;

    @Null
    @Column(name = "season_to")
    private String season_to;
    
    @Null
    @Column(name="zone_resorts")
	private String zone_resorts;
    
    @Null
    @Column(name="to_zone")
	private String to_zone;
    
    public String getCmd_code_from() {
		return cmd_code_from;
	}

	public void setCmd_code_from(String cmd_code_from) {
		this.cmd_code_from = cmd_code_from;
	}

	public String getCmd_code_to() {
		return cmd_code_to;
	}

	public void setCmd_code_to(String cmd_code_to) {
		this.cmd_code_to = cmd_code_to;
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


	public String getTo_zone() {
		return to_zone;
	}

	public void setTo_zone(String to_zone) {
		this.to_zone = to_zone;
	}

	public String getZone_resorts() {
		return zone_resorts;
	}

	public void setZone_resorts(String zone_resorts) {
		this.zone_resorts = zone_resorts;
	}

	public void setSeason_to(String season_to) {
		this.season_to = season_to;
	}


	@Null
    @Column(name = "notes")
    private String transfer_type_notes;


	public String getDmc() {
		return dmc;
	}



	public void setDmc(String dmc) {
		this.dmc = dmc;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getSource_markets() {
		return source_markets;
	}



	public void setSource_markets(String source_markets) {
		this.source_markets = source_markets;
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

	public double getOw_rtn_percentage() {
		return ow_rtn_percentage;
	}

	public void setOw_rtn_percentage(double ow_rtn_percentage) {
		this.ow_rtn_percentage = ow_rtn_percentage;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getJourney_type() {
		return journey_type;
	}

	public void setJourney_type(String journey_type) {
		this.journey_type = journey_type;
	}

	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public double getVehicle_rate() {
		return vehicle_rate;
	}



	public void setVehicle_rate(double vehicle_rate) {
		this.vehicle_rate = vehicle_rate;
	}



	public double getAdult_rate() {
		return adult_rate;
	}



	public void setAdult_rate(double adult_rate) {
		this.adult_rate = adult_rate;
	}



	public double getChild_rate() {
		return child_rate;
	}



	public void setChild_rate(double child_rate) {
		this.child_rate = child_rate;
	}







	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}






	public String getTransfer_type_notes() {
		return transfer_type_notes;
	}



	public void setTransfer_type_notes(String transfer_type_notes) {
		this.transfer_type_notes = transfer_type_notes;
	}






	public String getSl() {
		return sl;
	}






	public void setSl(String sl) {
		this.sl = sl;
	}






	public RatesInfo(String sl, String dmc, String country, String destination, String source_markets,
			String transfer_type, Date valid_from, Date valid_to, String from, String to, String transport_method,
			String charge_method, String max_seats,String journey_type, double ow_rtn_percentage, double tax, String currency,
			double vehicle_rate, double adult_rate, double child_rate, String additional_adult, String comments,
			String season_from, String season_to, String transfer_type_notes,String zone_resorts,String cmd_code_from,String cmd_code_to) {
		super();
		this.sl = sl;
		this.dmc = dmc;
		this.country = country;
		this.destination = destination;
		this.source_markets = source_markets;
		this.transfer_type = transfer_type;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.from = from;
		this.to = to;
		this.transport_method = transport_method;
		this.charge_method = charge_method;
		this.max_seats = max_seats;
		this.journey_type=journey_type;
		this.ow_rtn_percentage = ow_rtn_percentage;
		this.tax = tax;
		this.currency = currency;
		this.vehicle_rate = vehicle_rate;
		this.adult_rate = adult_rate;
		this.child_rate = child_rate;

		this.comments = comments;
		this.season_from = season_from;
		this.season_to = season_to;
		this.transfer_type_notes = transfer_type_notes;
		this.zone_resorts= zone_resorts;
		this.cmd_code_from=cmd_code_from;
		this.cmd_code_to=cmd_code_to;
	}

	@Override
	public String toString() {
		return "RatesInfo [sl=" + sl + ", dmc=" + dmc + ", contract_id=" + contract_id + ", country=" + country
				+ ", destination=" + destination + ", source_markets=" + source_markets + ", transfer_type="
				+ transfer_type + ", note=" + note + ", valid_from=" + valid_from + ", valid_to=" + valid_to + ", from="
				+ from + ", to=" + to + ", transport_method=" + transport_method + ", charge_method=" + charge_method
				+ ", max_seats=" + max_seats + ", ow_rtn_percentage=" + ow_rtn_percentage + ", tax=" + tax + ", currency="
				+ currency + ", vehicle_rate=" + vehicle_rate + ", adult_rate=" + adult_rate + ", child_rate="
				+ child_rate + ", comments=" + comments + ", season_from=" + season_from + ", season_to=" + season_to
				+ ", zone_resorts=" + zone_resorts + ", transfer_type_notes=" + transfer_type_notes + "]";
	}


















}
