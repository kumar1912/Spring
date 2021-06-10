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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_transport_method")
public class TransportMethod {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="transport_method_id")
	    private int transport_method_id;

	    @Column(name="transport_method")
	    private String transport_method;

	    @JsonSerialize(as = Date.class)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	    @Column(name="effective_from")
		private Date effective_from;

	    @JsonSerialize(as = Date.class)
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	    @Column(name="effective_to")
	    private Date effective_to;

		public int getTransport_method_id() {
			return transport_method_id;
		}

		public void setTransport_method_id(int transport_method_id) {
			this.transport_method_id = transport_method_id;
		}

		public String getTransport_method() {
			return transport_method;
		}

		public void setTransport_method(String transport_method) {
			this.transport_method = transport_method;
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

		public TransportMethod() {
			super();
		}

		public TransportMethod(int transport_method_id, String transport_method, Date effective_from,
				Date effective_to) {
			super();
			this.transport_method_id = transport_method_id;
			this.transport_method = transport_method;
			this.effective_from = effective_from;
			this.effective_to = effective_to;
		}

		@Override
		public String toString() {
			return "TransportMethod [transport_method_id=" + transport_method_id + ", transport_method="
					+ transport_method + ", effective_from=" + effective_from + ", effective_to=" + effective_to + "]";
		}




}
