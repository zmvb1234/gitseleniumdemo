/**
 * 
 */
package testSuite;
/** 
 * @author 作者: LHZ
 * @version 创建时间：2017年10月12日 上午10:42:38 
 * 类说明 
 */
import java.io.IOException;  
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;   
import framework.BrowserEngine;  
/**
 * @author Administrator
 *
 */
public class TestLaunchBrowser 
{

	/**
	 * @param args
	 */

		// TODO Auto-generated method stub
		public WebDriver driver;  
	      
	    @BeforeClass  
	    public void setUp() throws IOException
	    {  
	          
	        BrowserEngine browserEngine = new BrowserEngine();  
	        browserEngine.initConfigData();  
	        driver=browserEngine.getBrowser();  
	          
	    }  
	      
	      
	    @Test  
	    public void clickNews() throws InterruptedException
	    {  
	          
	        driver.findElement(By.id("key")).sendKeys("iPhone 8");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id='search']/div/div[2]/button")).click();
	        Thread.sleep(5000);
	          
	    }  
	      
	    @AfterClass  
	    public void tearDown()
	    {  
	          
	        driver.quit();  
	    }  
	}


