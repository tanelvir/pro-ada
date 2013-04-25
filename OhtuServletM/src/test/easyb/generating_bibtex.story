import bibtexgeneraattori.*;
import bibtexgeneraattori.generators.*;
import bibtexgeneraattori.app.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can view bibtex code'

scenario "user can view bibtex code", {
    given 'the inproceedings form has been chosen', {

    }
    when 'all of the required fields are filled and user has pressed the submit button', {

    }
    then 'user can view bibtex code', {

    }
}

scenario "user cannot view bibtex code", {
    given 'user has filled the inproceedings form', {
        
    }
    when 'all of the required fields are not filled and user has pressed the submit button', {
        
    }
    then 'user cannot view bibtex code', {
        
    }
}

scenario "correctly filled form with special characters is sent", {
    given 'inproceedings form is selected', {
        
    }
    when 'the required fields with special letters have been filled', {
        
    }
    then 'bibtex code with special letters is generated correctly', {
        
    }
}