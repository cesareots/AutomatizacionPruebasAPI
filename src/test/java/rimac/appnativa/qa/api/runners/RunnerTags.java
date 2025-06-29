package rimac.appnativa.qa.api.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        tags = {"@LoginOk"},
        glue = {"rimac.appnativa.qa.api.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class RunnerTags {

}
