package com.tui.uk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_relations_rk")
public class Relations implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public  Long id;


	@Column(name = "parent_id", nullable = false)
	public Integer parent_id;

	@Column(name = "child_id", nullable = false)
	public Integer child_id;

	 @OneToOne(orphanRemoval=true)
	 @JoinColumn(name="id")
	 private NodeData node;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parentid) {
		this.parent_id = parentid;
	}

	public Integer getChild_id() {
		return child_id;
	}

	public void setChild_id(Integer child_id) {
		this.child_id = child_id;
	}

	public NodeData getNode() {
		return node;
	}

	public void setNode(NodeData node) {
		this.node = node;
	}

	public Relations(Long id, Integer parent_id, Integer child_id) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.child_id = child_id;
	}

	public Relations(){

	}

	@Override
	public String toString() {
		return "tr_relations [id=" + id + ", parent_id=" + parent_id + ", child_id=" + child_id + ", node=" + node
				+ "]";
	}



}
