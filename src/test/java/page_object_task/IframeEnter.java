package page_object_task;

import org.openqa.selenium.WebDriver;


public class IframeEnter {
    public static void goToIframe(WebDriver driver) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }
}