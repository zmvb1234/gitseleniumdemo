package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class GoodsDetailsPage extends BasePage 
{
	
	/*
	 * 商品详情页，价格对比，下单入口等操作
	 */
	public GoodsDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath="//*/span[@class='p-price']/span[2]")
	WebElement goods_price;
	
	@FindBy (id="InitCartUrl")
	WebElement addToCart_Btn;

	
	
	/*
	 * 获取商品详情页的价格
	 */
	public String getPriceOnDetailsPage()
	{
	
		return goods_price.getText();
	}
	
	/*
	 * 点击添加购物车
	 */
	public void addGoodToCart()
	{
		
		click(addToCart_Btn);
	}
}
