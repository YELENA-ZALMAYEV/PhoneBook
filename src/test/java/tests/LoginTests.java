package tests;

import models.User;
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
//        User user = new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@");
//        user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567Qq@'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com","@1234567Qq@"); //(new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
       // Assert.assertFalse(app.getHelperUser().isLogged());

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sing out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com", "@1234567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sing out' present");
    }

    @Test
    public  void  loginWrongEmail(){
        logger.info("Test data ---> email: 'papgmail.com' & password '@1234567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("papgmail.com","@1234567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public  void  LoginWrongPassword(){
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567q@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pap@gmail.com","@1234567q@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public  void  loginUnregisteredUser(){
        logger.info("Test data ---> email: 'qqap@gmail.com' & password 'qqq34567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qqap@gmail.com","qqq34567Qq@");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }





}