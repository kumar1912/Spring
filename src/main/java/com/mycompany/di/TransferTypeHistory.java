package com.tui.uk.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

	 /**
	  * Transfer Type History
	  */
	 @Entity
	 @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	 @Table(name = "tr_transfer_type_history")
	 public class TransferTypeHistory {

	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name="id")
	 	private int id;

	 	@Column(name="transfer_type_id")
	 	private int transfer_type_id;

	 	@Column(name="contract_id")
	 	private String contract_id;

	 	@Column(name="contract_version")
	 	private double contract_version;

	 	@Column(name="transfer_type")
	 	private String transfer_type;

	 	@Column(name="ow_rtn")
	 	private String ow_rtn;

	 	/*@Column(name="ow_percentage")
	 	private Double ow_percentage;*/

	 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	 	@Column(name="valid_from")
	 	private Date valid_from;

	 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	 	@Column(name="valid_to")
	 	private Date valid_to;

	 	@Column(name="season_from")
	 	private String season_from;

	 	@Column(name="season_to")
	 	private String season_to;

	 	@Column(name="currency")
	 	private String currency;

	 	@Column(name="additional_adult_rates_required")
	 	private String additional_adult_rates_required;

	 	@Column(name="notes")
	 	private String notes;

	 	@Column(name="source_markets_rate_applies")
	 	private String source_markets_rate_applies;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getTransfer_type_id() {
			return transfer_type_id;
		}

		public void setTransfer_type_id(int transfer_type_id) {
			this.transfer_type_id = transfer_type_id;
		}

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
		}*/

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

		public TransferTypeHistory() {
			super();
		}


		public TransferTypeHistory(int id, int transfer_type_id, String contract_id, double contract_version,
				String transfer_type, String ow_rtn, /*Double ow_percentage,*/ Date valid_from, Date valid_to,
				String season_from, String season_to, String currency, String additional_adult_rates_required,
				String notes, String source_markets_rate_applies) {
			super();
			this.id = id;
			this.transfer_type_id = transfer_type_id;
			this.contract_id = contract_id;
			this.contract_version = contract_version;
			this.transfer_type = transfer_type;
			this.ow_rtn = ow_rtn;
		//	this.ow_percentage = ow_percentage;
			this.valid_from = valid_from;
			this.valid_to = valid_to;
			this.season_from = season_from;
			this.season_to = season_to;
			this.currency = currency;
			this.additional_adult_rates_required = additional_adult_rates_required;
			this.notes = notes;
			this.source_markets_rate_applies = source_markets_rate_applies;
		}

		public TransferTypeHistory(TransferType transferType) {
			this.id = id;
			this.transfer_type_id = transferType.getTransfer_type_id();
			this.contract_id = transferType.getContract_id();
			this.contract_version = contract_version;
			this.transfer_type = transferType.getTransfer_type();
			this.ow_rtn = transferType.getOw_rtn();
			//this.ow_percentage = transferType.getOw_percentage();
			this.valid_from = transferType.getValid_from();
			this.valid_to = transferType.getValid_to();
			this.season_from = transferType.getSeason_from();
			this.season_to = transferType.getSeason_to();
			this.currency = transferType.getCurrency();
			this.additional_adult_rates_required = transferType.getAdditional_adult_rates_required();
			this.notes = transferType.getNotes();
			this.source_markets_rate_applies = transferType.getSource_markets_rate_applies();
		}

		@Override
		public String toString() {
			return "TransferTypeHistory [id=" + id + ", transfer_type_id=" + transfer_type_id + ", contract_id="
					+ contract_id + ", contract_version=" + contract_version + ", transfer_type=" + transfer_type
					+ ", ow_rtn=" + ow_rtn + /*", ow_percentage=" + ow_percentage +*/ ", valid_from=" + valid_from
					+ ", valid_to=" + valid_to + ", season_from=" + season_from + ", season_to=" + season_to
					+ ", currency=" + currency + ", additional_adult_rates_required=" + additional_adult_rates_required
					+ ", notes=" + notes + ", source_markets_rate_applies=" + source_markets_rate_applies + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((contract_id == null) ? 0 : contract_id.hashCode());
			result = prime * result + transfer_type_id;
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
			TransferTypeHistory other = (TransferTypeHistory) obj;
			if (contract_id == null) {
				if (other.contract_id != null)
					return false;
			} else if (!contract_id.equals(other.contract_id))
				return false;
			if (transfer_type_id != other.transfer_type_id)
				return false;
			return true;
		}



	 }
