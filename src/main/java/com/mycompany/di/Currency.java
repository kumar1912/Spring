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
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_currency")
public class Currency implements Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="currency_id")
    private Long currency_id;


    @Column(name="contract_id ")
    private String contract_id;

    @Column(name="currency ")
    private String currency;

    @Column(name="notes ")
    private String notes;

	@Version
	@Column(name="jpa_version")
    private int jpa_version;
    
    public int getJpa_version() {
		return jpa_version;
	}

	public void setJpa_version(int jpa_version) {
		this.jpa_version = jpa_version;
	}

	@ManyToOne
    @JoinTable(
        name = "tr_contract",
        joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "contract_id")})


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

	public Currency(Long currency_id, String contract_id, String currency, String notes) {
		super();
		this.currency_id = currency_id;
		this.contract_id = contract_id;
		this.currency = currency;
		this.notes = notes;
	}

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Currency [currency_id=" + currency_id + ", contract_id=" + contract_id + ", currency=" + currency
				+ ", notes=" + notes + "]";
	}

	public Object clone()throws CloneNotSupportedException{
		Currency currencyObj =  new Currency ( currency_id,contract_id,currency,notes);
		return currencyObj;
		}

}
