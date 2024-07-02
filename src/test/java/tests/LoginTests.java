package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test

    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com","@1234567Qq@");
        app.getHelperUser().submitLogin();

    }


}