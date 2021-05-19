package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CriarNovaTarefaMantisPage extends BasePage {

//    Cenário 1:
//    Localizando botão Criar tarefa
    @FindBy(xpath = "//span[text()=' Criar Tarefa ']")
    private WebElement criarTarefaButton;

//    Localizando título da página Criar tarefa
    @FindBy(tagName = "h4")
    private WebElement tituloPagCriarTarefa;

//    Cenário 2:
//    Localizando combobox Categoria
    @FindBy(id = "category_id")
    private WebElement comboboxcategoria;

//    Localizando campo Resumo
    @FindBy(id = "summary")
    private WebElement resumoField;

//    Localizando campo Descrição
    @FindBy(id = "description")
    private WebElement descricaoField;

//    Localizando botão Criar Nova Tarefa
    @FindBy(xpath = "//input[@value='Criar Nova Tarefa']")
    private WebElement criarNovaTarefaButton;

//    Cenário 3:

    public CriarNovaTarefaMantisPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

//    Cenário 1:
//    Função para clicar no botão Criar tarefa
    public void acessarCriartarefa(){
        wait.until(ExpectedConditions.elementToBeClickable(criarTarefaButton));
        criarTarefaButton.click();
    }

//    Função para validar título da página Criar Tarefa
    public String validarTituloCriarTarefa(){
        wait.until(ExpectedConditions.visibilityOf(tituloPagCriarTarefa));
        return tituloPagCriarTarefa.getText();
    }

//    Cenário 2:
//    Função para Selecionar categoria no combobox
    public void selecionarCategoria(){
        wait.until(ExpectedConditions.elementToBeClickable(comboboxcategoria));
        Select comboCategoria = new Select(comboboxcategoria);
        comboCategoria.selectByValue("1");
    }

//    Função para Preencher o campo Resumo
    public void preencherResumo(){
        wait.until(ExpectedConditions.elementToBeClickable(resumoField));
        resumoField.sendKeys("Resumo muito top nuuu!");
    }

//    Função para Preencher o campo Descrição
    public void preencherDescricao(){
        wait.until(ExpectedConditions.elementToBeClickable(descricaoField));
        descricaoField.sendKeys("Descrição muito top nuuu!");
    }

//    Função para clicar no botão Criar Nova Tarefa
    public void clicarCriarNovaTarefa(){
        wait.until(ExpectedConditions.elementToBeClickable(criarNovaTarefaButton));
        criarNovaTarefaButton.click();
    }

}
