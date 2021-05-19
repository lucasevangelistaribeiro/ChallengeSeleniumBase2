@desafio-base2 @login-mantis
Feature: Acessando outros menus Mantis

    Background:
        Given o usuário está na página inicial Mantis

    @automatizar @teste
    Scenario: Verificar se foi direcionado para a pagina Ver Tarefas
        When acesso a página "Ver Tarefas"
        Then valido se estou na página "Ver Tarefas"

    @automatizar @teste
    Scenario: Verificar se foi direcionado para a pagina Registro de Mudanças
        When acesso a página "Registro de Mudanças"
        Then valido se estou na página "Registro de Mudanças"

    @automatizar @teste
    Scenario: Verificar se foi direcionado para a pagina Planejamento
        When acesso a página "Planejamento"
        Then valido se estou na página "Planejamento"

    @automatizar @teste
    Scenario: Verificar se foi direcionado para a pagina Resumo
        When acesso a página "Resumo"
        Then valido se estou na página "Resumo"

