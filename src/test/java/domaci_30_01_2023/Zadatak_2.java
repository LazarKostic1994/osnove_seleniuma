package domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak_2 {
//Napisati program koji:
//Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//Implicitno cekanje za trazenje elemenata je maksimalno 10s
//Implicitno cekanje za ucitavanje stranice je 5s
//Ucitava stranicu https://docs.katalon.com/
//Maksimizuje prozor
//Od html elementa cita data-theme atribut.
//Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//Klikce na dugme za zamenu tema
//Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//Ceka da se dijalog za pretragu pojavi
//Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//Zatvara pretrazivac
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");

        driver.manage().window().maximize();

        String theme = driver.findElement(By.xpath("//html")).getAttribute("data-theme");


        if (theme.equals("light")){
            System.out.println("Theme is light.");
        } else {
            System.out.println("Theme is dark.");
        }

        driver.findElement(By.xpath("//*[contains(@class, 'rCf9')]")).click();

        if (theme.equals("light")){
            System.out.println("Theme is light.");
        } else {
            System.out.println("Theme is dark.");
        }

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("DocSearch-SearchBar")));

        String search = driver.findElement(By.className("DocSearch-Input")).getAttribute("type");

        if (search.equals("search")){
            System.out.println("Value of the attribute is search");
        }else {
            System.out.println("Value of the attribute is not search");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
