import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginNegativeTest extends BaseTest {
    @Test
    @DisplayName("Неудачная авторизация")
    void unsuccessfulAuthTest() {

        webDriver.get("https://leonardo.ru/");

        String actualTitle = webDriver.getTitle();
        assertEquals(actualTitle, "Леонардо – Интернет‑магазин для хобби и рукоделия", "Match found");
        System.out.println("Title matched");


        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//a[@href='/profile/']")).click();

        By authFormLocator = By.name("login-form");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("login")).sendKeys("karpenko0304@rambler.ru");
        authForm.findElement(By.name("pass")).sendKeys("qwert123456");
        authForm.findElement(By.xpath("//input[@value='Войти']")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='неправильный логин или пароль']")));

    }
}
