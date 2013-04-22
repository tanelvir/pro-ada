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
 
    then 'the form has been sent', {
        driver.getPageSource().contains("POLKU :").shouldBe true
    }
}

scenario "user can not login with incorrect password", {
    given 'command login selected'
    when 'a valid username and incorrect password are given'
    then 'user will not be logged in to system'
}

scenario "nonexistent user can not login to system", {
    given 'command login selected'
    when 'a nonexistent username and some password are given'
    then 'user will not be logged in to system'
}