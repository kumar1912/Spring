package com.tui.uk.domain;

import java.text.DecimalFormat;
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
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * A Contract.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_gateway_exception_rates")
public class GatewayExceptionRate implements Cloneable{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adult_rate == null) ? 0 : adult_rate.hashCode());
		result = prime * result + ((charge_method == null) ? 0 : charge_method.hashCode());
		result = prime * result + ((child_rate == null) ? 0 : child_rate.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((from_accomodation == null) ? 0 : from_accomodation.hashCode());
		result = prime * result + ((from_resort == null) ? 0 : from_resort.hashCode());
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		result = prime * result + ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result + ((max_seats == null) ? 0 : max_seats.hashCode());
		result = prime * result + ((ow_rtn == null) ? 0 : ow_rtn.hashCode());
		result = prime * result + ((ow_rtn_percentage == null) ? 0 : ow_rtn_percentage.hashCode());
		result = prime * result + ((transport_method == null) ? 0 : transport_method.hashCode());
		result = prime * result + ((transport_rating == null) ? 0 : transport_rating.hashCode());
		result = prime * result + ((vehicle_rate == null) ? 0 : vehicle_rate.hashCode());
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		result = prime * result + ((special_conditions == null) ? 0 : special_conditions.hashCode());
		result = prime * result + ((confirmed == null) ? 0 : confirmed.hashCode());
		result = prime * result + ((rate_type == null) ? 0 : rate_type.hashCode());
		result = prime * result + ((parent_vehicle_rate == null) ? 0 : parent_vehicle_rate.hashCode());
		result = prime * result + ((parent_adult_rate == null) ? 0 : parent_adult_rate.hashCode());
		result = prime * result + ((parent_child_rate == null) ? 0 : parent_child_rate.hashCode());
		result = prime * result + ((parent_charge_method == null) ? 0 : parent_charge_method.hashCode());
		result = prime * result + ((cmd_code_from == null) ? 0 : cmd_code_from.hashCode());
		result = prime * result + ((cmd_code_to == null) ? 0 : cmd_code_to.hashCode());
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
		GatewayExceptionRate other = (GatewayExceptionRate) obj;
		if (adult_rate == null) {
			if (other.adult_rate != null)
				return false;
		} else if (!adult_rate.equals(other.adult_rate))
			return false;
		if (charge_method == null) {
			if (other.charge_method != null)
				return false;
		} else if (!charge_method.equals(other.charge_method))
			return false;
		if (child_rate == null) {
			if (other.child_rate != null)
				return false;
		} else if (!child_rate.equals(other.child_rate))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (special_conditions == null) {
			if (other.special_conditions != null)
				return false;
		} else if (!special_conditions.equals(other.special_conditions))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (cmd_code_from == null) {
			if (other.cmd_code_from != null)
				return false;
		} else if (!cmd_code_from.equals(other.cmd_code_from))
			return false;
		if (cmd_code_to == null) {
			if (other.cmd_code_to != null)
				return false;
		} else if (!cmd_code_to.equals(other.cmd_code_to))
			return false;
		if (from_accomodation == null) {
			if (other.from_accomodation != null)
				return false;
		} else if (!from_accomodation.equals(other.from_accomodation))
			return false;
		if (from_resort == null) {
			if (other.from_resort != null)
				return false;
		} else if (!from_resort.equals(other.from_resort))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		if (highlight == null) {
			if (other.highlight != null)
				return false;
		} else if (!highlight.equals(other.highlight))
			return false;
		if (max_seats == null) {
			if (other.max_seats != null)
				return false;
		} else if (!max_seats.equals(other.max_seats))
			return false;
		if (ow_rtn == null) {
			if (other.ow_rtn != null)
				return false;
		} else if (!ow_rtn.equals(other.ow_rtn))
			return false;
		if (ow_rtn_percentage == null) {
			if (other.ow_rtn_percentage != null)
				return false;
		} else if (!ow_rtn_percentage.equals(other.ow_rtn_percentage))
			return false;
		if (transport_method == null) {
			if (other.transport_method != null)
				return false;
		} else if (!transport_method.equals(other.transport_method))
			return false;
		if (transport_rating == null) {
			if (other.transport_rating != null)
				return false;
		} else if (!transport_rating.equals(other.transport_rating))
			return false;
		if (vehicle_rate == null) {
			if (other.vehicle_rate != null)
				return false;
		} else if (!vehicle_rate.equals(other.vehicle_rate))
			return false;
		if (confirmed == null) {
			if (other.confirmed != null)
				return false;
		} else if (!confirmed.equals(other.confirmed))
			return false;
		if (rate_type == null) {
			if (other.rate_type != null)
				return false;
		} else if (!rate_type.equals(other.rate_type))
			return false;
			if (parent_vehicle_rate == null) {
				if (other.parent_vehicle_rate != null)
					return false;
			} else if (!parent_vehicle_rate.equals(other.parent_vehicle_rate))
				return false;
			if (parent_child_rate == null) {
				if (other.parent_child_rate != null)
					return false;
			} else if (!parent_child_rate.equals(other.parent_child_rate))
				return false;
			if (parent_charge_method == null) {
				if (other.parent_charge_method != null)
					return false;
			} else if (!parent_charge_method.equals(other.parent_charge_method))
				return false;
			if (from_accomodation == null) {
				if (other.from_accomodation != null)
					return false;
			} else if (!from_accomodation.equals(other.from_accomodation))
				return false;
			if (parent_adult_rate == null) {
				if (other.parent_adult_rate != null)
					return false;
			} else if (!parent_adult_rate.equals(other.parent_adult_rate))
				return false;
		if (zone == null) {
			if (other.zone != null)
				return false;
		} else if (!zone.equals(other.zone))
			return false;
		return true;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sequence_number")
	private int sequence_number;

	@Version
	@Column(name="jpa_version")
    private int jpa_version;

	@Column(name="transfer_type_id")
	private int transfer_type_id;

	@Column(name="country")
	private String country="";

	@Column(name="`from`")
	private String from="";
	
	@Column(name="special_conditions")
	private String special_conditions="";
	
	@Column(name="rate_type")
	private String rate_type;

	 @Column(name="parent_vehicle_rate")
	private Double parent_vehicle_rate;
		
	@Column(name="parent_adult_rate")
	private Double parent_adult_rate;
		
	@Column(name="parent_child_rate")
	private Double parent_child_rate;

	@Column(name="parent_charge_method")
	private String parent_charge_method;
	
	@Column(name="cmd_code_from")
	private String cmd_code_from="";

	@Column(name="cmd_code_to")
	private String cmd_code_to="";
	
	@Column(name = "sheet_row_no")
	public String sheet_row_no;
	
	public String getSpecial_conditions() {
		return special_conditions;
	}

	public void setSpecial_conditions(String special_conditions) {
		this.special_conditions = special_conditions;
	}

	public String getFrom_accomodation() {
		return from_accomodation;
	}

	public void setFrom_accomodation(String from_accomodation) {
		this.from_accomodation = from_accomodation;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}

	public String getParent_charge_method() {
		return parent_charge_method;
	}

	public void setParent_charge_method(String parent_charge_method) {
		this.parent_charge_method = parent_charge_method;
	}

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


	@Column(name="from_accomodation")
	private String from_accomodation;
	
	@Column(name="from_resort")
	private String from_resort;

	@Column(name="destination")
	private String destination="";

	@Column(name="gateway")
	private String gateway="";


	public String getGateway() {
		return gateway;
	}

	public Double getParent_vehicle_rate() {
		return parent_vehicle_rate;
	}

	public void setParent_vehicle_rate(Double parent_vehicle_rate) {
		this.parent_vehicle_rate = parent_vehicle_rate;
	}

	public Double getParent_adult_rate() {
		return parent_adult_rate;
	}

	public void setParent_adult_rate(Double parent_adult_rate) {
		this.parent_adult_rate = parent_adult_rate;
	}

	public Double getParent_child_rate() {
		return parent_child_rate;
	}

	public void setParent_child_rate(Double parent_child_rate) {
		this.parent_child_rate = parent_child_rate;
	}

	public GatewayExceptionRate(int sequence_number, int transfer_type_id, String country, String from,
			String destination, String gateway, String to, String zone, String transport_method,
			String transport_rating, String charge_method, String max_seats, String ow_rtn, Double tax,
			Double vehicle_rate, Double adult_rate, Double child_rate, String confirmed, Double additional_adult,
			String comments,String rate_type,Double parent_vehicle_rate,Double parent_adult_rate,
			Double parent_child_rate,String parent_charge_method,String from_accomodation,TransferType transferType,String cmd_code_from,String cmd_code_to, String sheet_row_no) {
		super();
		this.sequence_number = sequence_number;
		this.transfer_type_id = transfer_type_id;
		this.country = country;
		this.from = from;
		this.destination = destination;
		this.gateway = gateway;
		this.to = to;
		this.zone = zone;
		this.transport_method = transport_method;
		this.transport_rating = transport_rating;
		this.charge_method = charge_method;
		this.max_seats = max_seats;
		this.ow_rtn = ow_rtn;
		this.tax = tax;
		this.vehicle_rate = vehicle_rate;
		this.adult_rate = adult_rate;
		this.child_rate = child_rate;
		this.confirmed = confirmed;
		this.additional_adult = additional_adult;
		this.comments = comments;
		this.rate_type=rate_type;
		this.parent_vehicle_rate = parent_vehicle_rate;
		this.parent_adult_rate=parent_adult_rate;
		this.parent_charge_method=parent_charge_method;
		this.from_accomodation=from_accomodation;
		this.transferType = transferType;
		this.cmd_code_from=cmd_code_from;
		this.cmd_code_to=cmd_code_to;
		this.sheet_row_no=sheet_row_no;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}


	@Column(name="`to`")
	private String to="";


	@Column(name="zones")
	private String zone="";


	public int getJpa_version() {
		return jpa_version;
	}

	public void setJpa_version(int jpa_version) {
		this.jpa_version = jpa_version;
	}

	public GatewayExceptionRate(int sequence_number, int transfer_type_id, String country, String from,
			String destination, String to, String zone, String transport_method, String transport_rating,
			String charge_method, String max_seats, String ow_rtn, Double tax, Double vehicle_rate, Double adult_rate,
			Double child_rate, String confirmed, Double additional_adult, String comments,String rate_type,Double parent_vehicle_rate,
			Double parent_adult_rate,Double parent_child_rate,String parent_charge_method,String from_accomodation, TransferType transferType,String cmd_code_from,String cmd_code_to, String sheet_row_no) {
		super();
		this.sequence_number = sequence_number;
		this.transfer_type_id = transfer_type_id;
		this.country = country;
		this.from = from;
		this.destination = destination;
		this.to = to;
		this.zone = zone;
		this.transport_method = transport_method;
		this.transport_rating = transport_rating;
		this.charge_method = charge_method;
		this.max_seats = max_seats;
		this.ow_rtn = ow_rtn;
		this.tax = tax;
		this.vehicle_rate = vehicle_rate;
		this.adult_rate = adult_rate;
		this.child_rate = child_rate;
		this.confirmed = confirmed;
		this.additional_adult = additional_adult;
		this.comments = comments;
		this.rate_type=rate_type;
		this.parent_vehicle_rate = parent_vehicle_rate;
		this.parent_adult_rate=parent_adult_rate;
		this.parent_charge_method=parent_charge_method;
		this.from_accomodation=from_accomodation;
		this.transferType = transferType;
		this.cmd_code_from=cmd_code_from;
		this.cmd_code_to=cmd_code_to;
		this.sheet_row_no=sheet_row_no;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}


	@Column(name="transport_method")
	private String transport_method;

	@Column(name="transport_rating")
	private String transport_rating="";

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

	@Column(name="confirmed")
	private String confirmed;


	@Column(name="additional_adult")
	private Double additional_adult;

	@Column(name="comments")
	private String comments;

	@Column(name="highlight")
	private String highlight="";

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public Double getOw_rtn_percentage() {
		return ow_rtn_percentage;
	}

	public void setOw_rtn_percentage(Double ow_rtn_percentage) {
		this.ow_rtn_percentage = ow_rtn_percentage;
	}


	@ManyToOne
	@JoinColumn(name = "transfer_type_id", insertable=false, updatable=false)
	@JsonIgnore
    private TransferType transferType;

	public int getTransfer_type_id() {
		return transfer_type_id;
	}

	public int getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(int sequence_number) {
		this.sequence_number = sequence_number;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getTax() {
		return tax;
	}


	public String getFrom_resort() {
		return from_resort;
	}

	public void setFrom_resort(String from_resort) {
		this.from_resort = from_resort;
	}

	public void setTransfer_type_id(int transfer_type_id) {
		this.transfer_type_id = transfer_type_id;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTransport_rating() {
		return transport_rating;
	}

	public void setTransport_rating(String transport_rating) {
		this.transport_rating = transport_rating;
	}

	public GatewayExceptionRate(Object[] gatewayExceptionRate) {
		super();
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		this.transfer_type_id = (int) gatewayExceptionRate[58];
		this.destination = (String) gatewayExceptionRate[31];
		if(((String) gatewayExceptionRate[35]).startsWith("AC"))
		this.from_accomodation = (String) gatewayExceptionRate[34];
		else if(((String) gatewayExceptionRate[35]).startsWith("LO"))
		this.from_resort = (String) gatewayExceptionRate[34];
		else 
		this.from = ((String) gatewayExceptionRate[35]).startsWith("VQ") ? (String) gatewayExceptionRate[34] : ((String) gatewayExceptionRate[34]).substring(((String) gatewayExceptionRate[34]).indexOf("(")+1,((String) gatewayExceptionRate[34]).indexOf(")"));
		//this.from =	((String) gatewayExceptionRate[34]).substring(((String) gatewayExceptionRate[34]).length()-4,((String) gatewayExceptionRate[34]).length()-1);
		
		if(((String) gatewayExceptionRate[39]).startsWith("VQ") || ((String) gatewayExceptionRate[39]).startsWith("AP"))
		this.gateway = ((String) gatewayExceptionRate[38]).substring(((String) gatewayExceptionRate[38]).length()-4,((String) gatewayExceptionRate[38]).length()-1);
		else
		this.to = (String) gatewayExceptionRate[38];
		this.zone = ((String) gatewayExceptionRate[41]).trim();
		this.transport_method = ((String) gatewayExceptionRate[42]).trim();
		this.transport_rating = ((String) gatewayExceptionRate[44]).trim().substring(0,1).toUpperCase()+((String) gatewayExceptionRate[44]).trim().substring(1).toLowerCase();
		this.charge_method =  ((String) gatewayExceptionRate[45]).trim().substring(0,1).toUpperCase()+((String) gatewayExceptionRate[45]).trim().substring(1,4).toLowerCase()+((String) gatewayExceptionRate[45]).trim().substring(4,5).toUpperCase()+((String) gatewayExceptionRate[45]).trim().substring(5).toLowerCase();
		this.max_seats = (String) gatewayExceptionRate[46];
		this.ow_rtn = ((String) gatewayExceptionRate[47]).trim().toUpperCase();
		this.ow_rtn_percentage = (Double) gatewayExceptionRate[48];
		this.tax=(Double) gatewayExceptionRate[49];
		this.vehicle_rate=(Double) gatewayExceptionRate[51];
		this.adult_rate=(Double) gatewayExceptionRate[50];
		this.child_rate=(Double) gatewayExceptionRate[52];
		this.special_conditions=(String) gatewayExceptionRate[55];
		this.comments = (String) gatewayExceptionRate[40];
		this.country = (String) gatewayExceptionRate[62];
		this.cmd_code_from=(String) gatewayExceptionRate[35];
		this.cmd_code_to=(String) gatewayExceptionRate[39];
		this.confirmed = "Unconfirmed";
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public GatewayExceptionRate(int sequence_number, int transfer_type_id, String country, String from,
			String destination, String to, String transport_method, String transport_rating, String charge_method,
			String max_seats, String ow_rtn,Double ow_rtn_percentage, Double tax, Double vehicle_rate, Double adult_rate, Double child_rate,
			String confirmed, Double additional_adult, String comments,String rate_type,Double parent_vehicle_rate,
			Double parent_adult_rate,Double parent_child_rate,String parent_charge_method, String from_accomodation, 
			String zone,TransferType transferType,int jpa_version,String cmd_code_from,String cmd_code_to, String sheet_row_no) {
		super();
		this.sequence_number = sequence_number;
		this.transfer_type_id = transfer_type_id;
		this.country = country;
		this.from = from;
		this.destination = destination;
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
		this.confirmed = confirmed;
		this.additional_adult = additional_adult;
		this.comments = comments;
		this.rate_type=rate_type;
		this.parent_vehicle_rate = parent_vehicle_rate;
		this.parent_adult_rate=parent_adult_rate;
		this.parent_child_rate=parent_child_rate;
		this.parent_charge_method=parent_charge_method;
		this.from_accomodation=from_accomodation;
		this.zone=zone;
		this.transferType = transferType;
		this.jpa_version=jpa_version;
		this.cmd_code_from=cmd_code_from;
		this.cmd_code_to=cmd_code_to;
		this.sheet_row_no=sheet_row_no;
	}

	public GatewayExceptionRate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GatewayExceptionRate [sequence_number=" + sequence_number + ", jpa_version=" + jpa_version
				+ ", transfer_type_id=" + transfer_type_id + ", country=" + country + ", from=" + from
				+ ", special_conditions=" + special_conditions + ", rate_type=" + rate_type
				+ ", parent_vehicle_rate="
				+ parent_vehicle_rate + ", parent_adult_rate=" + parent_adult_rate + ", from_accomodation="
				+ from_accomodation + ", from_resort=" + from_resort + ", destination=" + destination + ", gateway="
				+ gateway + ", to=" + to + ", zone=" + zone + ", transport_method=" + transport_method
				+ ", transport_rating=" + transport_rating + ", charge_method=" + charge_method + ", max_seats="
				+ max_seats + ", ow_rtn=" + ow_rtn + ", tax=" + tax + ", vehicle_rate=" + vehicle_rate + ", adult_rate="
				+ adult_rate + ", child_rate=" + child_rate + ", confirmed=" + confirmed + ", additional_adult="
				+ additional_adult + ", comments=" + comments + ", highlight=" + highlight + ", transferType="
				+ transferType + ", sheet_row_no=" + sheet_row_no + "]";
	}

	public Object clone()throws CloneNotSupportedException{
		GatewayExceptionRate gatewayExceptionRate =  new GatewayExceptionRate (  sequence_number,   transfer_type_id,   country,   from,
				  destination,   to,   transport_method,   transport_rating,   charge_method,
				  max_seats,   ow_rtn,ow_rtn_percentage,   tax,   vehicle_rate,   adult_rate,   child_rate,
				  confirmed,   additional_adult,   comments,rate_type,parent_vehicle_rate,parent_adult_rate,parent_child_rate,
				  parent_charge_method,from_accomodation,zone,transferType,jpa_version,cmd_code_from, cmd_code_to, sheet_row_no
		);
		return gatewayExceptionRate;
		}

	public String getSheet_row_no() {
		return sheet_row_no;
	}

	public void setSheet_row_no(String sheet_row_no) {
		this.sheet_row_no = sheet_row_no;
	}

}