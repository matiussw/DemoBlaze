package co.com.tuya.certifications.demoblazetuya.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoBlazeHome {

    public static final Target LOGIN_INPUT = Target
            .the("Login")
            .locatedBy("//a[@id='login2']");
    public static final Target USERNAME_LOGIN = Target
            .the("User login")
            .locatedBy("//input[@id='loginusername']");
    public static final Target PASSWORD_LOGIN = Target
            .the("Login password")
            .locatedBy("//input[@id='loginpassword']");
    public static final Target BUTTON_LOGIN = Target
            .the("Login button")
            .locatedBy("//button[@onclick='logIn()']");
    public static final Target BUTTON_LAPTOP = Target
            .the("Laptop")
            .locatedBy("//a[@onclick=\"byCat('notebook')\"]");
    public static final Target LAPTOP_PRODUCT = Target
            .the("Product Laptop")
            .locatedBy("(//img[@src=\"imgs/macbook_air.jpg\"])[2]");

    private DemoBlazeHome() {
    }
}
