import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'user can fill form'

scenario "user can fill an inproceedings form", {
    given 'inproceedings form is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        element = driver.findElement(By.name("myform"));
        element.deselectAll();
        element.selectByVisibleText("Inproceedings");
        element.submit();
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
    then 'user becomes happy', {
        
    }
}

scenario "" {
    given '', {
        
    }
    when '', {
        
    }
    then '', {
        
    }
}
