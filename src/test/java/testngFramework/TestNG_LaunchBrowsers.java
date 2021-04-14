package testngFramework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_LaunchBrowsers {

	FileReader reader;

	@Test(dataProvider = "dp")
	public void Browserlaunch(Integer n, String driver) throws IOException {

		if (driver.contains("chrome")) {
			System.out.println("\t\t\t\t Chrome Driver");
			reader = new FileReader(".//src/test/resources/configs/application.properties");
			Properties props = new Properties();
			props.load(reader);
			reader.close();

			if (System.getProperty("os.name").contains("Windows")) {
				System.setProperty(props.getProperty("ChromeDriver"), props.getProperty("ChromeDriverLoc"));
			} else if (System.getProperty("os.name").contains("Mac")) {

				String home = System.getProperty("user.home");
				File f = new File(home + props.getProperty("macChromeDriverLoc"));

				if (f.exists()) {
					System.out.println("chrome driver Exists");
					System.setProperty(props.getProperty("ChromeDriver"), home + props.getProperty("macChromeDriverLoc"));
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

			drv.get("https://www.seleniumhq.org/");

			String pageTitle = drv.getTitle();

			System.out.println("pageTitle: " + pageTitle);
			// initial configuration
			System.out.println(
					"Browser Name is : " + ((RemoteWebDriver) drv).getCapabilities().getBrowserName().toLowerCase());
			System.out.println(
					"Browser Version is : " + ((RemoteWebDriver) drv).getCapabilities().getVersion().toString());
			System.out.println(
					"Platform Name is : " + ((RemoteWebDriver) drv).getCapabilities().getPlatform().toString());

			drv.close(); // closes active window/tab
			drv.quit(); // closes all windows/tabs
		} else if (driver.contains("edge")) {
			System.out.println("\t\t\t\t Edge Driver");
			reader = new FileReader(".//src/test/resources/configs/application.properties");
			Properties props = new Properties();
			props.load(reader);
			reader.close();

			if (System.getProperty("os.name").contains("Windows")) {
				System.setProperty(props.getProperty("EdgeDriver"), props.getProperty("EdgeDriverLoc"));
			} else if (System.getProperty("os.name").contains("Mac")) {

				String home = System.getProperty("user.home");
				File f = new File(home + "/Downloads/msedgedriver");

				if (f.exists()) {
					System.out.println("edge driver Exists");
					System.setProperty(props.getProperty("EdgeDriver"), home + props.getProperty("macEdgeDriverLoc"));
				} else {
					System.err.println("edge driver does not Exists in folder /Downloads/");
					System.exit(0);
				}

			} else {
				System.err.println("os is not compatible");
				System.exit(0);
			}
			WebDriver drv = new EdgeDriver();

			drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			drv.manage().window().maximize();
			drv.get("https://www.seleniumhq.org/");

			String pageTitle = drv.getTitle();

			System.out.println("pageTitle: " + pageTitle);

			// initial configuration
			System.out.println(
					"Browser Name is : " + ((RemoteWebDriver) drv).getCapabilities().getBrowserName().toLowerCase());
			System.out.println(
					"Browser Version is : " + ((RemoteWebDriver) drv).getCapabilities().getVersion().toString());
			System.out.println(
					"Platform Name is : " + ((RemoteWebDriver) drv).getCapabilities().getPlatform().toString());

			drv.close(); // closes active window/tab
			drv.quit(); // closes all window(s)/tab(s)
		} else {
			System.out.println("Driver not initiated");
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\t beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\t\t afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\t afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "chrome" }, new Object[] { 2, "edge" }, };
	}

}
