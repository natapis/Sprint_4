package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class MainPage {
    private String url="https://qa-scooter.praktikum-services.ru/";
    //Кнопки создания заказа
    private By createOrderButtons = By.xpath(".//button[contains(@class,'Button_Button__ra12g') and text()='Заказать']");
    //Вопросы
    private By questions = By.xpath(".//div[@class='accordion__heading']");
    //Ответы
    private By answers = By.xpath(".//div[@class='accordion__panel']");

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){

        driver.get(url);

    }

    //Метод клика на вопрос
    public void clickToQuestion(int numberQuestion){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(questions).get(numberQuestion));
        driver.findElements(questions).get(numberQuestion).click();
    }

    //Метод получения ответа
    public String getAnswer(int numberQuestion){
        clickToQuestion(numberQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(answers).get(numberQuestion));
        return driver.findElements(answers).get(numberQuestion).getText();
    }

    //Подскролл к ответу
    public void scrollToAnswer(int numberAnswer){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(answers).get(numberAnswer));
    }

    public String getAnswerToNumber(int numberAnswer){
        return driver.findElements(answers).get(numberAnswer).getText();
    }

    //Метод нажатия на одну из кнопок создания
    public void buttonCreateClick(int numberButton){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(createOrderButtons).get(numberButton));
        driver.findElements(createOrderButtons).get(numberButton).click();
    }

    public boolean createOrder(int numberButton, String name, String surName, String address, int numberMetro, String mobile, String date, int numberTerm, int numberColor, String comment) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.buttonCreateClick(numberButton);
        ForWhomForm fwForm = new ForWhomForm(driver);
        fwForm.isFormDisplayed();
        fwForm.enterForm(name, surName, address, numberMetro, mobile);
        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.enterForm(date, numberTerm, numberColor, comment);
        return aboutRent.isSuccessOrder();
    }


}
