package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HelperContact extends  HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
      //  click(By.xpath("//*[.='ADD']"));
        pause(5);
        //click(By.cssSelector("a[href='/add']"));
        click(By.xpath("//*[.='ADD']"));
    }

    public void fillAddingContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

        //cw
//        type(By.cssSelector("[placeholder='Name']"), contact.getName());
//        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
//        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
//        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
//        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
//        type(By.cssSelector("[placeholder='description']"), contact.getDescription());


    }
    public void saveAddingContactForm() {
        click(By.cssSelector(".add_form__2rsm2>button"));
      //  click(By.cssSelector("//button/b[text()='Save']"));
       // click(By.xpath("//button[.='Save']"));
    }

  //  public boolean ContactIsExists(){
  //      return isElementPresent(By.cssSelector(".contact-item_card__2SOIM"));
  //  }

    public boolean isConAddedByMame(String name) {//check all with name
     List<WebElement> list = wd.findElements(By.cssSelector("h2"));
     for (WebElement element : list){
         if(element.getText().equals(name)){
             return true;
         }
     }
     return false;
    }


    public boolean isConAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement element : list){
            if(element.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillOnDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void openContacts() {
        click(By.cssSelector("a[href='/contacts']"));
    }

    public void clickOnButtonRemove() {
        click(By.xpath("//button[normalize-space()='Remove']"));
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of Contacts before remove is --->" + before);
        removeContact(); 
        int after = countOfContacts();
        logger.info("Number of Contacts after remove is --->" + after);
        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(10);
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size(); 
    }

    public void removeAllContacts() {
        while (countOfContacts()!=0){
            removeContact();
        }
    }
    public void provideContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                addOneContact();

            }
        }

    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Harry"+i)
                .lastName("Potter")
                .email("harry"+i+"@gmail.com")
                .address("Hogwards")
                .phone("55566777"+i)
                .description("Friend")
                .build();

        openAddContactForm();
        fillAddingContactForm(contact);
        saveAddingContactForm();
        pause(5);
    }
}


