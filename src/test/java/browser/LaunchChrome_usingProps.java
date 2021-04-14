package browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchChrome_usingProps {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader reader = new FileReader(".//src/test/resources/configs/application.properties");
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
		System.out.println(
				"Browser Name \t\t: " + ((RemoteWebDriver) drv).getCapabilities().getBrowserName().toLowerCase());
		System.out.println("Browser Version \t: " + ((RemoteWebDriver) drv).getCapabilities().getVersion().toString());
		System.out.println("Platform Name \t\t: " + ((RemoteWebDriver) drv).getCapabilities().getPlatform().toString());

		drv.close(); // closes active window/tab
		drv.quit(); // closes all windows/tabs

	}

}
