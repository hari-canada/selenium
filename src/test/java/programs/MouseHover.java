package programs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		WebDriver drv = new ChromeDriver();

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drv.manage().window().maximize();

		drv.get("https://www.bankofcanada.ca/");

		System.out.println("page title: " + drv.getTitle());

		System.out.println("page current url: " + drv.getCurrentUrl());

		Actions actBuild = new Actions(drv);
		WebElement ele = drv.findElement(By.id("menu-item-148249"));
		actBuild.moveToElement(ele).click().perform();
		WebElement ele2 = drv.findElement(By.partialLinkText("The Bank's History"));
		actBuild.moveToElement(ele2).click().perform();
		actBuild.build().perform();

		System.out.println("page title: " + drv.getTitle());

		System.out.println("page current url: " + drv.getCurrentUrl());
		
		drv.close();
		drv.quit();

	}

}
