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
                .withEmail("lola"+i+"@gmail.com")
                .withPassword("qaQA123$%^");
        logger.info("Tests run with data: --->"+user.toString());

        app.getHelperUser().openLoginRegistrationForm();
        logger.info("openLoginRegistrationForm invoked");
        app.getHelperUser().fillLoginRegistrationForm(user);
        logger.info("fillLoginRegistrationForm invoked");
        app.getHelperUser().submitRegist();
        logger.info("submitRegist invoked");
      Assert.assertTrue(app.getHelperUser().isLogged());
      Assert.assertTrue(app.getHelperUser().displayWindow());

    }

    @Test //(description = *Bug report *23456 Fixed*)
    public  void RegistrationWrongEmail( ){
        User user = new User().withEmail("lolagmail.com").withPassword("qaQA123$%^");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegist();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test //(description = *Bug report *23456 Fixed*)
    public  void RegistrationWrongPassword( ) {
        User user = new User().withEmail("lola@gmail.com").withPassword("q123$%^");
        logger.info("Tests run with data: --->" + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegist();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test //(description = *Bug report *23456 Fixed*)
    public  void RegistrationExUser( ){
        User user = new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegist();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }
}
