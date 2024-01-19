package ru.ostrovcy.itpelag.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Getter;
import ru.ostrovcy.itpelag.navigation.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class LandingPage {
  @Getter
  private final String Title = "Создаем сайты для улучшения вашего бизнеса";
  private String locatorTitle = "h1";

  @Step("16. Нажать на кнопку «New Tab»")
  public LandingPage openNewTab(){
    $("#tabButton").click();
    return this;
  }

  @Step("17. Закрыть новую вкладку")
  public void closeNewTab(){
    close();
  }

  @Step("18. Нажать на кнопку «New window»")
  public LandingPage openNewWindow(){
    $("#windowButton").click();
    return this;
  }

  @Step("19. Закрыть новое окно")
  public void closeNewWindow(){
    close();
  }

  private void close(){
    Selenide.switchTo().window(1);
    Selenide.closeWindow();
    Selenide.switchTo().window(0);
  }

  public void verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
  }

}
