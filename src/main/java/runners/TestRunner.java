package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\Assignment4.feature", glue = { "steps" }, plugin = { "pretty",
		"html:target/html", "json:target/json/cucumber.json" }, monochrome = true, dryRun = false)
public class TestRunner {

}

