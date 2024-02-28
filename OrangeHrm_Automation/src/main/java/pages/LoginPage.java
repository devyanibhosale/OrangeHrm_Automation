package pages;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username") 
	WebElement Username;
	
	@FindBy(name="password") 
	WebElement Password;
	
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") 
	WebElement LoginButton;
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
	WebElement ErrorMessage;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public String ErrorMsg() {
		return ErrorMessage.getText();
	}
    public void Credentials(String username ,String password) {
    	Username.sendKeys(username);
    	Password.sendKeys(password);
    	LoginButton.click();
    	
    }
    
    public void captureScreenshot(String testName) {
        // Convert WebDriver instance to TakeScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String destinationPath = "C:\\Users\\humip\\eclipse-workspace\\OrangeHRM\\FailedTestScreenshot" + testName + ".png";

        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(source, new File(destinationPath));
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    
   

	
	


}
