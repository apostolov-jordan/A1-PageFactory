package Utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    private static WebDriverWait waiter;
    private static JavascriptExecutor js;
    static Actions action;

    public static void addCookie(String cookieName, String cookieValue)
    {
        var cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
    }

    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        waiter = new WebDriverWait(driver, Duration.ofSeconds(12));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public static void goTo(String url){
        driver.get(url);
    }

    public static WebDriver doing() {
        return driver;
    }

    public static WebDriverWait waiting() {
        return waiter;
    }

    public static void quiting(){
        driver.quit();
    }

    public static JavascriptExecutor javaScriptDo(){
        return js;
    }

    public static Actions getAction(){
        return action;
    }


}
