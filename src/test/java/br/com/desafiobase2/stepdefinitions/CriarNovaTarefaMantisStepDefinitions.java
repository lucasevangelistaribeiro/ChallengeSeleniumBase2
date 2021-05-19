package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.steps.CriarNovaTarefaMantisSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.nio.charset.CoderResult;

public class CriarNovaTarefaMantisStepDefinitions {

//    Linkando Step e Stepdefinitions
    @Steps
    CriarNovaTarefaMantisSteps criarNovaTarefaMantisSteps;

//    Cenário 1:
    @When(("^acesso a página \"Criar Tarefa\"$"))
    public void acessarCriarTarefa(){
        criarNovaTarefaMantisSteps.acessarCriarTarefa();
    }

    @Then("^valido se estou na página \"Criar Tarefa\"$")
    public void validarTituloCriarTarefa(){
        Assert.assertThat(criarNovaTarefaMantisSteps.validarTituloCriarTarefa(),
                CoreMatchers.containsString("Digite os Detalhes do Relatório"));
    }
//    Cenário 2:
    @And("^preencho os dados obrigatórios$")
    public void preencherTarefa(){
        criarNovaTarefaMantisSteps.selecionarCategoria();
        criarNovaTarefaMantisSteps.preecherResumo();
        criarNovaTarefaMantisSteps.preencherDescricao();
    }

    @And("^confirmo os dados para envio$")
    public void criarNovaTarefa(){
        criarNovaTarefaMantisSteps.criarNovaTarefa();
    }

//    Cenário 3:
    @And("^preencho resumo e descrição$")
    public void criarTarefaSemCategoria(){
        criarNovaTarefaMantisSteps.criarTarefaSemCategoria();
    }

//    Cenário 4:
    @And("^preencho categoria e descrição$")
    public void criarTarefaSemResumo(){
        criarNovaTarefaMantisSteps.criarTarefaSemResumo();
    }

//    Cenário 5:
    @And("^preencho categoria e resumo$")
    public void criarTarefaSemDescricao(){
        criarNovaTarefaMantisSteps.criarTarefaSemDescricao();
    }

}
