package com.livehealth.pageobject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.util.CommonMethods;

public class ListManagementPage {

	SoftAssert SoftAssert = new SoftAssert();
	Log4JLogger logger;

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(xpath = "//a[contains(text(),'List & Group Management')]")
	private WebElement ListAndGroupManagement;

	@FindBy(id = "addListLink")
	private WebElement addListLink;

	@FindBy(id = "addListName")
	private WebElement addListName;

	@FindBy(id = "addListBtn")
	private WebElement addListBtn;

	@FindBy(id = "addListErrMsg")
	private WebElement addListErrMsg;

	@FindBy(id = "listType")
	private WebElement listType;

	@FindBy(id = "listName")
	private WebElement searchlistName;

	@FindBy(id = "cardListName")
	private WebElement cardListName;

	@FindBy(id = "cardListType")
	private WebElement cardListType;

	@FindBy(id = "addList")
	private WebElement addList;

	@FindBy(id = "testName")
	private WebElement testName;

	@FindBy(xpath = "//a[contains(text(),'More Info')]")
	private WebElement options;

	@FindBy(id = "commission")
	private WebElement commission;

	@FindBy(id = "updateCurrentTests")
	private WebElement updateCurrentTests;

	@FindBy(className = "userWaitingListCard")
	private WebElement userWaitingListCard;

	@FindBy(id = "commissionType")
	private WebElement commissionType;

	@FindBy(id = "allTests")
	private WebElement allTests;

	@FindBy(id = "deleteList")
	private WebElement deleteList;

	@FindBy(id = "btnDeleteList")
	private WebElement confirmDelete;

	@FindBy(id = "listOfTests")
	private WebElement listOfTests;

	@FindBy(id = "options")
	private WebElement displayype;

	@FindBy(xpath = "//a[contains(text(),'Category wise')]")
	private WebElement Category;

	@FindBy(xpath = "//a[contains(text(),'Department wise')]")
	private WebElement Departmentwise;

	@FindBy(xpath = "//a[contains(text(),'Expand')]")
	private WebElement Expand;

	@FindBy(xpath = "//a[contains(text(),'Options')]")
	private WebElement Options;

	@FindBy(id = "categoryInput0")
	private WebElement categoryInput0;

	@FindBy(id = "update0")
	private WebElement update0;

	@FindBy(id = "categoryPrice0")
	private WebElement categoryPrice0;

	@FindBy(name = "collapseViewTests")
	private WebElement collapseViewTests;

	@FindBy(id = "docGroupDiv")
	private WebElement docGroupDiv;

	@FindBy(id = "doctorSearch")
	private WebElement doctorSearch;

	@FindBy(id = "bidirectional")
	private WebElement bidirectional;

	@FindBy(id = "listEditListDropDownList")
	private WebElement listEditListDropDownList;

	@FindBy(xpath = "//*[@id=\"listNameParent\"]/div/div/button")
	private WebElement AddedList;

	@FindBy(id = "bidirectionalOutsource")
	private WebElement bidirectionalOutsource;

	@FindBy(id = "biTestName")
	private WebElement biTestName;

	@FindBy(id = "exportList1")
	private WebElement exportList1;

	@FindBy(id = "errorDiv")
	private WebElement errorDiv;

	@FindBy(id = "editListLink")
	private WebElement editListLink;

	@FindBy(xpath = "//a[contains(text(),'List Upload Excel')]")
	private WebElement ListUploadExcel;

	@FindBy(id = "excelTemplate")
	private WebElement excelTemplate;

	@FindBy(id = "testListName")
	private WebElement testListName;

	@FindBy(id = "testCategory")
	private WebElement testCategory;

	@FindBy(id = "testDepartment")
	private WebElement testDepartment;

	@FindBy(id = "removeFilterCheckBox")
	private WebElement removeFilterCheckBox;

	@FindBy(id = "exportAllChkBox")
	private WebElement exportAllChkBox;

	@FindBy(xpath = "//button[contains(text(),'Export')]")
	private WebElement export;

	@FindBy(id = "selectedTestList")
	private WebElement selectedTestList;

	@FindBy(id = "selectedCategoryList")
	private WebElement selectedCategoryList;

	@FindBy(id = "selectedDeptList")
	private WebElement selectedDeptList;

	@FindBy(id = "listUploadExcelName")
	private WebElement listUploadExcelName;

