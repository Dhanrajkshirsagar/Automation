package com.livehealth.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationResponse {
	
	@JsonIgnore
	int orgPrepaidModuleFlag;
	
	@JsonIgnore
	Object labUserList;

	ArrayList<Organization> organizationList = new ArrayList<Organization>();

	
	public int getOrgPrepaidModuleFlag() {
		return orgPrepaidModuleFlag;
	}

	@JsonIgnore
	public void setOrgPrepaidModuleFlag(int orgPrepaidModuleFlag) {
		this.orgPrepaidModuleFlag = orgPrepaidModuleFlag;
	}

	public Object getLabUserList() {
		return labUserList;
	}

	@JsonIgnore
	public void setLabUserList(Object labUserList) {
		this.labUserList = labUserList;
	}


	public ArrayList<Organization> getOrganizationList() {
		return organizationList;
	}

	@JsonProperty("OrganizationList")
	public void setOrganizationList(ArrayList<Organization> organizationList) {
		this.organizationList = organizationList;
	}
	
}
