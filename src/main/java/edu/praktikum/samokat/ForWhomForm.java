package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ForWhomForm {
    private WebDriver driver;
    //Заголовок формы "Для кого самокат"
    private By headerForm = By.xpath(".//div[text()='Для кого самокат']");
    //Поле ввода имени
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private By inputSurName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода станции метро
    private By inputMetro = By.className("select-search__input");
    //Выпадающий список
    private By metroDropdownList = By.xpath(".//button[contains(@class,'select-search__option')]");
    //Поле ввода телефона
    private By inputMobile = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private By buttonNext = By.xpath(".//Button[text()='Далее']");

    public ForWhomForm(WebDriver driver){
        this.driver = driver;
    }
    //Метод ввода текста
    public void enterTextField(By field, String text){
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(text);
    }
    //Метод ввода имени
    public void enterName(String name){
        enterTextField(inputName, name);
    }
    //Метод ввода фамилии
    public void enterSurName(String surName){
        enterTextField(inputSurName, surName);
    }
    //Метод ввода адреса
    public void enterAddress(String address){
        enterTextField(inputAddress, address);
    }
    //Метод выбора станции метро
    public void enterMetro(int numberMetro){
        driver.findElement(inputMetro).clear();
        driver.findElement(inputMetro).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(metroDropdownList).get(numberMetro));
        driver.findElements(metroDropdownList).get(numberMetro).click();
    }
    //метод ввода телефона
    public void enterMobile(String mobile){
        enterTextField(inputMobile, mobile);
    }
    //Выбор кнопки далее
    public void buttonNextClick(){
        driver.findElement(buttonNext).click();
    }

    // Заполнение формы Для кого самокат
    public void enterForm(String name, String surName, String address, int numberMetro, String mobile){
        enterName(name);
        enterSurName(surName);
        enterAddress(address);
        enterMetro(numberMetro);
        enterMobile(mobile);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        buttonNextClick();
    }

    //Проверка что форма Для кого самокат отображается
    public void isFormDisplayed(){
        driver.findElement(headerForm).isDisplayed();
    }

}
