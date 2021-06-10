
package com.tui.uk.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_nodes_view")
public class NodesView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private int id;


    @Column
    private String cmd_id;


    public NodesView(int id, String cmd_id, String cmd_name, String subtype, int parent_id) {
		super();
		this.id = id;
		this.cmd_id = cmd_id;
		this.cmd_name = cmd_name;
		this.subtype = subtype;
		this.parent_id = parent_id;
	}






	public String getCmd_id() {
		return cmd_id;
	}






	public void setCmd_id(String cmd_id) {
		this.cmd_id = cmd_id;
	}






	@Column
    private String cmd_name;



    @Column
    private String subtype;

    @Column
    private int parent_id;






	public NodesView(int id, String cmd_name, String subtype, int parent_id) {
		super();
		this.id = id;
		this.cmd_name = cmd_name;
		this.subtype = subtype;
		this.parent_id = parent_id;
	}






	@Override
	public String toString() {
		return "NodesView [id=" + id + ", cmd_name=" + cmd_name + ", subtype=" + subtype + ", parent_id=" + parent_id
				+ "]";
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getCmd_name() {
		return cmd_name;
	}






	public void setCmd_name(String cmd_name) {
		this.cmd_name = cmd_name;
	}






	public String getSubtype() {
		return subtype;
	}






	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}






	public int getParent_id() {
		return parent_id;
	}






	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}






	public NodesView() {
		super();
	}










}
