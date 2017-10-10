package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject{
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement h1Title;

    @FindBy(xpath = "")
    private WebElement fromField;

    @FindBy(xpath = "")
    private WebElement toField;

    @FindBy(xpath = "")
    private WebElement departOnFiled;

    @FindBy(xpath = "")
    private WebElement departOnCalendar;

    @FindBy(xpath = "")
    private WebElement returnOnFiled;

    @FindBy(xpath = "")
    private WebElement returnOnCalendar;

    @FindBy(xpath = "")
    private WebElement whoWillBeTravellingField;

    @FindBy(xpath = "")
    private WebElement showPricesInFlyingBlueMilesCheckbox;

    @FindBy(xpath = "")
    private WebElement passagerIcon;

    @FindBy(xpath = "")
    private WebElement saveButtonForPassagerForm;

    @FindBy(xpath = "")
    private WebElement searchButton;

    public String checkTitle(){
        return "";
    }

    public String getSelectedPlaceFromTheFromField(){
        return "";
    }

    public String getSelectedPlaceFromTheToField(){
        return "";
    }

    public String getDateFromTheDepartOnField(){
        return "";
    }

    public void uncheckShowPricesInFlyingBlueMilesCheckbox(){

    }
    public String getTextFormReturnOnField (){
        return "";
    }


}
