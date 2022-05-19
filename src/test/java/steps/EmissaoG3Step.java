package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.HomePage;

public class EmissaoG3Step {

    HomePage homePage = new HomePage();

    @Dado("que eu esteja na home da Gol")
    public void queEuEstejaNaHomeDaGol() {
        homePage.validarHomePage();
    }

    @Dado("realize uma busca G3 Nacional {string} para {string} e {string} no dia {string}")
    public void realizeUmaBuscaG3NacionalParaENoDia(String tipoTrecho, String aeroportoIda, String aeroportoVolta, String data) throws InterruptedException {
        homePage.buscarVoo(tipoTrecho, aeroportoIda, aeroportoVolta);
    }

    @Dado("selecione um voo com a tarifa {string}")
    public void selecioneUmVooComATarifa(String tipoTarifa) {

    }

    @Dado("ir para o login {string}")
    public void irParaOLogin(String tipoLogin) {

    }

    @Dado("inserir os dados do passageiro com:")
    public void inserirOsDadosDoPassageiroCom(DataTable dataTable) {

    }

    @Quando("selecionar o assento")
    public void selecionarOAssento() {

    }

    @Quando("na personalizacao {string}")
    public void naPersonalizacao(String personalizar) {

    }

    @Entao("no resumo deve ser validado os dados e valores do voo selecionado")
    public void noResumoDeveSerValidadoOsDadosEValoresDoVooSelecionado() {

    }

}
