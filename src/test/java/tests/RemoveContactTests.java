package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class RemoveContactTests {

    @BeforeClass
    public  void preConditions(){
        if(app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@"));

        }
     //   app.getHelperContact().provedContact();
    }
    @Test
    public void removeFirstContact(){
        //Assert list.size less by one

    }
    @Test
    public  void removeAllContacts(){
        //Assert "No contacts here!"
    }
}
