package com.tui.uk.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * A Contract.
 */
@Entity
@Table(name = "tr_multi_leg")
public class MultiLegRate implements Cloneable{



	public MultiLegRate() {
		super();
	}

	public MultiLegRate(int sequence_number, int jpa_version, int transfer_type_id, String from, String to,
			 String transport_method, String transport_rating,
			String charge_method, String max_seats, String journey_type,Double ow_rtn_percentage, Double tax, Double vehicle_rate,
			Double adult_rate, Double child_rate, String special_conditions, String highlight,Double parent_vehicle_rate,
			Double parent_adult_rate,Double parent_child_rate,String parent_charge_method,String to_accommodation,String from_accomodation,
			TransferType transferType,String cmd_code_from,String cmd_code_to, String sheet_row_no) {
		super();
		this.sequence_number = sequence_number;
		this.jpa_version = jpa_version;
		this.transfer_type_id = transfer_type_id;
		this.from = from;
		this.to = to;
		this.transport_method = transport_method;
		this.transport_rating = transport_rating;
		this.charge_method = charge_method;
		this.max_seats = max_seats;
		this.journey_type = journey_type;
		this.ow_rtn_percentage=ow_rtn_percentage;
		this.tax = tax;
		this.vehicle_rate = vehicle_rate;
		this.adult_rate = adult_rate;
		this.child_rate = child_rate;
		this.special_conditions = special_conditions;
		this.highlight = highlight;
		this.parent_vehicle_rate = parent_vehicle_rate;
		this.parent_adult_rate=parent_adult_rate;
		this.parent_child_rate=parent_child_rate;
		this.parent_charge_method=parent_charge_method;
		this.to_accommodation=to_accommodation;
		this.from_accomodation=from_accomodation;
		this.transferType = transferType;
		this.cmd_code_from=cmd_code_from;
		this.cmd_code_to=cmd_code_to;
		this.sheet_row_no=sheet_row_no;
	}


	public MultiLegRate(Object[] multiLegRate) {
		this.transfer_type_id = (int) multiLegRate[58];
		if(((String) multiLegRate[35]).startsWith("AC"))
		this.from_accomodation = (String) multiLegRate[34];
		else
		this.from = (String) multiLegRate[34];
		if(((String) multiLegRate[39]).startsWith("AC"))
			this.to_accommodation = (String) multiLegRate[38];
		else
		this.to = (String) multiLegRate[38];
		this.transport_method = ((String) multiLegRate[42]).trim();
		this.transport_rating = ((String) multiLegRate[44]).trim().substring(0,1).toUpperCase()+((String) multiLegRate[44]).trim().substring(1).toLowerCase();
		this.charge_method = ((String) multiLegRate[45]).trim();
		this.max_seats = (String) multiLegRate[46];
		this.journey_type = ((String) multiLegRate[47]).trim().toUpperCase();
		this.ow_rtn_percentage = (Double) multiLegRate[48];
		this.tax=(Double) multiLegRate[49];
		this.vehicle_rate=(Double) multiLegRate[51];
		this.adult_rate=(Double) multiLegRate[50];
		this.child_rate=(Double) multiLegRate[52];
		this.cmd_code_from=(String) multiLegRate[35];
		this.cmd_code_to=(String) multiLegRate[39];
		this.special_conditions="Yes";	
		
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

	 @Column(name="rate_type")
	 private String rate_type; 
	 
	@Column(name="`from`")
	private String from="";
	
	@Column(name="`to`")
	private String to="";
	
	@Column(name="`confirmed`")
	private String confirmed="";
	
	@Column(name="`comments`")
	private String comments="";
	
	@Column(name="cmd_code_from")
	private String cmd_code_from="";

	@Column(name="cmd_code_to")
	private String cmd_code_to="";
	
	@Column(name = "sheet_row_no")
	public String sheet_row_no;

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}


	@Column(name="transport_method")
	private String transport_method="";


	@Column(name="from_destination")
	private String from_destination="";
	
	@Column(name="to_destination")
	private String to_destination="";

	public String getFrom_destination() {
		return from_destination;
	}

	public void setFrom_destination(String from_destination) {
		this.from_destination = from_destination;
	}

	public String getTo_destination() {
		return to_destination;
	}

