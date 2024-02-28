package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.LoginPage;
import base.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage login; 
	
	@BeforeMethod
	public void setup() {
		login = new LoginPage();

	}
	
	
	@Test
	public void verifyUrl() {
		String actualUrl = login.verifyUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(actualUrl, expectedUrl);
		login.captureScreenshot("Verify URL");
	}
	
	@Test(priority=2)
	public void verifyPageTitle() {
		String title = login.verifyPageTitle();
		String actualTitle= "OrangeHRM";
		Assert.assertEquals(title, actualTitle);
		login.captureScreenshot("Verify Page Title");
		
	}
	@DataProvider(name="Credentials")
	public Object[][] getData()
	{
		return new Object[][]
				{  {"blank","",""},
				   {"valid","Admin","admin123"},
			       {"invalid","xyz","xyz@123"},
			       {"invalidUN","pqr","admin123"},
			       {"invalidPass","Admin","hyq78"},
		
				};

}
	
	@Test(dataProvider = "Credentials")
    public void verifyLogin(String scenario, String username, String password) {
        login.Credentials(username, password);
        switch (scenario) {
            case "blank":
                Assert.assertEquals(login.ErrorMsg(), "Username and Password required");
                break;
            case "valid":
                Assert.assertEquals(login.verifyUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
                break;
            case "invalid":
            case "invalidUN":
            case "invalidPass":
                Assert.assertEquals(login.ErrorMsg(), "Username and password do not match");
                break;
        }
        
        login.captureScreenshot("Verify user login");
    }
	}
