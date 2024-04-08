package stedefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleSD 
{

	
	WebDriver driver;

@Given("^User Should on Ranford Home Page$")
public void user_Should_on_Ranford_Home_Page() throws Throwable 
{
	    driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get("http://192.168.1.4/ranford2");
	
}

@When("^User Enters un and Pwd click on Login$")
public void user_Enters_un_and_Pwd_click_on_Login() throws Throwable 
{
	driver.findElement(By.id("txtuId")).sendKeys("Admin");
	driver.findElement(By.id("txtPword")).sendKeys("Admin");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\'login\']")).click();

	
}

@Then("^User Click on Role button$")
public void user_Click_on_Role_button() throws Throwable 
{
	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	
}

@When("^User click on new role and enters \"(.*)\" and \"(.*)\"$")
public void user_click_on_new_role_and_enters_RoleDetails(String Rn,String Rt) throws Throwable
{
	driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
	driver.findElement(By.id("txtRname")).sendKeys(Rn);
	driver.findElement(By.id("lstRtypeN")).click();
	driver.findElement(By.id("lstRtypeN")).sendKeys(Rt);
	Thread.sleep(3000);

	driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
	driver.switchTo().alert().accept();
}

@Then("^User Close Application$")
public void user_Close_Application() throws Throwable 
{
   driver.close();
}


}
