import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestStartQa {
    @BeforeSuite
    public void before() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://netology.ru/";
        Configuration.browser = "edge";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true ;

    }

    @Test
    public void loginTest() {
        String email = "Levushka22@yandex.ru";
        String password = "123+321@";
        open("/");
        $(".styles_loginLink__ycSG8.styles_login__w96aN").shouldHave(text("Войти")).click();
        $(".styles_root__l6N51").shouldHave(text("Email"));
        $("[name=email]").setValue(email);
        $("[name=password]").setValue(password);
        $(".Button_button__4WipJ.Button_size-m__gjfV9.Button_color-lilac__CoiuP.styles_button__A3FGY").shouldHave(text("Войти")).click();
        $(".src-components-pages-Profile--root--GZ5Xm").shouldHave(text("Моё обучение"));

    }

    @Test
    public void testName() {

    }

    @AfterMethod
    public void after() {
 closeWindow();
    }
}
