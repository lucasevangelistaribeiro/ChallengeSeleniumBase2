package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.enums.DadosUsuarioMantis;
import br.com.desafiobase2.steps.MinhaContaMantisSteps;
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

public class MinhaContaMantisStepDefinitions {

//    Buscando as informações do Json do usuário Mantis
    UsuarioMantis usuarioMantis;

//    Linkando Step e Stepdefinitions
    @Steps
    MinhaContaMantisSteps minhaContaMantisSteps;

//    Trazendo dados de um arquivo Json a fim de ler as variaveis de usuario e senha fora do BDD
//    Direto do arquivo Json, passando pela classe Hook, e classe Enum.
    public MinhaContaMantisStepDefinitions() throws IOException {
        usuarioMantis = Serenity.sessionVariableCalled(DadosUsuarioMantis.USUARIO_MANTIS);
    }

//    StepDefinitions cenário "Verificar se está na página Minha Conta" e
//    "Alterar senha do usuário com sucesso"
    @Given("^o usuário está na página inicial Mantis$")
    public void acessarPaginaInicialMantis(){
        minhaContaMantisSteps.acessarMantis(usuarioMantis.getUsuario(), usuarioMantis.getSenha());
    }

    @When ("^acesso a página \"Minha conta\"$")
    public void acessarMinhaConta(){
        minhaContaMantisSteps.acessarMinhaConta();
    }

    @Then("^Verifico se estou na pagina minha conta$")
    public void validarPaginaMinhaConta(){
        Assert.assertThat(minhaContaMantisSteps.validarAcessoPagMinhaConta(),
                CoreMatchers.containsString("Minha Conta"));
    }

//    StepDefinitions do cenário "Alterar a senha do usuário com sucesso"
    @And("^preencho as informações para alterar a senha$")
    public void preencherDadosContaUsuario(){
        minhaContaMantisSteps.preencherSenhaAtual();
        minhaContaMantisSteps.preencherNovaSenha();
        minhaContaMantisSteps.confirmarSenhaNova();
    }

    @And("^atualizo o usuário$")
    public void atualizarUsuario(){
        minhaContaMantisSteps.atualizarUsuario();
    }

    @Then("^o sistema exibe a mensagem de sucesso na tela \"Operação realizada com sucesso.\"$")
    public void validarMensagemSucesso(){
        Assert.assertThat(minhaContaMantisSteps.validarMsgSenhaNova(),
                CoreMatchers.containsString("Operação realizada com sucesso."));
    }

//    StepDefinitions do cenário "Alterar senha do usuário preenchendo somente o campo senha atual"
    @And("^preencho a senha atual$")
    public void enviarSenhaAtual(){
        minhaContaMantisSteps.preencherSenhaAtual();
    }

//    StepDefinitions do cenário "Alterar senha do usuário preenchendo
//    somente os campos senha atual e nova senha"
    @And("^preencho a nova senha$")
    public void preencherSenhaNova(){
        minhaContaMantisSteps.preencherNovaSenha();
    }

    @Then("^o sistema exibe a mensagem de erro na tela \"A senha não combina com a verificação.\"$")
    public void validarMensagemSenhaErro(){
        Assert.assertThat(minhaContaMantisSteps.validarMsgConfirmarSenha(),
                CoreMatchers.containsString("A senha não combina com a verificação."));
    }

//    StepDefinitions do cenário "Alterar o nome verdadeiro"
    @And("^informo um nome$")
    public void informarNomeVerdadeiro(){
        minhaContaMantisSteps.preencherNomeVerdadeiro();
    }

    @Then("^o sistema exibe a mensagem de sucesso na tela \"Nome verdadeiro atualizado com sucesso\"$")
    public void validaMensagemAlterarNome(){
        Assert.assertThat(minhaContaMantisSteps.validarMensagemNomeVerdadeiro(),
                CoreMatchers.containsString("Nome verdadeiro atualizado com sucesso"));
    }

//    StepDefinitions do cenário "Verificar se está na sub página Perfís"
    @And("^acesso a opção \"Perfís\"$")
    public void acessarPerfis(){
        minhaContaMantisSteps.acessarPerfis();
    }

    @Then("^valido se estou na sub página \"Perfís\"$")
    public void validarSubPaginaPerfis(){
        Assert.assertThat(minhaContaMantisSteps.validarPaginaPerfis(),
                CoreMatchers.containsString("Adicionar Perfil"));
    }

//    StepDefinitions do cenário "Adicionar perfís com sucesso"
    @And("^preencho as informações de perfil (.*) (.*) (.*)$")
    public void preencherInfoPerfis(String plataforma, String so, String soVersion){
        minhaContaMantisSteps.preencherPerfil(plataforma, so, soVersion);
    }

    @And("^adiciono o perfil$")
    public void adicionarPerfil(){
        minhaContaMantisSteps.adicionarPerfil();
    }

    @Then("^o sistema apresenta uma tabela com o título \"Alterar ou Apagar Perfís\"$")
    public void validarTabelaEdicaoPerfis(){
        Assert.assertTrue(minhaContaMantisSteps.validarTabelaEdicaoPerfis());
    }

//    StepDefinition do cenário "Editar perfil com descrição adicional"
    @And("^seleciono o perfil para editar$")
    public void selecionarPerfilEditar(){
        minhaContaMantisSteps.selecionarPerfilEditar();
    }

