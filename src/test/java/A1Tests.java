import Pages.MainPage;
import Pages.SmartphonePage;
import Sections.FilterSection;
import Utilities.Browser;
import org.testng.annotations.*;

public class A1Tests {

    @BeforeClass
    public void setup(){
        Browser.setup();
    }

    @Test(priority = 1)
    public void initialTest(){
        Browser.goTo("https://www.a1.bg");
        MainPage.rejectTheCookies();
        MainPage.hoverOverDevices();
        MainPage.clickSmartphoneNavBar();
        SmartphonePage.verifyClearFilterIsDisplayed();
    }
    @Test (priority = 2)
    public void filterResultsPositive(){
        FilterSection.selectAvailableOnlyCheckbox();
        FilterSection.selectAndroidButton();
        FilterSection.selectYes5G();
        SmartphonePage.verifySearchResultIsVisible();
    }

    @Test (priority = 3)
    public void filterResultNegative(){
        FilterSection.selectAvailableOnlyCheckbox();
        FilterSection.selectYes5G();
        FilterSection.selectBrandNokia();
        FilterSection.selectAndroidButton();
        SmartphonePage.verifyNoResultsAreDisplayed();
    }
    @AfterClass
    public void tearDown(){
        Browser.quiting();
    }
}
