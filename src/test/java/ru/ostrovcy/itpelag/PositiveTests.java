package ru.ostrovcy.itpelag;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.ostrovcy.itpelag.base.TestBaseRemote;

import static io.qameta.allure.Allure.step;

@Layer("web")
@Owner("hso")
@Feature("Issues")
public class PositiveTests extends TestBaseRemote {

  @Test
  @TM4J("HOMEWORK")
  @Story("Навигация по сайту https://itpelag.com/")
  @JiraIssues({@JiraIssue("HOMEWORK-1070")})
  @Description("Проверка перехода между рубриками на главной странице")
  @Severity(SeverityLevel.CRITICAL)
  @Tags({@Tag("pages"), @Tag("positive"), @Tag("smoke")})
  public void switchingPagesTest(){
    step("Открыть главную страницу", () -> {
      mainPage.openMainPage()
              .verifyTitle(mainPage.getTitle());
    });

    step("Открыть страницу \"Вакансии\"", () -> {
      mainPage.openVacanciesPage()
              .verifyTitle(mainPage.getVacanciesPage().getTitle());
    });

    step("Открыть страницу \"Лендинги\"", () -> {
      mainPage.openLandingPage()
              .verifyTitle(mainPage.getLandingPage().getTitle());
    });

    step("Открыть страницу \"Блог\"", () -> {
      mainPage.openBlogPage()
              .verifyTitle(mainPage.getBlogPage().getTitle());
    });

    step("Открыть страницу \"Контакты\"", () -> {
      mainPage.openContactsPage()
              .verifyTitle(mainPage.getContactsPage().getTitle());
    });

    step("Открыть страницу \"Мероприятия\"", () -> {
      mainPage.openKvartirnikPage()
              .verifyTitle(mainPage.getKvartirnikPage().getTitle());
      mainPage.goHome();
    });

    step("Открыть форму \"Обсудить проект\"", () -> {
      mainPage.openProjectPage()
              .verifyTitle(mainPage.getProjectPage().getTitle())
              .closePage();
    });
  }

  @Test
  @TM4J("HOMEWORK")
  @Story("Ведение вакансий в \"ITpelag\"")
  @JiraIssues({@JiraIssue("HOMEWORK-1070")})
  @Description("Проверка переключений между вакансиями на странице \"Вакансии\"")
  @Severity(SeverityLevel.NORMAL)
  @Tags({@Tag("vacancies"), @Tag("positive")})
  public void vacanciesTest(){
    String amountOfSalaryDevOps = "103.500 - 200.000 руб";
    String amountOfSalarySystemAnalyst = "до 126.000 руб";
    String amountOfSalaryPHPDeveloper = "103.500 - 200.000 руб";
    String amountOfSalarySeniorPHPDeveloper = "от 200.000 руб";
    String amountOfSalaryJuniorStrongQAEngineer = "от 60.000 руб";
    String amountOfSalaryJuniorFrontendDeveloperVue = "35.000 - 100.000 руб";
    String devOpsEngineer = "DevOps Engineer ";
    String systemAnalystTitle = "System Analyst";

    step("Открыть приложение на странице \"Вакансии\"", () -> {
      mainPage.openVacanciesPage()
              .openVacancyDevOps()
              .verifySalary(amountOfSalaryDevOps)
              .goHome()
              .openVacancySystemAnalyst()
              .verifySalary(amountOfSalarySystemAnalyst)
              .goHome()
              .openVacancyPHPDeveloper()
              .verifySalary(amountOfSalaryPHPDeveloper)
              .goHome()
              .openVacancySeniorPHPDeveloper()
              .verifySalary(amountOfSalarySeniorPHPDeveloper)
              .goHome()
              .openVacancyJuniorStrongQAEngineer()
              .verifySalary(amountOfSalaryJuniorStrongQAEngineer)
              .goHome()
              .openVacancyJuniorFrontendDeveloperVue()
              .verifySalaryFrontend(amountOfSalaryJuniorFrontendDeveloperVue)
              .goHome();
    });
  }
}
