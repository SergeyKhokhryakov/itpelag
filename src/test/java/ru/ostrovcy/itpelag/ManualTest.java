package ru.ostrovcy.itpelag;

import io.qameta.allure.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ManualTest {
  @Test
  @Manual
  @DisplayName("Проверка формы \"Обсудить проект\"")
  public void testAuth(){
    step("Открыть форму \"Обсудить проект\"");
    step("Заполнить поля формы", () -> {
      step("Ввести данные пользователя");
      step("Ввести способы связи");
      step("Ввести описание задачи");
      step("Ввести приблизительный бюджет");
      step("Нажать кнопку Отправить");
    });
    step("Проверить результат регистрации запроса");
  }
}
