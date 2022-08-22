package com.spring.hibernate.issuelisting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assignees")
public class Assignees {
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "assigneeiid", nullable = false)
	private int assigneeiid;
	*/
	@Id
	@Column(name = "assigneeid")
	private String assigneeid;
	@Column(name = "assigneename")
	private String assigneename;
	@Column(name = "assigneeweburl")
	private String assigneeweburl;
	@ManyToOne
	@JoinColumn(name = "nodes_qid")
	private Nodes nodeAssignees;

	public Nodes getNodeAssignees() {
		return nodeAssignees;
	}

	public void setNodeAssignees(Nodes nodeAssignees) {
		this.nodeAssignees = nodeAssignees;
	}

	/*public int getAssigneeiid() {
                return assigneeiid;
            }

            public void setAssigneeiid(int assigneeiid) {
                this.assigneeiid = assigneeiid;
            }
        */
	public String getAssigneeid() {
		return assigneeid;
	}

	public void setAssigneeid(String assigneeid) {
		this.assigneeid = assigneeid;
	}

	public String getAssigneename() {
		return assigneename;
	}

	public void setAssigneename(String assigneename) {
		this.assigneename = assigneename;
	}

	public String getAssigneeweburl() {
		return assigneeweburl;
	}

	public void setAssigneeweburl(String assigneeweburl) {
		this.assigneeweburl = assigneeweburl;
	}

}
