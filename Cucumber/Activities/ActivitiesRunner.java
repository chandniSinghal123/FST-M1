package stepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = { "stepDefinitions.Activity5" },
        tags="@activity5",
        plugin={"pretty"},
        plugin = {"html: test-reports"},
        plugin = {"json: test-reports/json-report.json"},
        monochrome = true
)

public class ActivitiesRunner {
    // empty
}