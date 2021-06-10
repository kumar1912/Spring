package com.tui.uk.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * Season
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_season")
public class Season {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="season_from")
	private String season_from;

	@Column(name="season_to")
	private String season_to;

	@Column(name="start_date")
	private Date start_date;

	@Column(name="end_date")
	private Date end_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeason_from() {
		return season_from;
	}

	public void setSeason_from(String season_from) {
		this.season_from = season_from;
	}

	public String getSeason_to() {
		return season_to;
	}

	public void setSeason_to(String season_to) {
		this.season_to = season_to;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Season() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Season [id=" + id + ", season_from=" + season_from + ", season_to=" + season_to + ", start_date="
				+ start_date + ", end_date=" + end_date + "]";
	}


}
