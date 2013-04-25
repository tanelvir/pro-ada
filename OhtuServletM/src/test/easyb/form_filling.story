import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can fill an inproceedings form'

scenario "user can send an inproceedings form", {
    given 'inproceedings form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }

    when 'the required fields have been filled', {
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='author']"));
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='title']"));
        element.sendKeys("Ilmoja pidelty");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='booktitle']"));
        element.sendKeys("Uudet tuulet");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("1995");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='id']"));
        element.sendKeys("1");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@type='submit']"));
        element.submit();
    }
 
    then 'the form has been sent', {
        System.out.println(driver.getPageSource());
        driver.getPageSource().contains("Pekka Pouta").shouldBe true
    }
}

scenario "an incorrectly filled form is not sent", {
    given 'inproceedings form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the required fields have not been filled', {
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='author']"));
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='booktitle']"));
        element.sendKeys("Uudet tuulet");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("1995");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='id']"));
        element.sendKeys("2");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has not been sent', {
        driver.getPageSource().contains("Pekka Pouta").shouldBe false
    }
}

scenario "correctly filled form with special characters is sent", {
    given 'inproceedings form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the required fields with special letters have been filled', {
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='author']"));
        element.sendKeys("Helinä Keiju");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='title']"));
        element.sendKeys("Lentämisen käsikirja");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='booktitle']"));
        element.sendKeys("Osa 1");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("2013");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='id']"));
        element.sendKeys("5");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@type='submit']"));
        element.submit();
    }
    then 'bibtex code with special letters is generated correctly', {
        driver.getPageSource().contains("Helin\"{a} Keiju").shouldBe true
        driver.getPageSource().contains("Lent\"{a}misen k\"{a}sikirja").shouldBe true
    }
}