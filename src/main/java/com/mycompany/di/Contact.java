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
 * A ContractContact.
 */
@Entity
@Table(name = "test_contact")
public class Contact implements Cloneable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="contract_id")
	private String contract_id;

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

    @Column(name="position")
    private String position;

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


	public int getId() {
		return id;
	}


	public void setId(int id) {
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




	public String getContract_id() {
		return contract_id;
	}


	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}



	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	public Contact() {
		super();
	}

	public Contact(int id, String firstName, String contract_id, String lastName, String contact_type,
			String email_address, String telephone, String mobile_number, String position) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.contract_id = contract_id;
		this.lastName = lastName;
		this.contact_type = contact_type;
		this.email_address = email_address;
		this.telephone = telephone;
		this.mobile_number = mobile_number;
		this.position = position;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", contract_id=" + contract_id + ", lastName="
				+ lastName + ", contact_type=" + contact_type + ", email_address=" + email_address + ", telephone="
				+ telephone + ", mobile_number=" + mobile_number + ", position=" + position + "]";
	}


	public Object clone()throws CloneNotSupportedException{
		Contact contact =  new Contact (  id,   firstName,   contract_id,   lastName,   contact_type,
				  email_address,   telephone,   mobile_number, position
		);
		return contact;
		}

}
