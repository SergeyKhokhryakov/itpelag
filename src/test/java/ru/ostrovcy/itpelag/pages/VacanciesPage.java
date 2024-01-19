package ru.ostrovcy.itpelag.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import ru.ostrovcy.itpelag.navigation.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VacanciesPage {
  // Заголовки
  @Getter
  private final String Title = "Развивайся в айти вместе с ITpelag";

  // Локаторы
  private String locatorTitle = "h1";
  private String locatorVacanciesTitle = "h2[field=\"tn_text_1685951846859\"]";
  private String locatorDevOps = "a[href=\"/vacancies/middle-devops-engineer\"]";
  private String locatorSystemAnalyst = "a[href=\"/vacancies/system-analyst\"]";
  private String locatorPHPDeveloper = "a[href=\"/vacancies/middle-php-developer\"]";
  private String locatorSeniorPHPDeveloper = "a[href=\"/vacancies/senior-php-developer\"]";
  private String locatorJuniorStrongQAEngineer = "a[href=\"/vacancies/junior-strong-qa-engineer\"]";
  private String locatorJuniorFrontendDeveloperVue = "a[href=\"/vacancies/junior-frontend-developer-vue\"]";
  private String locatorSalary = "div[field=\"tn_text_1687159252492\"]";
  private String locatorSalaryFrontend = "div[field=\"tn_text_1702298315250\"]";
  private String locatorEmploymentText = "div[field=\"tn_text_1687154712029\"]";
  private String locatorTitleText = "div[field=\"tn_text_1686733880321\"]";
  private String locatorEmployment = "h3[field=\"tn_text_1687154712032\"]";
  private String locatorHome = "a[href=\"/vacancies/#vacancies\"]";

  @Step("Открыть вакансию Dev Ops")
  public VacanciesPage openVacancyDevOps() {
    open(locatorDevOps);
    return this;
  }
  @Step("Открыть вакансию System Analyst")
  public VacanciesPage openVacancySystemAnalyst() {
    open(locatorSystemAnalyst);
    return this;
  }
  @Step("Открыть вакансию PHP Developer")
  public VacanciesPage openVacancyPHPDeveloper() {
    open(locatorPHPDeveloper);
    return this;
  }
  @Step("Открыть вакансию Senior PHP Developer")
  public VacanciesPage openVacancySeniorPHPDeveloper() {
    open(locatorSeniorPHPDeveloper);
    return this;
  }
  @Step("Открыть вакансию Junior Strong QAEngineer")
  public VacanciesPage openVacancyJuniorStrongQAEngineer() {
    open(locatorJuniorStrongQAEngineer);
    return this;
  }
  @Step("Открыть вакансию Junior Frontend Developer Vue")
  public VacanciesPage openVacancyJuniorFrontendDeveloperVue() {
    open(locatorJuniorFrontendDeveloperVue);
    return this;
  }

  private void open(String locator) {
    scrollTo(locator);
    $(locator).pressEnter();
  }

  private void scrollTo(String locator) {
    $(locator).shouldBe(visible).scrollTo();
  }

  private void scrollToH(String locator) {
//    $(locator).scrollIntoView("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
    $(locator).scrollIntoView(false);
  }

  public VacanciesPage verifyTitle(String value) {
    MainPage.verifyText(locatorTitle, value);
    return this;
  }

  @Step("Проверить значение зарплаты")
  public VacanciesPage verifySalary(String value) {
    scrollTo(locatorSalary);
    MainPage.verifyText(locatorSalary, value);
    return this;
  }
  @Step("Проверить значение зарплаты")
  public VacanciesPage verifySalaryFrontend(String value) {
    scrollTo(locatorSalaryFrontend);
    MainPage.verifyText(locatorSalaryFrontend, value);
    return this;
  }

  @Step("Проверить правописание логотипа компании")
  public VacanciesPage verifySpellingLogo(String value) {
    scrollToH(locatorEmploymentText);
    MainPage.verifyText(locatorEmploymentText, value);
    return this;
  }
  @Step("Проверить правописание аббревиатуры \"IT\"")
  public VacanciesPage verifySpellingIT(String value) {
    scrollToH(locatorTitleText);
    MainPage.verifyCaseSensitiveText(locatorTitleText, value);
    return this;
  }
  @Step("Вернуться на страницу \"Вакансии\"")
  public VacanciesPage goHome() {
    open(locatorHome);
//    Selenide.back();
    return this;
  }
}
