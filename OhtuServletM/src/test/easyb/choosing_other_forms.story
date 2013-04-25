import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can choose an article form or a book form'

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
        element.sendKeys("9004");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has been sent', {
        driver.getPageSource().contains("Kukka Keto").shouldBe true
    }
}

scenario "user can fill a book form", {
    given 'the correct form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("book");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the form has been filled correctly', {
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='author']"));
        element.sendKeys("Kukka Mutu");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='title']"));
        element.sendKeys("Ihana kauneus");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='publisher']"));
        element.sendKeys("Klassikot");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='year']"));
        element.sendKeys("2007");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='id']"));
        element.sendKeys("8001");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has been sent', {
        driver.getPageSource().contains("Kukka Mutu").shouldBe true
    }
}

scenario "user fills an article form incorrectly", {
    given 'the correct form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("article");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the form has not been filled correctly', {
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='author']"));
        element.sendKeys("Kukka Keto");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='title']"));
        element.sendKeys("Ihana rumuus");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='journal']"));
        element.sendKeys("Klassikot");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@name='id']"));
        element.sendKeys("8002");
        element = driver.findElement(By.xpath("//form[@name='article']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has not been sent', {
        driver.getPageSource().contains("Ihana rumuus").shouldBe false
    }
}

scenario "user fills a book form incorrectly", {
    given 'the correct form is selected', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("book");
        element = driver.findElement(By.name("submit"));       
        element.click();
    }
    when 'the form has not been filled correctly', {
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='author']"));
        element.sendKeys("Kukka Mutuli");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='title']"));
        element.sendKeys("Ihana kauneus");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='year']"));
        element.sendKeys("2007");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@name='id']"));
        element.sendKeys("8003");
        element = driver.findElement(By.xpath("//form[@name='book']//input[@type='submit']"));
        element.submit();
    }
    then 'the form has not been sent', {
        driver.getPageSource().contains("Kukka Mutuli").shouldBe false
    }
}