package manager;

import com.google.common.io.Files;
import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public  void  login(String email, String password) {
        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.name("login")).click();

    }

    public  void  type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if(text!=null) {
            element.sendKeys(text);
        }
    }

    private void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public  void  click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public  boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return  list.size()>0;
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        if (alert!= null&&alert.getText().contains(message)){
            System.out.println(alert.getText());
            pause(50);
            alert.accept();
            return true;
        }
        //click ok --->alert.accept();
        //click cancel ---> alert.dismis();
        //type into alert ---> alert.sendKeys("hello");

        return false;
    }

    public  void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(User user) {
        wd.findElement(By.name("email")).sendKeys(user.getEmail());
        wd.findElement(By.name("password")).sendKeys(user.getPassword());
        wd.findElement(By.name("login")).click();

    }

    public void refresh(){
        wd.navigate().refresh();
    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}