package com.taller;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Abrir el navegador y redireccionar a la página Demo Blaze
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegar entre cada una de las categorías - Iphone
        WebElement menuIphone = driver.findElement(By.linkText("Phones"));
        menuIphone.click();

        //Localizar cada uno de las Cards de los productos - HTC One M9
        buscarPrecio(driver,"Phones","HTC One M9");

        //Localizar cada uno de las Cards de los productos - MacBook air
        WebElement siguiente = driver.findElement(By.id("next2"));
        siguiente.click();
        buscarPrecio(driver,"Phones","MacBook air");

        //Navegar entre cada una de las categorías - Laptops
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement menuLapton = driver.findElement(By.linkText("Laptops"));
        menuLapton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Localizar cada uno de las Cards de los productos - MacBook Pro
        buscarPrecio(driver,"Laptops","MacBook Pro");

        //Localizar cada uno de las Cards de los productos - Dell i7 8gb
        buscarPrecio(driver,"Laptops","Dell i7 8gb");

        //Navegar entre cada una de las categorías - Monitors 
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement menuMonitors = driver.findElement(By.linkText("Monitors"));
        menuMonitors.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Localizar cada uno de las Cards de los productos - ASUS Full HD
        buscarPrecio(driver,"Monitors","ASUS Full HD");

        //Cerrar el navegador
        driver.close();
        driver.quit();
    }

    public static  WebElement buscarPrecio(WebDriver driver, String tipodispositivo, String nombredispositivo) {
        
        //Realizar un punto de control por cada uno de los productos involucrados
        
        WebElement dispositivo = driver.findElement(By.linkText(nombredispositivo));
        dispositivo.click();
        WebElement dispositivopre = driver.findElement(By.className("price-container"));
        WebElement nombredis = driver.findElement(By.className("name"));
        System.out.println(tipodispositivo +" : "+ nombredis.getText() + " " + dispositivopre.getText());
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return dispositivo;
        
    }
}

