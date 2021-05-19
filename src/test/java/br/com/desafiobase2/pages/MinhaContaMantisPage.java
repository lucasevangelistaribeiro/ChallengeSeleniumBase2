package br.com.desafiobase2.pages;

import br.com.desafiobase2.bases.BasePage;
import br.com.desafiobase2.exceptions.ExpectedElementNotFoundException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaContaMantisPage extends BasePage{

    BasePage basePage;


//    Localizando na tela o campo "login"
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userfield;

//    Localizando na tela o botão entrar após inserir o user name
    @FindBy(xpath = "//label[@for='username']/../input[@type='submit']")
    private WebElement entrarUserButton;

//    Localizando na tela o campo senha
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

//    Localizando na tela o botão entrar após inserir a senha
    @FindBy(xpath = "//label[@for='password']/../input[@type='submit']")
    private WebElement passwordButton;

//    Clicando no botão administrador na tela inicial
    @FindBy(className = "user-info")
    private WebElement administratorButton;

//    Localizando o botão Minha conta após clicar em administrador
    @FindBy(xpath = "//a[text()=' Minha Conta']")
    private WebElement minhaContaButton;

//    Localizando o título "Minha Conta" na tela Minha Conta
    @FindBy(xpath = "//li[@class='active']/a[@href='/account_page.php']")
    private WebElement minhacontaTitle;

//    Localizando campo Senha Atual na página Minha conta
    @FindBy(id = "password-current")
    private WebElement senhaAtualField;

//    Localizando campo Nova Senha
    @FindBy(id = "password")
    private WebElement novaSenhaField;

//    Localizando campo Confirma Senha
    @FindBy(id = "password-confirm")
    private WebElement confirmarSenhaField;

//    Localizando botão Atualizar Usuário
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement atualizarUsuarioButton;

//    Localizando mensagem de sucesso após alteração de senha do usuário
    @FindBy(xpath = "//p[text()='Operação realizada com sucesso.']")
    private WebElement msgSucessoSenha;

//    Localizando na tela mensagem de erro quando não é confirmada a nova senha
    @FindBy(xpath = "//p[text()='A senha não combina com a verificação.']")
    private WebElement msgErroSenha;

//    Localizando o campo nome Verdadeiro na tela
    @FindBy(id = "realname")
    private WebElement realNameField;

//    Localizando mensagem de sucesso após alterar o nome verdadeiro
    @FindBy(xpath = "//p[text()='Nome verdadeiro atualizado com sucesso']")
    private WebElement mensagemNomeVerdadeiro;

//    Localizando o botão "Perfís" na tela
    @FindBy(xpath = "//a[@href='/account_prof_menu_page.php']")
    private WebElement perfisButton;

//    Localizando o título "Adicionar Perfil" na sub página
    @FindBy(xpath = "//form/fieldset/div/div[1]/h4")
    private WebElement subPaginaPerfis;

//    Localizando o campo plataforma
    @FindBy(id = "platform")
    private WebElement plataformaField;

//    Localizando o campo SO
    @FindBy(id = "os")
    private WebElement soField;

//    Localizando o campo versão SO
    @FindBy(id = "os-version")
    private WebElement soVersionField;

//    Localizando o campo descrição
    @FindBy(name = "description")
    private WebElement descriptionField;

//    Localizando o botão adicionar perfil
    @FindBy(xpath = "//input[@value='Adicionar Perfil']")
    private WebElement adicionarPerfilButton;

//    Localizando botão enviar abaixo da tabela de edição de perfís
    @FindBy(xpath = "//input[@value='Enviar']")
    private WebElement tabelaPerfisButton;

//    Localizando na tela a Tabela de Edição de perfís
    @FindBy(xpath = "//form/div/div[@class='widget-body']")
    private WebElement tabelaPerfis;

//    Localizando Radio button "Editar perfil"
    @FindBy(xpath = "//input[@id='action-edit']/../span[@class='lbl']")
    private WebElement radioEditarPerfil;

//    Localizar Combobox na tela de perfís
    @FindBy(id = "select-profile")
    private WebElement comboboxPerfis;

//    Localizar o botão Atualizar Perfil na tela
    @FindBy(xpath = "//input[@value='Atualizar Perfil']")
    private WebElement atualizarPerfilButton;

//    Localizar mensagem de erro após clicar em enviar sem selecionar campos obrigatórios
    @FindBy(xpath = "//p[@class='bold' and contains(., 'APPLICATION ERROR')]")
    private WebElement msgErroPerfis;

//    Localizar mensagem de erro após clicar em enviar selecionando apenas Editar Perfil
    @FindBy(xpath = "//p[text()='APPLICATION ERROR #11']")
    private WebElement msgErroEditarPerfil;

//    Localizar radio button "Tornar Padrão"
    @FindBy(xpath = "//input[@id='action-default']/../span")
    private WebElement tornarPadraoRadioButton;

//    Localizar radio button "Apagar Perfil"
    @FindBy(xpath = "//input[@id='action-delete']/../span")
    private WebElement apagarPerfilRadioButton;

//    Localizar botão "Preferências" na página Minha Conta
    @FindBy(xpath = "//a[@href='/account_prefs_page.php']")
    private WebElement subPaginaPreferencias;

//    Localizando o título da sub página preferências
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Preferências da Conta')]")
    private WebElement tituloSubPaginaPreferencias;

//    Localizando o botão atualizar preferências na tela
    @FindBy(xpath = "//input[@value='Atualizar Preferências']")
    private WebElement atualizarPreferenciasButton;

//    Localizando o botão Redefinir Preferencias
    @FindBy(xpath = "//input[@value='Redefinir Preferências']")
    private WebElement redefinirPreferenciasButton;

//    Localizando o botão Gerenciar colunas na tela
    @FindBy(xpath = "//a[@href='/account_manage_columns_page.php']")
    private WebElement subPaginaGerenciarColunas;

//    Localizando o título da sub pagina gerenciar colunas
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Gerenciar Colunas')]")
    private WebElement tituloSubPaginaGerenciarColunas;

//    Localizando botão "Atualizar Colunas para o Padrão para todos os Projetos"
    @FindBy(name = "update_columns_as_my_default")
    private WebElement atualizarColunasButton;

//    Localizando o botão Copiar colunas de
    @FindBy(name = "copy_from")
    private WebElement copiarColunasDeButton;

//    Localizando o botão copiar colunas para
    @FindBy(name = "copy_to")
    private WebElement copiarColunasParaButton;

//    Localizando o botão Reinicializar Configurações das Colunas
    @FindBy(xpath = "//input[@value='Reinicializar Configurações das Colunas']")
    private WebElement reinicializarConfigColunas;

//    Localizando o botão Tokens API na tela
    @FindBy(xpath = "//a[@href='/api_tokens_page.php']")
    private WebElement subPaginaTokensAPI;

//    Localizando o título da sub Página Tokens API
    @FindBy(xpath = "//h4[@class='widget-title lighter' and contains(., 'Criar token API')]")
    private WebElement tituloSubPaginaTokensAPI;

    public MinhaContaMantisPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 60);
    }

