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

import amazonPOM.SearchProdut;

public class ApplicationLaunch {
	WebDriver driver;

	@Parameters("browser")

	@BeforeTest
	public void LaunchBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			System.out.println("BeforeClass");
			System.setProperty("webdriver.chrome.driver",
					"C:\\selenium\\drviver\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		if (browserName.equals("Edge")) {
			System.out.println("browserLounch");
			System.out.println("BeforeClass");
			System.setProperty("webdriver.edge.driver", "C:\\selenium\\drviver\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	
	
	@BeforeMethod
	public void LounchApplication()
    {
		System.out.println("Application Lounch");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		System.out.println("Test_1");
		
		SearchProdut search=new SearchProdut(driver);
				search.SearchBox();
		        search.Product();
		
		        Thread.sleep(5000);
		
		String actualURL=driver.getCurrentUrl();
		System.out.println("actualURL is " + actualURL);
		
		String actualTitle=driver.getTitle();
		System.out.println("actualTitle is " +actualTitle);
		
		String expectedURL="https://www.amazon.in/s?k=laptop&crid=12X0PJMOQ7VQM&sprefix=laptop%2Caps%2C373&ref=nb_sb_ss_ts-doa-p_2_6";
		String expectedTitle="Amazon.in : laptop";
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
