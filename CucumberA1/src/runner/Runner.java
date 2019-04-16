package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Srihari\\BDD\\Cucumber4\\scenario-feature\\BOIFeature.Feature"}
		,glue="stepdef1"
		,plugin= {"pretty", "html:target/srihari-report"}
		,monochrome=true
		,dryRun=true
		)


public class Runner {

}
