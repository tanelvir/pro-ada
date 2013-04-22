
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
       
       // Alustetaan driver ja tulostetaan index-sivu
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );
        
        // Valitaan drop down -menusta kohta Inproceedings
        WebElement element = driver.findElement(By.id("theSelect")); 
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        
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
        
        //element = driver.findElement(By.name("booktitle")); ei toimi vielä :<
        //element.sendKeys("Ilmoja pidellyt");
        
        
//        
//        System.out.println("==");
//        
//        System.out.println( driver.getPageSource() );
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//        element.submit();
//        
//        System.out.println("==");
//        System.out.println( driver.getPageSource() );
        
    }
    
    
}
