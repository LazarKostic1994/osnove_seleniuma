package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        driver.manage().window().maximize();

        WebElement hoverable = driver.findElement(By.id("menu-item-6408"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='menu-item-6408']/ul"))));

        WebElement hoverable1 = driver.findElement(By.id("menu-item-5362"));
        new Actions(driver)
                .moveToElement(hoverable1)
                .perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='menu-item-5362 ']/ul"))));

        WebElement hoverable2 = driver.findElement(By.id("menu-item-5453"));
        new Actions(driver)
                .moveToElement(hoverable2)
                .perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='menu-item-5453']/ul"))));

        driver.quit();
    }
}
