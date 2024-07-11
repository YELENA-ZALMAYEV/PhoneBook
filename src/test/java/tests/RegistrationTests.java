package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public  void preCondition(){
        if (app.getHelperUser().isRegistered()){
        app.getHelperUser().isLogged();
        }
    }

    @Test
    public  void registrationIsSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillRegistrationForm();
        app.getHelperUser().submitRegist();


    }

}
