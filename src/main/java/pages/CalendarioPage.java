package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CalendarioPage extends BasePage{

    private WebDriver driver = DriverFactory.getDriver();
    private Utils utils = new Utils();

    public CalendarioPage() {
        PageFactory.initElements(driver, this);
    }

    public void selecionarDataDeIda(String data) {

        String dataFormatada = utils.converteDataEmMesEAno(data);

        WebElement mesCalendarioIda = driver.findElement(By.xpath("(//p[@class='o-calendar__title']//span)[1]")),
                    btnProximo = driver.findElement(By.xpath("(//button[@class='o-calendar__btn o-calendar__btn--next a-icon'])[1]"))
        ;

//        utils.sleep(1);
//        utils.waitUntilIsVisible(btnProximo, 1);
        esperarElementoEstarVisivel(driver,btnProximo,10);
        utils.scrollDown();

        // Verificar se o mês está visivel - Se não estiver visivel avança pro próximo mês
        while(!mesCalendarioIda.getText().contains(dataFormatada)){
            if(!mesCalendarioIda.getText().contains(dataFormatada)){
                btnProximo.click();
                utils.sleep(2);
            }else{
                return;
            }
        }

        WebElement dia = driver.findElement(By.xpath("//li[@id='departureDate"+data.replaceAll("/", "")+"']"));
        // Seleciona a data do mês
        dia.click();
    }


}
