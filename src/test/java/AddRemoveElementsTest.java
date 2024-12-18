import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Element;
import java.time.Duration;

public class AddRemoveElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void checkAddRemoveTwoElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"elements\"]/button[1]")).sendKeys("Delete");
        driver.findElement(By.xpath("//*[@id=\"elements\"]/button[2]")).sendKeys("Delete");
        boolean elementOnDelete1 = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[1]")).isDisplayed();
        boolean elementOnDelete2 = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[2]")).isDisplayed();
        //если elementOnDelete1 и elementOnDelete2 находятся на дисплее, то должно быть true
        Assert.assertEquals(elementOnDelete1,elementOnDelete2);
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).sendKeys("Delete");
        driver.findElement(By.xpath("//button[text()='Delete']")).sendKeys("Delete");
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int count = driver.findElements(By.className("added-manually")).size();
        Assert.assertEquals(count, 1);
    }

    @Test
    public void checkAddRemoveElementsNegativ() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).sendKeys("Delete");
        driver.findElement(By.xpath("//button[text()='Delete']")).sendKeys("Delete");
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        int count = driver.findElements(By.className("added-manually")).size();
        //проверка на количество элементов не равное 1
        boolean countElements = (count != 1);
        Assert.assertTrue(countElements);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
