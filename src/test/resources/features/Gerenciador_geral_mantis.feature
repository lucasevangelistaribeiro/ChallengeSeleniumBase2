@desafio-base2 @login-mantis
Feature: Gerenciador geral mantis

    Como um usuário
    Eu quero gerenciar o Mantis
    Para que possa controlar meu projeto

    Background:
        Given o usuário está na página inicial Mantis

    @automatizado
    Scenario: Verificar se foi direcionado para a página Gerenciar
        When acesso a página "Gerenciar"
        Then valido se estou na página "Gerenciar"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        Then valido se estou na sub página "Gerenciar Usuários"

    @automatizado
    Scenario: Criar uma nova conta sem preencher nenhum campo em Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        And acesso "Criar nova conta"
        And crio novo usuário
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR"

    @automatizado
    Scenario: Criar uma nova conta preenchendo somente o Nome de Usuário em Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        And acesso "Criar nova conta"
        And envio "nome de usuário"
        And crio novo usuário
        Then o sistema apresenta mensagem de sucesso na tela "Usuário ... criado com um nível de acesso de relator"
    #BUG: O sistema não deveria permitir essa configuração.

    @automatizado
    Scenario: Criar uma nova conta preenchendo somente campo Nome Verdadeiro em Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        And acesso "Criar nova conta"
        And envio "nome verdadeiro"
        And crio novo usuário
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR"

    @automatizado
    Scenario: Criar uma nova conta preenchendo somente campo E-mail em Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        And acesso "Criar nova conta"
        And envio "e-mail"
        And crio novo usuário
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR"

    @automatizado 
    Scenario: Criar uma nova conta em Gerenciar Usuários
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Usuários"
        And acesso "Criar nova conta"
        And preencho informações nova conta
        And crio novo usuário
        Then o sistema apresenta mensagem de sucesso na tela "Usuário ... criado com um nível de acesso de relator"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Projetos
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Projetos"
        Then valido se estou na sub página "Gerenciar Projetos"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Marcadores
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Marcadores"
        Then valido se estou na sub página "Gerenciar Marcadores"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Campos Personalizados
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Campos Personalizados"
        Then valido se estou na sub página "Gerenciar Campos Personalizados"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Perfís Globais
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Perfís Globais"
        Then valido se estou na sub página "Gerenciar Perfís Globais"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Plugins
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Plugins"
        Then valido se estou na sub página "Gerenciar Plugins"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub página Gerenciar Configuração
        When acesso a página "Gerenciar"
        And acesso "Gerenciar Configuração"
        Then valido se estou na sub página "Gerenciar Configuração"