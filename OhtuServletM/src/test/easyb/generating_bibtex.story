import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can view bibtex code'

scenario "user can view bibtex code", {
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
        element.sendKeys("Pekka Pouta");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Uudet tuulet");
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Ilmoja pidellyt");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1999");
        element.submit();
    }

    then 'user can view bibtex code', {
        driver.getPageSource().contains("author = {Pekka Pouta},").shouldBe true
        driver.getPageSource().contains("title = {Uudet tuulet},").shouldBe true
        driver.getPageSource().contains("booktitle = {Ilmoja pidellyt},").shouldBe true
        driver.getPageSource().contains("year = {1999},").shouldBe true


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
        element = driver.findElement(By.name("year"));
        element.submit();
    }

    then 'user sees an error message', {
         driver.getPageSource().contains("pakollinen kenttä puuttuu!").shouldBe true
    }
}