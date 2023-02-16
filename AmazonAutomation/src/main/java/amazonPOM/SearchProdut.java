package amazonPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProdut {
WebDriver driver;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement search;
	@FindBy(xpath="//div[contains(text(),'lap')])[2]")
	private WebElement laptop;
	
	
	public  SearchProdut(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
	}
	public void SearchBox () throws InterruptedException {
		Thread.sleep(5000);
		search.click();
	search.sendKeys("laptop");
	}
	public void Product () throws InterruptedException {
		Thread.sleep(5000);
		laptop.click();
		
	}



}



