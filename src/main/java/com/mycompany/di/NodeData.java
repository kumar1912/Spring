package com.tui.uk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_node_rk")
public class NodeData  implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public  Long id;

	@Column(name = "cmd_id", nullable = true)
	public String cmd_id;

	@Column(name = "cmd_name", nullable = true)
	public String cmd_name;

	@Column
	public String type;

	@Column
	public String subtype;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmd_id() {
		return cmd_id;
	}

	public void setCmd_id(String cmd_id) {
		this.cmd_id = cmd_id;
	}

	public String getCmd_name() {
		return cmd_name;
	}

	public void setCmd_name(String cmd_name) {
		this.cmd_name = cmd_name;
	}

	public NodeData(Long id, String cmd_id, String cmd_name) {
		super();
		this.id = id;
		this.cmd_id = cmd_id;
		this.cmd_name = cmd_name;
	}

	public NodeData(){

	}

	public NodeData(Long id, String cmd_id, String cmd_name, String type, String subtype) {
		super();
		this.id = id;
		this.cmd_id = cmd_id;
		this.cmd_name = cmd_name;
		this.type = type;
		this.subtype = subtype;
	}

	@Override
	public String toString() {
		return "NodeData [id=" + id + ", cmd_id=" + cmd_id + ", cmd_name=" + cmd_name + ", type=" + type + ", subtype="
				+ subtype + "]";
	}



}