//    Acessando o MantisBT
    public void acessarMantisBT(){
        basePage.open();
    }

//    Função para preencher o nome do usuário
    public void preencherUsuario(String usuario){
        wait.until(ExpectedConditions.elementToBeClickable(userfield));
        userfield.sendKeys(usuario);
    }

//    Função para clicar em entrar logo após preencher o campo usuário
    public void clicarEntrarUser(){
        wait.until(ExpectedConditions.elementToBeClickable(entrarUserButton));
        entrarUserButton.click();
    }

//    Função para preencher a senha do usuário
    public void preencherSenha(String senha){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(senha);
    }

//    Função para clicar em entrar logo após preencher o campo senha
    public void clicarEntrarSenha(){
        wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
        passwordButton.click();
    }

//    Função para clicar no botão administrador na página inicial do Mantis
    public void acessarAdministrador(){
        wait.until(ExpectedConditions.elementToBeClickable(administratorButton));
        administratorButton.click();
    }

//    Clicando no botão Minha conta após clicar em administrador
    public void acessarMinhaConta(){
        wait.until(ExpectedConditions.elementToBeClickable(minhaContaButton));
        minhaContaButton.click();
    }

//    Função para validar que entrou na página inicial Minha Conta
    public String validarPaginaMinhaConta(){
        wait.until(ExpectedConditions.visibilityOf(minhacontaTitle));
        return minhacontaTitle.getText();
    }

