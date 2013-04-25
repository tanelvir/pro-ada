import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can choose an inproceedings form'

scenario "user can choose an inproceedings form", {
    given 'user is viewing the front page', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");        
    }

    when 'user chooses the inproceedings form', {
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");        
    }

    and 'submits the selection', {
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
 
    then 'user can see the form page', {        
        driver.getPageSource().contains("An article in a conference proceedings.").shouldBe true
    }
}