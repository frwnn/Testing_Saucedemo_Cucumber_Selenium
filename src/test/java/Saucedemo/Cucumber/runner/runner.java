package Saucedemo.Cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Saucedemo/Cucumber/features",
        glue = "Saucedemo/Cucumber/stepdef",
        plugin = {"html:target/HTML_report.html"}
)
public class runner {
}
