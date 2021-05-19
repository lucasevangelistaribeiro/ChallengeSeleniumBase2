package br.com.desafiobase2.pages;


import br.com.desafiobase2.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    //Constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By mensagemErroTextArea = By.xpath("/html/body/div[2]/font");

    //Actions
    public void preenhcerUsuario(String usuario){
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha){
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin(){
        click(loginButton);
    }

    public String retornaMensagemDeErro(){
        return getText(mensagemErroTextArea);
    }
}
