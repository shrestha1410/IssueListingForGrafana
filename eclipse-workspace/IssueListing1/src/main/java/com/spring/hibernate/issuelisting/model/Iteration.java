package com.spring.hibernate.issuelisting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="iteration")
@Entity
public class Iteration {
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "iterationiid", nullable = false)
	private int iterationiid;

*/
	@Id
	@Column(name = "iterationid")
	private String Iterationid;
	@Column(name = "iterationtitle")
	private String iterationtitle;
	@Column(name = "startdate")
	private Date iterationstartDate;
	@Column(name = "iterationcadencetitle")
	private String iterationCadenceTitle;
	@Column(name = "iterationduedate")
	private Date iterationdueDate;
	@ManyToOne
	@JoinColumn(name = "nodes_qid")
	private  Nodes nodeIteration;

	public Nodes getNodeIteration() {
		return nodeIteration;
	}

	public void setNodeIteration(Nodes nodeIteration) {
		this.nodeIteration = nodeIteration;
	}

	/*public int getIterationiid() {
                return iterationiid;
            }

            public void setIterationiid(int iterationiid) {
                this.iterationiid = iterationiid;
            }
        */
	public String getIterationid() {
		return Iterationid;
	}

	public void setIterationid(String iterationid) {
		Iterationid = iterationid;
	}

	public String getIterationtitle() {
		return iterationtitle;
	}

	public Date getIterationstartDate() {
		return iterationstartDate;
	}

	public void setIterationstartDate(Date iterationstartDate) {
		this.iterationstartDate = iterationstartDate;
	}

	public String getIterationCadenceTitle() {
		return iterationCadenceTitle;
	}

	public void setIterationCadenceTitle(String iterationCadenceTitle) {
		this.iterationCadenceTitle = iterationCadenceTitle;
	}

	public Date getIterationdueDate() {
		return iterationdueDate;
	}

	public void setIterationdueDate(Date iterationdueDate) {
		this.iterationdueDate = iterationdueDate;
	}

	public void setIterationtitle(String iterationtitle) {
		this.iterationtitle = iterationtitle;
	}

}
