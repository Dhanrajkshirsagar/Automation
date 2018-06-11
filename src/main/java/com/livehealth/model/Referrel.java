package com.livehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Referrel {

	private int docId;

	private String docFullName;

	@JsonIgnore
	private String docAuthKey;

	@JsonIgnore
	private String isConfirm;

	@JsonIgnore
	private String docSignature;

	@JsonIgnore
	private String docPassKey;

	@JsonIgnore
	private String docUsername;

	@JsonIgnore
	private String docPassword;

	@JsonIgnore
	private String docContact;

	@JsonIgnore
	private String docCity;

	@JsonIgnore
	private String docEmail;

	@JsonIgnore
	private String docEmailFlag;

	@JsonIgnore
	private String docSMSFlag;

	@JsonIgnore
	private String docSpeciality;

	@JsonIgnore
	private String isReferral;

	@JsonIgnore
	private String isDefault;

	@JsonIgnore
	private String isDisable;

	@JsonIgnore
	private String reportAccessType;

	@JsonIgnore
	private String accessFlag;

	@JsonIgnore
	private String docRegNo;

	@JsonIgnore
	private String docAddress;

	@JsonIgnore
	private String docComments;

	@JsonIgnore
	private String tmpFlag;

	@JsonIgnore
	private String createdTime;

	@JsonIgnore
	private String lastUpdatedTime;

	@JsonIgnore
	private String profilePic;

	@JsonIgnore
	private String countryCode;

	@JsonIgnore
	private String docdateOfBirth;

	@JsonIgnore
	private String docDateOfAnniversary;

	@JsonIgnore
	private String designation;

	@JsonIgnore
	private String pinCode;

	@JsonIgnore
	private String isEMR;

	@JsonIgnore
	private String visitTimings;

	@JsonIgnore
	private String displayName;

	@JsonIgnore
	private String isParent;

	@JsonIgnore
	private String isdismissUpdatable;

	@JsonIgnore
	private String parentLabId;

	@JsonIgnore
	private String doctorFinanceDashboard;

	@JsonIgnore
	private String labForId;

	@JsonIgnore
	private String departmentId;

	@JsonIgnore
	private String authDoctorId;

	@JsonIgnore
	private String orgId;

	public Referrel() {
		super();
	}

	public String getDocSignature() {
		return docSignature;
	}

	@JsonIgnore
	public void setDocSignature(String docSignature) {
		this.docSignature = docSignature;
	}

	public String getDocPassKey() {
		return docPassKey;
	}

	@JsonIgnore
	public void setDocPassKey(String docPassKey) {
		this.docPassKey = docPassKey;
	}

	public String getDocUsername() {
		return docUsername;
	}

	@JsonIgnore
	public void setDocUsername(String docUsername) {
		this.docUsername = docUsername;
	}

	public String getDocPassword() {
		return docPassword;
	}

	@JsonIgnore
	public void setDocPassword(String docPassword) {
		this.docPassword = docPassword;
	}

	public String getDocContact() {
		return docContact;
	}

	@JsonIgnore
	public void setDocContact(String docContact) {
		this.docContact = docContact;
	}

	public String getDocCity() {
		return docCity;
	}

	@JsonIgnore
	public void setDocCity(String docCity) {
		this.docCity = docCity;
	}

	public String getDocEmail() {
		return docEmail;
	}

	@JsonIgnore
	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}

	public String getDocEmailFlag() {
		return docEmailFlag;
	}

	@JsonIgnore
	public void setDocEmailFlag(String docEmailFlag) {
		this.docEmailFlag = docEmailFlag;
	}

	public String getDocSMSFlag() {
		return docSMSFlag;
	}

	@JsonIgnore
	public void setDocSMSFlag(String docSMSFlag) {
		this.docSMSFlag = docSMSFlag;
	}

	public String getDocSpeciality() {
		return docSpeciality;
	}

	@JsonIgnore
	public void setDocSpeciality(String docSpeciality) {
		this.docSpeciality = docSpeciality;
	}

	public String getIsReferral() {
		return isReferral;
	}

	@JsonIgnore
	public void setIsReferral(String isReferral) {
		this.isReferral = isReferral;
	}

	public String getIsDefault() {
		return isDefault;
	}

	@JsonIgnore
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getIsDisable() {
		return isDisable;
	}

	@JsonIgnore
	public void setIsDisable(String isDisable) {
		this.isDisable = isDisable;
	}

	public String getReportAccessType() {
		return reportAccessType;
	}

	@JsonIgnore
	public void setReportAccessType(String reportAccessType) {
		this.reportAccessType = reportAccessType;
	}

	public String getAccessFlag() {
		return accessFlag;
	}

	@JsonIgnore
	public void setAccessFlag(String accessFlag) {
		this.accessFlag = accessFlag;
	}

	public String getDocRegNo() {
		return docRegNo;
	}

	@JsonIgnore
	public void setDocRegNo(String docRegNo) {
		this.docRegNo = docRegNo;
	}

	public String getDocAddress() {
		return docAddress;
	}

	@JsonIgnore
	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}

	public String getDocComments() {
		return docComments;
	}

	@JsonIgnore
	public void setDocComments(String docComments) {
		this.docComments = docComments;
	}

	public String getTmpFlag() {
		return tmpFlag;
	}

	@JsonIgnore
	public void setTmpFlag(String tmpFlag) {
		this.tmpFlag = tmpFlag;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	@JsonIgnore
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	@JsonIgnore
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getProfilePic() {
		return profilePic;
	}

	@JsonIgnore
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getCountryCode() {
		return countryCode;
	}

	@JsonIgnore
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDocdateOfBirth() {
		return docdateOfBirth;
	}

	@JsonIgnore
	public void setDocdateOfBirth(String docdateOfBirth) {
		this.docdateOfBirth = docdateOfBirth;
	}

	public String getDocDateOfAnniversary() {
		return docDateOfAnniversary;
	}

	@JsonIgnore
	public void setDocDateOfAnniversary(String docDateOfAnniversary) {
		this.docDateOfAnniversary = docDateOfAnniversary;
	}

	public String getDesignation() {
		return designation;
	}

	@JsonIgnore
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPinCode() {
		return pinCode;
	}

	@JsonIgnore
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getIsEMR() {
		return isEMR;
	}

	@JsonIgnore
	public void setIsEMR(String isEMR) {
		this.isEMR = isEMR;
	}

	public String getVisitTimings() {
		return visitTimings;
	}

	@JsonIgnore
	public void setVisitTimings(String visitTimings) {
		this.visitTimings = visitTimings;
	}

	public String getDisplayName() {
		return displayName;
	}

	@JsonIgnore
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getIsParent() {
		return isParent;
	}

	@JsonIgnore
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getIsdismissUpdatable() {
		return isdismissUpdatable;
	}

	@JsonIgnore
	public void setIsdismissUpdatable(String isdismissUpdatable) {
		this.isdismissUpdatable = isdismissUpdatable;
	}

	public String getIsConfirm() {
		return isConfirm;
	}

	@JsonIgnore
	public void setIsConfirm(String isConfirm) {
		this.isConfirm = isConfirm;
	}

	public String getParentLabId() {
		return parentLabId;
	}

	@JsonIgnore
	public void setParentLabId(String parentLabId) {
		this.parentLabId = parentLabId;
	}

	public String getDoctorFinanceDashboard() {
		return doctorFinanceDashboard;
	}

	@JsonIgnore
	public void setDoctorFinanceDashboard(String doctorFinanceDashboard) {
		this.doctorFinanceDashboard = doctorFinanceDashboard;
	}

	public String getLabForId() {
		return labForId;
	}

	@JsonIgnore
	public void setLabForId(String labForId) {
		this.labForId = labForId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	@JsonIgnore
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getAuthDoctorId() {
		return authDoctorId;
	}

	@JsonIgnore
	public void setAuthDoctorId(String authDoctorId) {
		this.authDoctorId = authDoctorId;
	}

	public String getOrgId() {
		return orgId;
	}

	@JsonIgnore
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDocAuthKey() {
		return docAuthKey;
	}

	@JsonIgnore
	public void setDocAuthKey(String docAuthKey) {
		this.docAuthKey = docAuthKey;
	}

	public int getDocId() {
		return docId;
	}

	@JsonIgnore
	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocFullName() {
		return docFullName;
	}

	public void setDocFullName(String docFullName) {
		this.docFullName = docFullName;
	}

	@Override
	public String toString() {
		return "Referrel [docId=" + docId + ", docFullName=" + docFullName + "]";
	}

}
