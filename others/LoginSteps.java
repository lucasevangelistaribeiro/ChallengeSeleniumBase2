package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;

    @Step("Abrir Mantis")
    public void abrirMantis(){
        loginPage.open();
    }

    @Step("Preencher usuário com '{0}'")
    public void preenhcerUsuario(String usuario){
        loginPage.preenhcerUsuario(usuario);
    }

    @Step("Preencher senha com '[0}'")
    public void preencherSenha(String senha){
        loginPage.preencherSenha(senha);
    }

    @Step("Clicar em 'Login'")
    public void clicarEmLogin(){
        loginPage.clicarEmLogin();
    }

    @Step("Retorna mensagem de erro")
    public String retornaMensagemDeErro(){
        return loginPage.retornaMensagemDeErro();
    }
}
