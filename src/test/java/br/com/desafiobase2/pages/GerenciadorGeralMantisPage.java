package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GerenciadorGeralMantisPage extends BasePage {

//    Primeiro cenário da feature:
//    Localizando na tela o botão gerenciar
    @FindBy(xpath = "//span[text()=' Gerenciar ']")
    private WebElement gerenciarButton;

//    Localizando título da página Gerenciar
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Informação do Site')]")
    private WebElement tituloPaginaGerenciar;

//    Localizar botão Gerenciar Usuários na página Gerenciar
    @FindBy(xpath = "//a[text()='Gerenciar Usuários']")
    private WebElement gerenciarUsuariosButton;

//    Localizando título da sub página Gerenciar Usuários
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Gerenciar Contas')]")
    private WebElement tituloSubPagGerenciarUsuarios;

//    Localizando botão Criar nova conta
    @FindBy(xpath = "//a[text()='Criar nova conta']")
    private WebElement criarNovaContaButton;

//    Localizando botão Criar usuário
    @FindBy(xpath = "//input[@value='Criar Usuário']")
    private WebElement criarUsuarioButton;

//    Localizando campo Nome de usuário
    @FindBy(id = "user-username")
    private WebElement userNameField;

//    Localizando mensagem de sucesso após inclusão de um novo usuário
    @FindBy(xpath = "//p[text()=' criado com um nível de acesso de ']")
    private WebElement mensagemNovoUsuario;

//    Localizando campo Nome Verdadeiro
    @FindBy(id = "user-realname")
    private WebElement userRealNameField;

//    Localizando campo E-mail
    @FindBy(id = "email-field")
    private WebElement emailField;

//    Localizando o botão Gerenciar Projetos
    @FindBy(xpath = "//a[text()='Gerenciar Projetos']")
    private WebElement gerenciarProjetosButton;

//    Localizando o título da sub página Gerenciar Projetos
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Projetos')]")
    private WebElement tituloGerenciarProjetos;

//    Localizando o botão Gerenciar Marcadores
    @FindBy(xpath = "//a[text()='Gerenciar Marcadores']")
    private WebElement gerenciarMarcadoresButton;

    //    Localizando o título da sub página Gerenciar Marcadores
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Gerenciar Marcadores')]")
    private WebElement tituloGerenciarMarcadores;

//    Localizando o botão Gerenciar Campos Personalizados
    @FindBy(xpath = "//a[text()='Gerenciar Campos Personalizados']")
    private WebElement gerenciarCamposPersoButton;

    //    Localizando o título da sub página Gerenciar Campos Personalizados
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Campos Personalizados')]")
    private WebElement tituloGerenciarCamposPerso;

//    Localizando o botão Gerenciar Perfís Globais
    @FindBy(xpath = "//a[text()='Gerenciar Perfís Globais']")
    private WebElement gerenciarPerfisGlobaisButton;

    //    Localizando o título da sub página Gerenciar Perfís Globais
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Adicionar Perfil')]")
    private WebElement tituloGerenciarPerfGlobais;

//    Localizando o botão Gerenciar Plugins
    @FindBy(xpath = "//a[text()='Gerenciar Plugins']")
    private WebElement gerenciarPluginsButton;

    //    Localizando o título da sub página Gerenciar Plugins
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Plugins Instalados')]")
    private WebElement tituloGerenciarPlugins;

//    Localizando o botão Gerenciar Configuração
    @FindBy(xpath = "//a[text()='Gerenciar Configuração']")
    private WebElement gerenciarConfigButton;

//    Localizando o título da sub página Gerenciar Configuração
    @FindBy(xpath = "//h4[@class='widget-title lighter uppercase' and contains(., 'anexo(s)')]")
    private WebElement tituloGerenciarConfig;


    public GerenciadorGeralMantisPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

//    Primeiro cenário da feature:
//    Função para clicar no botão Gerenciar
    public void acessarMenuGerenciar(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarButton));
        gerenciarButton.click();
    }

//    Função para verificar o título da página Gerenciar
    public String verificarTituloGerenciar(){
        wait.until(ExpectedConditions.visibilityOf(tituloPaginaGerenciar));
        return tituloPaginaGerenciar.getText();
    }

