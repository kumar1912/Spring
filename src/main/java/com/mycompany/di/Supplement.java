package com.tui.uk.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_supplement")
public class Supplement implements Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplement_id")
    private Long id;
	
	 @Column(name="supplement_type_id ")
	 private Long supplement_type_id ;
	 
    @Column(name="contract_id ")
    private String contract_id;

    @Column(name="currency ")
    private String currency;

    @Column(name="notes ")
    private String notes;

    @Column(name="country ")
    private String country;

    @Column(name="transfer_type ")
    private String transfer_type;

    @Column(name="route_from ")
    private String route_from;

    @Column(name="route_to ")
    private String route_to;

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
    @Column(name="valid_from ")
    private Date valid_from;

    @JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="valid_to ")
    private Date valid_to;

    @Column(name="supplement_type ")
    private String supplement_type;

    @Column(name="tax ")
    private Double tax;

    @Column(name="supplement_rate ")
    private Double supplement_rate;
    
    @Column(name="parent_supplement_rate")
	private Double parent_supplement_rate;

    @Column(name="rate_type ")
    private String rate_type;
    
    @Column(name="parent_rate_type ")
    private String parent_rate_type;

    @Column(name="comments ")
    private String comments;

    @Column(name="confirmed ")
    private String confirmed;

    @Column(name="supplier_name ")
    private String supplier_name;

    @Column(name="season_from")
	private String season_from="";
    
    @Column(name="season_to")
	private String season_to="";
    
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

	public String getParent_rate_type() {
		return parent_rate_type;
	}

	public void setParent_rate_type(String parent_rate_type) {
		this.parent_rate_type = parent_rate_type;
	}

	public Long getSupplement_type_id() {
		return supplement_type_id;
	}

	public void setSupplement_type_id(Long supplement_type_id) {
		this.supplement_type_id = supplement_type_id;
	}

	@Column(name="highlight")
	private String highlight="";
    
    @Column(name="supplement_percent")
	private Double supplement_percent;
    
    
	public Double getSupplement_percent() {
		return supplement_percent;
	}

	public void setSupplement_percent(Double supplement_percent) {
		this.supplement_percent = supplement_percent;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

    @ManyToOne
    @JoinTable(
        name = "tr_contract",
        joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "contract_id")})

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}

	public String getRoute_from() {
		return route_from;
	}

	public void setRoute_from(String route_from) {
		this.route_from = route_from;
	}

	public String getRoute_to() {
		return route_to;
	}

	public void setRoute_to(String route_to) {
		this.route_to = route_to;
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

	public String getSupplement_type() {
		return supplement_type;
	}

	public void setSupplement_type(String supplement_type) {
		this.supplement_type = supplement_type;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getSupplement_rate() {
		return supplement_rate;
	}

	public void setSupplement_rate(Double supplement_rate) {
		this.supplement_rate = supplement_rate;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public Supplement() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Supplement [id=" + id + ", contract_id=" + contract_id + ", currency=" + currency + ", notes=" + notes
				+ ", country=" + country + ", transfer_type=" + transfer_type + ", route_from=" + route_from
				+ ", route_to=" + route_to + ", jpa_version=" + jpa_version + ", valid_from=" + valid_from
				+ ", valid_to=" + valid_to + ", supplement_type=" + supplement_type + ", tax=" + tax
				+ ", supplement_rate=" + supplement_rate + ", parent_supplement_rate=" + parent_supplement_rate
				+ ", rate_type=" + rate_type + ", comments=" + comments + ", confirmed=" + confirmed
				+ ", supplier_name=" + supplier_name + ", season_from=" + season_from + ", season_to=" + season_to
				+ ", highlight=" + highlight + ", supplement_percent=" + supplement_percent + "]";
	}

	public Supplement(Long id, String contract_id, String currency, String notes, String country, String transfer_type,
			String route_from, String route_to, Date valid_from, Date valid_to, String supplement_type, Double tax,
			Double supplement_rate,Double parent_supplement_rate, String rate_type, String parent_rate_type, String comments, String confirmed, String supplier_name,Long supplement_type_id,int jpa_version) {
		super();
		this.id = id;
		this.contract_id = contract_id;
		this.currency = currency;
		this.notes = notes;
		this.country = country;
		this.transfer_type = transfer_type;
		this.route_from = route_from;
		this.route_to = route_to;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.supplement_type = supplement_type;
		this.tax = tax;
		this.supplement_rate = supplement_rate;
		this.parent_supplement_rate=parent_supplement_rate;
		this.rate_type = rate_type;
		this.parent_rate_type = parent_rate_type;
		this.comments = comments;
		this.confirmed = confirmed;
		this.supplier_name = supplier_name;
		this.supplement_type_id=supplement_type_id;
		this.jpa_version=jpa_version;
	}
	
	public Double getParent_supplement_rate() {
		return parent_supplement_rate;
	}

	public void setParent_supplement_rate(Double parent_supplement_rate) {
		this.parent_supplement_rate = parent_supplement_rate;
	}

	public Object clone()throws CloneNotSupportedException{
		Supplement supplement =  new Supplement (  id,   contract_id,   currency,   notes,   country,   transfer_type,
				  route_from,   route_to,   valid_from,   valid_to,   supplement_type,   tax,
				  supplement_rate, parent_supplement_rate,  rate_type,parent_rate_type,   comments,   confirmed,   supplier_name,supplement_type_id,jpa_version
		);
		return supplement;
		}
	
	public Supplement(Object[] supplementData) {
		super();

		this.valid_from =  (Date) supplementData[0];
		this.valid_to =  (Date) supplementData[1];
		this.season_from =  ((String) supplementData[2]).trim();
		this.season_to =  ((String) supplementData[3]).trim();
		this.currency =  (String) supplementData[4];
		//this.transfer_type =  ((String) supplementData[5]).trim();
		this.route_from =  (String) supplementData[6];
		this.route_to =  (String) supplementData[9];
		this.comments=(String) supplementData[11];	
		this.supplement_type =   (String) supplementData[12];
		this.rate_type=(String) supplementData[13];
		this.tax =  (Double) supplementData[14];
		this.supplement_rate =  (Double) supplementData[15];		
		this.supplement_percent=(Double) supplementData[16];	
		this.country = (String) supplementData[18];
		this.contract_id = (String) supplementData[19];
		this.supplement_type_id = (Long) supplementData[20];
		this.confirmed = "Unconfirmed";

	}

	/*public Supplement(Object[] supplementData) {
		super();

		this.valid_from =  (Date) supplementData[0];
		this.valid_to =  (Date) supplementData[1];
		this.season_from =  ((String) supplementData[2]).trim();
		this.season_to =  ((String) supplementData[3]).trim();
		this.currency =  (String) supplementData[4];
		this.transfer_type =  ((String) supplementData[5]).trim();
		this.route_from =  (String) supplementData[7];
		this.route_to =  (String) supplementData[10];
		this.comments=(String) supplementData[12];	
		this.supplement_type =   (String) supplementData[13];
		this.rate_type=(String) supplementData[14];
		this.tax =  (Double) supplementData[15];
		this.supplement_rate =  (Double) supplementData[16];		
		this.supplement_percent=(Double) supplementData[17];	
		this.country = (String) supplementData[18];
		this.contract_id = (String) supplementData[19];
		this.confirmed = "Unconfirmed";

	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((rate_type == null) ? 0 : rate_type.hashCode());
		result = prime * result + ((route_from == null) ? 0 : route_from.hashCode());
		result = prime * result + ((route_to == null) ? 0 : route_to.hashCode());
		result = prime * result + ((season_from == null) ? 0 : season_from.hashCode());
		result = prime * result + ((season_to == null) ? 0 : season_to.hashCode());
		result = prime * result + ((supplement_rate == null) ? 0 : supplement_rate.hashCode());
		result = prime * result + ((parent_supplement_rate == null) ? 0 : parent_supplement_rate.hashCode());
		result = prime * result + ((parent_rate_type == null) ? 0 : parent_rate_type.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((transfer_type == null) ? 0 : transfer_type.hashCode());
		result = prime * result + ((valid_from == null) ? 0 : valid_from.hashCode());
		result = prime * result + ((valid_to == null) ? 0 : valid_to.hashCode());
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
		Supplement other = (Supplement) obj;
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
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (highlight == null) {
			if (other.highlight != null)
				return false;
		} else if (!highlight.equals(other.highlight))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (rate_type == null) {
			if (other.rate_type != null)
				return false;
		} else if (!rate_type.equals(other.rate_type))
			return false;
		if (route_from == null) {
			if (other.route_from != null)
				return false;
		} else if (!route_from.equals(other.route_from))
			return false;
		if (route_to == null) {
			if (other.route_to != null)
				return false;
		} else if (!route_to.equals(other.route_to))
			return false;
		if (season_from == null) {
			if (other.season_from != null)
				return false;
		} else if (!season_from.equals(other.season_from))
			return false;
		if (season_to == null) {
			if (other.season_to != null)
				return false;
		} else if (!season_to.equals(other.season_to))
			return false;
		if (supplement_rate == null) {
			if (other.supplement_rate != null)
				return false;
		} else if (!supplement_rate.equals(other.supplement_rate))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (transfer_type == null) {
			if (other.transfer_type != null)
				return false;
		} else if (!transfer_type.equals(other.transfer_type))
			return false;
		if (valid_from == null) {
			if (other.valid_from != null)
				return false;
		} else if (!valid_from.equals(other.valid_from))
			return false;
		if (valid_to == null) {
			if (other.valid_to != null)
				return false;
		} else if (!valid_to.equals(other.valid_to))
			return false;
		return true;
	}
}
