package com.spring.hibernate.issuelisting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="milestone")
@Entity
public class MileStone {
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "milestoneiid", nullable = false)
	private int milestoneiid;
*/  @Id
	@Column(name = "mileStoneid")
	private String milestoneid;
	@Column(name = "milestonetitle")
	private String milestonetitle;
	@ManyToOne
	@JoinColumn(name = "nodes_qid")
	private Nodes nodeMileStone;

	public Nodes getNodeMileStone() {
		return nodeMileStone;
	}

	public void setNodeMileStone(Nodes nodeMileStone) {
		this.nodeMileStone = nodeMileStone;
	}
/*

	public int getMilestoneiid() {
		return milestoneiid;
	}

	public void setMilestoneiid(int milestoneiid) {
		this.milestoneiid = milestoneiid;
	}
*/

	public String getMilestoneid() {
		return milestoneid;
	}

	public void setMilestoneid(String milestoneid) {
		this.milestoneid = milestoneid;
	}

	public String getMilestonetitle() {
		return milestonetitle;
	}

	public void setMilestonetitle(String milestonetitle) {
		this.milestonetitle = milestonetitle;
	}

}
