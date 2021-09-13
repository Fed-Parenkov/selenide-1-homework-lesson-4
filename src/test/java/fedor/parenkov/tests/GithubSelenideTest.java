package fedor.parenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void SelenideRepoTest() {

        // ACTION: открыть страницу проекта Selenide на github.com
        open("https://github.com/");
        $("[data-scoped-placeholder=Search]").setValue("selenide").pressEnter();
        $(".repo-list a").click();

        // ACTION: перейти в раздел "Wiki" проекта
        $("#wiki-tab").click();

        // ACTION: раскрыть список Pages полностью
        $("#wiki-pages-box button").click();

        // CHECK: в списке Pages есть страница "SoftAssertions"
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        // ACTION: перейти на страницу "SoftAssertions"
        $("#wiki-pages-box ul").$(byText("SoftAssertions")).click();

        // CHECK: на странице есть текст "Using JUnit5"
        $(".markdown-body").shouldHave(text("Using JUnit5"));
    }
}
