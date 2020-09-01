package br.com.inmetrics.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/br/com/inmetrics/features/RegistrarTask.feature",
glue = "br.com.inmetrics.steps", monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false)
public class RunnerFuncionalTest {

}
