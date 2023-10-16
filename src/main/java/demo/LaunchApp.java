package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

import java.net.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException  {
		// TODO Auto-generated method stub
		
		DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability("appPackage", "com.solodroid.solomerce");
			dc.setCapability("appActivity", ".activities.ActivitySplash");
			dc.setCapability("deviceName", "Umidigi");
			dc.setCapability("platformName", "Android");
			dc.setCapability("platformVersion", "11");
//			dc.setCapability("unlockType", "pin");
//			dc.setCapability("unlockKey", "2910");
			
			AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Starting");
//			searchoption(driver);
//			profile(driver);
//			categoryByFixedcoordinates(driver);
//			category(driver);
//			screenRotate(driver);
//			lockUnlock(driver);
//			swipe(driver);
//			switchApp(driver);
//			scrollDownUp(driver);
//			scroll(driver);
			zoom(driver);
			
			WebElement item = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Samsung Galaxy S10 - Black\")");
			item.click();
			
			driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.solodroid.solomerce:id/product_image\")").click();
			MultiTouchAction action = new MultiTouchAction(driver);
			
			TouchAction touch1 = new TouchAction<>(driver);
			TouchAction touch2 = new TouchAction<>(driver);
			
		touch1.press(PointOption.point(339, 821)).moveTo(PointOption.point(339, 383)).release().wait(500);
		touch2.press(PointOption.point(339, 815)).moveTo(PointOption.point(339, 1000)).release().wait(500);
			
			action.add(touch1).add(touch2).perform().wait(500);
			
			
			System.out.println("End");
		}
	
	
	public static void searchoption(AndroidDriver driver) throws InterruptedException {
		
		System.out.println("Performing Search");
				driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
				driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("watch");
				driver.hideKeyboard();
				Thread.sleep(3000);
				
			}
	
	
			
	public static void profile(AndroidDriver driver) {
		
		System.out.println("Clicking profile");
		driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
				}
			
			
			public static void categoryByFixedcoordinates(AndroidDriver driver) {
				
				System.out.println("Clicking Category using fixed X and Y coordinates");
				TouchAction action = new TouchAction<>(driver);
				action.tap(PointOption.point(268, 1429)).perform();
			}
			
			public static void category(AndroidDriver driver) {
				
				System.out.println("Clicking Category using x and y cordinates ");
				WebElement category = driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
				
//				For Below lines from 59 to 61 we can get x and y coordinates from code from line 63 to 65.
//				Dimension categorysize = category.getSize();
//				System.out.println("height is :" +categorysize.height);
//				System.out.println("width is :"+categorysize.width);
				
				Point categorysize = category.getLocation();
				System.out.println("x coordinate is :" +categorysize.x);
				System.out.println("y coordinate is :"+categorysize.y);
								
				TouchAction action = new TouchAction<>(driver);
				action.tap(PointOption.point(categorysize.x, categorysize.y)).perform();
			}
			
			
			public static void screenRotate(AndroidDriver driver) {
				
				System.out.println("Performing ScreenRotate");
				
				if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
					driver.rotate(ScreenOrientation.PORTRAIT);
				}
				
				else {
					driver.rotate(ScreenOrientation.LANDSCAPE);
				}
				
				driver.rotate(ScreenOrientation.LANDSCAPE);
				driver.runAppInBackground(Duration.ofSeconds(10));
				driver.rotate(ScreenOrientation.PORTRAIT);
				
			}
			
			public static void lockUnlock(AndroidDriver driver) throws InterruptedException {
				
			System.out.println("Performing LockUnlock");
			Thread.sleep(8000);
			driver.lockDevice();
			System.out.println("locked");
			Thread.sleep(3000);
			driver.unlockDevice();
			System.out.println("unlocked");
			Thread.sleep(3000);
			
			}
	
			public static void swipe(AndroidDriver driver) {
				WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				System.out.println("Performing Swipe(2 times)");
				TouchAction swipeAction = new TouchAction<>(driver);
				System.out.println("Swipe left");
				swipeAction.press(PointOption.point(680, 975)).waitAction().moveTo(PointOption.point(50, 975)).waitAction().release().perform();
				swipeAction.press(PointOption.point(680, 975)).waitAction().moveTo(PointOption.point(50, 975)).waitAction().release().perform();
				System.out.println("Swipe right");
				swipeAction.press(PointOption.point(50, 975)).waitAction().moveTo(PointOption.point(680, 975)).waitAction().release().perform();
			
			}
			
			public static void switchApp(AndroidDriver driver) throws InterruptedException {
				System.out.println("Opening Ecommerce app and Clicking profile");
				driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
				Thread.sleep(3000);
				Activity calci = new Activity("com.android.calculator2", ".Calculator");
				driver.startActivity(calci);
				
				System.out.println("Back to 1st app");
				Thread.sleep(3000);
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
			}
			
			public static void scrollDownUp(AndroidDriver driver) throws InterruptedException {
				Thread.sleep(3000);
				System.out.println("Scrolling down");
				
				TouchAction swipeAction = new TouchAction<>(driver);
				while(true) {
					
					swipeAction.press(PointOption.point(680, 1100)).waitAction().moveTo(PointOption.point(680, 300)).waitAction().release().perform();
				if(driver.findElement(By.id("com.solodroid.solomerce:id/product_name")).isDisplayed()) {
					break;
				}
				
				Thread.sleep(3000);
				System.out.println("Scrolling Up");
				while(true) {
					swipeAction.press(PointOption.point(680, 300)).waitAction().moveTo(PointOption.point(680, 1100)).waitAction().release().perform();
				if(driver.findElement(By.linkText("Samsung Galaxy S10 - Black")).isDisplayed()) {
					break;
				}
				}
			}
			}
			
			public static void scroll(AndroidDriver driver) {
				
				System.out.println("Scrolling down and clicking element");
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
						+ ".resourceId(\"com.solodroid.solomerce:id/viewpager\"))"
						+ ".scrollForward().scrollIntoView(new UiSelector().textContains(\"Bathroom Toilet Wall Shelves A289\"))");
				
				driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Bathroom Toilet Wall Shelves A289\")").click();
			}
			
			public static void zoom(AndroidDriver driver) throws InterruptedException {
				System.out.println("zooming in");
								
				WebElement item = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Samsung Galaxy S10 - Black\")");
				item.click();
				
				driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.solodroid.solomerce:id/product_image\")").click();
				
				MultiTouchAction action = new MultiTouchAction(driver);
				
				TouchAction touch1 = new TouchAction<>(driver);
				TouchAction touch2 = new TouchAction<>(driver);
				
			touch1.press(PointOption.point(339, 821)).moveTo(PointOption.point(339, 383)).release().wait(500);
			touch2.press(PointOption.point(339, 815)).moveTo(PointOption.point(339, 1000)).release().wait(500);
				
				action.add(touch1).add(touch2).perform().wait(500);
				
				
				
			}
}
