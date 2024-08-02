package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SIGN OUT present --->logout
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test (dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password){
//        User user = new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@");
//        user.setEmail("pap@gmail.com");
//        user.setPassword("@1234567Qq@");

        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567Qq@'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password); //(new User().setEmail("pap@gmail.com").setPassword("@1234567Qq@");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
       // Assert.assertFalse(app.getHelperUser().isLogged());

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sing out' present");
    }


    @Test (dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Start loginSuccessModelTest");
        logger.info("Test data ---> " + user.toString());

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sing out' present");
        logger.info("Finish login Success Model Test");
    }

    @Test (dataProvider = "loginsModels", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Start loginSuccessModelTest");
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sing out' present");
        logger.info("Finish login Success Model Test");
    }

    @Test (dataProvider = "loginWrongEmail", dataProviderClass = DataProviderUser.class)
    public  void  loginWrongEmail(User user) {
        logger.info("Test data ---> email: 'papgmail.com' & password '@1234567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test (dataProvider = "loginWrongPassword", dataProviderClass = DataProviderUser.class)
    public  void  LoginWrongPassword(User user){
        logger.info("Test data ---> email: 'pap@gmail.com' & password '@1234567q@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test (dataProvider = "loginUnregisteredUser", dataProviderClass = DataProviderUser.class)
    public  void  loginUnregisteredUser(User user){
        logger.info("Test data ---> email: 'qqap@gmail.com' & password 'qqq34567Qq@'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }





}