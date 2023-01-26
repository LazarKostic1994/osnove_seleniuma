package domaci_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak_3 {
//Napisati program koji vrsi dodavanje 5 redova
//Maksimizirati prozor
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//Klik na dugme Add New
//Unesite name,departmant i phone (uvek iste vrednost)
//Trazenje po name atributu
//Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add,
// delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci
// i last() fukncionalnost za xpath. Koristan link last mehnizma
//Cekanje od 0.5s
//Na kraju programa ugasite pretrazivac.
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        ArrayList<String> employees = new ArrayList<>();

        Thread.sleep(1500);

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[contains(@class , 'add-new')]")).click();
            driver.findElement(By.name("name")).sendKeys("Jack Johnson");
            driver.findElement(By.name("department")).sendKeys("Project Manager");
            driver.findElement(By.name("phone")).sendKeys("(452) 445-443");
            driver.findElement(By.xpath("//table[contains(@class, 'table table-bordered')" +
                                                            "]/tbody/tr[last()]/td[last()]/a[1]")).click();

        Thread.sleep(500);
        }
        driver.quit();
    }
}
