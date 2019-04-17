package com.cg.stepdef;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.Input;
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
		//Configuring the driver to access the HTML Page
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/srihark/Desktop/set%201/WebPages/PersonalDetails.html#");
		
		//Maximizing the Opened Window
		driver.manage().window().maximize();

		// throw new PendingException();
	}

	@When("^Verify the title of the page$")
	public void verify_the_title_of_the_page() throws Throwable {
		
		//Obtaining and Verifying the Page name
		String pageTitle = driver.getTitle();
		if (!pageTitle.equalsIgnoreCase("Personal Details")) {
			System.out.println("Page not found, Exitting the Program");
			System.exit(0);
		}
		// throw new PendingException();
	}

	@Then("^Verify all the personal details when click on next$")
	public void verify_all_the_personal_details_when_click_on_next() throws Throwable {
		//Input for First Name
		System.out.println("Enter First Name:");
		String firstName = sc.next();
		driver.findElement(By.name("txtFN")).sendKeys(firstName);
		
		//Input for Second Name
		System.out.println("Enter Last Name:");
		String lastName = sc.next();
		driver.findElement(By.name("txtLN")).sendKeys(lastName);
		
		//Input for email
		System.out.println("Enter Email:");
		String email = sc.next();
		driver.findElement(By.name("Email")).sendKeys(email);
		
		//Input for Phone Number
		System.out.println("Enter Phone number:");
		String pNumber = sc.next();
		driver.findElement(By.name("Phone")).sendKeys(pNumber);
		
		// HardCoded Addesses
		System.out.println("Hardcoded address is added");
		driver.findElement(By.name("address1")).sendKeys("Lab2, ATP");
		driver.findElement(By.name("address2")).sendKeys("WhiteField");
		
		//obtaining and Printing the List count of available cities
		Select s1 = new Select(driver.findElement(By.name("city")));
		List<WebElement> l1 = s1.getOptions();
		System.out.println("Total number of drop down Cities aavailable are " + l1.size());
		//Selecting the list element
		s1.selectByIndex(2);
		
		//obtaining and Printing the List count of available cities
		Select s2 = new Select(driver.findElement(By.name("state")));
		List<WebElement> l2 = s2.getOptions();
		System.out.println("Total number of drop down States aavailable are " + l2.size());
		//Selecting the list element
		s2.selectByIndex(2);
		
		//Finding the "Next" button and Clicking it
		WebElement w1 = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(11) > td > a"));
		w1.click();
		
		//Alert message capturing and handling
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// throw new PendingException();
	}

	@When("^navigated to Educational details page$")
	public void navigated_to_Educational_details_page() throws Throwable {
		// Selecting the Graduation degree
		Select s3 = new Select(driver.findElement(By.name("graduation")));
		List<WebElement> l3 = s3.getOptions();
		System.out.println("Total number of Graduation Degrees aavailable are " + l3.size());
		s3.selectByIndex(2);
		
		//Input for percentage
		System.out.println("Enter Percentage: ");
		String percentage = sc.next();
		driver.findElement(By.name("percentage")).sendKeys(percentage);
		
		//Input for YOP
		System.out.println("Enter Year of passing:");
		String yop = sc.next();
		driver.findElement(By.name("passingYear")).sendKeys(yop);
		
		//Input for Project Name
		System.out.println("Enter Project name (Without spaces):");
		String project = sc.next();
		driver.findElement(By.name("projectName")).sendKeys(project);
		
		//selecting radio element
		WebElement radio1 = driver.findElement(By.id("cbTechnologies"));
		radio1.click();
		
		//Input for Other Technologies
		System.out.println("Enter Other Technologies");
		String tech = sc.next();
		driver.findElement(By.name("otherTechnologies")).sendKeys(tech);

		// throw new PendingException();
	}

	@Then("^Verify the Educational details and Project details  and Click on register-me$")
	public void verify_the_Educational_details_and_Project_details_and_Click_on_register_me() throws Throwable {
		// Finding and Clicking the "Register Now " botton
		WebElement w1 = driver.findElement(By.id("btnRegister"));
		w1.click();
		
		//Alert message capturing and handling
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
		// throw new PendingException();
	}

}
