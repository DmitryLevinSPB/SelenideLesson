package testsSelenideGitHub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.TypeOptions.text;

public class TestSelenideRepositorySearch {
    @BeforeMethod
    public void before() {
        // Открыть главную страницу
        open("https://github.com/");
        Configuration.baseUrl = "/";
        Configuration.browser = "firefox";
      //  Configuration.timeout = 10000;
       // Configuration.browserSize = "1366x768";

    }

    @Test
    public void loginGitHub() {
        // Клик по кнопке sign in
        //$(".HeaderMenu-link.HeaderMenu-link--sign-in.flex-shrink-0.no-underline.d-block.d-lg-inline-block.border.border-lg-0.rounded.rounded-lg-0.p-2.p-lg-0").click();
        // Кликнуть по полю поиска
        $(".search-input-container.search-with-dialog.position-relative.d-flex.flex-row.flex-items-center.mr-4.rounded").click();
        // Ввсести в поле поиска значение
        $("[name=query-builder-test]").setValue("selenide").pressEnter();
        // Кликнуть на первый репозиторий из списка найденных
       // $$("div.Box-sc-g0xbh4-0.kXssRI div").first().$("a").click();
        // Выбрать второй элемент
      //  $$("div.Box-sc-g0xbh4-0.kXssRI div").first().$("").click();
        // Проверяем что первый нужный нам элемент
        $("div.Box-sc-g0xbh4-0.kXssRI a").click();
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
       // sleep(3000);


    }
}
