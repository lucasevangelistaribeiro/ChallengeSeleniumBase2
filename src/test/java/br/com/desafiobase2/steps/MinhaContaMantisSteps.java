package br.com.desafiobase2.steps;

import br.com.desafiobase2.pages.MinhaContaMantisPage;
import net.thucydides.core.annotations.Step;

public class MinhaContaMantisSteps {

//    Linkando as camadas Page e Steps
    MinhaContaMantisPage minhaContaMantisPage;

//    Step do background da feature.
    @Step("Acessando a página inicial do Mantis")
    public void acessarMantis(String usuario, String senha){
        minhaContaMantisPage.acessarMantisBT();
        minhaContaMantisPage.preencherUsuario(usuario);
        minhaContaMantisPage.clicarEntrarUser();
        minhaContaMantisPage.preencherSenha(senha);
        minhaContaMantisPage.clicarEntrarSenha();
    }

//    Step do cenário "Verificar se está na página Minha Conta"
    @Step("Acessando o página Minha conta pelo link na tela inicial do Mantis")
    public void acessarMinhaConta(){
        minhaContaMantisPage.acessarAdministrador();
        minhaContaMantisPage.acessarMinhaConta();
    }

    @Step("Validar se realmente entrou na página Minha Conta corretamente")
    public String validarAcessoPagMinhaConta(){
       return minhaContaMantisPage.validarPaginaMinhaConta();
    }

//    Step do cenário "Alterar a senha do usuário com sucesso"
    @Step("Digitar senha atual")
    public void preencherSenhaAtual(){
        minhaContaMantisPage.preencherSenhaAtual();
    }

    @Step("Digitar nova senha")
    public void preencherNovaSenha(){
        minhaContaMantisPage.criarNovaSenha();
    }

    @Step("Confirmar nova senha")
    public void confirmarSenhaNova(){
        minhaContaMantisPage.confirmarNovaSenha();
    }

    @Step("Atualizar usuário")
    public void atualizarUsuario(){
        minhaContaMantisPage.atualizarUsuraio();
    }

    @Step("Validar mensagem de sucesso após atualizar senha do usuário")
    public String validarMsgSenhaNova(){
        return minhaContaMantisPage.validarMsgSenhaNova();
    }

//    Steps do cenário "Alterar senha do usuário preenchendo somente o campo senha atual"
    @Step("Preencho somente o campo senha atual e em seguida atualizado o usuário")
    public void enviarSenhaAtual(){
        minhaContaMantisPage.preencherSenhaAtual();
    }

//    Steps do cenário "Alterar senha do usuário preenchendo
//    somente os campos senha atual e nova senha"
    @Step("Preencho a nova senha")
    public void preencherSenhaNova(){
        minhaContaMantisPage.criarNovaSenha();
    }

    @Step("Valido mensagem de erro após tentativa de atualizar usuário")
    public String validarMsgConfirmarSenha(){
        return minhaContaMantisPage.validarMsgConfirmarSenhaNova();
    }

//    Steps do cenário "Alterar o nome verdadeiro"
    @Step("Preencho o campo nome verdadeiro")
    public void preencherNomeVerdadeiro(){
        minhaContaMantisPage.preencherRealName();
    }

    @Step("Validar mensagem de sucesso após atualizar nome verdadeiro")
    public String validarMensagemNomeVerdadeiro(){
        return minhaContaMantisPage.validarMsgNomeVerdadeiro();
    }

//    Steps do cenário "Verificar se está na sub página Perfís"
    @Step("Clicar no botão Perfís")
    public void acessarPerfis(){
        minhaContaMantisPage.acessarPerfis();
    }

    @Step("Validar título da página Perfís")
    public String validarPaginaPerfis(){
        return minhaContaMantisPage.validarTituloPerfis();
    }

//    Steps do cenário "Adicionar perfís com sucesso"
    @Step("Preencher os campo plataforma, SO e versão do SO")
    public void preencherPerfil(String plataforma, String so, String soVersion){
        minhaContaMantisPage.preencherPlataforma(plataforma);
        minhaContaMantisPage.preencherSO(so);
        minhaContaMantisPage.preencherSOVersion(soVersion);
    }

    @Step("Clicar em Adicionar Perfil")
    public void adicionarPerfil(){
        minhaContaMantisPage.adicionarPerfil();
    }

    @Step("Validar tabela de edição de perfís")
    public boolean validarTabelaEdicaoPerfis(){
       return minhaContaMantisPage.verificarTabelaEdicaoPerfis();
    }

//    Steps do cenário "Editar perfil com descrição adicional"
    @Step("Selecionando perfil para editar")
    public void selecionarPerfilEditar(){
        minhaContaMantisPage.selecionarEditarPerfil();
        minhaContaMantisPage.selecionarPerfil();
        minhaContaMantisPage.editarPerfil();
    }

