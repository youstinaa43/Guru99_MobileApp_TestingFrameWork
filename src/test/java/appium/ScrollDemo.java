package appium;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BasicTests{
    ElementActions elementActions=new ElementActions(driver);

    @Test
    public void scrollTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
         elementActions.scrollToEndAction();

    }
}
