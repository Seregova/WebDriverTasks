package page_object_task;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframePageObject {
    WebDriver driver;
    JavascriptExecutor executor;
    @FindBy(how = How.ID, using = "input_58")
    WebElement numberOfInstances;
    @FindBy(how = How.ID, using = "select_83")
    WebElement machineType;
    @FindBy(how = How.ID, using = "select_option_212")
    WebElement machineTypeOption;
    @FindBy(how = How.XPATH, using = "//md-checkbox[@aria-label=\"Add GPUs\"]")
    WebElement checkBoxAddGpu;
    @FindBy(how = How.ID, using = "select_value_label_332")
    WebElement gpuNumber;
    @FindBy(how = How.ID, using = "select_option_339")
    WebElement gpuNumberOption;
    @FindBy(how = How.ID, using = "select_value_label_333")
    WebElement gpuType;
    @FindBy(how = How.ID, using = "select_option_346")
    WebElement gpuTypeOption;
    @FindBy(how = How.ID, using = "select_value_label_169")
    WebElement ssdType;
    @FindBy(how = How.ID, using = "select_option_233")
    WebElement ssdTypeOption;
    @FindBy(how = How.ID, using = "select_value_label_56")
    WebElement location;
    @FindBy(how = How.ID, using = "select_option_181")
    WebElement locationOption;
    @FindBy(how = How.ID, using = "select_value_label_57")
    WebElement usage;
    @FindBy(how = How.ID, using = "select_option_90")
    WebElement usageOption;
    @FindBy(how = How.XPATH, using = "//form[@name=\"ComputeEngineForm\"]")
    WebElement computeEngineForm;
    @FindBy(how = How.ID, using = "email_quote")
    WebElement sendEmailEstimateButton;
    @FindBy(how = How.ID, using = "input_401")
    WebElement emailToInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"dialogContent_407\"]/form/md-dialog-actions/button[2]")
    WebElement sendEmailButton;

    public IframePageObject(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
    }
    public void setNumberOfInstances() {
        String inputInstances = "4";
        numberOfInstances.sendKeys(inputInstances);
    }
    public void selectMachineType() {
        executor.executeScript("arguments[0].click();", machineType);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(machineTypeOption));
        executor.executeScript("arguments[0].click();", machineTypeOption);
    }
    public void selectCheckBoxAddGpu() {
        executor.executeScript("arguments[0].click()", checkBoxAddGpu);
    }
    public void selectGpuNumber() {
        executor.executeScript("arguments[0].click()", gpuNumber);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", gpuNumberOption);
    }
    public void selectGpuType() {
        executor.executeScript("arguments[0].click()", gpuType);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", gpuTypeOption);
    }
    public void selectSsdType() {
        executor.executeScript("arguments[0].click()", ssdType);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", ssdTypeOption);
    }
    public void selectLocation() {
        executor.executeScript("arguments[0].click()", location);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", locationOption);
    }
    public void selectUsage() {
        executor.executeScript("arguments[0].click()", usage);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click()", usageOption);
    }
    public void addToEstimate() {
        computeEngineForm.submit();
    }
    public void sendEmail() {
        executor.executeScript("arguments[0].click()", sendEmailEstimateButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("window.open();");
    }
    public void setCopiedEmail(String copiedEmailFrom10Minutes){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emailToInput.sendKeys(copiedEmailFrom10Minutes);
    }
    public void sendEmailToAddress(){
        executor.executeScript("arguments[0].click()", sendEmailButton);
    }
}

