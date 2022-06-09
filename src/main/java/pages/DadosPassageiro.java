package pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class DadosPassageiro extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();

    public DadosPassageiro() {
        PageFactory.initElements(driver, this);
    }

    //MAPEAMENTO

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
}
