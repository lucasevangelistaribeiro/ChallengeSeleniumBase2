package br.com.desafiobase2.stepdefinitions;

import br.com.desafiobase2.steps.AcessandoOutrosMenusMantisSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

public class AcessandoOutrosMenusMantisStepDefinitions {

//    Linkando Steps e StepDefinitions
    @Steps
    AcessandoOutrosMenusMantisSteps acessandoOutrosMenusMantisSteps;

//    Cenário 1:
    @When("^acesso a página \"Ver Tarefas\"$")
    public void acessarVerTarefas(){
        acessandoOutrosMenusMantisSteps.acessarVerTarefas();
    }

    @Then("^valido se estou na página \"Ver Tarefas\"$")
    public void validarTituloVerTarefas(){
        Assert.assertThat(acessandoOutrosMenusMantisSteps.validarTituloVerTarefas(),
                CoreMatchers.containsString("Visualizando Tarefas"));
    }

//    Cenário 2:
    @When("^acesso a página \"Registro de Mudanças\"$")
    public void acessarRegMudanca(){
        acessandoOutrosMenusMantisSteps.acessarRegMudanca();
    }

    @Then("^valido se estou na página \"Registro de Mudanças\"$")
    public void validarTituloRegMudanca(){
        Assert.assertThat(acessandoOutrosMenusMantisSteps.validarTituloRegMudanca(),
                CoreMatchers.containsString("registro de mudança"));
    }

//    Cenário 3:
    @When("^acesso a página \"Planejamento\"$")
    public void acessarPlanejamento(){
        acessandoOutrosMenusMantisSteps.acessarPlanejamento();
    }

    @Then("^valido se estou na página \"Planejamento\"$")
    public void validarTituloPlanejamento(){
        Assert.assertThat(acessandoOutrosMenusMantisSteps.validarTituloPlanejamento(),
                CoreMatchers.containsString("planejamento"));
    }

//    Cenário 4:
    @When("^acesso a página \"Resumo\"$")
    public void acessarResumo(){
        acessandoOutrosMenusMantisSteps.acessarResumo();
    }

    @Then("^valido se estou na página \"Resumo\"$")
    public void validarTituloResumo(){
        Assert.assertThat(acessandoOutrosMenusMantisSteps.validarTituloResumo(),
                CoreMatchers.containsString("Resumo"));
    }
}
