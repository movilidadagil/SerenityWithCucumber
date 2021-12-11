
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
       // tags = "@favs",
        tags ="@votes",
       // tags="@postcodes",
       // tags="@wiki",
        features = "src/test/resources/features"
)
public class CucumberTestSuite {}
