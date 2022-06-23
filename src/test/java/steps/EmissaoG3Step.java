package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.*;

public class EmissaoG3Step {

    HomePage homePage = new HomePage();
    EscolhaSeuVooPage escolhaSeuVooPage = new EscolhaSeuVooPage();
    SeusDadosPage seusDadosPage = new SeusDadosPage();
    DadosPassageiro dadosPassageiroPage = new DadosPassageiro();
    AssentosPage assentosPage = new AssentosPage();

    @Dado("que eu esteja na home da Gol")
    public void queEuEstejaNaHomeDaGol() {
        homePage.validarHomePage();
    }

    @Dado("realize uma busca G3 Nacional {string} para {string} e {string} no dia {string} e {string}")
    public void realizeUmaBuscaG3NacionalParaENoDiaE(String tipoTrecho, String aeroportoIda, String aeroportoVolta, String dataIda, String dataVolta) {
        homePage.buscarVoo(tipoTrecho, aeroportoIda, aeroportoVolta, dataIda, "");
    }

    @Dado("selecione um voo com a tarifa {string}")
    public void selecioneUmVooComATarifa(String tipoTarifa) {
        escolhaSeuVooPage.validarPaginaEscolhaSeuVoo();
        escolhaSeuVooPage.selecionarVooETarifa(tipoTarifa);
    }

    @Dado("ir para o login {string}")
    public void irParaOLogin(String tipoLogin) {
        seusDadosPage.validarSeusDadosPage();
        seusDadosPage.selecionarSemLogin();
        seusDadosPage.clicarIrParaDadosDoPassageiro();
    }

    @Dado("inserir os dados do passageiro com:")
    public void inserirOsDadosDoPassageiroCom(DataTable dataTable) {
        dadosPassageiroPage.validarPaginaDadosPassageiro();
        dadosPassageiroPage.preencherDadosDoPassageiro(dataTable);
    }

    @Quando("selecionar o assento")
    public void selecionarOAssento() {
        assentosPage.validarPagina();
        assentosPage.escolherAssentos();

    }

    @Quando("na personalizacao {string}")
    public void naPersonalizacao(String personalizar) {

    }

    @Entao("no resumo deve ser validado os dados e valores do voo selecionado")
    public void noResumoDeveSerValidadoOsDadosEValoresDoVooSelecionado() {

    }

}
