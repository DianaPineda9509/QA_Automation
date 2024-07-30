package saucedemo;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestPage {

    WebDriver driver;

    @BeforeEach
    public void setupBrowser(){
        System.out.println(".....Ingresando a la pagina.....");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    
    @Test
    public void loginSuccesfull(){
        System.out.println(".....Realizando login.....");
        LoginPage.login(driver, "standard_user", "secret_sauce");
        System.out.println(".....Login finalizado.....");
        System.out.println(".....Verificando Home In.....");
        HomePage.userIsInPrivateHome(driver);
        System.out.println(".....Home In verificado exitosamente.....");
        System.out.println(".....Comprando productos.....");
        BuyPage.adding(driver);
        System.out.println(".....Productos comprados exitosamente.....");
    }

    @AfterEach
    public void closeBrowser(){
        System.out.println(".....Cerrando navegador.....");
            driver.quit();
    }


}
