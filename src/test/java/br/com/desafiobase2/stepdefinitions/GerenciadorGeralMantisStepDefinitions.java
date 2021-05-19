package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.steps.GerenciadorGeralMantisSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.nio.charset.CoderResult;

public class GerenciadorGeralMantisStepDefinitions {

//    Linkando Step e Stepdefinitions
    @Steps
    GerenciadorGeralMantisSteps gerenciadorGeralMantisSteps;

//    StepDefinitions do primeiro cenário:
    @When("^acesso a página \"Gerenciar\"$")
    public void acessarMenuGerenciar(){
        gerenciadorGeralMantisSteps.acessarGerenciar();
    }

    @Then("^valido se estou na página \"Gerenciar\"$")
    public void validarTituloGerenciar(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciar(),
                CoreMatchers.containsString("Informação do Site"));
    }

//    StepDefinitions do segundo cenário:
    @And("^acesso \"Gerenciar Usuários\"$")
    public void acessarGerenciarUsuarios(){
        gerenciadorGeralMantisSteps.acessarGerenciarUsuarios();
}

    @Then("^valido se estou na sub página \"Gerenciar Usuários\"$")
    public void validarTituloGerenciarUsuarios(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarUsuarios(),
                CoreMatchers.containsString("Gerenciar Contas"));
    }

//    StepDefinitions do terceiro cenário:
    @And("^acesso \"Criar nova conta\"$")
    public void criarNovaConta(){
        gerenciadorGeralMantisSteps.criarNovaConta();
    }

    @And("^crio novo usuário$")
    public void criarUsuario(){
        gerenciadorGeralMantisSteps.criarUsuario();
    }

//    StepDefinitions do quarto cenário:
    @And("^envio \"nome de usuário\"$")
    public void preencherNomeUsuario(){
        gerenciadorGeralMantisSteps.preencherNomeUsuario();
    }

    @Then("^o sistema apresenta mensagem de sucesso na tela \"Usuário ... criado com um nível de acesso de relator\"$")
    public void validarMensagemNovoUsuario(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarMensagemNovoUsuario(),
                CoreMatchers.containsString("criado com um nível de acesso de"));
    }

//    StepDefinitions do quinto cenário:
    @And("^envio \"nome verdadeiro\"$")
    public void preencherNomeVerdadeiro(){
        gerenciadorGeralMantisSteps.preencherNomeVerdadeiro();
    }

//    StepDefinitions do sexto cenário:
    @And("^envio \"e-mail\"$")
    public void preencherEmail(){
        gerenciadorGeralMantisSteps.preencherEmail();
    }

//    StepDefinitions do sexto cenário:
    @And("^preencho informações nova conta$")
    public void preencherNovoUsuarioInfo(){
        gerenciadorGeralMantisSteps.preencherNomeUsuario2();
        gerenciadorGeralMantisSteps.preencherNomeVerdadeiro();
        gerenciadorGeralMantisSteps.preencherEmail();
    }

//    StepDefinitions do Oitavo cenário:
    @And("^acesso \"Gerenciar Projetos\"$")
    public void acessarGerenciarProjetos(){
        gerenciadorGeralMantisSteps.acessarGerenciarProjetos();
    }

    @Then("^valido se estou na sub página \"Gerenciar Projetos\"$")
    public void validarTituloGerenciarProjetos(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarProjetos(),
                CoreMatchers.containsString("Projetos"));
    }

//    StepDefinitions do Nono cenário:
    @And("^acesso \"Gerenciar Marcadores\"$")
    public void acessarGerenciarMarcadores(){
        gerenciadorGeralMantisSteps.acessarGerenciarMarcadores();
    }

    @Then("^valido se estou na sub página \"Gerenciar Marcadores\"$")
    public void validarTituloGerenciarMarcadores(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarMarcadores(),
                CoreMatchers.containsString("Gerenciar Marcadores"));
    }

//    StepDefinitions do Décimo cenário:
    @And("^acesso \"Gerenciar Campos Personalizados\"$")
    public void acessarGerenciarCamposPerso(){
        gerenciadorGeralMantisSteps.acessarGerenciarCamposPerso();
    }

    @Then("^valido se estou na sub página \"Gerenciar Campos Personalizados\"$")
    public void validarTituloGerenciarCamposPerso(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarCamposPerso(),
                CoreMatchers.containsString("Campos Personalizados"));
    }

//    StepDefinitions do Décimo Primeiro cenário:
    @And("^acesso \"Gerenciar Perfís Globais\"$")
    public void acessarGerenciarPerfGlobais(){
        gerenciadorGeralMantisSteps.acessarGerenciarPerfGlobais();
    }

    @Then("^valido se estou na sub página \"Gerenciar Perfís Globais\"$")
    public void validarTituloGerenciarPerfGlobais(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarPerfGlobais(),
                CoreMatchers.containsString("Adicionar Perfil"));
    }

//    StepDefinitions do Décimo Segundo cenário:
    @And("^acesso \"Gerenciar Plugins\"$")
    public void acessarGerenciarPlugins(){
        gerenciadorGeralMantisSteps.acessarGerenciarPlugins();
    }

    @Then("^valido se estou na sub página \"Gerenciar Plugins\"$")
    public void validarTituloGerenciarPlugins(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarPlugins(),
                CoreMatchers.containsString("Plugins Instalados"));
    }

//    StepDefinitions do Décimo Terceiro cenário:
    @And("^acesso \"Gerenciar Configuração\"$")
    public void acessarGerenciarConfig(){
        gerenciadorGeralMantisSteps.acessarGerenciarConfig();
    }

    @Then("^valido se estou na sub página \"Gerenciar Configuração\"$")
    public void validarTituloGerenciarConfig(){
        Assert.assertThat(gerenciadorGeralMantisSteps.validarTituloGerenciarConfig(),
                CoreMatchers.containsString("ANEXO(S)"));
    }

}
