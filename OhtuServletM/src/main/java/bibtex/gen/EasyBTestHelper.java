
package bibtex.gen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Apuluokka Selenium-testejä varten.
 * 
 * Näyttää minne sivulle "käyttäjä" milloinkin siirtyy, mikä
 * auttaa easyB/Selenium-testin kirjoittamisessa.
 */
public class EasyBTestHelper {
    
   public static void main(String[] args) {
       
       WebDriver driver;
       WebElement element;
       Select clickThis;
       
       // Alustetaan driver ja tulostetaan index-sivu
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        
        // Valitaan drop down -menusta kohta Inproceedings
        element = driver.findElement(By.id("theSelect"));       
        clickThis = new Select(element);
        clickThis.selectByValue("inproceedings"); /// EI TOMI, VALITSEE ARTICLEN :<
        
        
        // Lähetetään valinta seuraavalle sivulle painamalla Submit-painiketta
        element = driver.findElement(By.name("submit"));
        element.click(); 
        
        // Tulostetaan Inproceedings-lomakesivu
        System.out.println( driver.getPageSource() );
        
        //Täytetään lomakkeen pakolliset tiedot
        element = driver.findElement(By.name("author"));
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Uudet tuulet");        
        element = driver.findElement(By.name("booktitle"));
        //element.sendKeys("Ilmoja pidellyt");
        

        
    }
    
    
}
