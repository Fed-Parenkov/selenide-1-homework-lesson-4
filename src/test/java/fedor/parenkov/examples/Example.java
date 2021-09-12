package fedor.parenkov.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Example {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void FirstQuestion() {

        // Пример #1
        open("https://reqres.in/");

        // найдет элемент h1
       String qqq = $("div h1").getText();
       System.out.println(qqq);

       // не найдет элемент h1, т.к. он не прямой потомок первого div в DOM
       String eee = $("div").$("h1").getText();
       System.out.println(eee);

        // Пример #2
        open("https://github.com/selenide/selenide");

        // найдет элемент h1 (первый попавшийся, хотя их там два)
        String yyy = $("div h1").getText();
        System.out.println(yyy);

        // не найдет элемент h1, т.к. такого элемента нет в первом div в DOM
        String uuu = $("div").$("h1").getText();
        System.out.println(uuu);
    }
}
