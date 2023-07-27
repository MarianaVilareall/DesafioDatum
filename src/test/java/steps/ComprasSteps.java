package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import pages.EcomercePage;

import static runner.RunCucumberTest.driver;

public class ComprasSteps extends RuntimeException {

    EcomercePage ecomercePage = new EcomercePage(driver);

    @Dado("que estou no site e-commerce")
    public void que_estou_no_site_e_commerce() {
    ecomercePage.acessarAplicacao();
    }
    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informo_o_usuário(String usuario) throws Throwable {
        ecomercePage.preencherUsuario(usuario);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void a_senha(String senha) throws Throwable {
        ecomercePage.preencherSenha(senha);
    }

    @Quando("^seleciono entrar$")
    public void seleciono_entrar() throws Throwable {
        ecomercePage.clicarEntrar();
    }
    @Quando("eu seleciono o primeiro item")
    public void seleciono_o_primeiro_item() throws InterruptedException {
        ecomercePage.selecionarProdutoStylish();
        ecomercePage.adicionarItemCarrinho();
    }

    @Quando("^seleciono o segundo item$")
    public void seleciono_o_segundo_item() throws Throwable {
        ecomercePage.selecionarProdutoBeautiful();
        ecomercePage.adicionarItemCarrinho();
    }

    @Quando("^seleciono o terceiro item$")
    public void seleciono_o_terceiro_item() throws Throwable {
    ecomercePage.selecionarProdutoTshirt();
    ecomercePage.adicionarItemCarrinho();
    }

    @Entao("vejo que os itens foram adicionados com sucesso ao carrinho")
    public void eu_finalizo_a_compra_com_sucesso() {
    ecomercePage.verificarItemStylish();
    ecomercePage.verificarBeautiful();
    ecomercePage.verificarTshirt();
    }
}