    @Step("Incluo a descrição no perfil")
    public void preencherDescricao(){
        minhaContaMantisPage.preencherDescricaoPerfil();
    }

    @Step("Atualizando o perfil que edite")
    public void atualizarPerfil(){
        minhaContaMantisPage.atualizarPerfil();
    }

//    Steps do cenário "Editar perfil sem selecionar campos obrigatórios"
    @Step("Clicar em Enviar sem marcar nenhuma opção obrigatória na tabela de Perfís")
    public void clicarEnviar(){
        minhaContaMantisPage.editarPerfil();
    }

    @Step("Validar mensagem de erro após clicar em enviar sem preencher campos obrigatórios")
    public String validarMsgErroPerfil(){
        return minhaContaMantisPage.validarMsgErroPerfil();
    }

//    Steps do cenário "Editar perfil sem selecionar o perfil"
    @Step("Seleciono a opção editar perfil")
    public void editarPerfil(){
        minhaContaMantisPage.selecionarEditarPerfil();
    }

    @Step("Validar mensagem de erro após selecionar Editar perfil e clicar enviar sem preencher demais campos")
    public String validarMsgErroEditarPerfil(){
        return minhaContaMantisPage.validarMsgErroEditarPerfil();
    }

//    Steps do cenário "Marcar um perfil como padrão"
    @Step("Selecionando o radio button Tornar Padrão")
    public void selecionarTornarPadrao(){
        minhaContaMantisPage.selecionarTornarPadrao();
    }

    @Step("Selecionando o Perfil e enviando")
    public void selecionarPerfilPadrao(){
        minhaContaMantisPage.selecionarPerfil2();
    }

//    Steps do cenário "Apagar um perfil"
    @Step("Selecionando o radio button Apagar Perfil")
    public void selecionarApagarPerfil(){
        minhaContaMantisPage.selecionarApagarPerfil();
    }

//    Steps do cenário "Verificar se foi direcionado para a sub pagina Preferências"
    @Step("Acessando a sub página Preferências")
    public void acessarPreferencias(){
        minhaContaMantisPage.selecionarPreferencias();
    }

    @Step("Validando título da sub página preferências")
    public String validarSubPaginaPreferencias(){
        return minhaContaMantisPage.verificarTituloPreferencias();
    }

//    Steps do cenário "Atualizar informações na sub página Preferências"
    @Step("Clico em Atualizar Preferências")
    public void atualizarPreferencias(){
        minhaContaMantisPage.atualizarPreferencias();
    }

//    Steps do cenário "Redefinir informações na sub página Preferências"
    @Step("Clico em Redefinir Preferências")
    public void redefinirPreferencias(){
        minhaContaMantisPage.redefinirPreferencias();
    }

//    Steps do cenário "Verificar se foi direcionado para a sub pagina Gerenciar Colunas"
    @Step("Acessando a sub página Gerenciar Colunas")
    public void acessarGerenciarColunas(){
        minhaContaMantisPage.selecionarGerenciarColunas();
    }

    @Step("Validando título da sub página Gerenciar Colunas")
    public String validarSubPaginaGerenciarColunas(){
        return minhaContaMantisPage.verificarTituloGerenciarColunas();
    }

//    Steps do cenário "Atualizar informações da sub página Gerenciar Colunas"
    @Step("Clico no botão atualizar colunas...projetos")
    public void atualizarColunas(){
        minhaContaMantisPage.atualizarColunas();
    }

//    Steps do cenário "Selecionar a opção 'copiar colunas de' da sub página Gerenciar Colunas"
    @Step("Clicando no botão copiar colunas de ")
    public void copiarColunasDe(){
        minhaContaMantisPage.copiarColunasDe();
    }

//    Steps do cenário "Selecionar a opção 'copiar colunas para' da sub página Gerenciar Colunas"
    @Step("Clicando no botão copiar colunas para ")
    public void copiarColunasPara(){
        minhaContaMantisPage.copiarColunasPara();}

//    Steps do cenário "Reinicializar informações da sub página Gerenciar Colunas"
    @Step("Clicando no botão Reinicializar Configurações das Colunas ")
    public void reinicializarConfigColunas(){
        minhaContaMantisPage.reinicializarConfigColunas();
    }

//    Steps do cenário "Verificar se foi direcionado para a sub pagina Tokens API"
    @Step("Clicar no botão Tokens API")
    public void acessarTokensAPI(){
        minhaContaMantisPage.acessarTokensAPI();
    }

    @Step("Validando o título da página Tokens API")
    public String validarTituloTokensAPI(){
        return minhaContaMantisPage.verificarTituloTokensAPI();
    }

}
