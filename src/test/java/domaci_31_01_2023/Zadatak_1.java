package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak_1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("img.edit-image")).click();
        driver.findElement(By.id("image-option-remove")).click();

        List<String> imgLinks = new ArrayList<>();
        imgLinks.add("images/front.jpg");
        imgLinks.add("images/right.jpg");
        imgLinks.add("images/left.jpg");
        imgLinks.add("images/back.jpg");

        for (int i = 0; i < imgLinks.size(); i++) {
            driver.findElement(By.cssSelector("img.edit-image")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));
            driver.findElement(By.id("imageUpload"))
                    .sendKeys(new File(imgLinks.get(i)).getAbsolutePath());
            wait.until(ExpectedConditions.numberOfElementsToBe(
                    By.xpath("//img[contains(@id,'image-option')]"), i+1));

            driver.findElement(By.id("image-option-0")).click();
            driver.findElement(By.id("image-crop-done-button")).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("textareaID")).sendKeys("Picture cube");

        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
