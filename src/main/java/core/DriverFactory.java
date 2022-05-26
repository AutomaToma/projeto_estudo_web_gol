package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    //varialvel do tipo WebDriver
    private static WebDriver driver = null;

    //variaval String que vai receber o caminho do arquivo chromedriver
    private static String chromePath = "src/test/resources/webdrivers/chromedriver.exe";

    //criar um método que sempre cria o webdriver
    public static WebDriver getDriver() {

        //criar instancia do webdriver -> Chrome
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();

            //configurar para abrir o navegador em tela cheia
            driver.manage().window().maximize();

            //configurar a espera implicita
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //ir para o site
            driver.get("https://hom-b2c.voegol.com.br/compra");
        }

        return driver;
    }

    //criar um método que encerra a execução do webdriver
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
