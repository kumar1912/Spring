package com.tui.uk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_Airport_Check")
public class CountryValidation implements Serializable{

	@Id
	@Column(length = 100)
	private String airportid;

	@Column(length = 100)
	private String countryid;

	@Column(length = 100)
	private String countryname;

	public String getAirportId() {
		return airportid;
	}

	public void setAirportId(String airportId) {
		this.airportid = airportId;
	}

	public String getCountryId() {
		return countryid;
	}

	public void setCountryId(String countryId) {
		this.countryid = countryId;
	}

	public String getCountryName() {
		return countryname;
	}

	public void setCountryName(String countryName) {
		this.countryname = countryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportid == null) ? 0 : airportid.hashCode());
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
		CountryValidation other = (CountryValidation) obj;
		if (airportid == null) {
			if (other.airportid != null)
				return false;
		} else if (!airportid.equals(other.airportid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CountryValidation [airportId=" + airportid + ", countryId=" + countryid + ", countryName=" + countryname
				+ "]";
	}

	public CountryValidation(String airportId) {
		super();
		this.airportid = airportId;
	}

	public CountryValidation() {
		super();
		// TODO Auto-generated constructor stub
	}



}
