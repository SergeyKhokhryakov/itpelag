package ru.ostrovcy.itpelag.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import ru.ostrovcy.itpelag.navigation.MainPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {
  @Getter
  private final String Title = "Контакты";
  private String locatorTitle = "h1";

  SelenideElement response = $("#output");

  @Step("4. Заполнить поля: Full Name, Email, Current Address, Permanent Address")
  public ContactsPage inputFields(String name, String email, String currentAddress, String permanentAddress){
    setUserName(name);
    setUserEmail(email);
    setCurrentAddress(currentAddress);
    setPermanentAddress(permanentAddress);
    return this;
  }

  public ContactsPage setUserName(String value) {
    $("input#userName").setValue(value);
    return this;
  }

  public ContactsPage setUserEmail(String value) {
    $("input#userEmail").setValue(value);
    return this;
  }

  public ContactsPage setCurrentAddress(String value) {
    $("textarea#currentAddress").setValue(value);
    return this;
  }

  public ContactsPage setPermanentAddress(String value) {
    $("textarea#permanentAddress").setValue(value);
    return this;
  }

  @Step("5. Нажать на кнопку «Submit»")
  public ContactsPage sendForm(){
    $("#submit").click();
    return this;
  }

  @Step("6. Проверить, что данные в блоке сохранены корректно")
  public void verifyBlockResult(String name, String email, String currentAddress, String permanentAddress){
    verifyModalAppears();
    verifyResult("name", name);
    verifyResult("email", email);
    verifyResult("currentAddress", currentAddress);
    verifyResult("permanentAddress", permanentAddress);
  }

  private void verifyModalAppears() {
    response.should(appear);
  }

  private void verifyResult(String key, String value) {
    response.$("#" + key).shouldHave(text(value));
  }
  public void verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
  }

}
