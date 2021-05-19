package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.BasePage;
import br.com.desafiobase2.exceptions.ExpectedElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMantisPage extends BasePage {

    String userLogado = "//span[text()='administrator']";

    BasePage basePage;

//    Localizando Logo da home page
    @FindBy(xpath = "//img[@src='/images/mantis_logo.png']")
    private WebElement logoMantis;

//    Localizando na tela o campo "login"
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userfield;

//    Localizando mensagem de erro pelo não preenchimento do usuário
    @FindBy(tagName = "p")
    private WebElement accessErrorText;

//    Localizando na tela o botão entrar após inserir o user name
    @FindBy(xpath = "//label[@for='username']/../input[@type='submit']")
    private WebElement entrarUserButton;

//    Localizando na tela o campo senha
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

//    Localizar Checkbox "Mantenha-me conectado(a)"
    @FindBy(xpath = "//label[@for='remember-login']/span[@class='lbl padding-6']")
    private WebElement rememberCheckbox;

//    Localizando na tela o botão entrar após inserir a senha
    @FindBy(xpath = "//label[@for='password']/../input[@type='submit']")
    private WebElement passwordButton;

//    Localizando na tela o título da página após o login
    @FindBy(xpath = "//span[text()=' MantisBT ']")
    private WebElement pageTitle;

//    Clicando no botão administrador na tela inicial
    @FindBy(className = "user-info")
    private WebElement administratorButton;

//    Clicando no botão sair para fazer logout
    @FindBy(xpath = "//a[@href='/logout_page.php']")
    private WebElement logoutButton;

    public LoginMantisPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

//    Acessando o MantisBT
    public void acessarMantisBT(){
//        this.driver.navigate().to("http://192.168.99.100:8989/login_page.php");
        basePage.open();
    }

//    Função para verificar Logo Mantis
    public boolean verificarMantisLogo(){
        try {
            wait.until(ExpectedConditions.visibilityOf(logoMantis));
            return logoMantis.isDisplayed();
        } catch    (NoSuchElementException e) {
            throw new ExpectedElementNotFoundException("Falha, o elemento não foi encontrado");
        }
    }

//    Função para preencher o nome do usuário
    public void preencherUsuario(String usuario){
        wait.until(ExpectedConditions.elementToBeClickable(userfield));
        userfield.sendKeys(usuario);
    }

//    Função para validar texto de erro após não preenchimento do usuário ou senha
    public String validarMensagemErroAcesso(){
        wait.until(ExpectedConditions.visibilityOf(accessErrorText));
        return accessErrorText.getText();
    }

//    Função para clicar em entrar logo após preencher o campo usuário
    public void clicarEntrarUser(){
        wait.until(ExpectedConditions.elementToBeClickable(entrarUserButton));
        entrarUserButton.click();
    }

//    Função para preencher a senha do usuário
    public void preencherSenha(String senha) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(senha);
    }

//    Função para clicar no checkbox "mantenha-me conectado"
    public void marcarManterConectado(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberCheckbox));
        rememberCheckbox.click();
    }

//    Função para clicar em entrar logo após preencher o campo senha
    public void clicarEntrarSenha(){
        wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
        passwordButton.click();
    }

//    Função para identificar a página inicial após o login
    public String validarTituloPagina(){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

//    Função para identificar o usuário logado no sistema
    public boolean validarUsuarioLogado(String usuarioLogado){
        try {
            String identificacao = userLogado.replace("###", usuarioLogado);
            return driver.findElement(By.xpath(identificacao)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Falha, o elemento não foi encontrado" + e);
            return false;
        }
    }

//    Função para clicar no botão administrador na página inicial do Mantis
    public void acessarAdministrador(){
        wait.until(ExpectedConditions.elementToBeClickable(administratorButton));
        administratorButton.click();
    }

//    Função para clicar no botão sair após clicar em administrador na página inicial do Mantis
    public void sairDoMantis(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

}
