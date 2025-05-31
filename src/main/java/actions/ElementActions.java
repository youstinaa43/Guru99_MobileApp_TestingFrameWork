package actions;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ElementActions {
      private WebDriver driver;
      public ElementActions(WebDriver driver){
          this.driver=driver;
      }

    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",2000));
    }
    public void scrollToEndAction(){
        boolean canScrollMore;
        do{
            canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left",100, "top",100, "width",200,"height",200,
                            "direction","down","percent",3.0
                    ));
        }while (canScrollMore);
    }
    public void swipeAction(WebElement element,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "direction",direction,"percent",0.75
                ));
    }
    public void dragDropAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "endX",665,"endY",585
                ));
    }
}
