package rimac.appnativa.qa.api.stepdefinitions;

import rimac.appnativa.qa.api.tasks.OpenUp;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ChoucairAcademyStepDefintions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^cesareo quiere aprender a automatizar con screenplay$")
    public void cesareoQuiereAprenderAAutomatizarConScreenplay() {
        OnStage.theActorCalled("cesareo").wasAbleTo(OpenUp.thePage());
    }

    @When("^busca el curso Recursos Automatizacion Bancolombia$")
    public void buscaElCursoRecursosAutomatizacionBancolombia() {
    }

    @Then("^verifica titulo de pagina Recursos Automatizacion Bancolombia$")
    public void verificaTituloDePaginaRecursosAutomatizacionBancolombia() {
    }
}