	public void setTo_destination(String to_destination) {
		this.to_destination = to_destination;
	}

	public String getTo_accommodation() {
		return to_accommodation;
	}

	public void setTo_accommodation(String to_accommodation) {
		this.to_accommodation = to_accommodation;
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


	@Column(name="transport_rating")
	private String transport_rating;

	@Column(name="charge_method")
	private String charge_method="";

	@Column(name="max_seats")
	private String max_seats;

	@Column(name="journey_type")
	private String journey_type;

	@Column(name="ow_rtn_percentage")
	private Double ow_rtn_percentage;

	@Column(name="tax")
	private Double tax;

	@Column(name="vehicle_rate")
	private Double vehicle_rate;

	public Double getParent_child_rate() {
		return parent_child_rate;
	}

	public void setParent_child_rate(Double parent_child_rate) {
		this.parent_child_rate = parent_child_rate;
	}

	public String getParent_charge_method() {
		return parent_charge_method;
	}

	public void setParent_charge_method(String parent_charge_method) {
		this.parent_charge_method = parent_charge_method;
	}


	@Column(name = "adult_rate")
	private Double adult_rate;

	@Column(name = "child_rate")
	private Double child_rate;

	@Column(name = "parent_vehicle_rate")
	private Double parent_vehicle_rate;

	@Column(name = "parent_child_rate")
	private Double parent_child_rate;

	@Column(name = "parent_adult_rate")
	private Double parent_adult_rate;
	
	@Column(name="parent_charge_method")
	private String parent_charge_method;

	@Column(name = "special_conditions")
	private String special_conditions;

	@Column(name="highlight")
	private String highlight="";
	
	@Column(name="to_accommodation")
	private String to_accommodation="";
	
	@Column(name="from_accomodation")
	private String from_accomodation="";

	@ManyToOne
	@JoinColumn(name = "transfer_type_id", insertable=false, updatable=false)
	@JsonIgnore
    private TransferType transferType;




	public int getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(int sequence_number) {
		this.sequence_number = sequence_number;
	}

	public int getJpa_version() {
		return jpa_version;
	}

	public void setJpa_version(int jpa_version) {
		this.jpa_version = jpa_version;
	}

	public int getTransfer_type_id() {
		return transfer_type_id;
	}

	public void setTransfer_type_id(int transfer_type_id) {
		this.transfer_type_id = transfer_type_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
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

	public String getTransport_rating() {
		return transport_rating;
	}

	public void setTransport_rating(String transport_rating) {
		this.transport_rating = transport_rating;
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

	public String getJourney_type() {
		return journey_type;
	}

	public void setJourney_type(String journey_type) {
		this.journey_type = journey_type;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
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

	public String getSpecial_conditions() {
		return special_conditions;
	}

	public void setSpecial_conditions(String special_conditions) {
		this.special_conditions = special_conditions;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}
	public String getFrom_accomodation() {
		return from_accomodation;
	}

	public void setFrom_accomodation(String from_accomodation) {
		this.from_accomodation = from_accomodation;
	}

	public Double getOw_rtn_percentage() {
		return ow_rtn_percentage;
	}

	public void setOw_rtn_percentage(Double ow_rtn_percentage) {
		this.ow_rtn_percentage = ow_rtn_percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adult_rate == null) ? 0 : adult_rate.hashCode());
		result = prime * result + ((charge_method == null) ? 0 : charge_method.hashCode());
		result = prime * result + ((child_rate == null) ? 0 : child_rate.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((confirmed == null) ? 0 : confirmed.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result + ((journey_type == null) ? 0 : journey_type.hashCode());
		result = prime * result + ((ow_rtn_percentage == null) ? 0 : ow_rtn_percentage.hashCode());
		result = prime * result + ((max_seats == null) ? 0 : max_seats.hashCode());
		result = prime * result + ((special_conditions == null) ? 0 : special_conditions.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((transport_method == null) ? 0 : transport_method.hashCode());
		result = prime * result + ((transport_rating == null) ? 0 : transport_rating.hashCode());
		result = prime * result + ((vehicle_rate == null) ? 0 : vehicle_rate.hashCode());
		result = prime * result + ((rate_type == null) ? 0 : rate_type.hashCode());
		result = prime * result + ((parent_vehicle_rate == null) ? 0 : parent_vehicle_rate.hashCode());
		result = prime * result + ((parent_adult_rate == null) ? 0 : parent_adult_rate.hashCode());
		result = prime * result + ((parent_child_rate == null) ? 0 : parent_child_rate.hashCode());
		result = prime * result + ((parent_charge_method == null) ? 0 : parent_charge_method.hashCode());
		result = prime * result + ((to_accommodation == null) ? 0 : to_accommodation.hashCode());
		result = prime * result + ((from_accomodation == null) ? 0 : from_accomodation.hashCode());
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
		MultiLegRate other = (MultiLegRate) obj;
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (confirmed == null) {
			if (other.confirmed != null)
				return false;
		} else if (!confirmed.equals(other.confirmed))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (highlight == null) {
			if (other.highlight != null)
				return false;
		} else if (!highlight.equals(other.highlight))
			return false;
		if (journey_type == null) {
			if (other.journey_type != null)
				return false;
		} else if (!journey_type.equals(other.journey_type))
			return false;
		if (ow_rtn_percentage == null) {
			if (other.ow_rtn_percentage != null)
				return false;
		} else if (!ow_rtn_percentage.equals(other.ow_rtn_percentage))
			return false;
		if (max_seats == null) {
			if (other.max_seats != null)
				return false;
		} else if (!max_seats.equals(other.max_seats))
			return false;
		if (special_conditions == null) {
			if (other.special_conditions != null)
				return false;
		} else if (!special_conditions.equals(other.special_conditions))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
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
		if (parent_adult_rate == null) {
			if (other.parent_adult_rate != null)
				return false;
		} else if (!parent_adult_rate.equals(other.parent_adult_rate))
			return false;
		if (parent_charge_method == null) {
			if (other.parent_charge_method != null)
				return false;
		} else if (!parent_charge_method.equals(other.parent_charge_method))
			return false;
		if (to_accommodation == null) {
			if (other.to_accommodation != null)
				return false;
		} else if (!to_accommodation.equals(other.to_accommodation))
			return false;
		if (from_accomodation == null) {
			if (other.from_accomodation != null)
				return false;
		} else if (!from_accomodation.equals(other.from_accomodation))
			return false;
		if (vehicle_rate == null) {
			if (other.vehicle_rate != null)
				return false;
		} else if (!vehicle_rate.equals(other.vehicle_rate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MultiLegRate [sequence_number=" + sequence_number + ", jpa_version=" + jpa_version
				+ ", transfer_type_id=" + transfer_type_id + ", rate_type=" + rate_type + ", from=" + from + ", to="
				+ to + ", confirmed=" + confirmed + ", comments=" + comments + ", transport_method=" + transport_method
				+ ", from_destination=" + from_destination + ", to_destination=" + to_destination
				+ ", transport_rating=" + transport_rating + ", charge_method=" + charge_method + ", max_seats="
				+ max_seats + ", journey_type=" + journey_type + ", tax=" + tax + ", vehicle_rate=" + vehicle_rate
				+ ", adult_rate=" + adult_rate + ", child_rate=" + child_rate + ", parent_vehicle_rate=" + parent_vehicle_rate + ", parent_adult_rate="
				+ parent_adult_rate + ", special_conditions=" + special_conditions + ", highlight=" + highlight
				+ ", transferType=" + transferType + ", sheet_row_no=" + sheet_row_no + "]";
	}

	public Object clone()throws CloneNotSupportedException{
		MultiLegRate gatewayExceptionRate =  new MultiLegRate (sequence_number, jpa_version,transfer_type_id, from,  to,
				 transport_method,transport_rating,
				charge_method, max_seats,  journey_type,ow_rtn_percentage,  tax, vehicle_rate,
				adult_rate, child_rate, special_conditions, highlight,parent_vehicle_rate,parent_adult_rate,parent_child_rate,parent_charge_method,from_accomodation,
				to_accommodation,transferType,cmd_code_from, cmd_code_to, sheet_row_no);
		return gatewayExceptionRate;
		}

	public String getSheet_row_no() {
		return sheet_row_no;
	}

	public void setSheet_row_no(String sheet_row_no) {
		this.sheet_row_no = sheet_row_no;
	}

	


}