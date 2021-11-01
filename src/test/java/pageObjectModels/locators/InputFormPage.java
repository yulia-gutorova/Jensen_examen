package pageObjectModels.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputFormPage {

    WebDriver driver;

    public InputFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    @FindBy(id = "at-cv-lightbox-close")
    public WebElement closePopUpWindow;

    @FindBy(xpath = "//img[@role='presentation']")
    public WebElement logotype;

    @FindBy(xpath = "//img[@class='cbt']")
    public WebElement sponsoredBy;

    @FindBy(xpath = "//input[@placeholder='Please enter your Message']")
    public WebElement enterMessage;

    @FindBy(xpath = "//button[@onclick='showInput();']")
    public WebElement showMessageButton;

    @FindBy(id = "display")
    public WebElement yourMessage;

    @FindBy(id = "sum1")
    public WebElement valueA;

    @FindBy(id = "sum2")
    public WebElement valueB;

    @FindBy(id = "displayvalue")
    public WebElement total;

    @FindBy(xpath = "//button[@onclick='return total()']")
    public WebElement getTotalButton;

}
