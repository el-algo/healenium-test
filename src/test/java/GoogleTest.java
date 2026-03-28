import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GoogleTest {
    @Test
    public void OpenFirefox() throws InterruptedException {
        // Punto 1
        WebDriverManager.firefoxdriver().setup();
        WebDriver delegate = new FirefoxDriver();
        // Driver de Healenium
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Punto 2
        WebElement txtInput = driver.findElement(By.id("my-text-id"));
        //WebElement txtInput = driver.findElement(By.id("my-text-id-old"));
        //  La prueba falla ^
        txtInput.sendKeys("Sample text");
        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("Password123");
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("This is a lot more sample text");

        // Punto 3
        WebElement dropDown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropDown);
        select.selectByValue("1");

        // Punto 4
        WebElement checkBox = driver.findElement(By.id("my-check-1"));
        checkBox.click();
        WebElement radioButton = driver.findElement(By.id("my-radio-2"));
        radioButton.click();
        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("04/10/2025");

        // Punto 5
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
    }
}
