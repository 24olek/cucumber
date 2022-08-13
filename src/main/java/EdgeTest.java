
import io.cucumber.java.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//To choose between chrome-cucumber feature and edge-cucumber feature change path in indicated place
// (adequatly edge-cucumber.feature and chrome-cucumber.feature
// 11 line of code, "@CucumberOptions(features = "src/cucumber/features/HERE===>edge-cucumber.feature<===HERE", plugin = {"pretty", "html:out.html"})"
@CucumberOptions(features = "src/cucumber/features/edge-cucumber.feature", plugin = {"pretty", "html:out.html"})
public class EdgeTest {

}