//    Função para digitar senha atual
    public void preencherSenhaAtual(){
        wait.until(ExpectedConditions.elementToBeClickable(senhaAtualField));
        senhaAtualField.sendKeys("base2");
    }

//    Função para digitar uma nova senha
    public void criarNovaSenha(){
        wait.until(ExpectedConditions.elementToBeClickable(novaSenhaField));
        novaSenhaField.sendKeys("base2");
    }

//    Função para digitar uma nova senha
    public void confirmarNovaSenha(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmarSenhaField));
        confirmarSenhaField.sendKeys("base2");
    }

//    Função para clicar no botão Atualizar Usuário
    public void atualizarUsuraio(){
        wait.until(ExpectedConditions.elementToBeClickable(atualizarUsuarioButton));
        atualizarUsuarioButton.click();
    }

//    Função para validar mensagem de sucesso após trocar a senha do usuário
    public String validarMsgSenhaNova(){
        wait.until(ExpectedConditions.visibilityOf(msgSucessoSenha));
        return msgSucessoSenha.getText();
    }

//    Função para validar mensagem de erro após tentar atualizar
//    a senha do usuário sem confirmar nova senha
    public String validarMsgConfirmarSenhaNova(){
        wait.until(ExpectedConditions.visibilityOf(msgErroSenha));
        return msgErroSenha.getText();
    }

//    Função para nomear uma conta do sistema
    public void preencherRealName(){
        wait.until(ExpectedConditions.elementToBeClickable(realNameField));
        realNameField.clear();
        realNameField.sendKeys("Lucas Naza");
    }

//    Função para validar mensagem de sucesso após atualizar nome verdadeiro do usuário
    public String validarMsgNomeVerdadeiro(){
        wait.until(ExpectedConditions.visibilityOf(mensagemNomeVerdadeiro));
        return mensagemNomeVerdadeiro.getText();
    }

//    Função para clicar no botão Perfís
    public void acessarPerfis(){
        wait.until(ExpectedConditions.elementToBeClickable(perfisButton));
        perfisButton.click();
    }

//    Função para validar título da página Perfís
    public String validarTituloPerfis(){
        wait.until(ExpectedConditions.visibilityOf(subPaginaPerfis));
        return subPaginaPerfis.getText();
    }

//    Função para preencher o campo plataforma
    public void preencherPlataforma(String plataforma){
        wait.until(ExpectedConditions.elementToBeClickable(plataformaField));
        plataformaField.sendKeys(plataforma);
    }

//    Função para preencher o campo SO
    public void preencherSO(String so){
        wait.until(ExpectedConditions.elementToBeClickable(soField));
        soField.sendKeys(so);
    }

//    Função para preencher o campo Versão SO
    public void preencherSOVersion(String soVersion){
        wait.until(ExpectedConditions.elementToBeClickable(soVersionField));
        soVersionField.sendKeys(soVersion);
    }

//    Função para clicar em adicionar perfil
    public void adicionarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(adicionarPerfilButton));
        adicionarPerfilButton.click();
    }

//    Função para verificar tabela de edição de perfis
    public boolean verificarTabelaEdicaoPerfis(){
        try {
            wait.until(ExpectedConditions.visibilityOf(tabelaPerfis));
            return tabelaPerfis.isDisplayed();
        } catch    (NoSuchElementException e) {
            throw new ExpectedElementNotFoundException("Falha, o elemento não foi encontrado");
        }
    }

//    Selecionando o radio button "Editar perfil"
    public void selecionarEditarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(radioEditarPerfil));
        radioEditarPerfil.click();
    }

//    Selecionando perfil no combobox
    public void selecionarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(comboboxPerfis));
        Select comboPerfis = new Select(comboboxPerfis);
        comboPerfis.selectByValue("6");
    }

//    Selecionando perfil no combobox
    public void selecionarPerfil2(){
        wait.until(ExpectedConditions.elementToBeClickable(comboboxPerfis));
        Select comboPerfis = new Select(comboboxPerfis);
        comboPerfis.selectByValue("7");
    }

//    Clicar no botão Enviar para editar um perfil
    public void editarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(tabelaPerfisButton));
        tabelaPerfisButton.click();
    }

