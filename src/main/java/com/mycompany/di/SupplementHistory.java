package com.tui.uk.domain;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tui.uk.domain.Supplement;


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_supplement_history")
public class SupplementHistory {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplement_history_id")
    private Long supplement_history_id;

	 @Column(name="supplement_id")
	 private Long supplement_id;

    @Column(name="contract_id ")
    private String contract_id;

    @Column(name="contract_version ")
    private Double contract_version;

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

    @Column(name="rate_type ")
    private String rate_type;

    @Column(name="comments ")
    private String comments;

    @Column(name="confirmed ")
    private String confirmed;

    @Column(name="supplier_name ")
    private String supplier_name;


    /* @ManyToOne
    @JoinTable(
        name = "tr_contract",
        joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "contract_id")})*/


	public Long getSupplement_history_id() {
		return supplement_history_id;
	}

	public void setSupplement_history_id(Long supplement_history_id) {
		this.supplement_history_id = supplement_history_id;
	}

	public Long getSupplement_id() {
		return supplement_id;
	}

	public void setSupplement_id(Long supplement_id) {
		this.supplement_id = supplement_id;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public Double getContract_version() {
		return contract_version;
	}

	public void setContract_version(Double contract_version) {
		this.contract_version = contract_version;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SupplementHistory() {
		super();
	}

	public SupplementHistory(Long supplement_history_id, Long supplement_id, String contract_id,
			Double contract_version, String currency, String notes, String country, String transfer_type,
			String route_from, String route_to, Date valid_from, Date valid_to, String supplement_type, Double tax,
			Double supplement_rate, String rate_type, String comments, String confirmed, String supplier_name) {
		super();
		this.supplement_history_id = supplement_history_id;
		this.supplement_id = supplement_id;
		this.contract_id = contract_id;
		this.contract_version = contract_version;
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
		this.rate_type = rate_type;
		this.comments = comments;
		this.confirmed = confirmed;
		this.supplier_name = supplier_name;
	}


	public SupplementHistory(Supplement supplement) {
		super();
		this.supplement_id = supplement.getId();
		this.contract_id = supplement.getContract_id();
		this.currency = supplement.getCurrency();
		this.notes = supplement.getNotes();
		this.country = supplement.getCountry();
		this.transfer_type = supplement.getTransfer_type();
		this.route_from = supplement.getRoute_from();
		this.route_to = supplement.getRoute_to();
		this.valid_from = supplement.getValid_from();
		this.valid_to = supplement.getValid_to();
		this.supplement_type = supplement.getSupplement_type();
		this.tax = supplement.getTax();
		this.supplement_rate = supplement.getSupplement_rate();
		this.rate_type = supplement.getRate_type();
		this.comments = supplement.getComments();
		this.confirmed = supplement.getConfirmed();
		this.supplier_name = supplement.getSupplier_name();
	}

	@Override
	public String toString() {
		return "SupplementHistory [supplement_history_id=" + supplement_history_id + ", supplement_id=" + supplement_id
				+ ", contract_id=" + contract_id + ", contract_version=" + contract_version + ", currency=" + currency
				+ ", notes=" + notes + ", country=" + country + ", transfer_type=" + transfer_type + ", route_from="
				+ route_from + ", route_to=" + route_to + ", valid_from=" + valid_from + ", valid_to=" + valid_to
				+ ", supplement_type=" + supplement_type + ", tax=" + tax + ", supplement_rate=" + supplement_rate
				+ ", rate_type=" + rate_type + ", comments=" + comments + ", confirmed=" + confirmed
				+ ", supplier_name=" + supplier_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contract_id == null) ? 0 : contract_id.hashCode());
		result = prime * result + ((supplement_id == null) ? 0 : supplement_id.hashCode());
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
		SupplementHistory other = (SupplementHistory) obj;
		if (contract_id == null) {
			if (other.contract_id != null)
				return false;
		} else if (!contract_id.equals(other.contract_id))
			return false;
		if (supplement_id == null) {
			if (other.supplement_id != null)
				return false;
		} else if (!supplement_id.equals(other.supplement_id))
			return false;
		return true;
	}






}
