package amazonPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="(((//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//div)[13]//span)[16]//span)[1]")
	private WebElement product;
	
	public  SelectProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
		
	}
	
	public void ProductSelect() throws InterruptedException
	{
		 Thread.sleep(5000);
		act.moveToElement(product).click().build().perform();
		
	}

}
