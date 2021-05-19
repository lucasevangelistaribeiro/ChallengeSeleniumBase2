Feature: Minha conta Mantis

    Background:
        Given o usuário está na página inicial Mantis

    @automatizado
    Scenario: Verificar se está na página Minha Conta
        When acesso a página "Minha conta"
        Then Verifico se estou na pagina minha conta

    @automatizado
    Scenario: Alterar a senha do usuário com sucesso
        When acesso a página "Minha conta"
        And preencho as informações para alterar a senha
        And atualizo o usuário
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."

    @automatizado
    Scenario: Alterar senha do usuário sem preencher nenhuma informação
        When acesso a página "Minha conta"
        And atualizo o usuário
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."
    #BUG: Não preenchendo nada o certo seria o sistema avisar sobre os campos obrigatórios.

    @automatizado
    Scenario: Alterar senha do usuário preenchendo somente o campo senha atual
        When acesso a página "Minha conta"
        And preencho a senha atual
        And atualizo o usuário
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."
    #BUG: Não deveria dar mensagem de sucesso visto que não preenchi nova senha nem confirmação.

    @automatizado
    Scenario: Alterar senha do usuário preenchendo somente os campos senha atual e nova senha
        When acesso a página "Minha conta"
        And preencho a senha atual
        And preencho a nova senha
        And atualizo o usuário
        Then o sistema exibe a mensagem de erro na tela "A senha não combina com a verificação."

    @automatizado
    Scenario: Alterar o nome verdadeiro
        When acesso a página "Minha conta"
        And informo um nome
        And atualizo o usuário
        Then o sistema exibe a mensagem de sucesso na tela "Nome verdadeiro atualizado com sucesso"
    #BUG: Como é a tela de alteração de senha, deveria não permitir a atualização
    #pois nem todos os campos foram preenchidos.

    @automatizado
    Scenario: Verificar se está na sub página Perfís
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        Then valido se estou na sub página "Perfís"

    @automatizado
    Scenario Outline: Adicionar perfís com sucesso
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And preencho as informações de perfil <Plataforma> <SO> <VSO>
        And adiciono o perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"

        Examples:
            | Plataforma | SO  | VSO  |
            | PL1        | SO1 | VSO1 |
            | PL2        | SO2 | VSO2 |
            | PL3        | SO3 | VSO3 |
            | PL4        | SO4 | VSO4 |
            | PL5        | SO5 | VSO5 |
            | PL6        | SO6 | VSO6 |

    @automatizado
    Scenario: Editar perfil com descrição adicional
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono o perfil para editar
        And incluo descrição
        And atualizo o perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"

    @automatizado
    Scenario: Editar perfil sem descrição adicional
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono o perfil para editar
        And atualizo o perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"

    @automatizado
    Scenario: Editar perfil sem selecionar campos obrigatórios
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And envio dados do perfil
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR"

    @automatizado
    Scenario: Editar perfil sem selecionar o perfil
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono "Editar Perfil"
        And envio dados do perfil
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR #11"

    @automatizado
    Scenario: Marcar um perfil como padrão
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono "Tornar Padrão"
        And seleciono o perfil
        And envio dados do perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"

    @automatizado
    Scenario: Marcar um perfil como padrão sem selecionar o perfil
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono "Tornar Padrão"
        And envio dados do perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"
    #BUG: O sistema deveria não permitir essa configuração e apresentar uma mensagem de alerta.

    @automatizado
    Scenario: Apagar um perfil
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono "Apagar Perfil"
        And seleciono o perfil
        And envio dados do perfil
        Then o sistema apresenta uma tabela com o título "Alterar ou Apagar Perfís"

    @automatizado
    Scenario: Apagar um perfil sem selecionar o perfil
        When acesso a página "Minha conta"
        And acesso a opção "Perfís"
        And seleciono "Apagar Perfil"
        And envio dados do perfil
        Then o sistema apresenta uma mensagem de alerta na tela "APPLICATION ERROR #11"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub pagina Preferências
        When acesso a página "Minha conta"
        And acesso a opção "Preferências"
        Then valido se estou na sub página "Preferências"

    @automatizado 
    Scenario: Atualizar informações na sub página Preferências
        When acesso a página "Minha conta"
        And acesso a opção "Preferências"
        And atualizo preferências
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."

    @automatizado
    Scenario: Redefinir informações na sub página Preferências
        When acesso a página "Minha conta"
        And acesso a opção "Preferências"
        And redefino preferências
        Then valido se estou na sub página "Preferências"

    @automatizado
    Scenario: Verificar se foi direcionado para a sub pagina Gerenciar Colunas
        When acesso a página "Minha conta"
        And acesso a opção "Gerenciar Colunas"
        Then valido se estou na sub página "Gerenciar Colunas"

    @automatizado
    Scenario: Atualizar informações da sub página Gerenciar Colunas
        When acesso a página "Minha conta"
        And acesso a opção "Gerenciar Colunas"
        When atualizo colunas
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."

    @automatizado
    Scenario: Selecionar a opção 'copiar colunas de' da sub página Gerenciar Colunas
        When acesso a página "Minha conta"
        And acesso a opção "Gerenciar Colunas"
        And seleciono "Copiar Colunas De"
        Then valido se estou na sub página "Gerenciar Colunas"

    @automatizado
    Scenario: Selecionar a opção 'copiar colunas para' da sub página Gerenciar Colunas
        When acesso a página "Minha conta"
        And acesso a opção "Gerenciar Colunas"
        And seleciono "Copiar Colunas Para"
        Then valido se estou na sub página "Gerenciar Colunas"

    @automatizado
    Scenario: Reinicializar informações da sub página Gerenciar Colunas
        When acesso a página "Minha conta"
        And acesso a opção "Gerenciar Colunas"
        And reinicializo colunas
        Then o sistema exibe a mensagem de sucesso na tela "Operação realizada com sucesso."

    @automatizado
    Scenario: Verificar se foi direcionado para a sub pagina Tokens API
        When acesso a página "Minha conta"
        And acesso a opção "Tokens API"
        Then valido se estou na sub página "Tokens API"