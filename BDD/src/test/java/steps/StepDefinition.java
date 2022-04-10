package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import page.Loginpage;
import util.BrowserFactory;


public class StepDefinition {
	
	WebDriver driver;
	Loginpage loginPage;
	@Before
	public void beforeMethod() {
		driver = BrowserFactory.init();
	    loginPage =PageFactory.initElements(driver, Loginpage.class);
	}
	
	@Given("^User is on the TechFios login page$")
	
	public void User_is_on_the_TechFios_login_page() throws InterruptedException {
		
		driver.get("https://techfios.com/billing/?ng=login/");
		Thread.sleep(2000);
	}
	
	@When ("^User enters username as \"([^\"]*)\"$")
	
	public void User_enters_username_as(String userName) throws InterruptedException {
		
		loginPage.enterUserName(userName);
		Thread.sleep(2000);
		
	}
	
	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws InterruptedException  {
	
		loginPage.enterPassword(password);
		Thread.sleep(2000);
	}

	@When("^User clicks on signin button$")
	public void user_clicks_on_signin_button() throws InterruptedException  {
		
		loginPage.clickOnSigninButton();
		Thread.sleep(2000);
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page()  {
		
		Assert.assertEquals("Dashboard- iBilling", loginPage.getPageTitle());
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
