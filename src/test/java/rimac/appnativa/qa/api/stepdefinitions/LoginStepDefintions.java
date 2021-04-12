package rimac.appnativa.qa.api.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import rimac.appnativa.qa.api.model.DataDriven;
import rimac.appnativa.qa.api.model.JsonRequest;
import rimac.appnativa.qa.api.tasks.OpenUp;
import rimac.appnativa.qa.api.util.Constantes;
import rimac.appnativa.qa.api.util.Util;

public class LoginStepDefintions {

    private Util util = Util.getInstancia();
    private DataDriven dataDriven;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^usuario establece sus datos \"([^\"]*)\"$")
    public void usuarioEstableceSusDatos(String codigo) {
        dataDriven = util.getData(codigo);
        JsonRequest jsonRequest = new JsonRequest(Constantes.endpoint001);
        String password = util.encryptSHA384(dataDriven.getListEndPoint().get(0));
        //OnStage.theActorCalled("cesareo").wasAbleTo(OpenUp.thePage());
    }

    @When("^ingreso al app$")
    public void aaa() {
    }

    @Then("^verifico estatus code$")
    public void bbb() {
    }
}
