import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest{

        //WebDriver driver = new ChromeDriver();
        DefineCases defineCases = new DefineCases();
        //RW_File dosyaClass = new RW_File();



    @Test
    void testMethod() throws IOException {

        //defineCases.case1Method();
        //defineCases.case2Method();
        //defineCases.case3Method();
        //defineCases.case4Method();
        //defineCases.case5Method();
        //defineCases.case6Method();
        //defineCases.case7Method();
        //defineCases.case8Method();
        //defineCases.case9Method();
        //defineCases.case10Method();

    }

    @AfterTest
    void after(){

        //driver.close();
    }

}
