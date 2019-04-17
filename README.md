package com.cg.stepdef;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	WebDriver driver;
	JavascriptExecutor js;
	Scanner sc = new Scanner(System.in);

	@Given("^Open Personaldetails\\.html$")
	public void open_Personaldetails_html() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/srihark/Desktop/set%201/WebPages/PersonalDetails.html#");
		driver.manage().window().maximize();

		// throw new PendingException();
	}

	@When("^Verify the title of the page$")
	public void verify_the_title_of_the_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String pageTitle = driver.getTitle();
		if(!pageTitle.equalsIgnoreCase("Personal Details")) {
			System.out.println("Page not found, Exitting the Program");
			System.exit(0);
		}	
		// throw new PendingException();
	}

	@Then("^Verify all the personal details when click on next$")
	public void verify_all_the_personal_details_when_click_on_next() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("txtFN")).sendKeys("Srihari");
		driver.findElement(By.name("txtLN")).sendKeys("K");
		driver.findElement(By.name("Email")).sendKeys("srihari@gmail.com");
		driver.findElement(By.name("Phone")).sendKeys("7845612312");
		driver.findElement(By.name("address1")).sendKeys("Lab2, ATP");
		driver.findElement(By.name("address2")).sendKeys("WhiteField");
		Select s1=new Select(driver.findElement(By.name("city")));
		List<WebElement> l1=s1.getOptions();
		System.out.println("Total number of drop down Cities aavailable are "+l1.size());
		s1.selectByIndex(2);
		Select s2=new Select(driver.findElement(By.name("state")));
		List<WebElement> l2=s2.getOptions();
		System.out.println("Total number of drop down States aavailable are "+l2.size());
		s2.selectByIndex(2);
		WebElement w1 = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(11) > td > a"));
		w1.click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// throw new PendingException();
	}

	@When("^navigated to Educational details page$")
	public void navigated_to_Educational_details_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Select s3=new Select(driver.findElement(By.name("graduation")));
		List<WebElement> l3=s3.getOptions();
		System.out.println("Total number of Graduation Degrees aavailable are "+l3.size());
		s3.selectByIndex(2);
		driver.findElement(By.name("percentage")).sendKeys("74.5");
		driver.findElement(By.name("passingYear")).sendKeys("2018");
		driver.findElement(By.name("projectName")).sendKeys("Nissan ADAS");
		Select checkBox = new Select(driver.findElement(By.name("technologies")));
		
		
		// throw new PendingException();
	}

	@Then("^Verify the Educational details and Project details  and Click on register-me$")
	public void verify_the_Educational_details_and_Project_details_and_Click_on_register_me() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

}
