package framework;
/** 
 * @author 
 * @version 创建时间：2017年10月12日 上午11:19:50 
 * 类说明 
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *页面基类，看到基类，我们会想到继承。
 *在这个框架基于POM的思想上，我们需要利用继承的特点，来实现，减少我们重复代码量。
 */
/**
 *我们每个模块或者相关功能，都能在一个个页面类上去定义和写相关业务操作方法。
 *很多页面，我们有些方法是相同的，例如，
 *判断一个元素是否在页面显示，还有元素点击和输入操作，还有判断页面标题和页面地址等等，
 *甚至，有些软件web不同页面有公共的元素。
 *这些因素，决定了我们需要写一个页面父类，来定义一些公共的方法或者公共的元素。
 */

public class BasePage 
{
	public static WebDriver driver;
	public static String pageTitle;
	public static String pageUrl;
	
	/*
	 * 构造方法
	 */
	public BasePage (WebDriver driver)
	{
		BasePage.driver = driver;
	}
	
	/*
	 * 在文本框内输入字符
	 */
	protected void type(WebElement element , String text)
	{
		try {
				if (element.isEnabled()) 
				{
				    element.clear();
				    Logger.Output(LogType.LogTypeName.INFO, "Clean the value if any in "+ element.toString()+".");
					element.sendKeys(text);
					Logger.Output(LogType.LogTypeName.INFO, "Type value is: " + text+".");
				}
			} 
		catch (Exception e) 
		{
				Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
		}
			
		}
    public static void keyPressWithPagedown() throws AWTException 
    { 
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_PAGE_DOWN);
    	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
    	r.delay(1000);
    }
	
	/*
	 * 点击元素，这里指点击鼠标左键
	 */	
	protected void click(WebElement element)
	{
			
		try {
				if (element.isEnabled()) 
				{
						element.click();
						Logger.Output(LogType.LogTypeName.INFO, "Element: "+element.toString()+" was clicked.");
				}
			} 
		catch (Exception e) 
		{
						Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
		}
			
		}
		
	/*
	 * 在文本输入框执行清除操作
	 */
	protected void clean(WebElement element)
	{
			
		try {
				if (element.isEnabled()) 
				{
					element.clear();
					Logger.Output(LogType.LogTypeName.INFO, "Element "+element.toString()+" was cleaned.");
				}
			} 
		catch (Exception e) 
		{
				Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
		}
			
		}
	
	/*
	 * 判断一个页面元素是否显示在当前页面
	 */  
	protected void verifyElementIsPresent(WebElement element)
	{
	    	
	    try {
				if (element.isDisplayed()) 
				{
					Logger.Output(LogType.LogTypeName.INFO, "This Element " + element.toString().trim()+" is present.");
						
				}
			} 
	    catch (Exception e) 
	         {
				Logger.Output(LogType.LogTypeName.ERROR, e.getMessage()+".");
		     }
	    }
	
	/*
	 * 获取页面的标题
	 */
	protected String getCurrentPageTitle()
	{
	    pageTitle=driver.getTitle();
	    Logger.Output(LogType.LogTypeName.INFO, "Current page title is "+pageTitle);
	    return pageTitle;
	}
	
	/*
	 * 获取页面的url
	 */
    protected String getCurrentPageUrl()
    {
	    pageUrl=driver.getCurrentUrl();
	    Logger.Output(LogType.LogTypeName.INFO, "Current page title is "+pageUrl);
	    return pageUrl;
	} 
   
    /*
     * 处理多窗口之间切换
     */
	public void switchWindow()
	{
		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄  
        Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄  
        Logger.Output(LogType.LogTypeName.INFO, "当前窗口数量： "+ handles.size());  
        Iterator<String> it = handles.iterator();  
        while (it.hasNext()) 
        {  
            if (currentWindow == it.next()) 
            {  
            	 continue;
            }  
            try 
            {  
            	driver.close();
                WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口 
                Logger.Output(LogType.LogTypeName.INFO, "new page title is "+ window.getTitle());
            } 
            catch (Exception e) 
            {  
            	 Logger.Output(LogType.LogTypeName.ERROR,"无法切换到新打开窗口"+ e.getMessage());  
            }  
            //driver.close();//关闭当前焦点所在的窗口  
            
        }  
        // driver.switchTo().window(currentWindow);//回到原来页面  
	}      
}
