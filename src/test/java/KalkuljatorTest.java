import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KalkuljatorTest extends BaseTest {
    @Test
    @DisplayName("Калькулятор расхода пряжи")
    void kalkuljatorTest() {

        webDriver.get("https://leonardo.ru/");

        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[text()='Калькулятор расхода пряжи']")).click();

        By authFormLocator = By.name("yarnproject");
        new WebDriverWait(webDriver, 200).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.click();
        authForm.findElement(By.xpath("//*[text()='Женский жакет']")).click();

        By authFormLocators = By.name("yarnsize");
        new WebDriverWait(webDriver, 200).until(ExpectedConditions.presenceOfElementLocated(authFormLocators));
        WebElement authForms = webDriver.findElement(authFormLocators);
        authForms.click();
        authForms.findElement(By.xpath("//*[text()='132 см размер груди (2XL)']")).click();

    }
}
