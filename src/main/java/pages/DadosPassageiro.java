package pages;

import core.DriverFactory;
import io.cucumber.datatable.DataTable;
import javafx.scene.input.KeyCode;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

public class DadosPassageiro extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();

    public DadosPassageiro() {
        PageFactory.initElements(driver, this);
    }

    //MAPEAMENTO

    @FindBy(xpath = "//legend[contains(text(),'Preencha os dados')]")
    private WebElement tituloPreenchaDadosPassageiro;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement primeiroNome;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement ultimoNome;

    @FindBy(xpath = "//input[@id='birthDate']")
    private WebElement dataNascimento;

    @FindBy(xpath = "//fieldset[@aria-controls='select-gender']")
    private WebElement genero;

    @FindBy(xpath = "//fieldset[@aria-controls='select-nacionalidade']")
    private WebElement nacionalidade;

    @FindBy(xpath = "//fieldset[@aria-controls='select-typeDocument']")
    private WebElement tipoDocumento;

    @FindBy(xpath = "//input[@id='numberDocument']")
    private WebElement numeroDocumento;

    @FindBy(xpath = "//input[@id='document']")
    private WebElement cpf;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='cellPhone']")
    private WebElement DDDcelular;

    @FindBy(xpath = "//label[contains(text(),' Li e estou de acordo com a  ')]")
    private WebElement liEEstouDeAcordo;

    @FindBy(xpath = "//label[contains(text(), 'Não quero informar')]")
    private WebElement naoInformarContatpoEmergencia;

    @FindBy(xpath = "//button[contains(text(), ' Ir para seleção de assento ')]")
    private WebElement btnSelecaoDeAssento;

    //METODOS

    public void validarPaginaDadosPassageiro() {
        Assert.assertEquals("Preencha os dados do passageiro", tituloPreenchaDadosPassageiro.getText().replace("\n", " "));
    }

    public void preencherDadosDoPassageiro(DataTable dados) {
        List<List<String>> listaDados = dados.asLists();

        // cada get() pega um índice do dataTable que vem da Feature [linha | coluna]
        primeiroNome.sendKeys(listaDados.get(1).get(0));
        ultimoNome.sendKeys(listaDados.get(1).get(1));
        dataNascimento.sendKeys(listaDados.get(1).get(2));

        WebElement opcaoGenero = driver.findElement(By.xpath("//button[contains(text(), '" + listaDados.get(1).get(3) + "')]")),
                opcaoDocumento = driver.findElement(By.xpath("//button[contains(text(), '" + listaDados.get(1).get(4) + "')]"));
        //opcaoPais = driver.findElement(By.xpath("//button[contains(text(), '"+listaDados.get(1).get(4)+"')]"))

        espera(4);

        genero.click();
        opcaoGenero.click();

        rolarParaBaixo();
        esperarElementoEstarVisivel(tipoDocumento, 10);

        tipoDocumento.click();
        opcaoDocumento.click();

        numeroDocumento.sendKeys(listaDados.get(1).get(5));
        cpf.sendKeys(listaDados.get(1).get(6));
        email.sendKeys(listaDados.get(1).get(7));
        DDDcelular.sendKeys(listaDados.get(1).get(8));

        rolarParaBaixo();
        espera(2);
        //liEEstouDeAcordo.click();

        rolarAteOElemento(naoInformarContatpoEmergencia);
        rolarParaBaixo();
        espera(2);
        naoInformarContatpoEmergencia.click();

        esperarElementoEstarClicavel(btnSelecaoDeAssento, 200);
        btnSelecaoDeAssento.click();
    }


}
