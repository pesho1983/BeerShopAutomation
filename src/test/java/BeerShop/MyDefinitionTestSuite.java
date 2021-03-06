package BeerShop;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)


@CucumberOptions(features = "src/test/resources/features/consult_dictionary/UserProfile.feature",
  //      tags = "@tt",
        snippets = SnippetType.CAMELCASE)
public class MyDefinitionTestSuite {

}
