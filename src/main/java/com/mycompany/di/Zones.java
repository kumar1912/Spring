
package com.tui.uk.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_zone")
public class Zones implements Serializable {


	private static final long serialVersionUID = 1L;

    public Zones() {
		super();
	}

	public Zones(int zone_id, String zone, String resort,String accomodation, String dmc_name, String country, Date effective_from,
			Date effective_to,String resort_code,String accomodation_code,String gateway,String gateway_code) {
		super();
		this.zone_id = zone_id;
		this.zone = zone;
		this.resort = resort;
		this.accomodation=accomodation;
		this.dmc_name = dmc_name;
		this.country = country;
		this.effective_from = effective_from;
		this.effective_to = effective_to;
		this.resort_code=resort_code;
		this.accomodation_code=accomodation_code;
		this.gateway=gateway;
		this.gateway_code=gateway_code;
	}

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zone_id;


    @Column
    private String zone;


	@Column
    private String resort;
	
	@Column
    private String resort_code;
	
	@Column
    private String gateway;
	
	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getGateway_code() {
		return gateway_code;
	}

	public void setGateway_code(String gateway_code) {
		this.gateway_code = gateway_code;
	}

	@Column
    private String gateway_code;
	
	@Column
    private String accomodation;
	
	@Column
    private String accomodation_code;

    @Column
    private String dmc_name;

    @Column
    private String country;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date effective_from;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date effective_to;




	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getResort() {
		return resort;
	}

	public void setResort(String resort) {
		this.resort = resort;
	}

	public String getdmc_name() {
		return dmc_name;
	}

	public void setdmc_name(String dmc_name) {
		this.dmc_name = dmc_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	
	public String getResort_code() {
		return resort_code;
	}

	public void setResort_code(String resort_code) {
		this.resort_code = resort_code;
	}

	public String getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}

	public String getAccomodation_code() {
		return accomodation_code;
	}

	public void setAccomodation_code(String accomodation_code) {
		this.accomodation_code = accomodation_code;
	}

	@Override
	public String toString() {
		return "Zones [zone_id=" + zone_id + ", zone=" + zone + ", resort=" + resort + ", dmc_name=" + dmc_name
				+ ", country=" + country + ", effective_from=" + effective_from + ", effective_to=" + effective_to
				+ "]";
	}


}
