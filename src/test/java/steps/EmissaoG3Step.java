package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class EmissaoG3Step {

    @Dado("que eu esteja na home da Gol")
    public void queEuEstejaNaHomeDaGol() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("realize uma busca G3 Nacional {string} para {string} e {string} no dia {string}")
    public void realizeUmaBuscaG3NacionalParaENoDia(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("selecione um voo com a tarifa {string}")
    public void selecioneUmVooComATarifa(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("ir para o login {string}")
    public void irParaOLogin(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dado("inserir os dados do passageiro com:")
    public void inserirOsDadosDoPassageiroCom(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Quando("selecionar o assento")
    public void selecionarOAssento() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("na personalizacao {string}")
    public void naPersonalizacao(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entao("no resumo deve ser validado os dados e valores do voo selecionado")
    public void noResumoDeveSerValidadoOsDadosEValoresDoVooSelecionado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
