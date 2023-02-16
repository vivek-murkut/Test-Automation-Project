package AmazonTestNg;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazonPOM.BuyNowButton;

public class BuyProduct {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void LounchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
		  System.out.println("BeforeClass");
			System.setProperty("webdriver.chrome.driver",
					"C:\\selenium\\drviver\\chromedriver_win32\\chromedriver.exe");	
             driver =new ChromeDriver();
         }
		if(browserName.equals("Edge"))
		{
			System.out.println("browserLounch");
			System.out.println("BeforeClass");
			System.setProperty("webdriver.edge.driver", "C:\\selenium\\drviver\\edgedriver_win64\\msedgedriver.exe");

	         driver =new EdgeDriver();
	    }
		
		
	    
		
	}
	
	@BeforeMethod
	public void AppLounch()
	{
		System.out.println("AppLounch");
		
		driver.get("https://www.amazon.in/HP-Chromebook-11-6-inch-Touchscreen-11a-na0002MU/dp/B08WPNPTDD/ref=sr_1_1_sspa?crid=12X0PJMOQ7VQM&keywords=laptop&qid=1676117036&sprefix=laptop%2Caps%2C373&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	
	@Test
	public void Test3() throws InterruptedException
	{
		System.out.println("Test3");
		
		Thread.sleep(10000);
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(addr.get(1));
		  Thread.sleep(5000);
		 	
		  BuyNowButton buyButton=new  BuyNowButton(driver);
		  
		  
		String actText=buyButton.BuyNowProduct("Text2");
		
		System.out.println("Actual text is " + actText);
		String expText =" Buy Now ";
		
		if (expText.equals(actText))
		{
			System.out.println("Actual text and Expected text are same " + actText);
		}
		else
		{
			System.out.println("Actual text is not same as expected text ");
		}
		Thread.sleep(5000);
		

		String actualURL =driver.getCurrentUrl();
		System.out.println("actualURL is " +actualURL);
		
		String actualTitle=driver.getTitle();
		System.out.println("actualTitle is " +actualTitle);
		
		String expectedURL="https://www.amazon.in/ap/signin?";
		String expectedTitle="Amazon Sign In";
		
		if(actualURL.equals(expectedURL) || actualTitle.equals(expectedTitle))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}

	}

	@AfterMethod
		public void CloseApp()
		{
			driver.close();
			System.out.println("closed Current Tab");
		}
		
	@AfterClass
		public void QuitApp()
		{
			driver.quit();
			System.out.println("Quit Tab");
		}
		
	

}


