package saucedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    static By title = By.className("app_logo");
    static By labelProducts =  By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static void userIsInPrivateHome(WebDriver driver){
        System.out.println("Cookie de sesion: " + driver.manage().getCookieNamed("session-username"));
        assertEquals("Swag Labs", driver.findElement(title).getText());
        assertEquals("Products", driver.findElement(labelProducts).getText());
    }

}
