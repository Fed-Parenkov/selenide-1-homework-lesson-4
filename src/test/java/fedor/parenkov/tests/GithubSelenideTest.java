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
        $$(".repo-list li").first().$("a").click();

        // CHECK: открыта страница проекта Selenide
        $(".author").shouldHave(text("selenide"));

        // ACTION: перейти в раздел "Wiki" проекта
        $("#wiki-tab").click();

        // CHECK: открыта страница "Wiki" проекта Selenide
        $("#wiki-body").$("h1").shouldHave(text("Welcome to the selenide wiki!"));

        // CHECK: в списке страниц есть ссылка на страницу "Soft Assertions"
        $(".markdown-body ul").shouldHave(text("Soft Assertions"));

        // ACTION: перейти на страницу "Soft Assertions"
        $(".markdown-body ul").$(byText("Soft assertions")).click();

        // CHECK: открыта страница "Soft Assertions"
        $("#wiki-wrapper").shouldHave(text("SoftAssertions"));

        // CHECK: на странице есть текст "Using JUnit5"
        $(".markdown-body").shouldHave(text("Using JUnit5"));
    }
}