//    Função para preencher Descrição Adicional na edição de um perfil
    public void preencherDescricaoPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(descriptionField));
        descriptionField.clear();
        descriptionField.sendKeys("Que teste massa meu consgrado!");
    }

//    Função para salvar a edição feita no perfil
    public void atualizarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(atualizarPerfilButton));
        atualizarPerfilButton.click();
    }

//    Função para validar mensagem de erro após clicar em enviar sem selecionar campos obrigatórios
    public String validarMsgErroPerfil(){
        wait.until(ExpectedConditions.visibilityOf(msgErroPerfis));
        return msgErroPerfis.getText();
    }

//    Função para validar mensagem de erro após clicar em enviar selecionando apenas Editar perfil
    public String validarMsgErroEditarPerfil(){
        wait.until(ExpectedConditions.visibilityOf(msgErroEditarPerfil));
        return msgErroEditarPerfil.getText();
    }

//    Função para Selecionar o radio button "Tornar Padrão"
    public void selecionarTornarPadrao(){
        wait.until(ExpectedConditions.elementToBeClickable(tornarPadraoRadioButton));
        tornarPadraoRadioButton.click();
    }

//    Função para Selecionar o radio button "Apagar Perfil"
    public void selecionarApagarPerfil(){
        wait.until(ExpectedConditions.elementToBeClickable(apagarPerfilRadioButton));
        apagarPerfilRadioButton.click();
    }

//    Função para Selecionar a sub página preferências
    public void selecionarPreferencias(){
        wait.until(ExpectedConditions.elementToBeClickable(subPaginaPreferencias));
        subPaginaPreferencias.click();
    }

//    Função para verificar o título da sub página Preferências
    public String verificarTituloPreferencias(){
        wait.until(ExpectedConditions.visibilityOf(tituloSubPaginaPreferencias));
        return tituloSubPaginaPreferencias.getText();
    }

//    Função para clicar no botão atualizar preferências
    public void atualizarPreferencias(){
        wait.until(ExpectedConditions.elementToBeClickable(atualizarPreferenciasButton));
        atualizarPreferenciasButton.click();
    }

//    Função para clicar no botão atualizar preferências
    public void redefinirPreferencias(){
        wait.until(ExpectedConditions.elementToBeClickable(redefinirPreferenciasButton));
        redefinirPreferenciasButton.click();
    }

//    Função para Selecionar a sub página gerenciar colunas
    public void selecionarGerenciarColunas(){
        wait.until(ExpectedConditions.elementToBeClickable(subPaginaGerenciarColunas));
        subPaginaGerenciarColunas.click();
    }

//    Função para verificar o título da sub página Gerenciar Colunas
    public String verificarTituloGerenciarColunas(){
        wait.until(ExpectedConditions.visibilityOf(tituloSubPaginaGerenciarColunas));
        return tituloSubPaginaGerenciarColunas.getText();
    }

//    Função para clicar no botão Atualizar colunas...
    public void atualizarColunas(){
    wait.until(ExpectedConditions.elementToBeClickable(atualizarColunasButton));
        atualizarColunasButton.click();
    }

//    Função para clicar no botão Atualizar colunas...
    public void copiarColunasDe(){
        wait.until(ExpectedConditions.elementToBeClickable(copiarColunasDeButton));
        copiarColunasDeButton.click();
    }

//    Função para clicar no botão Atualizar colunas...
    public void copiarColunasPara(){
        wait.until(ExpectedConditions.elementToBeClickable(copiarColunasParaButton));
        copiarColunasParaButton.click();
    }

//    Função para clicar no botão Atualizar colunas...
    public void reinicializarConfigColunas(){
        wait.until(ExpectedConditions.elementToBeClickable(reinicializarConfigColunas));
        reinicializarConfigColunas.click();
    }

//    Função para clicar no botão Tokens API
    public void acessarTokensAPI(){
        wait.until(ExpectedConditions.elementToBeClickable(subPaginaTokensAPI));
        subPaginaTokensAPI.click();
    }

//    Função para verificar o título da sub página Tokens API
    public String verificarTituloTokensAPI(){
        wait.until(ExpectedConditions.visibilityOf(tituloSubPaginaTokensAPI));
        return tituloSubPaginaTokensAPI.getText();
    }

}
