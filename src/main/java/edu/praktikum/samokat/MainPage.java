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
    private final String[] ANSWERS = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
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

    //Метод сравнения ответа
    public void checkAnswer(int numberQuestion){
        clickToQuestion(numberQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(answers).get(numberQuestion));
        Assert.assertEquals("Не тот текст", ANSWERS[numberQuestion],driver.findElements(answers).get(numberQuestion).getText());
    }

    //Метод нажатия на одну из кнопок создания
    public void buttonCreateClick(int numberButton){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(createOrderButtons).get(numberButton));
        driver.findElements(createOrderButtons).get(numberButton).click();
    }


}
