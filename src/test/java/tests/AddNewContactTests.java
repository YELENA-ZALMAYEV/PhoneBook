package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preConditions(){
        if(app.getHelperContact().isLogged())
            app.getHelperContact().login(new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@"));
            app.getHelperContact().openAddContactForm();
    }

    @Test
    public void addNewContactTest(){
        int i = new Random().nextInt(100)+1000;

        Contact contact = Contact.builder()
                .name("Ksenia")
                .lastName("Moroz")
                .phone(1234567891)
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("sern")
                .build();

        app.getHelperContact().submitAddingContactForm();
        app.getHelperContact().fillAddingContactForm(contact);
        app.getHelperContact().submitAddingContactForm();
    }
}
