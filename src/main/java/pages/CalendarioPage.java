package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CalendarioPage extends BasePage {

    private WebDriver driver = DriverFactory.getDriver();
    private Utils utils = new Utils();

    public CalendarioPage() {
        PageFactory.initElements(driver, this);
    }

    public void selecionarDataDeIda(String data) {

        String dataFormatada = utils.converteDataEmMesEAno(data);

        WebElement mesCalendario1 = driver.findElement(By.xpath("(//p[@class='o-calendar__title']//span)[1]")),
//                mesCalendario2 = driver.findElement(By.xpath("(//p[@class='o-calendar__title']//span)[2]")),
                btnProximo = driver.findElement(By.xpath("(//button[@class='o-calendar__btn o-calendar__btn--next a-icon'])[1]"));

//        utils.sleep(1);
        esperarElementoEstarVisivel(btnProximo, 10);
        utils.sleep(2);
        utils.scrollDown();

        // Verificar se o mês está visivel - Se não estiver visivel avança pro próximo mês
//        while (!mesCalendario1.getText().contains(dataFormatada) && !mesCalendario2.getText().contains(dataFormatada)) {
//            if (!mesCalendario1.getText().contains(dataFormatada) && !mesCalendario2.getText().contains(dataFormatada)) {
//                btnProximo.click();
//                utils.sleep(2);
//            } else {
//                return;
//            }
//        }
        while (!mesCalendario1.getText().contains(dataFormatada)) {
            if (!mesCalendario1.getText().contains(dataFormatada)) {
                btnProximo.click();
                utils.sleep(2);
            } else {
                return;
            }
        }


        WebElement dia = driver.findElement(By.xpath("//li[@id='departureDate" + data.replaceAll("/", "") + "']"));
        //utils.sleep(6);
        //aguardarModalSairDaTela();
        // Seleciona a data do mês
        esperarElementoEstarClicavel(dia, 10);
        utils.sleep(4);
        dia.click();
    }


}
