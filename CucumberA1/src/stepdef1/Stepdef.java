package stepdef1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	WebDriver d;

	@Given("^Google Home Page is Opened$")
	public void google_Home_Page_is_Opened() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		// throw new PendingException();
	}

	@When("^user input is Bank of India and search$")
	public void user_input_is_Bank_of_India_and_search() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement w1 = d.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		w1.sendKeys("Bank of India");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait w2 = new WebDriverWait(d, 20);
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		WebElement w21 = d.findElement(By.name("btnK"));
		if ((w21).isDisplayed()) {
			System.out.println("btn found");
			w21.click();
		} else
			System.out.println("btn not found");

		if (d.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")) != null) {
			System.out.println("Found BOI Site");
			d.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();

		} else
			System.out.println("BOI Site not found");

		// throw new PendingException();
	}

	@Then("^Bank of India Page should open$")
	public void bank_of_India_Page_should_open() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement w3 = d.findElement(By.xpath("/html/body/header/div[2]/div[2]/a[1]/img"));
		if (w3.isDisplayed())
			System.out.println("Home Page Loaded Successfully");
		else
			System.out.println("Home Page failed to load");
		// throw new PendingException();
	}

	@When("^Click on Internet Banking and Click on Personal$")
	public void bank_of_Inda_page_is_open() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement w4 = d.findElement(By.xpath("/html/body/div/div[2]/div/div/div[9]"));
		w4.click();
		Thread.sleep(5000);
		WebElement w5 = d.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]"));
		w5.click();
		System.out.println("Clicked on Internet banking");
		Thread.sleep(5000);
		WebElement w6 = d.findElement(By.cssSelector(
				"body > div > div.col-sm-3.sidewrap > div > div > div.accordingcontent.active > div > div.viewport > div > ul > li:nth-child(1) > a"));
		w6.click();
		Thread.sleep(5000);

		// throw new PendingException();
	}

	@Then("^Handle the newly opened window and redirect to the Login Page$")
	public void click_on_Contact_Us() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		for(String window:d.getWindowHandles()) {
			d.switchTo().window(window);
			String t=d.getTitle();
			if(t.equalsIgnoreCase("Bank of India")) {
				WebElement w = d.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(1) > div > input[type=\"button\"]"));
				w.click();
			}
		}
		// throw new PendingException();
	}

}
