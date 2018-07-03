package testSuite;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.BasePage;
import pageObject.HomePage;
import pageObject.functions.Login;

public class Test_HomePage_Search {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickLoginLnk();
		Login login = new Login();
		login.initSetup();
		login.loginValid();
		driver = login.driver;
	}
	
	
	@Test
	public void test_searchGoods() throws InterruptedException, AWTException
	{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.searchWithKeyword("Java");
		Thread.sleep(3000);
        BasePage.keyPressWithPagedown();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.quit();
	}
	

}
