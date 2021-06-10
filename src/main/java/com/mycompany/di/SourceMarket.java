package com.tui.uk.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_source_market")

public class SourceMarket implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@NotNull
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(length = 20)
String source_market_id;

@Column(length = 20)
String source_market_abrivation;

@Column(length = 20)
String source_market_name;

public String getSource_market_id() {
	return source_market_id;
}

@Override
public String toString() {
	return "SourceMarket [source_market_id=" + source_market_id + ", source_market_abrivation="
			+ source_market_abrivation + ", source_market_name=" + source_market_name + "]";
}

public SourceMarket() {
	super();
}

public SourceMarket(String source_market_id, String source_market_abrivation, String source_market_name) {
	super();
	this.source_market_id = source_market_id;
	this.source_market_abrivation = source_market_abrivation;
	this.source_market_name = source_market_name;
}

public void setSource_market_id(String source_market_id) {
	this.source_market_id = source_market_id;
}

public String getSource_market_abrivation() {
	return source_market_abrivation;
}

public void setSource_market_abrivation(String source_market_abrivation) {
	this.source_market_abrivation = source_market_abrivation;
}

public String getSource_market_name() {
	return source_market_name;
}

public void setSource_market_name(String source_market_name) {
	this.source_market_name = source_market_name;
}

}
