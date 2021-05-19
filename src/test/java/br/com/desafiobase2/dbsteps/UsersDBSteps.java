package br.com.desafiobase2.dbsteps;

import br.com.desafiobase2.utils.DBUtils;
import br.com.desafiobase2.utils.GeneralUtils;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;

public class UsersDBSteps {

    private String sqlPath = "src/test/java/br/com/serenitybddtemplate/sqls/users/";

    @Step("Retorna senha do usuario '{0}'")
    public String retornaSenhaDoUsuarioDB(String usuario){
        String query = GeneralUtils.getFileContentAsString(sqlPath+"retornaSenhaDoUsuario.sql");
        query = query.replace("$usuario", usuario);

        return DBUtils.getQueryResult(query).get(0);
    }
}
