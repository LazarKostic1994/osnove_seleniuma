package domaci_02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private String url = "https://s.bootsnipp.com";
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(url);
    }

    @Test (priority = 1)
    @Description("Edit Row")
    public void editRow() throws InterruptedException {
        String firstName = "Lazar";
        String lastName = "Kostic";
        String middleName = "Zoran";

       driver.get(url + "/iframe/K5yrx");

//       wait.until(ExpectedConditions.presenceOfElementLocated
//               (By.xpath(url + "/iframe/K5yrx")));

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not contain ' Table with Edit and Update Data - Bootsnipp.com'");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//tbody/tr[1]/td[5]/button")));

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("modal-content")));

        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("mn")).clear();

        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).sendKeys(middleName);

        driver.findElement(By.xpath("//button[@id='up']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.className("modal-content")));

        Assert.assertEquals(driver.findElement
                (By.id("f1")).getText(), firstName, "[ERROR] First name is not input");
        Assert.assertEquals(driver.findElement
                (By.id("l1")).getText(), lastName, "[ERROR] Last name is not input");
        Assert.assertEquals(driver.findElement
                (By.id("m1")).getText(), middleName, "[ERROR] Middle name is not input");
    }

    @Test (priority = 2)
    @Description("Delete Row")
    public void deleteRow() throws InterruptedException {
        String firstName = "Jelena";
        String lastName = "Kostic";
        String middleName = "Jasmina";

        driver.get(url + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not contain ' Table with Edit and Update Data - Bootsnipp.com'");

        driver.findElement(By.xpath("//*[@id='d1']//button[contains(@class,'delete')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delete']//div[@class='modal-content']")));

        driver.findElement(By.xpath("//*[@id='delete']//*[contains(@class,'modal-dialog')]/div[@class='modal-content']//button[@id='del']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.className("//div[@id='delete']//div[@class='modal-content']")));

        List <WebElement> rows = driver.findElements(By.xpath ("//*[contains(@class,'table-responsive')]/tbody/tr[0]"));

        Assert.assertTrue(rows.isEmpty(), "[ERROR] The row is not deleted");

        }

    @Test (priority = 3)
    @Description("Take a Screenshot")
    public void takeAScreenshot() throws InterruptedException, IOException {

        driver.get(url + "/iframe/K5yrx");

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not contain ' Table with Edit and Update Data - Bootsnipp.com'");

            TakesScreenshot ts=((TakesScreenshot)driver);
            File tsFile = ts.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("C:\\Users\\EliteBook\\Desktop\\github\\osnove_seleniuma\\screenshots\\screenshot.png");
            FileHandler.copy(tsFile, destinationFile);

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("The tests are completed");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png