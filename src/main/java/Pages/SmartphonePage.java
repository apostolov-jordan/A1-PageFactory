package Pages;

import Utilities.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SmartphonePage {

    @FindBy (css = "button.mt-10")
    static WebElement clearFiltersUpperButton;

    @FindBy (css = ".flex p.px-3")
    static WebElement noResultsFound;

    @FindBy (css = "div.grid a:nth-child(1) div.h-full")
    static WebElement firstSearchResultSmartphone;

    static {
        PageFactory.initElements(Browser.doing(), SmartphonePage.class);
    }

    public static void verifyClearFilterIsDisplayed(){
        Assert.assertTrue(clearFiltersUpperButton.isDisplayed());
    }

    public static void verifySearchResultIsVisible(){
        Assert.assertTrue(firstSearchResultSmartphone.isDisplayed());
    }

    public static void verifyNoResultsAreDisplayed(){
        Assert.assertEquals(noResultsFound.getText(), "Няма намерени резултати по зададените от вас критерии.");
    }

}
