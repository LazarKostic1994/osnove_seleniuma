package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak_1 {
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter
//Validira da li je novi todo dodat na stranici
//Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//Validirati da je na kraju programa broj todo-a na stranici 0.
//Cekanje od 5s
//Zatvorite pretrazivac
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        List<String> nizToDo = new ArrayList<String>();

        nizToDo.add("Visit Paris");
        nizToDo.add("Visit Prague");
        nizToDo.add("Visit London");
        nizToDo.add("Visit New York");
        nizToDo.add("Visit Belgrade");

        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < nizToDo.size(); i++) {
            String txt = nizToDo.get(i);
            driver.findElement(By.className("new-todo")).sendKeys(txt);
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
            if (driver.findElement(By.xpath("//*[@class='todo-list']/li/div/label")).isDisplayed()){
                System.out.println("Uneto");
            }else {
                System.out.println("Nije uneto");
            }
        }

        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='todo-list']/li/div/label"));

        for (int i = 0; i < elements.size(); i++) {

            WebElement element = driver.findElement(By.xpath("//*[@class='todo-list']/li/div/label"));
            Actions action = new Actions(driver);

            action.moveToElement(element).perform();

            driver.findElement(By.xpath("//*[@class='destroy todo-button']")).click();
        }


        WebElement items = driver.findElement(By.xpath("//span[@class='todo-count']/strong"));

        if (items.isDisplayed()){
            System.out.println("Broj ToDo-a na stranici je veci od 0");
        }else {
            System.out.println("Broj ToDo-a na stranici je 0");
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
