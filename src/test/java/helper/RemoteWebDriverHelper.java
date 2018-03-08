package helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class RemoteWebDriverHelper {

	private static AppiumDriver<MobileElement> appiumDriver;

	public static AppiumDriver<MobileElement> getDriverByPlatformName (String plataformName) throws MalformedURLException {

		if (appiumDriver==null) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if(plataformName.equals("Android")) {
				capabilities.setCapability("app",new File("apps/app-android-calculator.apk"));
				capabilities.setCapability("platformName","Android" );
				capabilities.setCapability("deviceName","Android Emulator API 22");
				capabilities.setCapability("disableAndroidWatchers" , true);
				return appiumDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
			}else if(plataformName.equals("Ios")) {
				capabilities.setCapability("app",new File("apps/SimpleCalculator.app"));
				capabilities.setCapability("plataform", "MAC" );
				capabilities.setCapability("plataformName", "ios" );
				capabilities.setCapability("deviceName", "iPhone SE");
				capabilities.setCapability("automationName" , "XCUITest");
				return appiumDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
			}else {
				Logger.getGlobal().info("========== Plataform name dont exist!! ==========");
			}
		}
		return appiumDriver;
	}
	
	public static void close() {
		appiumDriver.quit();
	}
}

