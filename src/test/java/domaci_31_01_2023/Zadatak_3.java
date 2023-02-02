package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
public class Zadatak_3 {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        Actions actions = new Actions(driver);

        actions.scrollToElement(driver.findElement(By.className("slider_bkgd"))).perform();

        WebElement element = driver.findElement(By.xpath("//*[@class='owl-stage']/div/div/img"));

        List<WebElement> srcList = driver.findElements(By.xpath("//*[@class='carousel-item']/img"));

        for (int i = 0; i < srcList.size(); i++) {
            String srcLink =  srcList.get(i).getAttribute("src");

            URL url = new URL(srcLink);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            if (http.getResponseCode() >= 200 && http.getResponseCode() < 400) {
                System.out.println("Link: " + url + " is available.");
            } else {
                System.out.println("Link: " + url + " is not available.");
            }
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
