package Part1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initialize the Chrome driver and open the website
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Setup completed. Browser is launched.");
    }

    @Test
    public void testLoggingIntoApplication() throws InterruptedException {
        // Wait for the HRM page to load completely
        Thread.sleep(5000);

        // Locate and interact with the username field
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // Locate and interact with the password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Click on the login button
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.tagName("h6")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);

        // Wait for a few seconds to see the result after login
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
       //Close the browser after the test is done
        driver.quit();
        System.out.println("Test completed. Browser closed.");
    }
}
