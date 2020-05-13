package page_object_task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPageObject {
    @FindBy(xpath = "//*[contains(text(),'Pricing')]")
    WebElement pricingTab;
    @FindBy(xpath = "//a[@href='/products/calculator' and @track-name='pricing']")
    WebElement calculatorsTab;

public void selectPricingTab() {
        pricingTab.click();
    }
public void selectCalculatorsTab() {
        calculatorsTab.click();
    }
}
