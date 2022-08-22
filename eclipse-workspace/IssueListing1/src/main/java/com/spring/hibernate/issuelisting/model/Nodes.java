package com.spring.hibernate.issuelisting.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="nodes")
@Entity
public class Nodes {
	@Id
	@Column(name = "iid", nullable = false)
	private int iid;
	@Column(name = "nodecreatedat")
	private Date nodecreatedAt;
	@Column(name = "humantimeestimate")
	private String humanTimeEstimate;
	@Column(name = "mergerequestscount")
	private int mergeRequestsCount;
	@Column(name = "nodetitle")
	private String nodetitle;
	@Column(name = "nodeupdatedat")
	private Date nodeupdatedAt;
	@Column(name = "userdiscussionscount")
	private int userDiscussionsCount;
	@Column(name = "nodeweburl")
	private String nodeWebUrl;
	@Column(name = "authid")
	private String authId;
	@Column(name = "authweburl")
	private String authwebUrl;
	@Column(name="state")
	private  String state;
	@Column(name="module")
	private  String module ;
	@Column(name="labelproject")
	private  String labelproject;
	@Column(name = "startdate")
	private Date iterationstartDate;
	@Column(name = "iterationduedate")
	private Date iterationdueDate;
	@Column(name = "milestonetitle")
	private String milestonetitle;
	@Column(name = "authname")
	private String authname;
	@Column(name = "type")
	private String type;
	@Column(name = "team")
	private String team;
	@Column(name = "labelstate")
	private String labelState;
	@OneToMany(mappedBy = "nodeLabel",cascade = CascadeType.ALL)
	private List<Labels> labels;
	@OneToMany(mappedBy = "nodeAssignees",cascade = CascadeType.ALL)
	private List<Assignees> assignees;
	@OneToMany(mappedBy = "nodeIteration",cascade = CascadeType.ALL)
	private List<Iteration> iteration;
	@OneToMany(mappedBy = "nodeMileStone",cascade = CascadeType.ALL)
	private List<MileStone> mileStone;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getHumanTimeEstimate() {
		return humanTimeEstimate;
	}
	public void setHumanTimeEstimate(String humanTimeEstimate) {
		this.humanTimeEstimate = humanTimeEstimate;
	}
	public int getMergeRequestsCount() {
		return mergeRequestsCount;
	}
	public void setMergeRequestsCount(int mergeRequestsCount) {
		this.mergeRequestsCount = mergeRequestsCount;
	}
	public String getNodetitle() {
		return nodetitle;
	}
	public void setNodetitle(String nodetitle) {
		this.nodetitle = nodetitle;
	}
		public int getUserDiscussionsCount() {
		return userDiscussionsCount;
	}
	public void setUserDiscussionsCount(int userDiscussionsCount) {
		this.userDiscussionsCount = userDiscussionsCount;
	}
	public String getNodeWebUrl() {
		return nodeWebUrl;
	}
	public void setNodeWebUrl(String nodeWebUrl) {
		this.nodeWebUrl = nodeWebUrl;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthwebUrl() {
		return authwebUrl;
	}
	public void setAuthwebUrl(String authwebUrl) {
		this.authwebUrl = authwebUrl;
	}
	public String getAuthname() {
		return authname;
	}
	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getNodecreatedAt() {
		return nodecreatedAt;
	}

	public void setNodecreatedAt(Object nodecreatedAt) {
		this.nodecreatedAt = (Date) nodecreatedAt;
	}

	public Date getNodeupdatedAt() {
		return nodeupdatedAt;
	}

	public void setNodecreatedAt(Date nodecreatedAt) {
		this.nodecreatedAt = nodecreatedAt;
	}

	public void setNodeupdatedAt(Date nodeupdatedAt) {
		this.nodeupdatedAt = nodeupdatedAt;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getLabelproject() {
		return labelproject;
	}

	public void setLabelproject(String labelproject) {
		this.labelproject = labelproject;
	}

	public Date getIterationstartDate() {
		return iterationstartDate;
	}

	public void setIterationstartDate(Date iterationstartDate) {
		this.iterationstartDate = iterationstartDate;
	}

	public Date getIterationdueDate() {
		return iterationdueDate;
	}

	public void setIterationdueDate(Date iterationdueDate) {
		this.iterationdueDate = iterationdueDate;
	}

	public String getMilestonetitle() {
		return milestonetitle;
	}

	public void setMilestonetitle(String milestonetitle) {
		this.milestonetitle = milestonetitle;
	}

	public void setNodeupdatedAt(Object nodeupdatedAt) {
		this.nodeupdatedAt = (Date) nodeupdatedAt;
	}

	public List<Labels> getLabels() {
		return labels;
	}

	public void setLabels(List<Labels> labels) {
		this.labels = labels;
	}

	public List<Assignees> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<Assignees> assignees) {
		this.assignees = assignees;
	}

	public List<Iteration> getIteration() {
		return iteration;
	}

	public void setIteration(List<Iteration> iteration) {
		this.iteration = iteration;
	}

	public List<MileStone> getMileStone() {
		return mileStone;
	}

	public void setMileStone(List<MileStone> mileStone) {
		this.mileStone = mileStone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLabelState() {
		return labelState;
	}

	public void setLabelState(String labelState) {
		this.labelState = labelState;
	}
}