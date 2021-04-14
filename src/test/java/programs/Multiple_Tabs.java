package programs;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Multiple_Tabs {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", ".//src/test/resources/drivers/chromedriver.exe");
		} else if (System.getProperty("os.name").contains("Mac")) {

			String home = System.getProperty("user.home");
			File f = new File(home + "/Downloads/chromedriver");

			if (f.exists()) {
				System.out.println("chrome driver Exists");
				System.setProperty("webdriver.chrome.driver", home + "/Downloads/chromedriver");
			} else {
				System.err.println("chrome driver does not Exists in folder /Downloads/");
				System.exit(0);
			}

		} else {
			System.err.println("os is not compatible");
			System.exit(0);
		}
		
		
		WebDriver drv = new ChromeDriver(capabilities);

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	drv.manage().window().maximize();
		
		drv.get("http://www.bankofcanada.ca/");

		Actions actBuild = new Actions(drv);

		// Window 1
		String firstTabHandle = drv.getWindowHandle();
		actBuild.click(drv.findElement(By.linkText("ABOUT THE BANK"))).perform();

		System.out.println("Page title: " + drv.getTitle());

		// Window 2
		WebElement ele = drv.findElement(By.id("menu-item-148249"));
		actBuild.moveToElement(ele).click().perform();
		WebElement ele2 = drv.findElement(By.partialLinkText("The Bank's History"));
		actBuild.keyDown(Keys.CONTROL);
		actBuild.moveToElement(ele2).click().perform();
		actBuild.build().perform();

		System.out.println("Page title: " + drv.getTitle());

		ArrayList<String> tabs = new ArrayList<String>(drv.getWindowHandles());
		int n = tabs.size();

		System.out.println("Total active Tabs or Windows = " + n);

		drv.switchTo().window(tabs.get(1));
		System.out.println("Page title: " + drv.getTitle());

		drv.switchTo().window(tabs.get(0));
		System.out.println("Page title: " + drv.getTitle());

		System.out.println("First tab handle = " + firstTabHandle);

		String secondTabHandle = (String) tabs.toArray()[1];

		System.out.println("second Tab handle = " + secondTabHandle);

		drv.close();
		drv.quit();

	}

}
