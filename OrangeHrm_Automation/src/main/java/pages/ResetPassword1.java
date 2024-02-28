package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import base.TestBase;

public class ResetPassword1 extends TestBase {
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/form/div[1]/div/div[2]/input")
    WebElement usernameField;
    
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/form/div[2]/button[2]")
    WebElement resetButton;
    
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/h6")
    WebElement errorMessage;

    public ResetPassword1() {
    	PageFactory.initElements(driver, this);
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void initiateForgotPassword(String username) {
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[1]/div/div[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[2]"));
        usernameField.sendKeys(username);
        submitButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/h6"));
        return errorMessage.getText();
    }

    public boolean isPasswordResetPageOpened() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("password_reset_url");
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




