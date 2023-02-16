package amazonPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatNewAcc1 {
	WebDriver driver;
	Actions act;

	@FindBy(xpath = "//a[contains(text(),'Create your Amazon account')]")
	private WebElement createNewAcc;

	public CreatNewAcc1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);

	}

	public String CreateAccount(String Test_3) throws InterruptedException {
		Thread.sleep(10000);
		createNewAcc.click();
		String actText = createNewAcc.getText();
		return actText;

	}
}
