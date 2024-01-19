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
@Story("Тестирование орфографии контента")
public class SpellingTests extends TestBaseRemote {
  @Test
  @TM4J("HOMEWORK")
  @JiraIssues({@JiraIssue("HOMEWORK-1070")})
  @Description("Проверка правописания в тексте аббревиатуры \"IT\"")
  @Severity(SeverityLevel.TRIVIAL)
  @Tags({@Tag("spelling"), @Tag("positive")})
  public void spellingITTest () {
    String it = "it";

    step("Открыть страницу \"Вакансии\"", () -> {
      mainPage.openVacanciesPage()
              .verifySpellingIT(it);
    });
  }

  @Test
  @TM4J("HOMEWORK")
  @JiraIssues({@JiraIssue("HOMEWORK-1070")})
  @Description("Проверка правописания наименования компании \"ITpelag\"")
  @Severity(SeverityLevel.TRIVIAL)
  @Tags({@Tag("spelling"), @Tag("positive")})
  public void spellingLogoTest() {

    String company = "ITpeag";

    step("Открыть страницу \"Вакансии\"", () -> {
      mainPage.openVacanciesPage()
              .verifySpellingLogo(company);
    });
  }
}
