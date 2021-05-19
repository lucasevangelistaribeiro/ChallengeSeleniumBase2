package br.com.desafiobase2.tests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Criar_nova_tarefa_mantis.feature", glue = {
        "classpath:br.com.desafiobase2.stepdefinitions",
        "classpath:br.com.desafiobase2.test",
        "classpath:br.com.desafiobase2.hooks" })

public class CriarNovaTarefaMantisTest {
}
