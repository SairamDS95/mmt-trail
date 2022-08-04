package org.stepDef;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.helper.BaseClass;
import org.locator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDef extends BaseClass{

	public static void main(String[] args) throws Exception {
				
		Robot r = new Robot();
		String startDate = null;
		String retDate = null;
		
		
		chromeBrowser();
		openUrl("https://www.makemytrip.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		MmtPOJO m = new MmtPOJO();
		
		m.getFromCity().sendKeys("MAA");
		Thread.sleep(1000);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
				
		m.getToCity().sendKeys("BLR");
		Thread.sleep(1000);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		m.getDepDate().click();
		
		Calendar cal = Calendar.getInstance();
		String date = cal.getTime().toString();//Tue Aug 02 HH:MM:SS IST 2022
		String[] rawDate = date.split(" ");
		startDate = rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		System.out.println(startDate);
		
		WebElement today = driver.findElement(By.xpath("//div[@aria-label='"+startDate+"']//div"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", today);
		
		m.getReturnSel().click();
		
		cal.add(Calendar.DATE, 7);
		String calender = cal.getTime().toString();
		String[] rawDatE = calender.split(" ");
		retDate = rawDatE[0]+" "+rawDatE[1]+" "+rawDatE[2]+" "+rawDatE[5];
		
		WebElement ret = driver.findElement(By.xpath("//div[@aria-label='"+retDate+"']//div"));
		js.executeScript("arguments[0].click()", ret);
		
		WebElement srchBtn = m.getSrchBtn();
		js.executeScript("arguments[0].click()", srchBtn);
		
		MmtResPOJO mr = new MmtResPOJO();
				
		System.out.println("No of Flights available:"+ mr.getDepFlights().size() );		
		System.out.println("No of Return Flights available:" + mr.getRetFlights().size());
		
		List<WebElement> depRates = mr.getDepRates();
		
		Map<WebElement, Integer> deps = new HashMap<WebElement, Integer>();
		Map<WebElement, Integer> rets = new HashMap<WebElement, Integer>();
		
		for (int i = 0; i < depRates.size(); i++) {
			deps.put(depRates.get(i), Integer.parseInt(depRates.get(i).getText().replaceAll("[₹| |,]", "")));			
		}
		
		List<WebElement> retRates = mr.getRetRates();
		
		for (int i = 0; i < retRates.size(); i++) {
			rets.put(retRates.get(i), Integer.parseInt(retRates.get(i).getText().replaceAll("[₹| |,]", "")));
		}
		
		List<Entry<WebElement, Integer>> dep = new ArrayList<Map.Entry<WebElement, Integer>>(deps.entrySet());
		dep.sort(Entry.comparingByValue());
		List<Entry<WebElement, Integer>> retn = new ArrayList<Map.Entry<WebElement, Integer>>(rets.entrySet());
		retn.sort(Entry.comparingByValue());
		
		System.out.println("Cheapest Flight :"+ dep.get(0).getValue()+ "\n" + "Cheapest Return Flight :" + retn.get(0).getValue());
		
		jsClick(dep.get(0).getKey());
		jsClick(retn.get(0).getKey());
		
		System.out.println("Departure Prices: "+ mr.getToPrice().getText());
		System.out.println("Return Prices: "+ mr.getRetPrice().getText());		
	}
	
}
