package co.com.tuya.certifications.demoblazetuya.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class VerifyCategory implements Question<Boolean> {

    private Boolean state;

    public VerifyCategory() {
        this.state = true;
    }

    public static VerifyCategory verifyCategory() {
        return new VerifyCategory();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return state;
    }
}
