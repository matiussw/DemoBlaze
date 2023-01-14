package co.com.tuya.certifications.demoblazetuya.stepdefinitions;

import co.com.tuya.certifications.demoblazetuya.questions.ValidationPage;
import co.com.tuya.certifications.demoblazetuya.questions.VerifyCategory;
import co.com.tuya.certifications.demoblazetuya.tasks.SelectLaptops;
import co.com.tuya.certifications.demoblazetuya.tasks.SelectProduct;
import co.com.tuya.certifications.demoblazetuya.tasks.UserLogged;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserSeeLaptopsStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver hisdriver;

    @Before
    public void setThestage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Dado("^el usuario se encuetra en la pagina principal de \"([^\"]*)\"$")
    public void elUsuarioSeEncuetraEnLaPaginaPrincipalDe(String url) {
        theActorInTheSpotlight().wasAbleTo(Open.url(url));
    }

    @Cuando("^el usuario da clic en el boton Laptops$")
    public void elUsuarioDaClicEnElBotonLaptops() {
        theActorInTheSpotlight().attemptsTo(SelectLaptops.selectLaptops());
    }

    @Entonces("^el sistema muestra los productos filtrados por Laptos$")
    public void elSistemaMuestraLosProductosFiltradosPorLaptos() {
        theActorInTheSpotlight().should(seeThat(VerifyCategory.verifyCategory()));
    }

    @Cuando("^el usuario se loguea  y da clic en el boton  Laptops y selecciona un producto$")
    public void elUsuarioSeLogueaYDaClicEnElBotonLaptopsYSeleccionaUnProducto(List<Map<String, String>> userAllFields) {
        theActorInTheSpotlight().attemptsTo(UserLogged.withDataFrom(userAllFields),
                SelectProduct.selectProduct());
    }

    @Entonces("^el sistema debera carga el producto seleccionado y debera aparecer el boton \"([^\"]*)\"$")
    public void elSistemaDeberaCargaElProductoSeleccionadoYDeberaAparecerElBoton(String message) {
        theActorInTheSpotlight().should(seeThat(ValidationPage.inTheScreen(), Matchers.is(message)));
    }
}
