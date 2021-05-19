package br.com.desafiobase2.hooks;

import br.com.desafiobase2.steps.LoginSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

public class GeneralHooks {
    @Steps
    LoginSteps loginSteps;

    @Before
    public void beforeScenario(){
        //código a ser executado antes de cada cenário
        loginSteps.abrirMantis();
    }

    @After
    public void afterScenario(){
        //código a ser executado depois de cada cenário
    }
}
