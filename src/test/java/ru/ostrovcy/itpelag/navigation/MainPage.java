package ru.ostrovcy.itpelag.navigation;


import io.qameta.allure.Step;
import lombok.Getter;
import ru.ostrovcy.itpelag.pages.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница приложения имеет
 * верхнюю панель навигации по категориям
 * Каждая категория - самостоятельная страница со скроллингом
 * <p>
 * Методы:
 * - openMainPage()
 * - openVacanciesPage()
 * - openLandingPage()
 * - openBlogPage()
 * - openKvartirnikPage()
 * - openContactsPage()
 * - openProjectPage()
 */


public final class MainPage {
  private static volatile MainPage instance;
  //locators
  private String locatorMain = "a[href=\"/\"]";
  private String locatorVacancies = "a[href=\"/vacancies\"]";
  private String locatorLanding = "a[href=\"/landing\"]";
  private String locatorBlog = "a[href=\"/blog\"]";
  private String locatorContacts = "a[href=\"/contacts\"]";
  private String locatorKvartirnik = "a[href=\"https://itpelag.com/kvartirnik23\"]";
  private String locatorProject = "a[href=\"#popup:project\"]";
  private String locatorTitle = "h1";
  @Getter
  private final String Title = "Разработка веб-решений для автоматизации бизнеса";
  @Getter
  private ContactsPage contactsPage = new ContactsPage();
  @Getter
  private VacanciesPage vacanciesPage = new VacanciesPage();
  @Getter
  private LandingPage landingPage = new LandingPage();
  @Getter
  private BlogPage blogPage = new BlogPage();
  @Getter
  private KvartirnikPage kvartirnikPage = new KvartirnikPage();
  @Getter
  private ProjectPage projectPage = new ProjectPage();

  private MainPage() {
  }

  public static MainPage getInstance() {
    MainPage result = instance;
    if (result != null) {
      return result;
    }
    synchronized (MainPage.class) {
      if (instance == null) {
        instance = new MainPage();
      }
      return instance;
    }
  }

  public MainPage openMainPage() {
    if($(locatorTitle).getText().equals(Title) == false){
      open(locatorMain);
    }
    return getInstance();
  }

  public MainPage goHome(){
    step("Вернуться домой", () -> {
      open(locatorMain);
    });
    return instance;
  }

  public VacanciesPage openVacanciesPage() {
    if($(locatorTitle).getText().equals(vacanciesPage.getTitle()) == false){
      open(locatorVacancies);
    }
    return vacanciesPage;
  }

  public LandingPage openLandingPage() {
    if($(locatorTitle).getText().equals(landingPage.getTitle()) == false) {
      open(locatorLanding);
    }
    return landingPage;
  }

  public BlogPage openBlogPage() {
    if($(locatorTitle).getText().equals(blogPage.getTitle()) == false) {
      open(locatorBlog);
    }
    return blogPage;
  }

  public KvartirnikPage openKvartirnikPage() {
    if($(locatorTitle).getText().equals(kvartirnikPage.getTitle()) == false) {
      open(locatorKvartirnik);
    }
    return kvartirnikPage;
  }

  public ContactsPage openContactsPage() {
    if($(locatorTitle).getText().equals(contactsPage.getTitle()) == false) {
      open(locatorContacts);
    }
    return contactsPage;
  }

  public ProjectPage openProjectPage() {
    if($(locatorTitle).getText().equals(projectPage.getTitle()) == false) {
      open(locatorProject);
    }
    return projectPage;
  }

  private void open(String locator) {
    $(locator).pressEnter();
  }

  private void scrollTo(String locator) {
    $(locator).scrollTo();
  }

  public void verifyTitle(String value) {
    verifyText(locatorTitle, value);
  }
  @Step("Проверить заголовок страницы")
  public static void verifyText(String locator, String textExpected) {
    $(locator).shouldBe(visible).shouldHave(text(textExpected));
  }
  public static void verifyCaseSensitiveText(String locator, String textExpected) {
    $(locator).shouldBe(visible).shouldHave( textCaseSensitive(textExpected));
  }
}

