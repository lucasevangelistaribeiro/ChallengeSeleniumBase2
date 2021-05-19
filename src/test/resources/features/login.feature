Feature: Login

    @teste
    Scenario: Efetuar login com sucesso
        Given informo o usuario 'templateautomacao'
        And informo a senha '123456'
        When acessar o sistema
        Then o usuário deve ser autenticado com sucesso
