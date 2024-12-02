import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void checkInputUp() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("0");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value"), "0");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(Keys.ARROW_UP);
        String increasedValue = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(increasedValue, "1");

    }
    @Test
    public void checkInputDown() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("0");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value"), "0");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        String decreasedValue = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value");
        Assert.assertEquals(decreasedValue, "-1");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
