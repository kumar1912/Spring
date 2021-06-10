package com.tui.uk.domain;


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

import com.tui.uk.domain.Currency;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_currency_history")
public class CurrencyHistory {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="currency_history_id")
    private Long currency_history_id;

    @Column(name="currency_id")
    private Long currency_id;

    @Column(name="contract_id ")
    private String contract_id;

    @Column(name="contract_version ")
    private double contract_version;

    @Column(name="currency ")
    private String currency;

    @Column(name="notes ")
    private String notes;


   /* @ManyToOne
    @JoinTable(
        name = "tr_contract",
        joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "contract_id")})*/

    public Long getCurrency_history_id() {
		return currency_history_id;
	}

	public void setCurrency_history_id(Long currency_history_id) {
		this.currency_history_id = currency_history_id;
	}

	public Long getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(Long currency_id) {
		this.currency_id = currency_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CurrencyHistory() {
		super();
	}

	public CurrencyHistory(Long currency_history_id, Long currency_id, String contract_id, double contract_version,
			String currency, String notes) {
		super();
		this.currency_history_id = currency_history_id;
		this.currency_id = currency_id;
		this.contract_id = contract_id;
		this.contract_version = contract_version;
		this.currency = currency;
		this.notes = notes;
	}


	public CurrencyHistory(Currency currency) {
		super();
		this.currency_history_id = currency_history_id;
		this.currency_id = currency.getCurrency_id();
		this.contract_id = currency.getContract_id();
		this.contract_version = contract_version;
		this.currency = currency.getCurrency();
		this.notes = currency.getNotes();
	}

	@Override
	public String toString() {
		return "CurrencyHistory [currency_history_id=" + currency_history_id + ", currency_id=" + currency_id
				+ ", contract_id=" + contract_id + ", contract_version=" + contract_version + ", currency=" + currency
				+ ", notes=" + notes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contract_id == null) ? 0 : contract_id.hashCode());
		result = prime * result + ((currency_id == null) ? 0 : currency_id.hashCode());
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
		CurrencyHistory other = (CurrencyHistory) obj;
		if (contract_id == null) {
			if (other.contract_id != null)
				return false;
		} else if (!contract_id.equals(other.contract_id))
			return false;
		if (currency_id == null) {
			if (other.currency_id != null)
				return false;
		} else if (!currency_id.equals(other.currency_id))
			return false;
		return true;
	}





}
