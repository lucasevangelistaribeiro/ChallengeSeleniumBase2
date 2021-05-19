package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.CriarNovaTarefaMantisPage;
import net.thucydides.core.annotations.Step;

public class CriarNovaTarefaMantisSteps {

//    Linkando as camadas Page e Steps
    CriarNovaTarefaMantisPage criarNovaTarefaMantisPage;

//    Cenário 1:
    @Step("Acessar o menu Criar Tarefa")
    public void acessarCriarTarefa(){
        criarNovaTarefaMantisPage.acessarCriartarefa();
    }

    @Step("Validar título da página Criar Tarefa")
    public String validarTituloCriarTarefa(){
        return criarNovaTarefaMantisPage.validarTituloCriarTarefa();
    }

//    Cenário 2:
    @Step("Selecionando a categoria")
    public void selecionarCategoria(){
        criarNovaTarefaMantisPage.selecionarCategoria();
    }

    @Step("Preenchendo Resumo")
    public void preecherResumo(){
        criarNovaTarefaMantisPage.preencherResumo();
    }

    @Step("Preenchendo Descrição")
    public void preencherDescricao(){
        criarNovaTarefaMantisPage.preencherDescricao();
    }

    @Step("Clicar Criar Nova Tarefa")
    public void criarNovaTarefa(){
        criarNovaTarefaMantisPage.clicarCriarNovaTarefa();
    }

//    Cenário 3:
    @Step("Preenchendo somente resumo e descrição")
    public void criarTarefaSemCategoria(){
        criarNovaTarefaMantisPage.preencherResumo();
        criarNovaTarefaMantisPage.preencherDescricao();
    }

//    Cenário 4:
    @Step("Preenchendo somente categoria e descrição")
    public void criarTarefaSemResumo(){
        criarNovaTarefaMantisPage.selecionarCategoria();
        criarNovaTarefaMantisPage.preencherDescricao();
    }

//    Cenário 5:
    @Step("Preenchendo somente categoria e resumo")
    public void criarTarefaSemDescricao(){
        criarNovaTarefaMantisPage.selecionarCategoria();
        criarNovaTarefaMantisPage.preencherResumo();
    }

}
