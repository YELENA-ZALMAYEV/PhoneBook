package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SIGN OUT present --->logout
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com","@1234567Qq@");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
       // Assert.assertFalse(app.getHelperUser().isLogged());

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com", "@1234567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public  void  loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("papgmail.com","@1234567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public  void  LoginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com","@1234567q@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public  void  loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qqap@gmail.com","qqq34567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }





}