//    Segundo cenário da feature:
//    Função para clicar no botão Gerenciar Usuários
    public void acessarGerenciarUsuarios(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarUsuariosButton));
        gerenciarUsuariosButton.click();
}

//    Função para verificar o título da sub página Gerenciar Usuários
    public String verificarTituloGerenciarUsuarios(){
        wait.until(ExpectedConditions.visibilityOf(tituloSubPagGerenciarUsuarios));
        return tituloSubPagGerenciarUsuarios.getText();
    }

//    Terceiro cenário da feature:
//    Função para clicar no botão Criar Nova Conta
    public void criarNovaConta(){
        wait.until(ExpectedConditions.elementToBeClickable(criarNovaContaButton));
        criarNovaContaButton.click();
}

//    Função para clicar no botão Criar Usuário
    public void criarUsuario(){
        wait.until(ExpectedConditions.elementToBeClickable(criarUsuarioButton));
        criarUsuarioButton.click();
    }

//    Quarto cenário da feature:
//    Função para preencher campo nome de usuário
    public void preencherNomeUsuario(){
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys("Lucas Naza Nazario");
    }

//    Função para validar mensagem de sucesso após criar um novo usuário
    public String validarMsgCriarNovoUsuario(){
        wait.until(ExpectedConditions.visibilityOf(mensagemNovoUsuario));
        return mensagemNovoUsuario.getText();
    }

//    Quinto cenário da feature:
//    Função para preencher campo nome verdadeiro
    public void preencherNomeVerdadeiro(){
        wait.until(ExpectedConditions.elementToBeClickable(userRealNameField));
        userRealNameField.sendKeys("Lucas Messi");
    }

//    Sexto cenário da feature:
//    Função para preencher campo email
    public void preencherEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys("lucasmessi@liomessi.com");
    }

//    Sétimo cenário da feature:
//    Função para preencher campo nome de usuário
    public void preencherNomeUsuario2(){
        wait.until(ExpectedConditions.elementToBeClickable(userNameField));
        userNameField.sendKeys("Lucas Messi");
    }

//    Oitavo cenário da feature:
//    Função para clicar no botão Gerenciar Projetos
    public void acessarGerenciarProjetos(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarProjetosButton));
        gerenciarProjetosButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Projetos
    public String verificarTituloGerenciarProjetos(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarProjetos));
        return tituloGerenciarProjetos.getText();
    }

//    Nono cenário da feature:
//    Função para clicar no botão Gerenciar Marcadores
    public void acessarGerenciarMarcadores(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarMarcadoresButton));
        gerenciarMarcadoresButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Marcadores
    public String verificarTituloGerenciarMarcadores(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarMarcadores));
        return tituloGerenciarMarcadores.getText();
    }

//    Décimo cenário da feature:
//    Função para clicar no botão Gerenciar Campos Personalizados
    public void acessarGerenciarCamposPerso(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarCamposPersoButton));
        gerenciarCamposPersoButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Campos Personalizados
    public String verificarTituloGerenciarCamposPerso(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarCamposPerso));
        return tituloGerenciarCamposPerso.getText();
    }

//    Décimo Primeiro cenário da feature:
//    Função para clicar no botão Gerenciar Perfís Globais
    public void acessarGerenciarPerfGlobais(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarPerfisGlobaisButton));
        gerenciarPerfisGlobaisButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Perfís Globais
    public String verificarTituloGerenciarPerfGlobais(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarPerfGlobais));
        return tituloGerenciarPerfGlobais.getText();
    }

//    Décimo segundo cenário da feature:
//    Função para clicar no botão Gerenciar Plugins
    public void acessarGerenciarPlugins(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarPluginsButton));
        gerenciarPluginsButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Plugins
    public String verificarTituloGerenciarPlugins(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarPlugins));
        return tituloGerenciarPlugins.getText();
    }

//    Décimo Terceiro cenário da feature:
//    Função para clicar no botão Gerenciar Configurações
    public void acessarGerenciarConfig(){
        wait.until(ExpectedConditions.elementToBeClickable(gerenciarConfigButton));
        gerenciarConfigButton.click();
    }

//    Função para verificar o título da sub página Gerenciar Configurações
    public String verificarTituloGerenciarConfig(){
        wait.until(ExpectedConditions.visibilityOf(tituloGerenciarConfig));
        return tituloGerenciarConfig.getText();
    }


}
