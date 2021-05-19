package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcessandoOutrosMenusMantisPage extends BasePage {

//    Cenário 1:
//    Localizando botão Ver Tarefas
    @FindBy(xpath = "//span[text()=' Ver Tarefas ']")
    private WebElement verTarefasButton;

//    Localizando título da página Ver Tarefas
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Visualizando Tarefas')]")
    private WebElement tituloVerTarefas;

//    Cenário 2:
//    Localizando botão Registro de mudanças
    @FindBy(xpath = "//span[text()=' Registro de Mudanças ']")
    private WebElement regMudancasButton;

//    Localizando título da página Registro de mudança
    @FindBy(tagName = "p")
    private WebElement tituloRegMudanca;

//    Cenário 3:
//    Localizando botão Planejamento
    @FindBy(xpath = "//span[text()=' Planejamento ']")
    private WebElement planejamentoButton;

//    Localizando título da página Planejamento
    @FindBy(tagName = "p")
    private WebElement tituloPlanejamento;

//    Cenário 4:
//    Localizando botão Resumo
    @FindBy(xpath = "//span[text()=' Resumo ']")
    private WebElement resumoButton;

//    Localizando título da página Resumo
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Resumo')]")
    private WebElement tituloResumo;

    public AcessandoOutrosMenusMantisPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

//    Cenário 1:
//    Função para clicar em Ver tarefas
    public void clicarVerTarefas(){
        wait.until(ExpectedConditions.elementToBeClickable(verTarefasButton));
        verTarefasButton.click();
    }

//    Função para validar o título da página Ver Tarefas
    public String validarTituloVerTarefas(){
        wait.until(ExpectedConditions.visibilityOf(tituloVerTarefas));
        return tituloVerTarefas.getText();
    }

//    Cenário 2:
//    Função para clicar em Registro de Mudanças
    public void clicarRegMudanca(){
        wait.until(ExpectedConditions.elementToBeClickable(regMudancasButton));
        regMudancasButton.click();
    }

//    Função para validar o título da página Registro de Mudanças
    public String validarTituloRegMudanca(){
        wait.until(ExpectedConditions.visibilityOf(tituloRegMudanca));
        return tituloRegMudanca.getText();
    }

//    Cenário 3:
//    Função para clicar em Planejamento
    public void clicarPlanejamento(){
        wait.until(ExpectedConditions.elementToBeClickable(planejamentoButton));
        planejamentoButton.click();
    }

//    Função para validar o título da página Planejamento
    public String validarTituloPlanejamento(){
        wait.until(ExpectedConditions.visibilityOf(tituloPlanejamento));
        return tituloPlanejamento.getText();
    }

//    Cenário 4:
//    Função para clicar em Resumo
    public void clicarResumo(){
        wait.until(ExpectedConditions.elementToBeClickable(resumoButton));
        resumoButton.click();
    }

//    Função para validar o título da página Resumo
    public String validarTituloResumo(){
        wait.until(ExpectedConditions.visibilityOf(tituloResumo));
        return tituloResumo.getText();
    }
}
