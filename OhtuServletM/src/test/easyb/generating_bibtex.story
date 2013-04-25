import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can view bibtex code'

scenario "user can view bibtex code when the form has been properly filled", {
    given 'the inproceedings form has been chosen', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();

    }
    when 'all of the required fields are filled and user has pressed the submit button', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Rekka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Pahat tuulet");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("En ole pidellyt");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("1977");
        element.submit();
    }

    then 'user can view bibtex code', {
        driver.getPageSource().contains("author = {Rekka Pouta},").shouldBe true
        driver.getPageSource().contains("title = {Pahat tuulet},").shouldBe true
        driver.getPageSource().contains("booktitle = {En ole pidellyt},").shouldBe true
        driver.getPageSource().contains("year = {1977},").shouldBe true


    }
}






scenario "user cannot view bibtex code if some of the required fields are left blank", {
    given 'the inproceedings form has been chosen', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();

    }
    when 'all of the required fields are not filled and user has pressed the submit button', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Uudet tuulet");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Ilmoja pidellyt");
        element.submit();
    }

    then 'user sees an error message', {
         driver.getPageSource().contains("pakollinen kenttä puuttuu!").shouldBe true
    }
}





scenario "user can view bibtex code that includes optional fields", {
    given 'the inproceedings form has been chosen', {
        driver = new HtmlUnitDriver(true);
        driver.get("http://localhost:8080");
        element = driver.findElement(By.id("theSelect"));
        Select clickThis = new Select(element);
        clickThis.selectByValue("inproceedings");
        element = driver.findElement(By.name("submit"));       
        element.click();

    }

    when 'all of the required fields are filled', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Pakka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Vanhat tuulet");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Almoja pidellyt");
        element = driver.findElement(By.xpath("//form[@name='inproceedings']//input[@name='year']"));
        element.sendKeys("1995");
    }

    and 'some of the optional fields are filled and user has pressed the submit button', {
        element = driver.findElement(By.name("series"));
        element.sendKeys("Ilmaiset kelit");
        element = driver.findElement(By.name("note"));
        element.sendKeys("Hups");
        element = driver.findElement(By.name("key"));
        element.sendKeys("7");
        
        element.submit();
    }

    then 'user sees bibtex that contains optional fields', {
        driver.getPageSource().contains("author = {Pakka Pouta},").shouldBe true
        driver.getPageSource().contains("title = {Vanhat tuulet},").shouldBe true
        driver.getPageSource().contains("booktitle = {Almoja pidellyt},").shouldBe true
        driver.getPageSource().contains("year = {1995},").shouldBe true

        driver.getPageSource().contains("series = {Ilmaiset kelit},").shouldBe true
        driver.getPageSource().contains("note = {Hups},").shouldBe true
        driver.getPageSource().contains("key = {7},").shouldBe true
    }
}