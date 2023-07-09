package edu.practikum.samokat;

import edu.praktikum.samokat.AboutRent;
import edu.praktikum.samokat.ForWhomForm;
import edu.praktikum.samokat.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CreatingOrder {
    private WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
     //   driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void createOrderOne(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.buttonCreateClick(0);
        ForWhomForm fwForm = new ForWhomForm(driver);
        fwForm.isFormDisplayed();
        fwForm.enterForm("Наталия", "Гончарова", "поместье Ярополец Московская губерния", 15, "80001234578");
        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.enterForm("12.08.2023",0,0,"Тестовый комментарий");
        aboutRent.isSuccessOrder();
    }
    @Test
    public void createOrderTwo(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.buttonCreateClick(1);
        ForWhomForm fwForm = new ForWhomForm(driver);
        fwForm.isFormDisplayed();
        fwForm.enterForm("Михаил", "Тургенев", "Спасское-Лутовиново в Орловской области", 10, "89998765432");
        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.enterForm("01.09.2023",4,1,"Звонить после 8");
        aboutRent.isSuccessOrder();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
