import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can fill in all the different forms'

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
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='id']"));
        element.sendKeys("3");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has been sent', {
        driver.getPageSource().contains("Mari Herkku").shouldBe true
    }
}

scenario "user can fill an article form", {
    given 'the correct form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("article");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the form has been filled correctly', {
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='author']"));
        element.sendKeys("Kukka Keto");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='title']"));
        element.sendKeys("Ihana kauneus");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='journal']"));
        element.sendKeys("Klassikot");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='year']"));
        element.sendKeys("2007");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='id']"));
        element.sendKeys("4");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has been sent', {
        driver.getPageSource().contains("Kukka Keto").shouldBe true
    }
}

scenario "user can fill a book form", {
    given 'the correct form is selected', {
        
    }
    when 'the form has been filled correctly', {
        
    }
    then 'the form has been sent', {
        
    }
}

scenario "user fills an inproceedings form incorrectly", {
    given 'the correct form is selected', {
        
    }
    when 'the form has not been filled correctly', {
        
    }
    then 'the form has not been sent', {
        
    }
}

scenario "user fills an article form incorrectly", {
    given 'the correct form is selected', {
        
    }
    when 'the form has not been filled correctly', {
        
    }
    then 'the form has not been sent', {
        
    }
}

scenario "user fills a book form incorrectly", {
    given 'the correct form is selected', {
        
    }
    when 'the form has not been filled correctly', {
        
    }
    then 'the form has not been sent', {
        
    }
}

scenario "", {
    given '', {
        
    }
    when '', {
        
    }
    then '', {
        
    }
}
