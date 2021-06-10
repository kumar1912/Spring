
package com.tui.uk.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;




@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_node_accomodation")
public class NodeAccoms implements Serializable {

    @Override
	public String toString() {
		return "NodeResorts [country=" + country + ", state=" + state + ", destination=" + destination + ", resort="
				+ accomodation + "]";
	}


	private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private String country;


    @Column
    private String state;


	@Column
    private String destination;


    @Column
    private String accomodation;





	public NodeAccoms(String country, String state, String destination, String resort) {
		super();
		this.country = country;
		this.state = state;
		this.destination = destination;
		this.accomodation = resort;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}




	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getResort() {
		return accomodation;
	}



	public void setResort(String resort) {
		this.accomodation = resort;
	}


	public NodeAccoms() {
		super();
	}


}
