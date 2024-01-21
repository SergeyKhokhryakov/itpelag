package ru.ostrovcy.itpelag.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import ru.ostrovcy.itpelag.navigation.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ProjectPage {
  @Getter
  private final String Title = "Давайте обсудим задачу и найдем решение";
  private String locatorTitle = "div[field=\"tn_text_1686635876729\"]";
  private String locatorClose = "a.loaded";

  public ProjectPage verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
    return this;
  }

  public void closePage(){
    step("Закрыть форму", () -> {
      $(locatorClose).pressEnter();
    });
  }

}
