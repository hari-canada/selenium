package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/hari/Downloads/chromedriver");
		WebDriver drv = new ChromeDriver();

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drv.manage().window().maximize();

		drv.get("http://www.web-source.net/web_design_tips/alert_message_web_page_load.htm#.Vvt66Pl95SZ");

		WebDriverWait wait = new WebDriverWait(drv, 20);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = drv.switchTo().alert();

		String alertText = alert.getText();

		System.out.println(alertText);

		alert.accept();

		// alert.dismiss();

		// System.out.println("Alert dismissed");
		
		drv.close();
		drv.quit();

	}

}
