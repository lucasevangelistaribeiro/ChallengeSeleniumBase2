package br.com.desafiobase2.tests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Login_mantis.feature", glue = {
        "classpath:br.com.desafiobase2.stepdefinitions",
        "classpath:br.com.desafiobase2.test",
        "classpath:br.com.desafiobase2.hooks" })

public class LoginMantisTest {
}
