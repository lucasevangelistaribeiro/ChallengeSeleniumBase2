package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.BugReportPage;

public class BugReportSteps {

    BugReportPage bugReportPage;

    public void selecionarCategoria(String categoria){
        bugReportPage.selecionarCategoria(categoria);
    }

    public void preencherResumo(String resumo){
        bugReportPage.preencherResumo(resumo);
    }

    public void preencherDescricao(String descricao){
        bugReportPage.preencherDescricao(descricao);
    }

    public void inserirAnexo(String caminhoArquivo){
        bugReportPage.inserirAnexo(caminhoArquivo);
    }

    public void clicarEmSubmitReport(){
        bugReportPage.clicarEmSubmitReport();
    }
}