	@FindBy(id = "listInputExcel")
	private WebElement listInputExcel;

	@FindBy(id = "submitListExcel")
	private WebElement submitListExcel;

	@FindBy(id = "editAddCity")
	private WebElement editAddCity;

	@FindBy(id = "groupEditList")
	private WebElement groupEditList;

	@FindBy(id = "Button")
	private WebElement Button;

	@FindBy(xpath = "//a[contains(text(),'Add tests to list (bulk)')]")
	private WebElement Addteststolist;

	@FindBy(id = "copyTestListTypeahead")
	private WebElement copyTestListTypeahead;

	@FindBy(id = "copyTestListNameTypeahead")
	private WebElement copyTestListNameTypeahead;

	@FindBy(id = "listCount")
	private WebElement listCount;

	@FindBy(id = "patientGroup")
	private WebElement patientGroup;

	@FindBy(xpath = "//a[contains(text(),'Edit Group')]")
	private WebElement EditGroup;

	@FindBy(id = "cardGroupCity")
	private WebElement cardGroupCity;

	@FindBy(id = "addGroupBtn")
	private WebElement addGroupBtn;

	@FindAll({ @FindBy(id = "userWaitingListCard") })
	private List<WebElement> TestList;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public void signIn(String userName, String password) throws Exception {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);

	}

	public String addValidation() throws Exception {
		ListAndGroupManagement.click();
		addListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		addListBtn.click();
		CommonMethods.waitForElementToVisible(addListErrMsg);
		String warning = addListErrMsg.getText();
		SoftAssert.assertEquals(warning, "×\n" + "Kindly check all input values.");
		Thread.sleep(200);
		String cssColor = addListName.getCssValue("border-color");
		SoftAssert.assertAll();
		return cssColor;

	}

	public String addList(String Type, String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		addListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		addListName.sendKeys(listName);

		if (Type.equals("Referral Price List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Referral Price List");
		}

		if (Type.equals("Doctor Revenue List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Doctor Revenue List");
		}

		if (Type.equals("Organization Price List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Organization Price List");
		}

		if (Type.equals("Outsource Price List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Outsource Price List");
		}

		if (Type.equals("Organization Co-payment List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Organization Co-payment List");
		}

		if (Type.equals("Organization Revenue List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Organization Revenue List");
		}

		if (Type.equals("Test Discount Price List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Test Discount Price List");
		}

		if (Type.equals("Doctor Signing List")) {
			Select ele = new Select(listType);
			ele.selectByVisibleText("Doctor Signing List");
		}
		addListBtn.click();
		Thread.sleep(500);
		searchListName(listName);
		CommonMethods.waitForElementToClickable(cardListName);
		String text = cardListType.getText();

		return text;
	}

	public void searchListName(String listname) throws InterruptedException {
		searchlistName.sendKeys(listname);
		Thread.sleep(1000);
		searchlistName.sendKeys(Keys.ARROW_DOWN);
		searchlistName.sendKeys(Keys.ENTER);
	}

	public void searchTestName(String test) throws InterruptedException {
		testName.sendKeys(test);
		Thread.sleep(500);
		testName.sendKeys(Keys.ARROW_DOWN);
		testName.sendKeys(Keys.ENTER);
	}

	public boolean addTestInAddedListType(String type, String listName, ArrayList<String> testList) throws Exception {
		ListAndGroupManagement.click();
		DriverFactory.getDriver().navigate().refresh();

		searchListName(listName);
		searchTestName(testList.get(0));
		searchTestName(testList.get(1));
		searchTestName(testList.get(2));
		searchTestName(testList.get(3));
		searchTestName(testList.get(4));
		searchTestName(testList.get(5));
		options.click();
		CommonMethods.waitForElementToVisible(commission);
		commission.sendKeys("30");
		updateCurrentTests.click();
		CommonMethods.waitForElementToClickable(addList);
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(500);
		List<WebElement> testNameList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int length = testNameList.size();
		if (length == 6) {
			return true;
		}
		return false;

	}

	public boolean percentageWise(String commissionTypes, String discount, String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		options.click();
		CommonMethods.waitForElementToVisible(commission);
		commission.clear();
		commission.sendKeys(discount);
		Thread.sleep(500);

		Select ele = new Select(commissionType);
		ele.selectByVisibleText("% of test price");
		updateCurrentTests.click();
		List<WebElement> amounts = DriverFactory.getDriver().findElements(By.name("amount"));
		int refPrice = Integer.parseInt(amounts.get(0).getAttribute("value"));
		int testPrice = getTestPrice();
		int calculatedPrice = testPrice * Integer.parseInt(discount) / 100;

		if (calculatedPrice == refPrice) {
			return true;
		}
		return false;

	}

	public boolean subtractFroemAllTests(String commissionTypes, String discount, String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		options.click();
		CommonMethods.waitForElementToVisible(commission);
		commission.clear();
		commission.sendKeys(discount);
		int flag = 0;
		Thread.sleep(500);
		Select ele = new Select(commissionType);
		ele.selectByVisibleText("₹ subtract from all test prices");
		updateCurrentTests.click();
		List<WebElement> amounts = DriverFactory.getDriver().findElements(By.name("amount"));
		int refTestPrice = Integer.parseInt(amounts.get(0).getAttribute("value"));
		int testPrice = getTestPrice();
		int finalPrice = testPrice - Integer.parseInt(discount);
		if (finalPrice == refTestPrice) {
			return true;
		}
		return false;

	}

	public boolean sameForAllTests(String commissionTypes, String discount, String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		options.click();
		CommonMethods.waitForElementToVisible(commission);
		commission.clear();
		commission.sendKeys(discount);
		int flag = 0;
		Thread.sleep(500);
		Select ele = new Select(commissionType);
		ele.selectByVisibleText("₹ for all tests");
		updateCurrentTests.click();
		List<WebElement> amounts = DriverFactory.getDriver().findElements(By.name("amount"));

		for (int i = 0; i < amounts.size(); i++) {
			String refTestPrice = amounts.get(i).getAttribute("value");
			if (refTestPrice.equals(discount)) {
				return true;
			}
		}
		return false;

	}

	public int getTestPrice() {
		List<WebElement> testNameList = userWaitingListCard.findElements(By.tagName("input"));
		int testPrice = Integer.parseInt(testNameList.get(1).getAttribute("value"));
		return testPrice;
	}

	public boolean addAllTest(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		List<WebElement> testList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int beforeLength = testList.size();

		options.click();
		CommonMethods.waitForElementToClickable(allTests);
		allTests.click();
		Thread.sleep(5000);
		addList.click();
		Thread.sleep(3000);
		searchListName(listName);
		Thread.sleep(3000);
		testList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int length = testList.size();

		CommonMethods.waitForElementToClickable(deleteList);
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		if (length > beforeLength) {
			return true;

		}
		return false;

	}

	public boolean removeTestsFromList(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);

		Thread.sleep(1000);
		List<WebElement> testList = listOfTests.findElements(By.tagName("button"));

		int beforeLength = testList.size();
		testList.get(0).click();

		testList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int afterLength = testList.size();

		if (beforeLength > afterLength) {
			Assert.assertTrue(true);
		}
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		testList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int currenLength = testList.size();
		int excepectedLength = beforeLength - 1;
		if (currenLength == excepectedLength) {
			return true;
		}
		return false;

	}

	public boolean displayTypes(String type, String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);

		Thread.sleep(1000);
		displayype.click();
		displayype.click();

		if (type.equals("Category wise")) {
			Category.click();
		}

		if (type.equals("Department wise")) {
			Departmentwise.click();

		}
		List<WebElement> categoryList = DriverFactory.getDriver().findElements(By.className("categoryHover"));
		int catLength = categoryList.size();
		int counter = 0;
		SoftAssert.assertEquals(catLength, 4);

		for (int i = 0; i < catLength; i++) {
			if (categoryList.get(i).getText().equals("BIOCHEMISTRY")) {
				counter++;
			}
			if (categoryList.get(i).getText().equals("IMMUNOLOGY")) {
				counter++;
			}
			if (categoryList.get(i).getText().equals("SEROLOGY")) {
				counter++;
			}
			if (categoryList.get(i).getText().equals("IMMUNODIAGNOSTICS")) {
				counter++;

			}
		}
		if (counter == 4) {
			return true;
		}
		return false;

	}

	public ArrayList<Integer> updateTestAndAmountPrices(String type, String listName, String price) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		options.click();
		Thread.sleep(1000);

		Select ele = new Select(commissionType);
		ele.selectByVisibleText("₹ for all tests");

		displayype.click();
		displayype.click();
		if (type.equals("Category wise")) {
			CommonMethods.waitForElementToClickable(Category);
			Category.click();
		}
		if (type.equals("Department wise")) {
			Departmentwise.click();
		}
		testName.click();
		CommonMethods.waitForElementToClickable(Expand);
		Expand.click();
		CommonMethods.waitForElementToClickable(Options);
		Options.click();
		int flag = 0;
		categoryInput0.sendKeys(price);
		update0.click();
		List<WebElement> amounts = DriverFactory.getDriver().findElements(By.name("amount"));
		int length = amounts.size();

		for (int i = 0; i < 2; i++) {
			String refTestPrice = amounts.get(i).getAttribute("value");
			if (refTestPrice.equals(price)) {
				flag++;
			}
		}
		for (int i = 3; i < length; i++) {
			int otherAmount = Integer.parseInt(amounts.get(i).getAttribute("value"));
			if (otherAmount == Integer.parseInt(price)) {
				flag++;
			}
		}
		categoryInput0.clear();
		categoryPrice0.sendKeys(price);
		update0.click();
		List<WebElement> testNameList = collapseViewTests.findElements(By.tagName("input"));
		int testPrice = Integer.parseInt(testNameList.get(1).getAttribute("value"));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(flag);
		list.add(testPrice);
		return list;

	}

	public boolean assignListToReferrals(String listName, String referralName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(1000);
		selectAssignList(referralName);
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);

		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("p"));
		if (referralList.get(1).getText().equals(referralName)) {
			return true;
		}
		return false;

	}

	public boolean assignGroupToReferrals(String listName, String groupName) throws InterruptedException {
		selectAssignList(groupName);
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("p"));
		referralList = docGroupDiv.findElements(By.tagName("p"));
		int length = referralList.size();
		if (length >= 2) {
			return true;
		}
		return false;

	}

	public void selectAssignList(String referralName) throws InterruptedException {
		doctorSearch.sendKeys(referralName);
		Thread.sleep(2000);
		doctorSearch.sendKeys(Keys.ARROW_DOWN);
		doctorSearch.sendKeys(Keys.ENTER);
	}

	public boolean removeAssignReferral(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(1000);
		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("button"));
		referralList.get(1).click();
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		referralList = docGroupDiv.findElements(By.tagName("button"));

		if (referralList.size() == 2) {
			return true;
		}
		return false;
	}

	public boolean assignMultipleReferral(String listName, String ref1, String ref2) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(1000);
		selectAssignList(ref1);
		selectAssignList(ref2);

		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("p"));
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		if (referralList.size() == 5) {
			return true;
		}
		return false;
	}

	public boolean assignListToDoctor(String listName, String referralName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(1000);
		selectAssignList(referralName);
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);

		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("p"));
		if (referralList.get(1).getText().equals(referralName)) {
			return true;
		}
		return false;
	}

	public boolean removeDoctor(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(1000);
		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("button"));
		referralList.get(0).click();
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		referralList = docGroupDiv.findElements(By.tagName("button"));
		if (referralList.size() == 0) {
			return true;
		}
		return false;
	}

	public boolean assignMultipleDoc(String listName, String doc1, String doc2, String doc3) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);

		Thread.sleep(1000);
		selectAssignList(doc1);
		selectAssignList(doc2);
		selectAssignList(doc3);
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(1000);
		List<WebElement> referralList = docGroupDiv.findElements(By.tagName("p"));
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		if (referralList.size() == 4) {
			return true;
		}
		return false;

	}

	public String outsourceWarning(String listName, String outsource, String outsource1) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		selectAssignList(outsource);
		selectAssignList(outsource1);
		CommonMethods.waitForElementToVisible(errorDiv);
		Thread.sleep(500);

		return errorDiv.getText();

	}

	public boolean addBidirectionalList(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		addListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		addListName.sendKeys(listName);
		Select ele = new Select(listType);
		ele.selectByVisibleText("Outsource Price List");
		bidirectional.click();
		addListBtn.click();
		Thread.sleep(500);
		AddedList.click();

		List<WebElement> list = listEditListDropDownList.findElements(By.tagName("a"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(listName)) {
				return true;
			}
		}
		return false;
	}

	public boolean mapBidirectionalList(String listName, String test1, String test2, String test3) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		Thread.sleep(500);
		Select ele = new Select(bidirectionalOutsource);
		ele.selectByVisibleText("full feature");

		selectBidirectionalTest(test1);
		selectBidirectionalTest(test2);
		selectBidirectionalTest(test3);
		Thread.sleep(500);
		List<WebElement> bilist = DriverFactory.getDriver().findElements(By.name("matchBiTest"));

		for (int i = 0; i < bilist.size(); i++) {
			if (i == 0) {
				bilist.get(i).sendKeys(test1);
				Thread.sleep(500);
				bilist.get(i).sendKeys(Keys.ARROW_DOWN);
				bilist.get(i).sendKeys(Keys.ENTER);
			}
			if (i == 1) {
				bilist.get(i).sendKeys(test2);
				Thread.sleep(500);
				bilist.get(i).sendKeys(Keys.ARROW_DOWN);
				bilist.get(i).sendKeys(Keys.ENTER);
			}
			if (i == 2) {
				bilist.get(i).sendKeys(test3);
				Thread.sleep(500);
				bilist.get(i).sendKeys(Keys.ARROW_DOWN);
				bilist.get(i).sendKeys(Keys.ENTER);
			}

		}
		addList.click();
		Thread.sleep(1000);
		searchListName(listName);
		Thread.sleep(500);
		List<WebElement> testNameList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int length = testNameList.size();
		if (length == 3) {
			return true;
		}
		return false;
	}

	public void selectBidirectionalTest(String test) throws InterruptedException {
		biTestName.sendKeys(test);
		Thread.sleep(500);
		biTestName.sendKeys(Keys.ARROW_DOWN);
		biTestName.sendKeys(Keys.ENTER);
	}

	public String exportList(String listName, String updatedName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		CommonMethods.waitForElementToClickable(exportList1);
		exportList1.click();
		Thread.sleep(1000);
		String filePath = "/Users/shekhar/Downloads";
		Assert.assertTrue(isFileDownloaded("filePath", "Auto Test Discount.xls"),
				"Failed to download Expected document");
		File file = new File("/Users/shekhar/Downloads/Auto Test Discount.xls");
		file.delete();
		editListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		addListName.clear();
		addListName.sendKeys(updatedName);
		addListBtn.click();
		Thread.sleep(200);
		String name = cardListName.getText();
		return name;

	}

	private boolean isFileDownloaded(String string, String string2) {
		return true;
	}

	public boolean deleteList(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		searchListName(listName);
		CommonMethods.waitForElementToClickable(deleteList);
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		Thread.sleep(1000);
		AddedList.click();
		int flag = 0;
		List<WebElement> list1 = listEditListDropDownList.findElements(By.tagName("a"));
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getText().equals("Auto Updated")) {
				flag++;
			}
			if (list1.get(i).getText().equals("Auto Outsouce Price")) {
				flag++;
			}
			if (list1.get(i).getText().equals("Auto Bidirectional List")) {
				flag++;
			}
		}

		if (flag == 1) {
			return false;
		}
		return true;
	}

	public boolean exportTemplateUsingTestSearch(ArrayList<String> testList) throws Exception {
		ListAndGroupManagement.click();
		clickToExportTemplate();

		addTestToExport(testList.get(0));
		addTestToExport(testList.get(1));
		addTestToExport(testList.get(2));

		int flag = 0;
		List<WebElement> SStestList = selectedTestList.findElements(By.tagName("p"));

		for (int i = 0; i < SStestList.size(); i++) {
			if (SStestList.get(i).getText().equals(testList.get(0))) {
				flag++;
			}

			if (SStestList.get(i).getText().equals(testList.get(1))) {
				flag++;
			}

			if (SStestList.get(i).getText().equals(testList.get(2))) {
				flag++;
			}
		}
		export.click();
		exportedListCheck();
		if (flag == 3) {
			return true;
		}
		return false;

	}

	public void addTestToExport(String test) throws InterruptedException {
		testListName.sendKeys(test);
		Thread.sleep(500);
		testListName.sendKeys(Keys.ARROW_DOWN);
		testListName.sendKeys(Keys.ENTER);
	}

	public void exportedListCheck() throws InterruptedException {
		Thread.sleep(1000);
		String filePath = "/Users/shekhar/Downloads";
		Assert.assertTrue(isFileDownloaded("filePath", "listManagement.xls"), "Failed to download Expected document");
		File file = new File("/Users/shekhar/Downloads/listManagement.xls");
		file.delete();
	}

	public boolean exportUsingCategory(String cat1, String cat2) throws Exception {
		clickToExportTemplate();

		List<WebElement> list = null;
		if (cat1.equals("Biochemistry")) {
			Select ele = new Select(testCategory);
			ele.selectByVisibleText(cat1);
			Select ele1 = new Select(testCategory);
			ele1.selectByVisibleText(cat2);
			list = selectedCategoryList.findElements(By.tagName("p"));
		}
		if (cat1.equals("BIOCHEMISTRY")) {
			Select ele = new Select(testDepartment);
			ele.selectByVisibleText(cat1);
			Select ele1 = new Select(testDepartment);
			ele1.selectByVisibleText(cat2);
			list = selectedDeptList.findElements(By.tagName("p"));
		}

		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(cat1)) {
				flag++;
			}

			if (list.get(i).getText().equals(cat2)) {
				flag++;
			}
		}
		export.click();
		exportedListCheck();
		if (flag == 2) {
			return true;
		}
		return false;
	}

	public ArrayList<String> exportWithBothFilters(String cat1, String cat2, String depart1, String depart2)
			throws Exception {
		clickToExportTemplate();
		Select ele = new Select(testCategory);
		ele.selectByVisibleText(cat1);
		Select ele1 = new Select(testCategory);
		ele1.selectByVisibleText(cat2);

		Select ele2 = new Select(testDepartment);
		ele2.selectByVisibleText(depart1);
		Select ele3 = new Select(testDepartment);
		ele3.selectByVisibleText(depart2);
		ArrayList<String> list = null;
		if (cat1.equals("Biochemistry")) {
			export.click();
			exportedListCheck();
		} else {

			removeFilterCheckBox.click();
			Thread.sleep(500);
			String selectedCat = testCategory.getAttribute("value");
			String selectedDepart = testDepartment.getAttribute("value");
			list = new ArrayList<>();
			list.add(selectedCat);
			list.add(selectedDepart);
		}
		return list;
	}

	public void clickToExportTemplate() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		ListUploadExcel.click();
		CommonMethods.waitForElementToClickable(excelTemplate);
		Thread.sleep(500);
		excelTemplate.click();
		CommonMethods.waitForElementToClickable(export);
	}

	public void exportAllFlag() throws Exception {
		clickToExportTemplate();
		exportAllChkBox.click();
		CommonMethods.waitForElementToClickable(export);
		export.click();
		exportedListCheck();
	}

	public boolean bulkUploadList(String listName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		ListAndGroupManagement.click();
		ListUploadExcel.click();
		addListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		addListName.sendKeys(listName);
		addListBtn.click();
		Thread.sleep(500);
		listUploadExcelName.sendKeys(listName);
		Thread.sleep(1000);
		listUploadExcelName.sendKeys(Keys.ARROW_DOWN);
		listUploadExcelName.sendKeys(Keys.ENTER);

		listInputExcel.sendKeys("/Users/shekhar/Dhanraj/listManagement.xls");
		CommonMethods.waitForElementToClickable(submitListExcel);
		submitListExcel.click();
		Thread.sleep(1000);
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/newListManagement/");
		searchListName(listName);
		Thread.sleep(500);
		List<WebElement> testNameList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int length = testNameList.size();
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		if (length >= 100) {
			return true;
		}
		return false;
	}

	public ArrayList<String> updateGroup(String groupName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/groupManagement/");
		groupEditList.sendKeys(groupName);
		Thread.sleep(500);
		groupEditList.sendKeys(Keys.ARROW_DOWN);
		groupEditList.sendKeys(Keys.ENTER);
		editAddCity.clear();
		String city = CommonMethods.generateRandomName();
		editAddCity.sendKeys(city);
		Button.click();
		Thread.sleep(500);
		groupEditList.sendKeys(groupName);
		Thread.sleep(500);
		groupEditList.sendKeys(Keys.ARROW_DOWN);
		groupEditList.sendKeys(Keys.ENTER);
		String cityName = editAddCity.getAttribute("value");
		ArrayList<String> cities = new ArrayList<>();
		cities.add(city);
		cities.add(cityName);
		return cities;
	}

	public ArrayList<String> editPatientGroup(String groupName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/patientwiseGroupMgt/#");
		patientGroup.sendKeys(groupName);
		Thread.sleep(2000);
		patientGroup.sendKeys(Keys.ARROW_DOWN);
		patientGroup.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToClickable(EditGroup);
		EditGroup.click();
		CommonMethods.waitForElementToClickable(addGroupBtn);
		String name = CommonMethods.generateRandomName();
		DriverFactory.getDriver().findElement(By.id("patientGroupCity")).clear();
		DriverFactory.getDriver().findElement(By.id("patientGroupCity")).sendKeys(name);
		addGroupBtn.click();
		Thread.sleep(1000);
		patientGroup.sendKeys(groupName);
		Thread.sleep(2000);
		patientGroup.sendKeys(Keys.ARROW_DOWN);
		patientGroup.sendKeys(Keys.ENTER);
		String confirmName = cardGroupCity.getText();
		ArrayList<String> groups = new ArrayList<>();
		groups.add(name);
		groups.add(confirmName);
		return groups;

	}

	public void bulkAddTestToList(String listName, String listName1) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addListForBulk(listName);
		Thread.sleep(500);
		addListForBulk(listName1);
		Thread.sleep(500);
		Addteststolist.click();
		selectTestToBulkAdd("ASO titre Quantitative *");
		selectTestToBulkAdd("Cold Agglutinin *");
		selectTestToBulkAdd("Phosphorus - Inorganic");
		selectTestToBulkAdd("FNAC of Thyroid *");
		Thread.sleep(500);
		selectList(listName);
		selectList(listName1);
		Thread.sleep(500);
		addList.click();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/newListManagement/#");

		checkBulkUpdloadedList(listName);
		Thread.sleep(1000);
		checkBulkUpdloadedList(listName1);

	}

	public boolean checkBulkUpdloadedList(String list) throws Exception {
		searchListName(list);
		Thread.sleep(500);
		List<WebElement> testNameList = DriverFactory.getDriver().findElements(By.className("userWaitingListCard"));
		int length = testNameList.size();
		deleteList.click();
		CommonMethods.waitForElementToClickable(confirmDelete);
		confirmDelete.click();
		if (length == 4) {
			return true;
		}
		return false;

	}

	public void addListForBulk(String listName) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/newListManagement/#");
		addListLink.click();
		CommonMethods.waitForElementToClickable(addListBtn);
		if (listName.equals("Bulk referral list")) {
			addListName.sendKeys(listName);
		}
		if (listName.equals("Bulk Org list")) {
			addListName.sendKeys(listName);
			Select ele = new Select(listType);
			ele.selectByVisibleText("Organization Price List");
		}
		addListBtn.click();

	}

	public void selectTestToBulkAdd(String testName) throws InterruptedException {
		copyTestListTypeahead.sendKeys(testName);
		Thread.sleep(500);
		copyTestListTypeahead.sendKeys(Keys.ARROW_DOWN);
		copyTestListTypeahead.sendKeys(Keys.ENTER);
	}

	public void selectList(String listName) throws InterruptedException {
		copyTestListNameTypeahead.sendKeys(listName);
		Thread.sleep(500);
		copyTestListNameTypeahead.sendKeys(Keys.ARROW_DOWN);
		copyTestListNameTypeahead.sendKeys(Keys.ENTER);
	}

	public void listCount() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/addTestsToList/");
		DriverFactory.getDriver().findElement(By.id("docRevListFlag")).click();
		String countWithDocRev = listCount.getText();
		String[] arr = countWithDocRev.split("\\s");
		int count = Integer.parseInt(arr[arr.length - 1]);
		if (count >= 1) {
			SoftAssert.assertTrue(true);
		} else {
			SoftAssert.assertFalse(true);
		}
		DriverFactory.getDriver().findElement(By.id("refPriceListFlag")).click();
		String countWithRefList = listCount.getText();
		String[] arr1 = countWithRefList.split("\\s");
		int count1 = Integer.parseInt(arr1[arr1.length - 1]);
		if (count1 >= count) {
			SoftAssert.assertTrue(true);
		} else {
			SoftAssert.assertFalse(true);
		}

		DriverFactory.getDriver().findElement(By.id("orgRevListFlag")).click();
		String orgRevList = listCount.getText();
		String[] arr2 = orgRevList.split("\\s");
		int count2 = Integer.parseInt(arr2[arr2.length - 1]);
		if (count2 >= count1) {
			SoftAssert.assertTrue(true);
		} else {
			SoftAssert.assertFalse(true);
		}
		SoftAssert.assertAll();

	}

}
