package domaci_26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak_2 {
//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> niz = driver.findElements(By.xpath("//div [contains(@class, 'alert')]/button"));

        for (int i = 0; i < niz.size(); i++) {

            niz.get(i).click();

            List<WebElement> elements2 = driver.findElements(By.xpath("//div [contains(@class, 'alert')]/button"));
            if(elements2.size() > 0){
                System.out.println("Element postoji.");
            } else {
                System.out.println("Element ne postoji.");
            }
        }
    }

    private static boolean elements2(WebDriver driver,By by) {
        boolean elements = true;
        try {
            driver.findElement(by);
        } catch(Exception e) {
            elements = false;
        }
        return elements;
    }
}

