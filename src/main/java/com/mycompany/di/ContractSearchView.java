
package com.tui.uk.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.io.Serializable;



@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "tr_contract_search_view")
public class ContractSearchView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 45)
    private String cmd_id;


    @Column(length = 100)
    private String cmd_name;


	@Override
	public String toString() {
		return "ContractSearchView [cmd_id=" + cmd_id + ", cmd_name=" + cmd_name + "]";
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

	public ContractSearchView() {

	}



}
