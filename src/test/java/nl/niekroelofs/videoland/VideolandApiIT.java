package nl.niekroelofs.videoland;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "nl.niekroelofs.videoland.IT.steps",
        plugin = "plugin"
)
public class VideolandApiIT {
}
