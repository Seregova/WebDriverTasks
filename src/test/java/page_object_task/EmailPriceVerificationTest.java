package page_object_task;

import org.junit.Assert;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPriceVerificationTest {
    @Test
    @DisplayName("Comparing price from email with manually calculated")
    public void emailPriceTest(WebDriver driver) {
        WebElement priceInEmail = driver.findElement(By.xpath("//tr[@id=\"mobilepadding\"]/td/table/tbody/tr[2]/td[2]/h3"));
        String priceInEmailValue = priceInEmail.getText();
        Assert.assertEquals("Price is not correct!", "USD 1,082.77", priceInEmailValue);
    }
}
