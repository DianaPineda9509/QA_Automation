package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    static By textUserName = By.id("user-name");
    static By textPassword = By.name("password");
    static By buttonLogin = By.id("login-button");

    public static void login(WebDriver driver, String userName, String password){
        driver.findElement(textUserName).sendKeys(userName);
        driver.findElement(textPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }
}
