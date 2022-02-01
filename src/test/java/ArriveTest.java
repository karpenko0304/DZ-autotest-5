import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArriveTest extends BaseTest {
    @Test
    @DisplayName("Выбор доставки в США")
    void arriveUsaTest() {

        webDriver.get("https://leonardo.ru/");

        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[text()='Доставка']")).click();
        webDriver.findElement(By.xpath("//*[text()='За рубеж']")).click();

        By authFormLocator = By.xpath("//select[@class='choose-country form-control']");
        new WebDriverWait(webDriver, 80).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.click();
        authForm.findElement(By.xpath("//*[text()='США']")).click();

    }
}