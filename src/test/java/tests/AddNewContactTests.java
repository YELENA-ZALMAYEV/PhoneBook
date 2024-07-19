package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static tests.TestBase.app;

public class AddNewContactTests extends TestBase{

@BeforeClass
     public  void preConditions(){
        if(app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@"));

        }
    }

       @Test
public  void  addContSuccessAllFields(){
     //   int i = new Random().nextInt(100)+1000;
        int i = (int) (System.currentTimeMillis() / 1000)% 3600;
        Contact contact = Contact.builder()
                .name("senia")
                .lastName("oroz"+i)
                .phone("1234567891"+i)
                .email("wer"+i+"@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
           Assert.assertTrue(app.getHelperContact().isConAddedByMame(contact.getName()));
           Assert.assertTrue(app.getHelperContact().isConAddedByPhone(contact.getPhone()));

    }

    @Test
    public  void  addContSuccessAllReqField(){
        int i = new Random().nextInt(100)+1000;

        Contact contact = Contact.builder()
                .name("senia")
                .lastName("oroz")
                .phone("1234457891"+i )
                .email("wer"+i+"@Gmail.com")
                .address("Tel Aviv")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isConAddedByMame(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isConAddedByPhone(contact.getPhone()));
    }

    //NegativeTest
    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name("")
                .lastName("oroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();

        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("senia")
                .lastName("")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
    }
    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("senia")
                .lastName("oroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
    }
    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("senia")
                .lastName("oroz")
                .phone("")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("senia")
                .lastName("oroz")
                .phone("1234567891")
                .email("werGmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));


    }
}
