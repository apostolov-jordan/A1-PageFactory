package Sections;

import Utilities.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;

public class FilterSection {

    @FindBy(css = "span.h-5")
    static WebElement availableOnlyCheckbox;

    @FindBy (xpath = "//div[@class='filters_fields ']//button[contains(text(),\"Android\")]")
    static WebElement operatingSystem;

    @FindBy (xpath = "//p[contains(text(),\"5G\")]/following-sibling::div/button[1]")
    static WebElement yes5G;

    @FindBy (xpath = "//button[contains(text(),\"Nokia\")]")
    static WebElement brandNokia;

    static {
        PageFactory.initElements(Browser.doing(), FilterSection.class);
    }

    public static void selectAvailableOnlyCheckbox(){
       // Browser.waiting().until(ExpectedConditions.visibilityOf(availableOnlyCheckbox));
        if (availableOnlyCheckbox.isEnabled() || !availableOnlyCheckbox.isSelected()){
            availableOnlyCheckbox.click();
        } else{
            if(availableOnlyCheckbox.isSelected()){
                System.out.println("the \" Available only\" checkbox is already selected");
            }
            if(!availableOnlyCheckbox.isEnabled()){
                System.out.println("the \" Available only\" checkbox is not enabled");
            }
        }
    }

    public static void selectAndroidButton(){

        Browser.javaScriptDo().executeScript("arguments[0].scrollIntoView();", yes5G);
        Browser.waiting().until(ExpectedConditions.visibilityOf(yes5G));
        Browser.waiting().until(ExpectedConditions.elementToBeClickable(operatingSystem));
        operatingSystem.click();
    }

    public static void selectYes5G(){
       // js.executeScript("arguments[0].scrollIntoView();", yes5G);
        yes5G.click();
    }

    public static void selectBrandNokia(){
       // js.executeScript("arguments[0].scrollIntoView();", brandNokia);
        brandNokia.click();
    }

}
