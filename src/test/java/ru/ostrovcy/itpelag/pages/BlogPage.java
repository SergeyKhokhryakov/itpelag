package ru.ostrovcy.itpelag.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Alert;
import ru.ostrovcy.itpelag.navigation.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class BlogPage {
  @Getter
  private final String Title = "Ведем блог о работе";

  private String locatorTitle = "h1";
  private final static long DEFAULT_TIMEOUT = 4000;
  private final static long ALERT_TIMEOUT = 6000;

  String green = "rgba(40, 167, 69, 1)"; // для chrome

  @Step("21. Нажать на кнопку «Click me»  рядом с Click Button to see alert")
  public BlogPage showAlert(){
    $("button#alertButton").click();
    return this;
  }

  @Step("22. Закрыть уведомление")
  public void closeModal(){
    closeAlert();
  }

  @Step("23. Нажать на кнопку «Click me»  рядом с On button click, alert will appear after 5 seconds")
  public BlogPage showAlertTimer(){
    $("button#timerAlertButton").click();
    return this;
  }

  @Step("24. Закрыть уведомление")
  public void closeModalTimer(){
    Configuration.timeout = ALERT_TIMEOUT; // alert will appear after 5 seconds
    closeAlert();
    Configuration.timeout = DEFAULT_TIMEOUT; // set default value
  }

  @Step("25. Нажать на кнопку «Click me»  рядом с On button click, confirm box will appear")
  public BlogPage showConfirmBox(){
    $("button#confirmButton").click();
    return this;
  }

  @Step("26. Нажать на кнопку «Да» в уведомление")
  public BlogPage confirmModal(){
    closeAlert();
    return this;
  }

  private void closeAlert() {
    Selenide.switchTo().alert().accept();
  }

  @Step("27. Проверить, что появился текст You selected Ok")
  public void verifyConfirmResult(String value){
    verifyResult("#confirmResult", value);
  }

  @Step("28. Нажать на кнопку «Click me»  рядом с On button click, prompt box will appear")
  public BlogPage showPromptBox(){
    $("button#promtButton").click();
    return this;
  }

  @Step("29. Заполнить поле в уведомление данными: Test name")
  public BlogPage input(String value){
    Alert alert = switchTo().alert();
    alert.sendKeys(value);
    alert.accept();
    return this;
  }

  @Step("30. Проверить, что появился текст You entered Test name")
  public void verifyPromptResult(String value){
    verifyResult("#promptResult", "You entered \n" + value);
  }

  public void verifyResult(String locator, String textExpected){
    $(locator)
            .should(appear)
            .shouldHave(text(textExpected))
            .shouldHave(cssValue("color", green));
  }
  public void verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
  }

}
