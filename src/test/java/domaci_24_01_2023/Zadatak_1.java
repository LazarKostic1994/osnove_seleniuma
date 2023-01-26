package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak_1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(1500);
//        NIJE MI DOHVATAO NAREDNE ELEMENTE, IZ TOG RAZLOGA SAM UBACIO "Thread.sleep".

        driver.findElement(By.xpath("//*[@name = 'username']")).sendKeys("Admin");
//        driver.findElement(By.name("username")).sendKeys("Admin");  NE RADI IZ NEKOG RAZLOGA
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//        driver.findElement(By.name("password")).sendKeys("admin123");  NE RADI IZ NEKOG RAZLOGA
        driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")).click();

        Thread.sleep(5000);

        driver.findElement(By.className("oxd-input")).sendKeys("Me");

        driver.findElement(By.className("oxd-main-menu-item")).click();

        Thread.sleep(1000);

        driver.findElement(By.className("oxd-userdropdown-tab")).click();

        driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
