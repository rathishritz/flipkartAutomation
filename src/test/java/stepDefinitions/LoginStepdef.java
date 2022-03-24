package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.flipkartHomepage;
import pageObjects.flipkartProductpage;

public class LoginStepdef {
	public static WebDriver driver;
	public static flipkartHomepage Homepage;
	public static flipkartProductpage Productpage;
	boolean myaccount;
	public String mainWindow;
	public String productWindow;
	
	
	@Given("the user is on sign in page")
	public void the_user_is_on_sign_in_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rathi\\OneDrive\\Documents\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		Homepage=new flipkartHomepage(driver);
		Productpage=new flipkartProductpage(driver);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	    System.out.println("1");
	}
	
	@When("the user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String username, String password) {
		Homepage.siginFlipkart(username, password);
	}


	@Then("the user should be navigated to the homepage")
	public void the_user_should_be_navigated_to_the_homepage() {
		Homepage.validateLogin();
	}

	@Given("user is logged in and is on the homepage")
	public void user_is_logged_in_and_is_on_the_homepage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("4");
	}

	@When("user search for specific product")
	public void user_search_for_specific_product() throws Exception {
		Homepage.searchProduct();
	}

	@Then("user should be able to add the product to the cart")
	public void user_should_be_able_to_add_the_product_to_the_cart() throws Exception {
		Productpage.selectProduct();
	}


	

}
