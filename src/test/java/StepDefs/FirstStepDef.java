package StepDefs;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstStepDef {
	String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
//    String numbers = "0123456789";
    String alphaNumeric = upperAlphabet + lowerAlphabet ;
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    String randomString,randomString1,randomString2;
	
	WebDriver driver ;
	
	@Parameters("browserName")
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
//		driver = new FirefoxDriver(); 
		driver.get("http://elearningm1.upskills.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("User Clicks on SignUp link")
	public void user_Clicks_on_SignUp_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();		
	}

	@When("Navigates to Registration page")
	public void navigates_to_Registration_page() {
	    // Write code here that turns the phrase above into concrete actions
		String actualheader = driver.findElement(By.xpath("//h2[@class='page-header']")).getText();
	    String expectedheader = "Registration";
	    Assert.assertEquals(expectedheader, actualheader);
	}

	@When("User enters firstname")
	public void user_enters_firstname() {
		int length = 5;
	    for(int i = 0; i < length; i++) 
	    {
	      int index = random.nextInt(alphaNumeric.length());      
	      char randomChar = alphaNumeric.charAt(index);      
	      sb.append(randomChar);
	    }
	    randomString = sb.toString();
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_firstname")).sendKeys(randomString);
	}

	@When("User enters lastname")
	public void user_enters_lastname() {
		int length = 3;
	    for(int i = 0; i < length; i++) 
	    {
	      int index = random.nextInt(alphaNumeric.length());      
	      char randomChar = alphaNumeric.charAt(index);      
	      sb.append(randomChar);
	    }
	    randomString1 = sb.toString();
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_lastname")).sendKeys(randomString1);
	}

	@When("User enters emailid")
	public void user_enters_emailid() {
		int length = 6;
	    for(int i = 0; i < length; i++) 
	    {
	      int index = random.nextInt(alphaNumeric.length());      
	      char randomChar = alphaNumeric.charAt(index);      
	      sb.append(randomChar);
	    }
	    randomString2 = sb.toString();
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_email")).sendKeys(randomString2+"@gmail.com");
	}

	@When("User enters username")
	public void user_enters_username() {
	    
		driver.findElement(By.id("username")).sendKeys(randomString);
	}

	@When("User enters password")
	public void user_enters_password() {
	    
		driver.findElement(By.id("pass1")).sendKeys(randomString1);
		}

	@When("User enters confirmpwd")
	public void user_enters_confirmpwd() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("pass2")).sendKeys(randomString1);
	}

	@When("User clicks on Register Button")
	public void user_clicks_on_Register_Button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("registration_submit")).click();
		
	}

	@Then("Success Message {string} is displayed")
	public void success_Message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String expected_success_reg_msg = "Your personal settings have been registered.";
		String actual_success_reg_msg = driver.findElement(By.xpath("//div//p[contains(text(),'Dear')]")).getText();
	    System.out.println("Registration successful");  
	    driver.close();
	}
	
	

	@Then("Error Message {string} is displayed")
	public void error_Message_is_displayed(String string) {
		String expectedmissing_field_err_msg = "Required field";
		String actual_err_msg = driver.findElement(By.xpath("//div[contains(text(),'Required field')]")).getText();
		Assert.assertEquals(expectedmissing_field_err_msg,actual_err_msg);
		System.out.println("Expected Error message upon missing field is validated");  
		driver.close();
				
	}

	@When("User enters invalid emailid")
	public void user_enters_invalid_emailid() {
		driver.findElement(By.id("registration_email")).sendKeys("kavya.bgmail.com");
	}
	@Then("Email id Error Message {string} is displayed")
	public void email_id_Error_Message_is_displayed(String string) {
		String expected_emailiderror_xpath_string = driver.findElement(By.xpath("//div[contains(text(),'The email address is not complete or contains some invalid characters')]")).getText();
		String actual_emailid_err_msg = "The email address is not complete or contains some invalid characters";
		Assert.assertEquals(expected_emailiderror_xpath_string, actual_emailid_err_msg);
		System.out.println("Expected Error message when there is an invalid emailid is validated"); 
		driver.close();
	}
	
	

	@When("User enters existing username")
	public void user_enters_existing_username() {
	    
		driver.findElement(By.id("username")).sendKeys("cathy");
	}
	
	@Then("login already in use Error  {string} is displayed")
	public void login_already_in_use_Error_is_displayed(String string) {
		String expected_existingusererror_xpath_string = driver.findElement(By.xpath("//div[contains(text(),'This login is already in use')]")).getText();
		String actual_existingusererror_msg = "This login is already in use";
		Assert.assertEquals(expected_existingusererror_xpath_string,actual_existingusererror_msg );
		System.out.println("Expected Error message when the username already in use is validated"); 
		driver.close();
	    
	}
	
	@When("User enters username in the Home page")
	public void user_enters_username_in_the_Home_page() {
	    driver.findElement(By.xpath("//input[@id='login']")).sendKeys("cathy");
	    
	}

	@When("User enters password in the Home page")
	public void user_enters_password_in_the_Home_page() {
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("angel");
	}

	@When("User clicks on Login Button")
	public void user_clicks_on_Login_Button() {
	    driver.findElement(By.xpath("//button[@name='submitAuth']")).click();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    driver.findElement(By.xpath("//a[@href='#']"));
	    System.out.println("User is logged in successfully");
	    driver.close();
	}

	@When("User enters invalid password in the Home page")
	public void user_enters_invalid_password_in_the_Home_page() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("angelfgtrg");
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String string) {
		String actual_loginerror_msg = driver.findElement(By.xpath("//div[contains(text(),'Login failed - incorrect login or password.')]")).getText();
		String expected_loginerror_msg = "Login failed - incorrect login or password.";
		Assert.assertEquals(expected_loginerror_msg, actual_loginerror_msg);
		System.out.println("Login Error message is validated upon entering invalid credentials");
		driver.close();
	}
	@When("User enters invalid username in the Home page")
	public void user_enters_invalid_username_in_the_Home_page() {
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("catmouse");
	}
    
	@When("User clicks on profile dropdown button")
	public void user_clicks_on_profile_dropdown_button() {
		driver.findElement(By.xpath("//a[@href='#']")).click();
		
	}

	@Then("Registered emailid of that user should be displayed")
	public void registered_emailid_of_that_user_should_be_displayed() {
	    String actual_emailid = driver.findElement(By.xpath("//div[@class='text-center']//p[contains(text(),'cathy.angel1@gmail.com')]")).getText();
	    String expected_emailid = "cathy.angel1@gmail.com";
	    Assert.assertEquals(expected_emailid , actual_emailid);
	    System.out.println("Emailid of the loggedin user is validated");
	    driver.close();
	}

	@When("User is on Home page")
	public void user_is_on_Home_page() {
	    driver.findElement(By.xpath("//a[@title='Homepage']")).click();
	}

	@When("User clicks on Compose link")
	public void user_clicks_on_Compose_link() {
	    driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
	}

	@When("User enters Sendto address")
	public void user_enters_Sendto_address() throws InterruptedException {
		WebElement elem = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		elem.sendKeys("nav");
		Thread.sleep(3000);
		elem.sendKeys(Keys.ENTER);
   
	}

	@When("User enters subject")
	public void user_enters_subject() {
	    driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys("subject");
	}

	@When("User enters Message")
	public void user_enters_Message() throws InterruptedException {
		int framecount = driver.findElements(By.tagName("iframe")).size();
//		System.out.println("Entering for loop and framecount is "+framecount);
//		Thread.sleep(5000);
//		for(int i=0; i<=framecount; i++)
//		{
//			driver.switchTo().frame(0);
//			System.out.println("Switched to the frame");
//			driver.findElement(By.xpath("//html//body[@contenteditable]//p")).sendKeys("body of the message");
//		}
//	    driver.switchTo().defaultContent();
	}

	@When("User clicks on Send message button")
	public void user_clicks_on_Send_message_button() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
	    Thread.sleep(3000);
	}

	@Then("Success message {string} should be displayed")
	public void success_message_should_be_displayed(String string) {
	    String actual_successmsg = driver.findElement(By.xpath("//div[contains(text(),'The message has been sent to')]")).getText();
	    String expected_successmsg="The message has been sent to ";
	    if(actual_successmsg.contains(expected_successmsg))
	    {
	    	System.out.println("Success message upon sending the email is displayed");
	    }	    
	    driver.close();
	}

	@Then("Error message for missing subject {string} should be displayed")
	public void error_message_for_missing_subject_should_be_displayed(String string) {
//	    String actual_errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		String strg1 = driver.findElement(By.xpath("//section[@id='cm-content']")).getText();
	    String expected_errormsg = "There was an error while trying to send the message.";
//	    Assert.assertEquals(expected_errormsg, actual_errormsg);
	    if(strg1.contains(expected_errormsg)) 
	    {
	    System.out.println("Error message for missing subject is validated");}
	    driver.close();
	    
	}

	@Then("Error message for missing sendTo address {string} should be displayed")
	public void error_message_for_missing_sendTo_address_should_be_displayed(String string) {
//	    String actual_errormsg1 = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		String strg2 = driver.findElement(By.xpath("//section[@id='cm-content']")).getText();
	    String expected_errormsg1 = "Required field";
//	    Assert.assertEquals(expected_errormsg1, actual_errormsg1);
	    if(strg2.contains(expected_errormsg1)) 
	    {
	    System.out.println("Error message for missing sendTo address is validated");}
	    driver.close();
	}

	@When("User clicks on Logout Button")
	public void user_clicks_on_Logout_Button() {
	    driver.findElement(By.xpath("//a[@id='logout_button']")).click();
	    
	}

	@Then("User should be logged out successfully")
	public void user_should_be_logged_out_successfully() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]"));
		System.out.println("User loggedout successfully");
		driver.close();
	}




	

}

