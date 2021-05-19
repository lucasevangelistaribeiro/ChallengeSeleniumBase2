package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.MainPage;
import net.thucydides.core.annotations.Step;

public class MainSteps {
    MainPage mainPage;

    @Step("Retorna username das informações de login")
    public String retornaUsernameDasInformacoesDeLogin(){
        return mainPage.retornaUsernameDasInformacoesDeLogin();
    }

    @Step("Clicar em 'Report Issue'")
    public void clicarEmReportIssue(){
        mainPage.clicarEmReportIssue();
    }
}
