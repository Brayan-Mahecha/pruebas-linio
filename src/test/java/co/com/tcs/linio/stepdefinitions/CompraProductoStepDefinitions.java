package co.com.tcs.linio.stepdefinitions;


import co.com.tcs.linio.questions.Themensaje;
import co.com.tcs.linio.questions.visualizaProductos;
import co.com.tcs.linio.tasks.eliminate;
import co.com.tcs.linio.tasks.seleccionar;
import co.com.tcs.linio.userinterface.LinioPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraProductoStepDefinitions {

    LinioPage page;


// configuracion inicial creacion escenario
    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Brayan");
    }


    @Given("^el usuario se encuentra en la pagina (.*)$")
    public void elUsuarioSeEncuentraEnLaPagina (String url) {
        theActorInTheSpotlight().wasAbleTo(Open.browserOn(page));
    }


    @When("^el usuario ingresa al menu hogar colchones base cama y almohadas y elije un producto$")
    public void elUsuarioIngresaAlMenuHogarColchonesBaseCamaYAlmohadasYElijeUnProducto() {
        theActorInTheSpotlight().attemptsTo(seleccionar.seleccionamosColchones());

    }

    @When("^el usuario elimina un producto del carrito$")
    public void elUsuarioEliminaUnProductoDelCarrito() {

        theActorInTheSpotlight().attemptsTo(eliminate.eliminamosProductos());
    }

    @Then("^el usuario visualiza los productos y el valor total$")
    public void elUsuarioVisualizaLosProductosYElValorTotal(String mensaje) {
        // theActorInTheSpotlight().should(GivenWhenThen.seeThat());
        theActorInTheSpotlight().should(seeThat(visualizaProductos.verColchones(),Matchers.equalTo(mensaje)));
    }

    @Then("^el usuario visualiza el mensaje (.*)$")
    public void elUsuarioVisualizaElMensaje(String mensaje) {
       // theActorInTheSpotlight().should(GivenWhenThen.seeThat());
        theActorInTheSpotlight().should(seeThat(Themensaje.isVisible(), Matchers.equalTo(mensaje)));
    }

}
