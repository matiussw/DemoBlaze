package co.com.tuya.certifications.demoblazetuya.questions;


import co.com.tuya.certifications.demoblazetuya.userinterfaces.DemoBlazeProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidationPage implements Question<String> {
    public String answeredBy(Actor actor) {
        return Text.of(DemoBlazeProductPage.BUTTON_ADD_CART).viewedBy(actor).asString();
    }

    public static ValidationPage inTheScreen() {
        return new ValidationPage();
    }
}
