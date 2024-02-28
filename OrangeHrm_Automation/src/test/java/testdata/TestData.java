package testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="Credentials")
    public static Object[][] getData() {
        return new Object[][] {
            {"blank", "", ""},
            {"valid", "Admin", "admin123"},
            {"invalid", "xyz", "xyz@123"},
            {"invalidUN", "pqr", "admin123"},
            {"invalidPass", "Admin", "hyq78"}
        };
    }
}
