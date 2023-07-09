package edu.practikum.samokat;

import edu.praktikum.samokat.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class QuestionsAboutImportant {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkTextInDropdownList(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkAnswer(5);
        mainPage.checkAnswer(0);
        mainPage.checkAnswer(1);
        mainPage.checkAnswer(3);
        mainPage.checkAnswer(6);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
