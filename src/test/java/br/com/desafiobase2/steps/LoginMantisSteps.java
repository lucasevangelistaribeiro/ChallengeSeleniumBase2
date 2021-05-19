package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.LoginMantisPage;
import net.thucydides.core.annotations.Step;

public class LoginMantisSteps {

//    Linkando as camadas Page e Steps
    LoginMantisPage loginMantisPage;

//    Steps do cenário "Login com credenciais válidas"
    @Step("Acessando o site do MantisBT")
    public void acessarMantis(){
        loginMantisPage.acessarMantisBT();
    }

    @Step("Preenchendo usuario")
    public void preencherUsuario(String usuario){
        loginMantisPage.preencherUsuario(usuario);
    }

    @Step("Clicar no botão entrar após colocar o usuário")
    public void clicarEntrarU(){
        loginMantisPage.clicarEntrarUser();
    }

    @Step("Preenchendo senha")
    public void preencherSenha(String senha){
        loginMantisPage.preencherSenha(senha);
    }

    @Step("Clicando no botão entrar após colocar a senha")
    public void clicarEntrarS(){
        loginMantisPage.clicarEntrarSenha();
    }

    @Step("Validando título da página inicial após login")
    public String validarTituloTela(){
        return loginMantisPage.validarTituloPagina();
    }

    @Step("Validar usuário logado no sistema")
    public boolean validarUsuarioLogado(String usuarioLogado){
        return loginMantisPage.validarUsuarioLogado(usuarioLogado);
    }

//    Steps do cenário "valida a home page do mantis"
    @Step("Validar home page Mantis")
    public boolean validarHomePage(){
        return loginMantisPage.verificarMantisLogo();
    }

//    Steps do cenário "Login com credenciais válidas - mantenha-me conectado"
    @Step("Marcar checkbox mantenha-me conectado")
    public void marcarCheckbox(){
        loginMantisPage.marcarManterConectado();
    }

//    Steps do cenário "Tentativa de login sem informar usuário"
    @Step("Enviar campo usuário vazio")
    public void usuarioVazio(){
        loginMantisPage.clicarEntrarUser();
    }

    @Step("Validar texto de retorno após não enviar o usuário ou a senha no login")
    public String validarMensagemErroAcesso(){
        return loginMantisPage.validarMensagemErroAcesso();
    }

//    Steps do cenário "Tentativa de login sem informar senha"
    @Step("Preencher usuário e entrar")
    public void enviarUsuario(String usuario){
        loginMantisPage.preencherUsuario(usuario);
        loginMantisPage.clicarEntrarUser();
    }

    @Step("Enviar campo senha vazio")
    public void senhaVazia(){
        loginMantisPage.clicarEntrarSenha();
    }

//    Steps do cenário "Logout Mantis"
    @Step("Clico no botão Administrador")
    public void clicarAdministrador(){
        loginMantisPage.acessarAdministrador();
    }

    @Step("Clicar em sair")
    public void clicarSair(){
        loginMantisPage.sairDoMantis();
    }
}
