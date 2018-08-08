package com.livehealth.model;

public class BillData {

	private String billId;

	private String referrelPriceList;

	private String discountPriceList;

	private String organization;

	private String referrel;

	private String patientAdvance;

	private String organizationAdvance;

	private String payableAmount;

	private String amountPaid;

	private String concession;

	private String testName;

	private String balanceRemaining;

	private String testPrice;

	private String additionalPrice;

	private String additionalServices;

	private String outSouceList;

	private String organizationPriceList;

	public String getOrganizationPriceList() {
		return organizationPriceList;
	}

	public void setOrganizationPriceList(String organizationPriceList) {
		this.organizationPriceList = organizationPriceList;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getOutSouceList() {
		return outSouceList;
	}

	public void setOutSouceList(String outSouceList) {
		this.outSouceList = outSouceList;
	}

	public String getReferrel() {
		return referrel;
	}

	public void setReferrel(String referrel) {
		this.referrel = referrel;
	}

	public String getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(String additionalServices) {
		this.additionalServices = additionalServices;
	}

	public String getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(String additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public String getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(String testPrice) {
		this.testPrice = testPrice;
	}

	public BillData() {
		super();
	}

	public String getBalanceRemaining() {
		return balanceRemaining;
	}

	public void setBalanceRemaining(String balanceRemaining) {
		this.balanceRemaining = balanceRemaining;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getReferrelPriceList() {
		return referrelPriceList;
	}

	public void setReferrelPriceList(String referrelPriceList) {
		this.referrelPriceList = referrelPriceList;
	}

	public String getDiscountPriceList() {
		return discountPriceList;
	}

	public void setDiscountPriceList(String discountPriceList) {
		this.discountPriceList = discountPriceList;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPatientAdvance() {
		return patientAdvance;
	}

	public void setPatientAdvance(String patientAdvance) {
		this.patientAdvance = patientAdvance;
	}

	public String getOrganizationAdvance() {
		return organizationAdvance;
	}

	public void setOrganizationAdvance(String organizationAdvance) {
		this.organizationAdvance = organizationAdvance;
	}

	public String getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getConcession() {
		return concession;
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}

	@Override
	public String toString() {
		return "BillData [billId=" + billId + ", referrelPriceList=" + referrelPriceList + ", discountPriceList="
				+ discountPriceList + ", organization=" + organization + ", referrel=" + referrel + ", patientAdvance="
				+ patientAdvance + ", organizationAdvance=" + organizationAdvance + ", payableAmount=" + payableAmount
				+ ", amountPaid=" + amountPaid + ", concession=" + concession + ", testName=" + testName
				+ ", balanceRemaining=" + balanceRemaining + ", testPrice=" + testPrice + ", additionalPrice="
				+ additionalPrice + ", additionalServices=" + additionalServices + ", outSouceList=" + outSouceList
				+ "]";
	}

}
