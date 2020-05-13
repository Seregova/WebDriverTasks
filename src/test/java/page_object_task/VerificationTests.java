package page_object_task;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class VerificationTests {
    @Test
    @DisplayName("Comparing if the VM class was chosen 'regular'")
    public void vmClassValueTest(WebDriver driver){

        WebElement vmClass = driver.findElement(By.xpath("//div[contains (text(), 'VM class: regular')]"));
        String vmClassValue = vmClass.getText();
        String expectedVmClassValue = "VM class: regular";
        assertEquals(expectedVmClassValue, vmClassValue);
    }
    @Test
    public void instanceValueTypeTest(WebDriver driver) {
        WebElement instanceType = driver.findElement(By.xpath("//div[contains (text(), 'Instance type: n1-standard-8')]"));
        String instanceTypeValue = instanceType.getText();
        String expectedInstanceTypeValue = "Instance type: n1-standard-8";
        assertEquals(expectedInstanceTypeValue, instanceTypeValue);
    }
    @Test
    public void regionValueTest(WebDriver driver) {
        WebElement region = driver.findElement(By.xpath("//div[contains (text(), 'Region: Frankfurt')]"));
        String regionValue = region.getText();
        String expectedRegionValue = "Region: Frankfurt";
        assertEquals(expectedRegionValue, regionValue);
    }

    @Test
    public void localSsdValueTest(WebDriver driver) {
        WebElement localSsd = driver.findElement(By.xpath("//div[contains (text(), 'Total available local SSD space 2x375 GiB')]"));
        String localSsdValue = localSsd.getText();
        String expectedLocalSsdValue = "Total available local SSD space 2x375 GiB";
        assertEquals(expectedLocalSsdValue, localSsdValue);
    }
    @Test
    public void commitmentTermValueTest(WebDriver driver) {
        WebElement commitmentTerm = driver.findElement(By.xpath("//div[contains (text(), 'Commitment term: 1 Year')]"));
        String commitmentTermValue = commitmentTerm.getText();
        String expectedCommitmentTermValue = "Commitment term: 1 Year";
        assertEquals(expectedCommitmentTermValue, commitmentTermValue);
    }

    @Test
    @DisplayName("Total Price calculations and comparing it to manual count")
    public void totalPriceTest(WebDriver driver){
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b"));
        String totalPricePerMonth = totalPrice.getText();
        String manualPriceCount = "Total Estimated Cost: USD 1,082.77 per 1 month";
        assertEquals(manualPriceCount, totalPricePerMonth);
    }
}