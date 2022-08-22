package com.spring.hibernate.issuelisting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="labels")
@Entity
public class Labels {

	/* @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="labelid", nullable = false) 
	private int labelid;*/
	@Id
	@Column(name = "Lableid")
	private String Lableid;
	@Column(name = "titlekey")
	private String titleKey;
	@Column(name = "titlevalue")
	private String titleValue;
    @ManyToOne
    @JoinColumn(name = "nodes_qid")
    private Nodes nodeLabel;

	public Nodes getNodeLabel() {
		return nodeLabel;
	}

	public void setNodeLabel(Nodes nodeLabel) {
		this.nodeLabel = nodeLabel;
	}
/*

	  public int getLabelid() { 
		  return labelid; 
		  }
	  public void setLabelid(int labelid) {
		  this.labelid = labelid; 
		  }
*/

	public String getLableid() {
		return Lableid;
	}
	public void setLableid(String lableid) {
		Lableid = lableid;
	}
	public String getTitleKey() {
		return titleKey;
	}
	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}
	public String getTitleValue() {
		return titleValue;
	}
	public void setTitleValue(String titleValue) {
		this.titleValue = titleValue;
	}
	
	
}
