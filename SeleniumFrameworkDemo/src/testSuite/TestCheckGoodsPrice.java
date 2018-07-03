package testSuite;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.BasePage;
import framework.BrowserEngine;
import pageObject.GoodsDetailsPage;
import pageObject.HomePage;
import pageObject.SearchResultListPage;

public class TestCheckGoodsPrice 
{
	WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException
	{
		BrowserEngine browserEngine = new BrowserEngine();
		browserEngine.initConfigData();
		driver = browserEngine.getBrowser();
		
	}
	
	
	@Test
	public void checkPrice() throws InterruptedException
	{
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.searchWithKeyword("iPhone");
		//进入搜索结果列表页
		Thread.sleep(3000);
	    try {
			BasePage.keyPressWithPagedown();
		    } 
	    catch (AWTException e) 
	        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		SearchResultListPage srlp = PageFactory.initElements(driver, SearchResultListPage.class);
		Thread.sleep(1000);
		String price1 = srlp.getGoodsPriceOnListPage(); // 获取列表页商品的价格
		System.out.println("第一页价格"+price1+"元");
		srlp.clickItemImg();
		srlp.switchWindow();
		
		//进入商品详情页
		GoodsDetailsPage gdp = PageFactory.initElements(driver, GoodsDetailsPage.class);
		Thread.sleep(1000);
		String price2 = gdp.getPriceOnDetailsPage(); //获取商品详情页价格
		System.out.println("详细页价格"+price2+"元");
		
		//判断 同一个商品在列表页和详情页价格是否显示一致
//		if(price1 == price2){
//			System.out.println("Pass");
//		}else
//			System.out.println("Failed");
//			
		
		// 第二种断言
		Assert.assertEquals(price2, price1);
		Thread.sleep(1000);
		 try {
				BasePage.keyPressWithPagedown();
			    } 
		    catch (AWTException e) 
		        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
		gdp.addGoodToCart();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
