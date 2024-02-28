package base;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void initialization() {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}



