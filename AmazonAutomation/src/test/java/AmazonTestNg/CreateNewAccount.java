package AmazonTestNg;

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

import amazonPOM.CreatNewAcc1;

public class CreateNewAccount {
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
	public void AppLounch3()
	{
		System.out.println("AppLounch3");
		driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=amazon_checkout_in&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcheckoutportal%2Fenter-checkout.html%3Fie%3DUTF8%26asin%3DB08WPNPTDD%26buyNow%3D1%26cartCustomerID%3D0%26fromSignIn%3D1%26isBuyBack%3D0%26isGift%3D0%26offeringID%3D9enAXS%25252FivKYZY2GBbxGLDRoAIvbN4YZr1raQs%25252FOtuut1D%25252BZtO9LmpSkDbBhwdhZh%25252F202GTb7o0IsAexrdE0eazc38aPAJ7YVacMxd%25252Fr8%25252BzZDUuvThlGvPMxOr3zqoHhNElnAtwOcv2v77EZ85TnQ0akHc6P2RxZK%26quantity%3D1%26sessionID%3D261-5453428-8584815&pageId=amazon_checkout_in&showRmrMe=0&siteState=IMBMsgs.&suppressSignInRadioButtons=0");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void Test4() throws InterruptedException
	{
		System.out.println("Test4");
		CreatNewAcc1 createAcc=new CreatNewAcc1(driver);
		
		
	String actText=createAcc.CreateAccount("Test_3");
		
		System.out.println("Actual text is " + actText);
		String expText ="Create your Amazon account";
		
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
		
		String expectedURL="https://www.amazon.in/ap/register?";
		String expectedTitle="Amazon Registration";
		
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
		System.out.println("Quit Tab");
	}
}
