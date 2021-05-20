package br.com.desafiobase2.hooks;

import br.com.desafiobase2.enums.DadosUsuarioMantis;
import br.com.desafiobase2.types.UsuarioMantis;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MantisHook {

    @Before(order = 2, value = "@login-valido, @automatizado, @teste")
    public void dadosUsuarioMantis() throws IOException {
        try {
            UsuarioMantis usuarioMantis = UsuarioMantis.get("src/test/resources/json/DadosUsuarioMantis.json");
            Serenity.setSessionVariable(DadosUsuarioMantis.USUARIO_MANTIS).to(usuarioMantis);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Não foi possível ler o arquivo de json." + ex);
        }
    }

    @After
    public void after() throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
    }
}