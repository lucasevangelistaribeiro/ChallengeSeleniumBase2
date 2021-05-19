package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugReportPage extends PageBase {

    //Constructor
    public BugReportPage(WebDriver driver){
        super(driver);
    }

    //Mapping
    By categoryComboBox = By.name("category_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By uploadFileField = By.id("ufile[]");
    By submitButton = By.xpath("//input[@type='submit']");

    //Actions
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(categoryComboBox, categoria);
    }

    public void preencherResumo(String resumo){
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao){
        sendKeys(descriptionField, descricao);
    }

    public void inserirAnexo(String caminhoArquivo){
        sendKeysWithoutWaitVisible(uploadFileField, caminhoArquivo);
    }

    public void clicarEmSubmitReport(){
        click(submitButton);
    }
}
