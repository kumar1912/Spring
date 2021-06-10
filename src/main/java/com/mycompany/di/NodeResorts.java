
package com.tui.uk.domain;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_node_resorts")
public class NodeResorts implements Serializable {

	private static final long serialVersionUID = 1L;


	@Column
    private String country;


    @Column
    private String countryresort;

    @Id
    private String resort;

	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}

	public NodeResorts(){
		super();
	}
	public NodeResorts(String country, String countryresort, String resort) {
		super();
		this.country = country;
		this.countryresort = countryresort;
		this.resort = resort;
	}

	public String getCountryresort() {
		return countryresort;
	}

	public void setCountryresort(String countryresort) {
		this.countryresort = countryresort;
	}



	public String getResort() {
		return resort;
	}



	public void setResort(String resort) {
		this.resort = resort;
	}

	@Override
	public String toString() {
		return "NodeResorts [country=" + country + ", countryresort=" + countryresort + ", resort=" + resort + "]";
	}


}
