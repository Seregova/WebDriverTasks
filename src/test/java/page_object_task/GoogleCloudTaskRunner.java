package page_object_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GoogleCloudTaskRunner {
    public static void main(String[] args) {
        System.setProperty("ChromeDriver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(ConstantUrl.URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            GoogleCloudPageObject googleCloudPageObject = PageFactory.initElements(driver, GoogleCloudPageObject.class);
            googleCloudPageObject.selectPricingTab();
            googleCloudPageObject.selectCalculatorsTab();

            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            driver.switchTo().frame(0);
            driver.switchTo().frame("myFrame");

            IframePageObject iframePageObject = PageFactory.initElements(driver, IframePageObject.class);
            iframePageObject.setNumberOfInstances();
            iframePageObject.selectMachineType();
            iframePageObject.selectCheckBoxAddGpu();
            iframePageObject.selectGpuNumber();
            iframePageObject.selectGpuType();
            iframePageObject.selectSsdType();
            iframePageObject.selectLocation();
            iframePageObject.selectUsage();
            iframePageObject.addToEstimate();

           VerificationTests verificationTests = new VerificationTests();
           verificationTests.vmClassValueTest(driver);
           verificationTests.instanceValueTypeTest(driver);
           verificationTests.instanceValueTypeTest(driver);
           verificationTests.regionValueTest(driver);
           verificationTests.localSsdValueTest(driver);
           verificationTests.commitmentTermValueTest(driver);
           verificationTests.totalPriceTest(driver);

            iframePageObject.sendEmail();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get(ConstantUrl.EMAILURL);


            TenMinutesEmailPageObject tenMinutesEmailPageObject = PageFactory.initElements(driver, TenMinutesEmailPageObject.class);
            String copiedEmailFrom10Minutes = tenMinutesEmailPageObject.copyEmailAddress();

            driver.switchTo().window(tabs.get(0));

            IframeEnter iframeEnter = new IframeEnter();
            iframeEnter.goToIframe(driver);

            iframePageObject.setCopiedEmail(copiedEmailFrom10Minutes);
            iframePageObject.sendEmailToAddress();

            driver.switchTo().window(tabs.get(1));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            tenMinutesEmailPageObject.readLetterFromInbox();

            EmailPriceVerificationTest emailPriceVerificationTest = new EmailPriceVerificationTest();
            emailPriceVerificationTest.emailPriceTest(driver);

        } finally {
            driver.quit();
        }
    }
}

