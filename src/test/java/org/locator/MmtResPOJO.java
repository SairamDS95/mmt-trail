package org.locator;

import java.util.List;

import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MmtResPOJO extends BaseClass{
	
	public MmtResPOJO() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='paneView'])[1]//div[@class='listingCard ']")
	private List<WebElement> depFlights;
	
	@FindBy(xpath = "(//div[@class='paneView'])[2]//div[@class='listingCard ']")
	private List<WebElement> retFlights;
	
	@FindBy(xpath = "(//div[@class='paneView'])[1]//div[@class='listingCard ']//p[contains(@class, 'fontSize16')]")
	private List<WebElement> depRates;
	
	@FindBy(xpath = "(//div[@class='paneView'])[2]//div[@class='listingCard ']//p[contains(@class, 'fontSize16')]")
	private List<WebElement> retRates;
	
	@FindBy(xpath = "((//div[@class='filtersOuter'])[4]//div//div)[1]")
	private WebElement nonStop;
	
	@FindBy(xpath = "((//div[@class='filtersOuter'])[4]//div//div)[1]")
	private WebElement oneStop;
	
	@FindBy(xpath = "((//div[@class='filtersOuter'])[4]//div//div)[1]")
	private WebElement onePlus;
	
	@FindBy(xpath = "(//div[@class='makeFlex spaceBetween'])[1]//span[contains(@class, 'blackFont fontSize16')]")
	private WebElement toPrice;
	
	@FindBy(xpath = "(//div[@class='makeFlex spaceBetween'])[2]//span[contains(@class, 'blackFont fontSize16')]")
	private WebElement retPrice;
	
	public List<WebElement> getDepFlights(){
		return depFlights;
	}
	
	public List<WebElement> getRetFlights(){
		return retFlights;
	}
	
	public List<WebElement> getDepRates(){
		return depRates;
	}
	
	public List<WebElement> getRetRates(){
		return retRates;
	}
	
	public WebElement getNonStop() {
		return nonStop;
	}
	
	public WebElement getOneStop() {
		return oneStop;
	}
	
	public WebElement getOnePlus() {
		return onePlus;
	}
	
	public WebElement getToPrice() {
		return toPrice;
	}
	
	public WebElement getRetPrice() {
		return retPrice;
	}

}
