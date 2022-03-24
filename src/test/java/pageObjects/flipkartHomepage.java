package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flipkartHomepage {
	WebDriver driver;
	public flipkartHomepage(WebDriver driver) {
		this.driver=driver;
	}

	public void siginFlipkart(String username, String password) {
		 driver.findElement(By.xpath("//input[@class=\"_2IX_2- VJZDxU\"]")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@class=\"_2IX_2- _3mctLh VJZDxU\"]")).sendKeys(password);
		 driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]")).click();
		 System.out.println("2");
	}

	public void validateLogin() {
		boolean myaccount=driver.findElement(By.xpath("//div[@class=\"exehdJ\"]")).isDisplayed();
		System.out.println("Boolean value  "+myaccount);
		System.out.println("3");
	}

	public void searchProduct() throws Exception {
		driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys("iphone 13");
		WebElement search=driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]"));
		safeJavaScriptClick(search);
		String mainWindow=driver.getWindowHandle();
		System.out.println("5");
		
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
