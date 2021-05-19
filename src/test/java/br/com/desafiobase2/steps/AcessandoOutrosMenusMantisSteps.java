package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.AcessandoOutrosMenusMantisPage;
import net.thucydides.core.annotations.Step;

public class AcessandoOutrosMenusMantisSteps {

//    Linkando Page a Steps
    AcessandoOutrosMenusMantisPage acessandoOutrosMenusMantisPage;

//    Cenário 1:
    @Step("Acessar Ver Tarefas")
    public void acessarVerTarefas(){
        acessandoOutrosMenusMantisPage.clicarVerTarefas();
    }

    @Step("Validar Título da página Ver tarefas")
    public String validarTituloVerTarefas(){
        return acessandoOutrosMenusMantisPage.validarTituloVerTarefas();
    }

//    Cenário 2:
    @Step("Acessar Registro de Mudanças")
    public void acessarRegMudanca(){
        acessandoOutrosMenusMantisPage.clicarRegMudanca();
    }

    @Step("Validar Título da página Registro de Mudanças")
    public String validarTituloRegMudanca(){
        return acessandoOutrosMenusMantisPage.validarTituloRegMudanca();
    }

//    Cenário 3:
    @Step("Acessar Planejamento")
    public void acessarPlanejamento(){
        acessandoOutrosMenusMantisPage.clicarPlanejamento();
    }

    @Step("Validar Título da página Planejamento")
    public String validarTituloPlanejamento(){
        return acessandoOutrosMenusMantisPage.validarTituloPlanejamento();
    }

//    Cenário 4:
    @Step("Acessar Resumo")
    public void acessarResumo(){
        acessandoOutrosMenusMantisPage.clicarResumo();
    }

    @Step("Validar Título da página Resumo")
    public String validarTituloResumo(){
        return acessandoOutrosMenusMantisPage.validarTituloResumo();
    }
}
