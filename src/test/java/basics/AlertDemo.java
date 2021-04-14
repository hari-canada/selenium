package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/hari/Downloads/chromedriver");
		WebDriver drv = new ChromeDriver();

		// Alert Message handling

		drv.get("http://demo.guru99.com/test/delete_customer.php");

		drv.findElement(By.name("cusid")).sendKeys("53920");
		drv.findElement(By.name("submit")).submit();

		// Switching to Alert
		Alert alert = drv.switchTo().alert();

		// Capturing alert message.
		String alertMessage = drv.switchTo().alert().getText();

		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(5000);

		// Accepting alert
		alert.accept();
		drv.switchTo().defaultContent();

		drv.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		drv.findElement(By.name("cusid")).sendKeys("53920");
		drv.findElement(By.name("submit")).submit();

		// Displaying alert message
		System.out.println(drv.switchTo().alert().getText());
		Thread.sleep(5000);

		// Accepting alert
		alert.dismiss();
		
		drv.close();
		drv.quit();

	}

}
