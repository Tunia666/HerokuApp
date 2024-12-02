import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void checkCheckbox1() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isDisplayed();
        //проверка checkbox1 на unchecked
        boolean checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
        Assert.assertFalse(checkbox1);
        //клик checkbox1 и проверка на checked
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
        Assert.assertTrue(checkbox1);
    }
    @Test
    public void checkCheckbox2() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isDisplayed();
        //проверка checkbox2 на checked
        boolean checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        Assert.assertTrue(checkbox2);
        //клик checkbox2 и проверка на unchecked
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        Assert.assertFalse(checkbox2);
    }
    @Test
    public void checkCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isDisplayed();
        //проверка checkboxes на unchecked и checked
        boolean checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
        boolean checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        Assert.assertFalse(checkbox1);
        Assert.assertTrue(checkbox2);
        //клик checkboxes и проверка на unchecked и checked
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
        checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        Assert.assertTrue(checkbox1);
        Assert.assertFalse(checkbox2);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
