package cucumber_runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.RemoteWebDriverHelper;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources/features/", glue = "steps_definition", plugin = {"pretty", "html:target/cucumber"})
public class TestCucumber {
	
	@AfterClass
	public static void tearDown() {
		RemoteWebDriverHelper.close();
	}
}
