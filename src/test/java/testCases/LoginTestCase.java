package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login;
import pages.Profile;

public class LoginTestCase {
	public static WebDriver driver;
  @Test
  public void mainf() {
	  WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		//Instantiating Login & Profile page using initElements()
				Login loginPg = PageFactory.initElements(driver, Login.class);
				Profile profilePg = PageFactory.initElements(driver, Profile.class);
				 
				//Using the methods created in pages class to perform actions
				loginPg.LogIn_Action("gunjankaushik", "Password@123");
				profilePg.verifyUser("gunjankaushik");
				profilePg.logout_Action();
				 
				
  }
}
