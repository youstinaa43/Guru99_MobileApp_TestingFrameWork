package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BasicTests {
    public AndroidDriver driver;  // Made private for better encapsulation

    @BeforeClass
    public void setUp() throws Exception {
        // 1. BrowserStack-specific options
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("local", "true");
        bstackOptions.put("debug", "true");
        bstackOptions.put("networkLogs", "true");
        bstackOptions.put("projectName", "Guru99 Mobile Tests");
        bstackOptions.put("buildName", "Android Tests");
        bstackOptions.put("appiumVersion", "2.0");  // Explicitly set in bstackOptions

        // 2. Core capabilities
        UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setPlatformVersion("8.0") ; // Confirmed working on your BrowserStack
                options.setDeviceName("Samsung Galaxy S9");
                options.setApp("bs://da82e816002c1a8fc12abf006aee2e11e454f2f6") ; // Your app hash
                // BrowserStack authentication
                options.setCapability("browserstack.user", "youstinaatefsala_v352Cg");
                options.setCapability("browserstack.key", "3rQaNjH1L2qnFk5MMybp");
                // Required security settings
                options.setCapability("browserstack.acceptInsecureCerts", "true");
                options.setCapability("browserstack.allowInsecure", "true");
                // Debugging capabilities
                options.setCapability("browserstack.console", "verbose");
                options.setCapability("browserstack.appiumLogs", "true");
                // Bundle all BrowserStack options
                options.setCapability("bstack:options", bstackOptions);

        // 3. Initialize driver with improved error handling
        try {
            driver = new AndroidDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    options
            );
        } catch (Exception e) {
            System.err.println("Failed to initialize AndroidDriver: " + e.getMessage());
            throw e;  // Re-throw to fail the test explicitly
        }
    }


}