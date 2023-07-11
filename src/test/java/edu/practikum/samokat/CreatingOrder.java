package edu.practikum.samokat;

import edu.praktikum.samokat.AboutRent;
import edu.praktikum.samokat.ForWhomForm;
import edu.praktikum.samokat.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class CreatingOrder{
    private WebDriver driver;
    private final int numberButton;
    private final String name;
    private final String surName;
    private final String address;
    private final int numberMetro;
    private final String mobile;
    private final String date;
    private final int numberTerm;
    private final int numberColor;
    private final String comment;
    private final boolean expected;
    public CreatingOrder(int numberButton, String name, String surName, String address, int numberMetro, String mobile, String date, int numberTerm, int numberColor, String comment, boolean expected){
        this.numberButton = numberButton;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.numberMetro = numberMetro;
        this.mobile = mobile;
        this.date = date;
        this.numberTerm = numberTerm;
        this.numberColor = numberColor;
        this.comment = comment;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[] getOrderData(){
        return new Object[][] {
                {0, "Наталия", "Гончарова", "Село Никульское", 10, "89101234578", "10.10.2023", 2, 0, "Тестовый комментарий", true},
                {1, "Сергей", "Тургенев", "Москва, звонять колокола", 15, "89993216598", "30.08.2023", 3, 1, "Звонить после 8", true},
        };
    }
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void shouldBeOrder(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.buttonCreateClick(numberButton);
        ForWhomForm fwForm = new ForWhomForm(driver);
        fwForm.isFormDisplayed();
        fwForm.enterForm(name, surName, address, numberMetro, mobile);
        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.enterForm(date, numberTerm, numberColor, comment);
        boolean actual =  aboutRent.isSuccessOrder();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
