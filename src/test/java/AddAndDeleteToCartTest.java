import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class AddAndDeleteToCartTest extends BaseTest{
    @Test
    @DisplayName("Добавление товара в корзину и удаление")
    void successfulAddAndDeleteToCart() {

        webDriver.get("https://leonardo.ru/");

        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[text()='Товары месяца']")).click();
        webDriver.findElement(By.xpath("//a[@data-id='1754871892']")).click();
        webDriver.findElement(By.xpath("//a[@href='/cart/']")).click();
        webDriver.findElement(By.xpath("//button[@class='cartitem_delete']")).click();
        webDriver.findElement(By.xpath("//a[@href='/cart/']")).click();

    }
}
