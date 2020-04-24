package first_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HelloWebDriverTask {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://pastebin.com");
        WebElement titleInput = driver.findElement(By.id("paste_code"));
        titleInput.sendKeys("Hello from Webdriver");

        Select expirationInput = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[2]/div[2]/select")));
        expirationInput.selectByVisibleText("10 Minutes");

        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[5]/div[2]/input"));
        nameInput.sendKeys("helloweb");

        WebElement buttonCreateNewPaste = driver.findElement(By.id("submit"));
        buttonCreateNewPaste.click();

        //For visual checking in browser that everything was correctly executed
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}