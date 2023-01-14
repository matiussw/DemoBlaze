package co.com.tuya.certifications.demoblazetuya.tasks;

import co.com.tuya.certifications.demoblazetuya.iteractions.Wait;
import co.com.tuya.certifications.demoblazetuya.userinterfaces.DemoBlazeHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserLogged implements Task {
    private List<Map<String, String>> userFields;

    public UserLogged(List<Map<String, String>> userFields) {
        this.userFields = userFields;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.theSeconds(3),
                Click.on(DemoBlazeHome.LOGIN_INPUT),
                Wait.theSeconds(3),
                Enter.theValue(userFields.get(0).get("username")).into(DemoBlazeHome.USERNAME_LOGIN),
                Enter.theValue(userFields.get(0).get("password")).into(DemoBlazeHome.PASSWORD_LOGIN),
                Click.on(DemoBlazeHome.BUTTON_LOGIN)
        );
    }

    public static UserLogged withDataFrom(List<Map<String, String>> userFields) {
        return instrumented(UserLogged.class, userFields);
    }
}
