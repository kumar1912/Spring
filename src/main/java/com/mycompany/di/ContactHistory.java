package com.tui.uk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Contract Contact History.
 */
@Entity
@Table(name = "tr_contact_history")
public class ContactHistory{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="contact_id")
	private int contact_id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="contract_id")
	private String contract_id;

    @Column(name="contract_version")
   	private double contract_version;

    @Column(name="last_name")
    private String lastName;


    @Column(name="contact_type")
    private String contact_type;


    @Column(name="email_address")
    private String email_address;


    @Column(name="telephone")
    private String telephone;


    @Column(name="mobile_name")
    private String mobile_number;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getContact_type() {
		return contact_type;
	}


	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}


	public String getEmail_address() {
		return email_address;
	}


	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public int getContact_id() {
		return contact_id;
	}


	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "ContactHistory [id=" + id + ", contact_id=" + contact_id + ", firstName=" + firstName + ", contract_id="
				+ contract_id + ", contract_version=" + contract_version + ", lastName=" + lastName + ", contact_type="
				+ contact_type + ", email_address=" + email_address + ", telephone=" + telephone + ", mobile_number="
				+ mobile_number + "]";
	}


	public ContactHistory() {
		super();
	}


	public ContactHistory(Long id, int contact_id, String firstName, String contract_id, String lastName, String contact_type,
			String email_address, String telephone, String mobile_number,double contract_version) {
		super();
		this.id = id;
		this.contact_id=contact_id;
		this.firstName = firstName;
		this.contract_id = contract_id;
		this.lastName = lastName;
		this.contact_type = contact_type;
		this.email_address = email_address;
		this.telephone = telephone;
		this.mobile_number = mobile_number;
		this.contract_version = contract_version;
	}


	public ContactHistory(Contact contact){
		this.id = id;
		this.contact_id=contact.getId();
		this.firstName = contact.getFirstName();
		this.contract_id = contact.getContract_id();
		this.lastName = contact.getLastName();
		this.contact_type = contact.getContact_type();
		this.email_address = contact.getEmail_address();
		this.telephone = contact.getTelephone();
		this.mobile_number = contact.getMobile_number();
		this.contract_version = contract_version;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contact_id;
		result = prime * result + ((contract_id == null) ? 0 : contract_id.hashCode());
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
		ContactHistory other = (ContactHistory) obj;
		if (contact_id != other.contact_id)
			return false;
		if (contract_id == null) {
			if (other.contract_id != null)
				return false;
		} else if (!contract_id.equals(other.contract_id))
			return false;
		return true;
	}


	

}

