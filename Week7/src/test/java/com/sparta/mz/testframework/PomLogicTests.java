package com.sparta.mz.testframework;

import com.sparta.mz.testframework.lib.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

public class PomLogicTests {
    @Test
    @DisplayName("LoginPage hasMessage test")

    public void loginPage_hasMessage_Test() {

        WebDriver mockDriver = Mockito.mock(WebDriver.class);

        WebElement mockMessageElement = Mockito.mock(WebElement.class);

        Mockito.when(mockMessageElement.getText())

                .thenReturn("This is a message");


        Mockito.when(mockDriver.findElement(any(By.class)))

                .thenReturn(mockMessageElement);


        LoginPage sut = new LoginPage(mockDriver);

        Assertions.assertTrue(sut.hasMessage("This is a message"));

    }
}


class App {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Manish");
        al.add("David");
        al.add("Cathy");
        al.add("Neil");

        for (String n : al) {
            n = n.replaceAll("[^a-zA-Z]", "").toLowerCase();
            Map<Character, Integer> lf = new HashMap<>();

            for (char c : n.toCharArray()) {
                lf.put(c, lf.getOrDefault(c, 0) + 1);
            }

            char l = ' ';
            int max = 0;

            for (Map.Entry<Character, Integer> entry : lf.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    l = entry.getKey();
                }
            }

            if (l != ' ') {
                System.out.println(l);
            } else {
                System.out.println(" ");
            }
        }
    }
}