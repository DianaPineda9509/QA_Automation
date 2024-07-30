package saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationPage {

    static By nameProducts =  By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public static void products(WebDriver driver,  List<String> productsName){

        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement product : products) {
            String name = product.getText();
            if (productsName.contains(name)) {
                System.out.println("El producto '" + name + "' coincide con el que agregaste al carrito.");
            } else {
                System.out.println("El producto '" + name + "' NO coincide con el que agregaste al carrito.");
            }
        }

    }

}
