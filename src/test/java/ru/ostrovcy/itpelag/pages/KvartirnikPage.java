package ru.ostrovcy.itpelag.pages;

import lombok.Getter;
import ru.ostrovcy.itpelag.navigation.MainPage;

public class KvartirnikPage {
  @Getter
  private final String Title = "БИЗНЕС-КВАРТИРНИК";

  private String locatorTitle = "h1";

  public KvartirnikPage verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
    return this;
  }

}
