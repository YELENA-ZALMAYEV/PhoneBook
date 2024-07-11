package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        // xpath = //*a[text()='LOGIN']
//
//        loginTab.click();

        click(By.cssSelector("a[href='/login']"));

    }


    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput=wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);


//        WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));//type
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        type(By.xpath("//input[last()]"), password);

    }

    public void fillLoginRegistrationForm(User user){
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isRegist() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public  void  submitRegist(){
        click(By.xpath("//button[text()='Registration']"));
    }

//    public void fillRegistrationForm() {
//        type(By.name("email"), email);
//        type(By.name("password"), password);
//
//    }

}
