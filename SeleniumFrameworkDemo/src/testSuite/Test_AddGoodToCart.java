package testSuite;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.BasePage;
import pageObject.GoodsDetailsPage;
import pageObject.SearchResultListPage;

public class Test_AddGoodToCart 
{
	
	@BeforeTest
	public void setUp() 
	{     

	}
	
	
	@Test
	public void testAddToCart() throws InterruptedException, AWTException
	{
		
		SearchResultListPage srlp = PageFactory.initElements(Test_HomePage_Search.driver, SearchResultListPage.class);
		srlp.clickItemImg();
		
		// 切换窗口到商品详情页
		srlp.switchWindow();
		
		GoodsDetailsPage gdp = PageFactory.initElements(Test_HomePage_Search.driver, GoodsDetailsPage.class);
		BasePage.keyPressWithPagedown();
		gdp.addGoodToCart();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown()
	{
		
		Test_HomePage_Search.driver.quit();
	}

}
