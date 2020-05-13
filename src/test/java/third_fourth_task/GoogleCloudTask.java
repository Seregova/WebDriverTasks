package third_fourth_task;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object_task.VerificationTests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleCloudTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        WebElement pricingTab = driver.findElement(By.xpath("//*[contains(text(),'Pricing')]"));
        pricingTab.click();

        WebElement calculatorsTab = driver.findElement(By.xpath("/html/body/section/devsite-header/div/div[1]/div/div/div[2]/div[1]/cloudx-tabs-nav/div/tab[4]/div/div/div[2]/ul/li[4]/a/div[1]"));
        calculatorsTab.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        int size = driver.findElements(By.tagName("iframe")).size();
        if (size > 0) {
            driver.switchTo().frame(0);
            size = driver.findElements(By.tagName("iframe")).size();

            if (size > 0) {
                driver.switchTo().frame(0);
                int total = driver.findElements(By.id("input_58")).size();

                if (total > 0) {
                    WebElement instancesToInput = driver.findElement(By.id("input_58"));
                    String inputInstances = "4";
                    instancesToInput.sendKeys(inputInstances);

                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    WebElement element = driver.findElement(By.id("select_83"));
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("arguments[0].click();", element);


                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    jse.executeScript("document.getElementById('select_option_212').click();");

                    jse.executeScript("document.querySelector('#mainForm > div:nth-child(3) > div > md-card > md-card-content > div > div:nth-child(1) > form > div:nth-child(10) > div.layout-column.flex-gt-sm-90.flex-80 > md-input-container > md-checkbox').click();");

                    jse.executeScript("document.getElementById('select_334').click();");


                    jse.executeScript("document.querySelector('#select_option_339').click();");

                    jse.executeScript("document.getElementById('select_336').click();");
//gpu type
                    jse.executeScript("document.querySelector('#select_option_346').click();");

//ssd
                    jse.executeScript("document.getElementById('select_170').click();");

                    jse.executeScript("document.querySelector('#select_option_233').click();");

//location
                    jse.executeScript("document.getElementById('select_85').click();");

                    jse.executeScript("document.querySelector('#select_option_181').click();");
                    //1 year

                    jse.executeScript("document.getElementById('select_92').click();");

                    jse.executeScript("document.querySelector('#select_option_90').click();");
//button
                    jse.executeScript("document.querySelector('#mainForm > div:nth-child(3) > div > md-card > md-card-content > div > div:nth-child(1) > form > div.layout-align-end-start.layout-row > button').click();");

//                    //Comparing the form with values
//                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                    WebElement vmClass = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]/div"));
//                    String vmClassValue = vmClass.getText();
//                    String expectedVmClassValue = "VM class: regular";
//                    assertEquals(expectedVmClassValue, vmClassValue);
//
//                    WebElement instanceType = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[3]/div"));
//                    String instanceTypeValue = instanceType.getText();
//                    String expectedInstanceTypeValue = "Instance type: n1-standard-8";
//                    assertEquals(expectedInstanceTypeValue, instanceTypeValue);
//
//                    WebElement region = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[4]/div"));
//                    String regionValue = region.getText();
//                    String expectedRegionValue = "Region: Frankfurt";
//                    assertEquals(expectedRegionValue, regionValue);
//
//                    WebElement localSsd = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[5]/div"));
//                    String localSsdValue = localSsd.getText();
//                    String expectedLocalSsdValue = "Total available local SSD space 2x375 GiB";
//                    assertEquals(expectedLocalSsdValue, localSsdValue);
//
//                    WebElement commitmentTerm = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[6]/div"));
//                    String commitmentTermValue = commitmentTerm.getText();
//                    String expectedCommitmentTermValue = "Commitment term: 1 Year";
//                    assertEquals(expectedCommitmentTermValue, commitmentTermValue);
//
//                    //Total Price calculations and comparing it to manual count
//                    WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b"));
//                    String totalPricePerMonth = totalPrice.getText();
//                    String manualPriceCount = "Total Estimated Cost: USD 1,082.77 per 1 month";
//                    assertEquals(manualPriceCount, totalPricePerMonth)assertEquals;

                    //Email block from 4th task

                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    jse.executeScript("document.getElementById('email_quote').click();");


                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    jse.executeScript("window.open();");

                    ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
                    driver.switchTo().window(tabs.get(1));
                    driver.get("https://10minutemail.com/");


                    WebElement copyAddress = driver.findElement(By.id("mail_address"));
                    String address = copyAddress.getAttribute("value");

                    driver.switchTo().window(tabs.get(0));


                    goToIframe(driver);
                    WebElement emailToInput = driver.findElement(By.id("input_401"));
                    emailToInput.sendKeys(address);

                    jse.executeScript("document.querySelector('#dialogContent_407 > form > md-dialog-actions > button.md-raised.md-primary.cpc-button.md-button.md-ink-ripple').click();");



                    driver.switchTo().window(tabs.get(1));

                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    jse.executeScript("document.querySelector('#mail_messages_content > div > div.message_top').click();");



                    WebElement priceInEmail = driver.findElement(By.xpath("//*[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3"));

                    String priceInEmailValue = priceInEmail.getText();
                    Assert.assertEquals("Price is not correct!", "USD 1,082.77",priceInEmailValue );
                }
            }
        }
        driver.quit();
    }
    private static void goToIframe(WebDriver driver) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }
}