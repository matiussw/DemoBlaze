package co.com.tuya.certifications.demoblazetuya.tasks;


import co.com.tuya.certifications.demoblazetuya.iteractions.Wait;
import co.com.tuya.certifications.demoblazetuya.userinterfaces.DemoBlazeHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SelectLaptops implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DemoBlazeHome.BUTTON_LAPTOP),
                Wait.theSeconds(5)
        );
    }

    public static SelectLaptops selectLaptops() {
        return Tasks.instrumented(SelectLaptops.class);

    }
}