    @And("^incluo descrição$")
    public void preencherDescricao(){
        minhaContaMantisSteps.preencherDescricao();
    }

    @And("^atualizo o perfil$")
    public void atualizarPerfilEditado(){
        minhaContaMantisSteps.atualizarPerfil();
    }

//    StepDefinitions do cenário "Editar perfil sem selecionar campos obrigatórios"
    @And("envio dados do perfil$")
    public void editarPerfil(){
        minhaContaMantisSteps.clicarEnviar();
    }

    @Then("^o sistema apresenta uma mensagem de alerta na tela \"APPLICATION ERROR\"$")
    public void validarMsgErroPerfil(){
        Assert.assertThat(minhaContaMantisSteps.validarMsgErroPerfil(),
                CoreMatchers.containsString("APPLICATION ERROR"));
    }

//    StepDefinitions do cenário "Editar perfil sem selecionar o perfil"
    @And("^seleciono \"Editar Perfil\"$")
    public void selecionarEditarPerfil(){
        minhaContaMantisSteps.editarPerfil();
    }

    @Then("^o sistema apresenta uma mensagem de alerta na tela \"APPLICATION ERROR #11\"$")
    public void validarMsgEditarPerfilErro(){
        Assert.assertThat(minhaContaMantisSteps.validarMsgErroEditarPerfil(),
                CoreMatchers.containsString("APPLICATION ERROR #11"));
    }

//    StepDefinitions do cenário "Marcar um perfil como padrão"
    @And("^seleciono \"Tornar Padrão\"$")
    public void selecionarTornarPadrao(){
        minhaContaMantisSteps.selecionarTornarPadrao();
    }

    @And("^seleciono o perfil$")
    public void selecionarPerfil(){
        minhaContaMantisSteps.selecionarPerfilPadrao();
    }


//    StepDefinitions do cenário "Apagar um perfil"
    @And("^seleciono \"Apagar Perfil\"$")
    public void selecionarApagarPerfil(){
        minhaContaMantisSteps.selecionarApagarPerfil();
    }

//    StepDefinitions do cenário "Verificar se foi direcionado para a sub pagina Preferências"
    @And("^acesso a opção \"Preferências\"$")
    public void acessarPreferencias(){
        minhaContaMantisSteps.acessarPreferencias();
    }

    @Then("^valido se estou na sub página \"Preferências\"$")
    public void validarTituloPreferencias(){
        Assert.assertThat(minhaContaMantisSteps.validarSubPaginaPreferencias(),
                CoreMatchers.containsString("Preferências da Conta"));
    }

//    StepDefinitions do cenário "Atualizar informações na sub página Preferências"
    @And("^atualizo preferências$")
    public void atualizarPreferencias(){
        minhaContaMantisSteps.atualizarPreferencias();
    }

//    StepDefinitions do cenário "Redefinir informações na sub página Preferências"
    @And("^redefino preferências$")
    public void redefinirPreferencias(){
        minhaContaMantisSteps.redefinirPreferencias();
    }

//    StepDefinitions do cenário "Verificar se foi direcionado para a sub pagina Gerenciar Colunas"
    @And("^acesso a opção \"Gerenciar Colunas\"$")
    public void acessarGerenciarColunas(){
        minhaContaMantisSteps.acessarGerenciarColunas();
    }

    @Then("^valido se estou na sub página \"Gerenciar Colunas\"$")
    public void validarTituloGerenciarColunas(){
        Assert.assertThat(minhaContaMantisSteps.validarSubPaginaGerenciarColunas(),
                CoreMatchers.containsString("Gerenciar Colunas"));
    }

//    StepDefinitions do cenário "Atualizar informações da sub página Gerenciar Colunas"
    @And("^atualizo colunas$")
    public void atualizarColunas(){
        minhaContaMantisSteps.atualizarColunas();
    }

//    StepDefinitions do cenário "Selecionar a opção 'copiar colunas de' da sub página Gerenciar Colunas"
    @And("^seleciono \"Copiar Colunas De\"$")
    public void copiarColunasDe(){
        minhaContaMantisSteps.copiarColunasDe();
    }

//    StepDefinitions do cenário "Selecionar a opção 'copiar colunas para' da sub página Gerenciar Colunas"
    @And("^seleciono \"Copiar Colunas Para\"$")
    public void copiarColunasPara(){
        minhaContaMantisSteps.copiarColunasPara();
    }

//    StepDefinitions do cenário "Reinicializar informações da sub página Gerenciar Colunas"
    @And("^reinicializo colunas$")
    public void reinicializarConfigColunas(){
        minhaContaMantisSteps.reinicializarConfigColunas();
    }

//    StepDefinitions do cenário "Verificar se foi direcionado para a sub pagina Tokens API"
    @And("^acesso a opção \"Tokens API\"$")
    public void acessarTokensAPI(){
        minhaContaMantisSteps.acessarTokensAPI();
    }

    @Then("^valido se estou na sub página \"Tokens API\"$")
    public void validarTituloTokensAPI(){
        Assert.assertThat(minhaContaMantisSteps.validarTituloTokensAPI(),
                CoreMatchers.containsString("Criar token API"));
    }
}
