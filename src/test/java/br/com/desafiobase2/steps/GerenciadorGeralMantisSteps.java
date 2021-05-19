package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.GerenciadorGeralMantisPage;
import net.thucydides.core.annotations.Step;

public class GerenciadorGeralMantisSteps {

//    Linkando as camadas Page e Steps
    GerenciadorGeralMantisPage gerenciadorGeralMantisPage;

//    Steps do primeiro cenário:
    @Step("Clico no botão gerenciar na tela inicial do Mantis")
    public void acessarGerenciar(){
        gerenciadorGeralMantisPage.acessarMenuGerenciar();
    }

    @Step("Valido o título da página Gerenciar após fazer o acesso")
    public String validarTituloGerenciar(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciar();
    }

//    Steps do segundo cenário:
    @Step("Clico no botão gerenciar usuário na página Gerenciar")
    public void acessarGerenciarUsuarios(){
        gerenciadorGeralMantisPage.acessarGerenciarUsuarios();
    }

    @Step("Valido o título da página Gerenciar Usuários após fazer o acesso")
    public String validarTituloGerenciarUsuarios(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarUsuarios();
    }

//    Steps do Terceiro cenário:
    @Step("Clico no botão criar nova conta na página Gerenciar usuarios")
    public void criarNovaConta(){
        gerenciadorGeralMantisPage.criarNovaConta();
    }

    @Step("Clico no botão criar usuario após clicar em criar nova conta na página Gerenciar usuarios")
    public void criarUsuario(){
        gerenciadorGeralMantisPage.criarUsuario();
    }

//    Steps do Quarto cenário:
    @Step("Preencho o campo Nome de Usuário")
    public void preencherNomeUsuario(){
        gerenciadorGeralMantisPage.preencherNomeUsuario();
    }

    @Step("Validar mensagem de sucesso após incluir um novo usuário")
    public String validarMensagemNovoUsuario(){
        return gerenciadorGeralMantisPage.validarMsgCriarNovoUsuario();
    }

//    Steps do Quinto cenário:
    @Step("Preencho o campo Nome Verdadeiro")
    public void preencherNomeVerdadeiro(){
        gerenciadorGeralMantisPage.preencherNomeVerdadeiro();
    }

//    Steps do Sexto cenário:
    @Step("Preencho o campo Email")
    public void preencherEmail(){
        gerenciadorGeralMantisPage.preencherEmail();
    }

//    Steps do Sétimo cenário:
    @Step("Preencho o campo Nome de Usuário")
    public void preencherNomeUsuario2(){
        gerenciadorGeralMantisPage.preencherNomeUsuario2();
    }

//    Steps do Oitavo cenário:
    @Step("Acesso Gerenciar Projetos")
    public void acessarGerenciarProjetos(){
        gerenciadorGeralMantisPage.acessarGerenciarProjetos();
    }

    @Step("Valido o título da página Gerenciar Projetos")
    public String validarTituloGerenciarProjetos(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarProjetos();
    }

//    Steps do Nono cenário:
    @Step("Acesso Gerenciar Marcadores")
    public void acessarGerenciarMarcadores() {
        gerenciadorGeralMantisPage.acessarGerenciarMarcadores();
    }

    @Step("Valido o título da página Gerenciar Marcadores")
    public String validarTituloGerenciarMarcadores(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarMarcadores();
    }

//    Steps do Décimo cenário:
    @Step("Acesso Gerenciar Campos Personalizados")
    public void acessarGerenciarCamposPerso() {
        gerenciadorGeralMantisPage.acessarGerenciarCamposPerso();
    }

    @Step("Valido o título da página Gerenciar Campos Personalizados")
    public String validarTituloGerenciarCamposPerso(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarCamposPerso();
    }

//    Steps do Décimo Primeiro cenário:
    @Step("Acesso Gerenciar Perfís Globais")
    public void acessarGerenciarPerfGlobais(){
            gerenciadorGeralMantisPage.acessarGerenciarPerfGlobais();
    }

    @Step("Valido o título da página Gerenciar Perfís Globais")
    public String validarTituloGerenciarPerfGlobais(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarPerfGlobais();
    }

//    Steps do Décimo Segundo cenário:
    @Step("Acesso Gerenciar Plugins")
    public void acessarGerenciarPlugins() {
        gerenciadorGeralMantisPage.acessarGerenciarPlugins();
    }

    @Step("Valido o título da página Gerenciar Plugins")
    public String validarTituloGerenciarPlugins(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarPlugins();
    }

//    Steps do Décimo Terceiro cenário:
    @Step("Acesso Gerenciar Configuração")
    public void acessarGerenciarConfig() {
        gerenciadorGeralMantisPage.acessarGerenciarConfig();
    }

    @Step("Valido o título da página Gerenciar Configurações")
    public String validarTituloGerenciarConfig(){
        return gerenciadorGeralMantisPage.verificarTituloGerenciarConfig();
    }
}
