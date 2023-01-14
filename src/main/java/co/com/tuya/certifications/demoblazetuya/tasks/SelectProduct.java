package co.com.tuya.certifications.demoblazetuya.tasks;

import co.com.tuya.certifications.demoblazetuya.iteractions.Wait;
import co.com.tuya.certifications.demoblazetuya.userinterfaces.DemoBlazeHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SelectProduct implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.theSeconds(3),
                Click.on(DemoBlazeHome.BUTTON_LAPTOP),
                Wait.theSeconds(3),
                Scroll.to(DemoBlazeHome.LAPTOP_PRODUCT),
                Click.on(DemoBlazeHome.LAPTOP_PRODUCT),
                Wait.theSeconds(3)
        );
    }

    public static SelectProduct selectProduct() {
        return Tasks.instrumented(SelectProduct.class);
    }
}
