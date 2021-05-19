@desafio-base2 @login-mantis
Feature: Realizar login Mantis

    Como um usuário
    Eu quero realizar login no Mantis
    Para que possa acessar a plataforma

    Background:
        Given o usuário está na página de login do Mantis

    @valida-site @automatizado
    Scenario: Valida a home page do mantis
        Then verifico se estou na home page do mantis

    @login @login-valido @automatizado @teste
    Scenario: Login com credenciais válidas
        When informo as credenciais válidas
        And solicito acesso Mantis
        Then sistema Mantis realiza autenticação com sucesso
        And sistema Mantis abre página inicial

    @login @login-valido @mater-conectado @automatizado
    Scenario: Login com credenciais válidas - mantenha-me conectado
        When informo as credenciais válidas
        And informo que quero me manter conectado
        And solicito acesso Mantis
        Then sistema Mantis realiza autenticação com sucesso
        And sistema Mantis abre página inicial

    @autenticar-sem-usuario @automatizado
    Scenario: Tentativa de login sem informar usuário
        When envio campo usuário vazio
        Then o sistema exibi mensagem de alerta "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."

    @autenticar-sem-senha @automatizado_
    Scenario: Tentativa de login sem informar senha
        When envio credencial de usuário
        And clico entrar sem preencher senha
        Then o sistema exibi mensagem de alerta "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."

    @automatizado
    Scenario: Logout Mantis
        When informo as credenciais válidas
        And solicito acesso Mantis
        And acesso as opções do usuário
        And saio do Mantis
        Then verifico se estou na home page do mantis