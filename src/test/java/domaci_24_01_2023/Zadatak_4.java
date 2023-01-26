package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_4 {
//Maksimizirati prozor
//Ucitati stranicu https://artplayer.org/
//U fokusu je player sa desne strane
//Ceka 3-4s
//Klik na play dugme
//Klik na na zvucnik za mute
//Ceka 3s
//Klik na screenshot
//Klik na PIP mode
//Ceka 1s
//Klik na Exit PIP mode
//Klik na WebFullscreen
//Klik na Exit WebFullscreen
//Cekanje od 5s
//Zatvorite pretrazivac
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://artplayer.org/");

        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-play')]")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-volume')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[contains(@class, 'art-icon-screenshot')]")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'art-control-pip')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[contains(@class, 'art-control-pip')]")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'art-control-fullscreenWeb')]")).click();

        driver.findElement(By.xpath("//*[contains(@class, 'art-control-fullscreenWeb')]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
