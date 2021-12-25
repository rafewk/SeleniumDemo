package pl.testeroprogramowania;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/pl.testeroprogramowania/register_user.feature")
public class RunCucumberTests {
}
