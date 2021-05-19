package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.enums.DadosUsuarioMantis;
import br.com.desafiobase2.steps.LoginMantisSteps;
import br.com.desafiobase2.types.UsuarioMantis;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.io.IOException;

public class LoginMantisStepDefinitions {

//    Buscando as informações do Json do usuário Mantis
    UsuarioMantis usuarioMantis;

//    Linkando Step e Stepdefinitions
    @Steps
    LoginMantisSteps loginMantisSteps;

//    Trazendo dados de um arquivo Json a fim de ler as variaveis de usuario e senha fora do BDD
//    Direto do arquivo Json, passando pela classe Hook, e classe Enum.
    public LoginMantisStepDefinitions() throws IOException {
        usuarioMantis = Serenity.sessionVariableCalled(DadosUsuarioMantis.USUARIO_MANTIS);
    }

//    StepDefinitions cenário "Login com credenciais válidas"
    @Given("^o usuário está na página de login do Mantis$")
    public void acessarMantis(){
        loginMantisSteps.acessarMantis();
    }

    @When("^informo as credenciais válidas$")
    public void informarCredenciais(){
        loginMantisSteps.preencherUsuario(usuarioMantis.getUsuario());
        loginMantisSteps.clicarEntrarU();
        loginMantisSteps.preencherSenha(usuarioMantis.getSenha());
    }

    @And("^solicito acesso Mantis$")
    public void entrarMantis(){
        loginMantisSteps.clicarEntrarS();
    }

    @Then("^sistema Mantis realiza autenticação com sucesso$")
    public void autenticarUsuario(){
        Assert.assertTrue(loginMantisSteps.validarUsuarioLogado(usuarioMantis.getUsuario()));
    }

    @And("^sistema Mantis abre página inicial$")
    public void validarTituloTelaInicial(){
        Assert.assertThat(loginMantisSteps.validarTituloTela(),
                CoreMatchers.containsString("MantisBT"));
    }

//    StepDefinitions cenário "Valida a home page do mantis"
    @Then("^verifico se estou na home page do mantis$")
    public void validarHomePageMantis(){
        Assert.assertTrue(loginMantisSteps.validarHomePage());
    }

//    StepDefinitions cenário "Login com credenciais válidas - mantenha-me conectado"
    @And("^informo que quero me manter conectado$")
    public void marcarManterConectado(){
        loginMantisSteps.marcarCheckbox();
    }

//    StepDefinitions do cenário "Tentativa de login sem informar usuário"
    @When("^envio campo usuário vazio$")
    public void campoUsuarioVazio(){
        loginMantisSteps.usuarioVazio();
    }

    @Then("^o sistema exibi mensagem de alerta \"Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.\"$")
    public void validarMensagemErroAcesso(){
        Assert.assertThat(loginMantisSteps.validarMensagemErroAcesso(),
                CoreMatchers.containsString("Sua conta pode estar desativada ou bloqueada"));
    }

//    StepDefinitions do cenário "Tentativa de login sem informar senha"
    @When("^envio credencial de usuário$")
    public void enviarUsuario(){
        loginMantisSteps.enviarUsuario(usuarioMantis.getUsuario());
        loginMantisSteps.clicarEntrarU();
    }

    @And("^clico entrar sem preencher senha$")
    public void campoSenhaVazia(){
        loginMantisSteps.senhaVazia();
    }

//    StepDefinitions do cenário "Logout Mantis"
    @And("^acesso as opções do usuário$")
    public void clicarAdministrador(){
        loginMantisSteps.clicarAdministrador();
    }

    @And("^saio do Mantis$")
    public void clicarSair(){
        loginMantisSteps.clicarSair();
    }

}
