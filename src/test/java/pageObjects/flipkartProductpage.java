package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flipkartProductpage {
	WebDriver driver;
	public Set<String> handles;
	public Iterator<String> itHandles;
	public flipkartProductpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectProduct() throws Exception {
		String mainWindow=driver.getWindowHandle();
		String productWindow;
		WebElement phone=driver.findElement(By.xpath("//div[text()=\"APPLE iPhone 13 (Midnight, 128 GB)\"]"));
	//	WebElement phone=driver.findElement(By.xpath("(//img[@class=\"_396cs4 _3exPp9\"])[1]"));
		safeJavaScriptClick(phone);
		handles=driver.getWindowHandles();
		itHandles=handles.iterator();
		 while (itHandles.hasNext()) {
	             productWindow= itHandles.next();
	                if (!mainWindow.equalsIgnoreCase(productWindow)) {
	                driver.switchTo().window(productWindow);
	                driver.findElement(By.id("pincodeInputId")).clear();
	        		driver.findElement(By.id("pincodeInputId")).sendKeys("600066");
	            }
	        } 
		System.out.println("6");
	}
	
	public void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}


}
