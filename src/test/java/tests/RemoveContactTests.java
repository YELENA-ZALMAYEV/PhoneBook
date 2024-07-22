package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;

import static tests.TestBase.app;

public class RemoveContactTests extends TestBase{

    @BeforeClass
    public  void preConditions(){
        if(!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@"));
        }
     //   app.getHelperContact().provedContact();
    }
    @Test
    public void removeFirstContact(){
        app.getHelperContact().openContacts();
        app.getHelperContact().click(By.cssSelector("div[class='contact-page_leftdiv__yhyke'] div div:nth-child(1)"));
        app.getHelperContact().isConAddedByMame("Asenia");
        app.getHelperContact().clickOnButtonRemove();
        //Assert list.size less by one

    }
    @Test
    public  void removeAllContacts(){
        //Assert "No contacts here!"
    }
}
