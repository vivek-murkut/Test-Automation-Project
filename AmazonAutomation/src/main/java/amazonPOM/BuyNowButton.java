package amazonPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyNowButton {
	 private WebDriver driver;
     private Actions act;
	@FindBy(xpath="//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	
	public BuyNowButton (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//this.driver=driver;
		act=new Actions(driver);
		
	}
	
	public String BuyNowProduct(String Text2) throws InterruptedException 
	{
		Thread.sleep(10000);
		act.moveToElement(buyNow).click().build().perform();
		String actText=buyNow.getText();
		return actText;
		
		
	}

}
