package BeerShop;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/consult_dictionary/PasswordChangeDefinition.feature",
        snippets = SnippetType.CAMELCASE)
public class DefinitionTestSuiteKalin {}

