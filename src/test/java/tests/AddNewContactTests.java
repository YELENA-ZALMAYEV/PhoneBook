package tests;


import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Random;

import static tests.TestBase.app;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preConditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@"));
        }
    }

    //pause befor seve contact + disc (neme of test) + add method Newclear in HelperBase

//   @BeforeMethod
//   public void refresh(){ //for not adding error contact
//    if(app.getHelperContact().isAddPageStillOnDisplayed()){
//        app.getHelperContact().refresh();
//    }
//   }

    @Test(dataProvider = "addNewContactSuccess", dataProviderClass = DataProviderContact.class)
    public void addContSuccessAllFields(Contact contact) {
        //   int i = new Random().nextInt(100)+1000;
        //  int i = (int) (System.currentTimeMillis() / 1000)% 3600;
//
//           Contact contact = Contact.builder()
//                .name("Asenia")
//                .lastName("oroz"+i)
//                .phone("1234567891"+i)
//                .email("wer"+i+"@Gmail.com")
//                .address("Tel Aviv")
//                .description("all fields")
//                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //  app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isConAddedByMame(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isConAddedByPhone(contact.getPhone()));


    }

    @Test(dataProvider = "contactCSV", dataProviderClass = DataProviderContact.class)      //file data csv + DPContact
    public void addContSuccessAllFieldsCSV(Contact contact) {

        logger.info("Test-->" + contact.toString());
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isConAddedByMame(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isConAddedByPhone(contact.getPhone()));


    }

    @Test(dataProvider = "addContSuccessAllReqField", dataProviderClass = DataProviderContact.class)
    public void addContSuccessAllReqField(Contact contact) {
        //  int i = new Random().nextInt(100)+1000;

//        Contact contact = Contact.builder()
//                .name("Bsenia")
//                .lastName("oroz")
//                .phone("1234457891"+i )
//                .email("wer"+i+"@Gmail.com")
//                .address("Tel Aviv")
//                .build();
        logger.info(" Mathod add Contact Success All Req Field started");
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //   app.getHelperContact().pause(1500);
        //  app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png"); //randome for name
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isConAddedByMame(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isConAddedByPhone(contact.getPhone()));
        logger.info(" Mathod add Contact Success All Req Field finished");
    }

    //NegativeTest
    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Coroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //   app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();

        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        logger.info(" Mathod WrongName finished");
    }

    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder()
                .name("Dsenia")
                .lastName("")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //   app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        logger.info(" Mathod Wrong Last Name finished");
    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("Fsenia")
                .lastName("oroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //   app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
    }

    @Test(dataProvider = "wrongPhone", dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact) {
//        Contact contact = Contact.builder()
//                .name("Gsenia")
//                .lastName("oroz")
//                .phone("")
//                .email("wer@Gmail.com")
//                .address("Tel Aviv")
//                .description("wrong phone")
//                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //   app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addNewContactWrongEmail() { //bug
        Contact contact = Contact.builder()
                .name("Wsenia")
                .lastName("oroz")
                .phone("1234567891")
                .email("werGmail.com")
                .address("Tel Aviv")
                .description("new")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        //    app.getHelperContact().pause(1500);
        app.getHelperContact().saveAddingContactForm();
        Assert.assertTrue(app.getHelperContact().isAddPageStillOnDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));


    }

//    @DataProvider
//    public Iterator <Object[]> loginFile (){
//
//    }
//}
}
