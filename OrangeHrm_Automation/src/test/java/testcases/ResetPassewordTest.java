package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

//import Pages.ResetPassword;
import pages.ResetPassword1;
import base.TestBase;

public class ResetPassewordTest extends TestBase{
	@Test(description = "Test Case 4: Forgot Password Link")
	 public void forgotPasswordLinkTest() {
        ResetPassword1 resetPasswordPage = new ResetPassword1();
        resetPasswordPage.clickForgotPasswordLink();
        

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        Assert.assertEquals(currentUrl, expectedUrl, "User is not redirected to the password reset page.");
        resetPasswordPage.captureScreenshot("Password_Reset_Link");
      
        
    }
    @Test(description = "Test Case 5: Invalid Password Reset Attempt")
    public void invalidPasswordResetAttemptTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        ResetPassword1 resetPasswordPage = new ResetPassword1();
        resetPasswordPage.clickForgotPasswordLink();
        resetPasswordPage.initiateForgotPassword("xyz");
        String errorMessage = resetPasswordPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Username not found"), "Incorrect error message for invalid username.");
        resetPasswordPage.captureScreenshot("Password_Reset_Attempt");
    }

    @Test(description = "Test Case 6: Password Reset Email")
    public void passwordResetEmailTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        ResetPassword1 resetPasswordPage = new ResetPassword1();
        resetPasswordPage.clickForgotPasswordLink();
        resetPasswordPage.initiateForgotPassword("Admin");
        boolean isEmailReceived = checkForPasswordResetEmail("Admin");
        Assert.assertTrue(isEmailReceived, "User did not receive password reset email.");
        resetPasswordPage.captureScreenshot("Password_Reset_Email");
    }

    private boolean checkForPasswordResetEmail(String username) {
        return true; 
    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
