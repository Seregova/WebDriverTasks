package second_task;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewSheriffInTownTask {

        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://pastebin.com/");

            WebElement codeToInput = driver.findElement(By.id("paste_code"));
            String inputCode = "git config --global user.name \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} \"Legacy code\")\n"  +
                    "git push origin master --force";
            codeToInput.sendKeys(inputCode);

            Select expirationInput = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[2]/div[2]/select")));
            expirationInput.selectByVisibleText("10 Minutes");

            Select syntax = new Select(driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[1]/div[2]/select")));
            syntax.selectByVisibleText("Bash");

            WebElement nameToInput = driver.findElement(By.xpath("//*[@id=\"myform\"]/div[3]/div[5]/div[2]/input"));
            String inputName = "how to gain dominance";
            nameToInput.sendKeys(inputName);

            WebElement buttonCreateNewPaste = driver.findElement(By.id("submit"));
            buttonCreateNewPaste.submit();

            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
            WebElement codeOutput = driver.findElement(By.id("paste_code"));
            String outputCode = codeOutput.getText();
            Assert.assertEquals(inputCode, outputCode);

            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content_left\"]/div[2]/div[3]/div[1]/h1")));
            WebElement nameOutput = driver.findElement(By.xpath("//*[@id=\"content_left\"]/div[2]/div[3]/div[1]/h1"));
            String outputName = nameOutput.getText();
            Assert.assertEquals(inputName, outputName);

            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"code_buttons\"]/span[2]/a")));
            WebElement highlighting = driver.findElement(By.xpath("//*[@id=\"code_buttons\"]/span[2]/a"));
            String highlightName = highlighting.getText();
            Assert.assertEquals("Bash", highlightName);

            driver.quit();
        }
}