package testrunner;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", tags = "@regression", monochrome = true, plugin = {
      //  "com.cucumber.listener.ExtentCucumberFormatter",
        "pretty", "html:target/cucumber-report/runwebat",
        "json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},
        glue = "cred")
public class RunCucumberTestSuite {

}
