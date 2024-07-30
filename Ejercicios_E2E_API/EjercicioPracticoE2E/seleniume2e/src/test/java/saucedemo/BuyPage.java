package saucedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyPage {

    static By orderFinish = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    static By shoppingcart = By.cssSelector(".shopping_cart_container");
    static By checkout = By.id("checkout");
    static By continueBotton = By.id("continue");
    static By finish = By.id("finish");

    static By firstname = By.id("first-name");
    static By lastName = By.id("last-name");
    static By postalCode = By.id("postal-code");

    public static void adding(WebDriver driver){
        
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
        List<WebElement> names = driver.findElements(By.cssSelector(".inventory_item_name"));
        List<String> productsName = new ArrayList<>();
        int elementsAdd = 2;
        System.out.println(".....Agregando "+elementsAdd+" productos al carrito.....");
        if (elements.size() >= elementsAdd) {
            
            for (int i = 0; i < elementsAdd; i++) {
                elements.get(i).click();
                productsName.add( names.get(i).getText());
            }
        } else {
            System.out.println("No se encontraron elementos para agregar al carrito.");
        }
       
        System.out.println(".....Visualizando carrito de compras.....");
        driver.findElement(shoppingcart).click();
        System.out.println(".....Verificando los productos a comprar.....");
        ValidationPage.products(driver,productsName);
        System.out.println(".....Productos verificados exitosamente.....");
        System.out.println(".....Continuando con la compra.....");
        driver.findElement(checkout).click();

        System.out.println(".....Llenando datos para la compra.....");
        driver.findElement(firstname).sendKeys("Diana");
        driver.findElement(lastName).sendKeys("Pineda");
        driver.findElement(postalCode).sendKeys("123");
        System.out.println(".....Datos ingresados exitosamente.....");

        System.out.println(".....Continuando con la compra.....");
        driver.findElement(continueBotton).click();
        System.out.println(".....Finalizando con la compra.....");
        driver.findElement(finish).click();
        assertEquals("Thank you for your order!", driver.findElement(orderFinish).getText());

    }
}
