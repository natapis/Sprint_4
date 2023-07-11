package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRent {
    private WebDriver driver;
    //Поле даты
    private By inputDate = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");
    //Календарь
    private By dateInCalendar = By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]");
    //Поле срока
    private By term = By.className("Dropdown-control");
    //Выпадающий список
    private By listTerm = By.className("Dropdown-option");
    //Поле цвета
    private By listColor = By.className("Checkbox_Label__3wxSf");
    //Поле комментария
    private By inputComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка заказать
    private By buttonOrder = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    //Заголовок
    private By headerAboutRent = By.xpath(".//div[text()='Про аренду']");
    //Заголовок окна подтвержения заказа
    private By headerConfirmationWindow = By.xpath(".//div[text()='Хотите оформить заказ?']");
    //Кнопка "Да"
    private By buttonYes = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']");
    //Окно об успешном заказе
    private By successWindow = By.xpath(".//div[text()='Заказ оформлен']");
    public AboutRent (WebDriver driver){
        this.driver = driver;
    }
    //Метод заполнения даты
    public void enterDate(String date){
        driver.findElement(inputDate).clear();
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(dateInCalendar).click();
    }

    //Метод заполнения срока
    public void enterTerm(int numberTerm){
        driver.findElement(term).click();
        driver.findElements(listTerm).get(numberTerm).click();
    }
    //Метод заполнения цвета
    public void enterColour(int numberColor){
        driver.findElements(listColor).get(numberColor).click();
    }
    //Метод заполнения комментария
    public void enterComment(String comment){
        driver.findElement(inputComment).clear();
        driver.findElement(inputComment).sendKeys(comment);
    }
    //Метод нажатия на кнопку
    public void buttonClick(By button){
        driver.findElement(button).click();
    }
    //Проверка отображения формы Про аренду
    public boolean isFormDisplayed(By header){
        return driver.findElement(header).isDisplayed();
    }
    //Метод заполнения формы
    public void enterForm(String date, int numberTerm, int numberColor, String comment){
        isFormDisplayed(headerAboutRent);
        enterDate(date);
        enterTerm(numberTerm);
        enterColour(numberColor);
        enterComment(comment);
        buttonClick(buttonOrder);
    }
    //метод проверки успешности заказа
    public boolean isSuccessOrder(){
        isFormDisplayed(headerConfirmationWindow);
        buttonClick(buttonYes);
        return isFormDisplayed(successWindow);
    }


}
