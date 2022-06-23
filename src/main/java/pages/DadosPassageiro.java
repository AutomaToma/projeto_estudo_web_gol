package pages;

import core.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

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

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='cellPhone']")
    private WebElement DDDcelular;

    @FindBy(xpath = "//label[contains(text(), 'Li e estou de ')]")
    private WebElement liEEstouDeAcordo;

    @FindBy(xpath = "//label[contains(text(), 'Não quero informar')]")
    private WebElement naoInformarContatpoEmergencia;

    @FindBy(xpath = "//button[contains(text(), ' Ir para seleção de assento ')]")
    private WebElement btnSelecaoDeAssento;

    //METODOS

    //button[contains(text(), 'Fem')]
    //button[contains(text(), 'Afega')]
    //button[contains(text(), 'Passa')]

    public void  validarPaginaDadosPassageiro(){
        Assert.assertEquals("Preencha os dados do passageiro", tituloPreenchaDadosPassageiro.getText().replace("\n", " "));
    }

    public void preencherDadosDoPassageiro(DataTable dados){
        List<List<String>> listaDados = dados.asLists();

        // cada get() pega um índice do dataTable que vem da Feature [linha | coluna]
        primeiroNome.sendKeys(listaDados.get(1).get(0));
        ultimoNome.sendKeys(listaDados.get(1).get(1));
        dataNascimento.sendKeys(listaDados.get(1).get(2));

        WebElement opcaoGenero = driver.findElement(By.xpath("//button[contains(text(), '"+listaDados.get(1).get(3)+"')]")),
                    opcaoDocumento = driver.findElement(By.xpath("//button[contains(text(), '"+listaDados.get(1).get(4)+"')]"));
        //opcaoPais = driver.findElement(By.xpath("//button[contains(text(), '"+listaDados.get(1).get(4)+"')]"))

        genero.click();
        opcaoGenero.click();

        utils.scrollDown();

        tipoDocumento.click();
        opcaoDocumento.click();


    }




}
