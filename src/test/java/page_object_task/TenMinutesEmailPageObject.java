package page_object_task;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TenMinutesEmailPageObject {
    WebDriver driver;
    JavascriptExecutor executor;
    @FindBy(how = How.ID, using = "mail_address")
    WebElement copyAddress;
    @FindBy(how = How.XPATH, using = "//*[@class='message_top']")
    WebElement inbox;

    public TenMinutesEmailPageObject(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }
    public String copyEmailAddress() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String address = copyAddress.getAttribute("value");
        return address;
    }
    public void readLetterFromInbox() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", inbox);
    }
}