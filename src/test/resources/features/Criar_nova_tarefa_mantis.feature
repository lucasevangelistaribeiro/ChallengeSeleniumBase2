@desafio-base2 @login-mantis
Feature: Criar nova tarefa Mantis

    Como um usuário
    Eu quero criar nova tarefa no Mantis
    Para que possa controlar minhas tarefas

    Background:
        Given o usuário está na página inicial Mantis

    @automatizado
    Scenario: Verificar se foi direcionado para a pagina Criar Tarefa
        When acesso a página "Criar Tarefa"
        Then valido se estou na página "Criar Tarefa"

    @automatizado
    Scenario: Criar uma tarefa com sucesso

        When acesso a página "Criar Tarefa"
        And preencho os dados obrigatórios
        And confirmo os dados para envio
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."

    @automatizado
    Scenario: Criar uma tarefa sem preencher categoria

        When acesso a página "Criar Tarefa"
        And preencho resumo e descrição
        And confirmo os dados para envio
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR"

    @automatizado
    Scenario: Criar uma tarefa sem preencher resumo

        When acesso a página "Criar Tarefa"
        And preencho categoria e descrição
        And confirmo os dados para envio
        Then valido se estou na página "Criar Tarefa"

    @automatizado
    Scenario: Criar uma tarefa sem preencher descrição

        When acesso a página "Criar Tarefa"
        And preencho categoria e resumo
        And confirmo os dados para envio
        Then valido se estou na página "Criar Tarefa"

    @automatizado
    Scenario: Criar uma tarefa sem preencher nenhum campo obrigatório

        When acesso a página "Criar Tarefa"
        And confirmo os dados para envio
        Then valido se estou na página "Criar Tarefa"

