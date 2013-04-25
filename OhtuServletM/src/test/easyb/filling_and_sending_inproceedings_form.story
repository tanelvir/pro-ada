import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can fill and send an inproceedings form'

scenario "user can fill an inproceedings form", {

    given 'the correct form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }

    when 'the form has been filled correctly', {
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='author']"));
        element.sendKeys("Mari Herkku");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='title']"));
        element.sendKeys("Leivonnan raamattu");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='booktitle']"));
        element.sendKeys("Herkut");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("2001");        
    }


    and 'user sends the form', {
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@type='submit']"));
        element.submit();
    }

    then 'user gets to the bibtex page', {
        driver.getPageSource().contains("{Mari Herkku}").shouldBe true
    }
}


