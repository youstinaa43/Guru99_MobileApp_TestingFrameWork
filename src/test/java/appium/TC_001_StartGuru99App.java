package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_001_StartGuru99App extends BasicTests{
    @Test
    public void startGuru99App(){
        WebElement appName=driver.findElement(AppiumBy.id("android:id/action_bar_title"));
        Assert.assertTrue(appName.isDisplayed());
        Assert.assertEquals(appName.getText(),"Guru99");
        WebElement courseCat=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Course Category\"]"));
        Assert.assertTrue(courseCat.isDisplayed());
        Assert.assertTrue(courseCat.isSelected());
        //Assert.assertTrue(courseCat.isEnabled());
        List<WebElement> courses = driver.findElements(AppiumBy.id("com.vector.guru99:id/lblListHeader"));
        Assert.assertFalse(courses.isEmpty());
        for(WebElement course: courses){
            Assert.assertTrue(course.isEnabled());
        }
        WebElement courseList= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Course List\"]"));
        Assert.assertTrue(courseCat.isDisplayed());
        Assert.assertFalse(courseCat.isSelected());



    }
}
