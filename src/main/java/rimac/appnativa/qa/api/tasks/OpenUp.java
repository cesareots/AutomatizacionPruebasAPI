package rimac.appnativa.qa.api.tasks;

import rimac.appnativa.qa.api.userinterface.ChoucairAcademyPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUp implements Task {

    private ChoucairAcademyPage choucairAcademyPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(choucairAcademyPage));
    }

    public static OpenUp thePage() {
        return Tasks.instrumented(OpenUp.class);
    }
}
