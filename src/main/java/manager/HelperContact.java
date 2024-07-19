package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends  HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.xpath("//*[.='ADD']"));
    }

    public void fillAddingContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), String.valueOf(contact.getPhone()));
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }
    public void submitAddingContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean ContactIsExists(){
        return isElementPresent(By.cssSelector(".contact-item_card__2SOIM"));
    }
}
