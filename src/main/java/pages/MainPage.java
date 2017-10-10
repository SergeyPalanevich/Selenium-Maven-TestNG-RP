package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1Title;

    @FindBy(xpath = "//input[@id=\"routeSelection_DepartureStation-input\"]")
    public WebElement fromField;

    @FindBy(xpath = "")
    public WebElement toField;

    @FindBy(xpath = "")
    public WebElement departOnFiled;

    @FindBy(xpath = "")
    public WebElement departOnCalendar;

    @FindBy(xpath = "")
    public WebElement returnOnFiled;

    @FindBy(xpath = "")
    public WebElement returnOnCalendar;

    @FindBy(xpath = "")
    public WebElement whoWillBeTravellingField;

    @FindBy(xpath = "")
    public WebElement showPricesInFlyingBlueMilesCheckbox;

    @FindBy(xpath = "")
    public WebElement passagerIcon;

    @FindBy(xpath = "")
    public WebElement saveButtonForPassagerForm;

    @FindBy(xpath = "")
    public WebElement searchButton;

}
