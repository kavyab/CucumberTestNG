package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepDefs"},
        dryRun = false,
        monochrome = true, 
        plugin = {"html:target/cucumber-reports/TestResults_html.html",
        		"json:target/cucumber-reports/TestResults_json.json",
        		"junit:target/cucumber-reports/TestResults_xml.xml"},        		        		       
        tags = "@positive_flow"
)


public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}