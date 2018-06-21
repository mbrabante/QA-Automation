package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Feature/Catalog/Brand/CreateBrand.feature",
glue={"stepDefinition"}
)

public class TestRunner {

}
	