package co.com.tuya.certifications.demoblazetuya.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoBlazeProductPage {

    public static final Target BUTTON_ADD_CART = Target
            .the("Button Add Cart")
            .locatedBy("//a[contains(text(),'Add to cart')]");

    private DemoBlazeProductPage() {
    }
}

