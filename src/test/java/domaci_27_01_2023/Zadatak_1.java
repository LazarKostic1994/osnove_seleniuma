package domaci_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak_1 {

    public static void main(String[] args) throws InterruptedException {
//Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik na svako dugme od PRIMARY do DARK
//Sacekati da se toasts u desnom gornjem uglu pojavi
//Pauza izmedju klikova 1s
//Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        List<String> nizStringova = new ArrayList<String>();

        nizStringova.add("Primary");
        nizStringova.add("Secondary");
        nizStringova.add("Success");
        nizStringova.add("Danger");
        nizStringova.add("Warning");
        nizStringova.add("Info");
        nizStringova.add("Light");
        nizStringova.add("Dark");

        for (int i = 0; i < nizStringova.size(); i++) {

            WebElement buttons = driver.findElement
                    (By.xpath("//button[contains(text(), '"+nizStringova.get(i)+"')]"));

            Thread.sleep(1000);

            buttons.click();

            WebElement toasts = driver.findElement
                    (By.xpath("//div[contains(text(), '"+nizStringova.get(i)+" Basic Example')]"));

            if(toasts.isDisplayed()){
                System.out.println("Toast is visible.");
            }
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
