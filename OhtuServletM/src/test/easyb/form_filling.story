import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can fill form'

scenario "user can fill an inproceedings form", {
    given 'inproceedings form is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }

    when 'the required fields have been filled', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Ilmoja pidelty");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Uudet tuulet");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1995");
        element = driver.findElement(By.name("Send"));
        element.submit();
    }
 
    then 'the form has been sent', {
        driver.getPageSource().contains("POLKU :").shouldBe true
    }
}