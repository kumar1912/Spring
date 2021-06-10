package com.tui.uk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * Season
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_supplement_type")
public class SupplementType {

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supplement_type_id")
	private int supplement_type_id;

	@Column(name="effective_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date effective_from;

	@Column(name="effective_to")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date effective_to;

	@Column(name="supplement_type")
	private String supplement_type;

	public int getSupplement_type_id() {
		return supplement_type_id;
	}

	public void setSupplement_type_id(int supplement_type_id) {
		this.supplement_type_id = supplement_type_id;
	}

	public Date getEffective_from() {
		return effective_from;
	}

	public void setEffective_from(Date effective_from) {
		this.effective_from = effective_from;
	}

	public Date getEffective_to() {
		return effective_to;
	}

	public void setEffective_to(Date effective_to) {
		this.effective_to = effective_to;
	}

	public String getSupplement_type() {
		return supplement_type;
	}

	public void setSupplement_type(String supplement_type) {
		this.supplement_type = supplement_type;
	}

	public SupplementType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SupplementType(int supplement_type_id, String supplement_type, Date effective_from,
			Date effective_to) {
		super();
		this.supplement_type_id = supplement_type_id;
		this.supplement_type=supplement_type;
		this.effective_from = effective_from;
		this.effective_to = effective_to;
	}

	@Override
	public String toString() {
		return "SupplementType [supplement_type_id=" + supplement_type_id + ", effective_from=" + effective_from
				+ ", effective_to=" + effective_to + ", supplement_type=" + supplement_type + "]";
	}


}
