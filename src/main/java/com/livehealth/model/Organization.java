package com.livehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {

	private int orgId;

	private String orgFullName;

	public Organization(int orgId, String orgFullName) {
		this.orgId = orgId;
		this.orgFullName = orgFullName;
	}

	public Organization() {

	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgFullName() {
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgFullName=" + orgFullName + "]";
	}

}
