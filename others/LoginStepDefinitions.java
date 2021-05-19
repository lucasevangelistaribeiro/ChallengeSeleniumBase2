package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.steps.LoginSteps;
import br.com.desafiobase2.steps.MainSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginStepDefinitions {
    @Steps
    LoginSteps loginSteps;

    @Steps
    MainSteps mainSteps;

    @Given("informo o usuario '(.*)'")
    public void preencherUsuario(String usuario){
        Serenity.setSessionVariable("usuario").to(usuario);
        loginSteps.preenhcerUsuario(usuario);
    }

    @And("informo a senha '(.*)'")
    public void preencherSenha(String senha){
        loginSteps.preencherSenha(senha);
    }

    @When("acessar o sistema")
    public void clicarEmLogin(){
        loginSteps.clicarEmLogin();
    }

//    @Then("o usuário deve ser autenticado com sucesso")
//    public void verificarSeUsuarioEstaAutenticado(){
//        String usuario = Serenity.sessionVariableCalled("usuario");
//        Assert.assertEquals(usuario, mainSteps.retornaUsernameDasInformacoesDeLogin());
//    }
}
