package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class EscolhaSeuVooPage extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();

    public EscolhaSeuVooPage() {
        PageFactory.initElements(driver, this);
    }

    // ------ MAPEAMENTO ------

    @FindBy(xpath = "//h1[contains(text(), 'Escolha o seu voo')]")
    private WebElement titleEscolhaSeuVoo;

    @FindBy(xpath = "(//div[contains(@class,'p-select-flight__accordion')]//div[contains(@aria-controls,'flight-')])[1]")
    private WebElement cardVoo;

    @FindBy(xpath = "//button[text()='Continuar para login']")
    private WebElement buttonContinuarParaLogin;


    @FindBy(xpath = "//div[contains(@aria-controls,'flight-')]")
    private List<WebElement> listaDeVoos;

    // ------ MÉTODOS ------

    public void validarPaginaEscolhaSeuVoo() {
        aguardarModalSairDaTela();
        esperarElementoEstarVisivel(titleEscolhaSeuVoo, 10);
        espera(2);
        Assert.assertTrue(titleEscolhaSeuVoo.getText().contains("Escolha o seu voo"));
    }

    public void selecionarVooETarifa(String tarifa) {
        espera(2);

        int indice = 0;

        System.out.println("=======================================================================");

        for (int i = 0; i <= listaDeVoos.size(); i++) {
            System.out.println(i + " ==> " + listaDeVoos.get(i).getText());

            if (listaDeVoos.get(i).getText().contains("3 paradas")) {
                indice = i+1;
                System.out.println("ENCONTRADO NO INDICE " + indice);
                break;
            }
        }

        System.out.println("=======================================================================");

        WebElement cardVoo = DriverFactory.getDriver().findElement(By.xpath("(//div[contains(@aria-controls,'flight-')])["+indice+"]//div[contains(@class,'m-bar-product--border-bottom')][1]"));

        scrollToElement(cardVoo);

        espera(2);
        cardVoo.click();

        scrollToElement(cardVoo);
        espera(2);
        WebElement cardVooETarifa = DriverFactory.getDriver().findElement(By.xpath("(//h2[text()='" + tarifa + "']//following::div[@class='m-card__body'][1]//label)[" + indice + "]"));
        rolarParaBaixo();

        if (cardVooETarifa.getText().equals("Tarifa selecionada")) {
            esperarElementoEstarVisivel(buttonContinuarParaLogin, 80);
            esperarElementoEstarClicavel(buttonContinuarParaLogin, 80);
            buttonContinuarParaLogin.click();
        } else {
            espera(2);
            cardVooETarifa.click();
            buttonContinuarParaLogin.click();
        }
        //aguardarModalSairDaTela();
        //espera(5);
    }


}
