package com.tui.uk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_node_auto_increment")
public class NodeAutoIncrement implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "AUTO_INCREMENT")
	int AUTO_INCREMENT;

	public int getAUTO_INCREMENT() {
		return AUTO_INCREMENT;
	}

	public void setAUTO_INCREMENT(int AUTO_INCREMENT) {
		this.AUTO_INCREMENT = AUTO_INCREMENT;
	}

	public NodeAutoIncrement(int AUTO_INCREMENT) {
		super();
		this.AUTO_INCREMENT = AUTO_INCREMENT;
	}

	public NodeAutoIncrement() {
		super();
	}


}
