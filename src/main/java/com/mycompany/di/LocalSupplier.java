/**
 *
 */
package com.tui.uk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * LocalSupplier
 *
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_local_supplier")
public class LocalSupplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="local_supplier_Id")
	private int local_supplier_Id;

	@Column(name="local_supplier_code")
	private String local_supplier_code;

	@Column(name="supplier_code")
	private String supplier_code;

	@Column(name="source_market_id")
	private String source_market_id;

	@Column(name="local_supplier_name")
	private String local_supplier_name;

	public int getLocal_supplier_Id() {
		return local_supplier_Id;
	}

	public String getLocal_supplier_name() {
		return local_supplier_name;
	}

	public void setLocal_supplier_name(String local_supplier_name) {
		this.local_supplier_name = local_supplier_name;
	}

	public LocalSupplier(int local_supplier_Id, String local_supplier_code, String supplier_code,
			String source_market_id, String local_supplier_name) {
		super();
		this.local_supplier_Id = local_supplier_Id;
		this.local_supplier_code = local_supplier_code;
		this.supplier_code = supplier_code;
		this.source_market_id = source_market_id;
		this.local_supplier_name = local_supplier_name;
	}

	@Override
	public String toString() {
		return "LocalSupplier [local_supplier_Id=" + local_supplier_Id + ", local_supplier_code=" + local_supplier_code
				+ ", supplier_code=" + supplier_code + ", source_market_id=" + source_market_id
				+ ", local_supplier_name=" + local_supplier_name + "]";
	}

	public void setLocal_supplier_Id(int local_supplier_Id) {
		this.local_supplier_Id = local_supplier_Id;
	}

	public String getLocal_supplier_code() {
		return local_supplier_code;
	}

	public void setLocal_supplier_code(String local_supplier_code) {
		this.local_supplier_code = local_supplier_code;
	}

	public String getSupplier_code() {
		return supplier_code;
	}

	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}

	public String getSource_market_id() {
		return source_market_id;
	}

	public void setSource_market_id(String source_market_id) {
		this.source_market_id = source_market_id;
	}





	public LocalSupplier(){
		super();
	}

}