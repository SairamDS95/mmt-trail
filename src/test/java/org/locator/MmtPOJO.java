package org.locator;

import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MmtPOJO extends BaseClass{

	public MmtPOJO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@data-cy='fromCity']")
	private WebElement fromCity;
	
	@FindBy(xpath = "//input[@data-cy='toCity']")
	private WebElement toCity;
	
	@FindBy(xpath = "//p[@data-cy= 'departureDate']")
	private WebElement depDate;
	
	@FindBy(xpath = "//p[@data-cy='returnDefaultText']")
	private WebElement returnSel;
	
	@FindBy(xpath = "//p[@data-cy='returnDate']")
	private WebElement returnDate;
	
	@FindBy(xpath = "//a[text() = 'Search']")
	private WebElement srchBtn;

	public WebElement getFromCity() {
		return fromCity;
	}

	public WebElement getToCity() {
		return toCity;
	}

	public WebElement getDepDate() {
		return depDate;
	}

	public WebElement getReturnSel() {
		return returnSel;
	}

	public WebElement getReturnDate() {
		return returnDate;
	}	
	
	public WebElement getSrchBtn() {
		return srchBtn;
	}
	
}
