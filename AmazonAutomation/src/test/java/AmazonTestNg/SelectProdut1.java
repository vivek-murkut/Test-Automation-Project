package AmazonTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazonPOM.SelectProduct;

public class SelectProdut1 {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void LounchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
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
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    
		
	}
	
	@BeforeMethod
	public void AppLounch()
	{
		System.out.println("AppLounch");
		
		driver.get("https://www.amazon.in/s?k=laptop&crid=12X0PJMOQ7VQM&sprefix=laptop%2Caps%2C373&ref=nb_sb_ss_ts-doa-p_2_6");
	
		driver.manage().window().maximize();
		
	
	}
	
	@Test
	public void Test_2() throws InterruptedException
	{
		System.out.println("Test_2");
		
		SelectProduct product1=new SelectProduct(driver);
		product1.ProductSelect();
		
		
		
	Thread.sleep(5000);
		

		String actualURL =driver.getCurrentUrl();
		System.out.println("actualURL is " +actualURL);
		
		String actualTitle=driver.getTitle();
		System.out.println("actualTitle is " +actualTitle);
		
		String expectedURL="https://www.amazon.in/HP-Chromebook-11-6-inch-Touchscreen-11a-na0002MU/dp/B08WPNPTDD/ref=sr_1_1_sspa?crid=1FGADNFLFGSL0&keywords=laptop&qid=1676119557&sprefix=laptop%2Caps%2C264&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1";
		String expectedTitle="HP Chromebook 11a, MediaTek MT8183 Processor 11.6 inch(29.5 cm) Thin and Light Touchscreen Laptop (4 GB RAM/64 GB eMMC/ Chrome OS /Fast Charge/Google Assistant/Indigo Blue/1.07Kg), na0002MU, 1.07Kg : Amazon.in: Computers & Accessories";
		
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
		System.out.println("CloseApp");
	}
	@AfterTest
	public void QuitApp()
	{
		driver.quit();
		System.out.println("QuitApp");
	}
	
}

