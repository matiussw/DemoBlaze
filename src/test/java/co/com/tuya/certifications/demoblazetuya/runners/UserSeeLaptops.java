package co.com.tuya.certifications.demoblazetuya.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/precios_laptops.feature",
        glue = "co.com.tuya.certifications.demoblazetuya.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class UserSeeLaptops {
}
