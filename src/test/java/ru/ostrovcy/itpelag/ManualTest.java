package ru.ostrovcy.itpelag;

import io.qameta.allure.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ManualTest {
  @Test
  @Manual
  @DisplayName("Проверка авторизации в фиче \"Book Store Application\"")
  public void testAuth(){
    step("Открываем рубрику Book Store Application");
    step("Авторизуемся как пользователь Paul Drobenok", () -> {
      step("Вводим логин pdrobenok");
      step("Вводим пароль 123121312");
      step("Нажимаем кнопку Войти");
    });
    step("И тут продолжение....");

  }
}
