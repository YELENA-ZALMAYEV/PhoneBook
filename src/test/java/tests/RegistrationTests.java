package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public  void preCondition(){
        if (app.getHelperUser().isLogged()){
        app.getHelperUser().logout();
        }
    }

    @Test
    public  void RegistrationSuccess(){

        int i = (int) (System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withEmail("ghklk"+i+"@gmail.com")
                .withPassword("qaQA123$%^");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegist();
      Assert.assertTrue(app.getHelperUser().isRegist());

    }

}
