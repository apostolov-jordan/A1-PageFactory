package Pages;

import Utilities.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    // static Actions perform = new Actions(Browser.doing());
    @FindBy (css = "li.drop a[href='/devices']")
    static
    WebElement navBarDevices;
    @FindBy (css = "li[class='span-2'] a[href='/mobile-devices-smartphones']")
    static
    WebElement smartphonesNavBarHovered;
    @FindBy (id = "onetrust-reject-all-handler")
    static WebElement rejectCookies;


    static {
        PageFactory.initElements(Browser.doing(), MainPage.class);
    }

    public static void hoverOverDevices(){
        Browser.getAction().moveToElement(navBarDevices).perform();
    }
    public static void clickSmartphoneNavBar(){
        smartphonesNavBarHovered.click();
    }
    public static void rejectTheCookies(){
        rejectCookies.click();
    }
}
