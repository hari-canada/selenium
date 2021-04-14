package browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_SignUp {
	
	public static void main(String[] args) throws InterruptedException {
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

		drv.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");

		String pageTitle = drv.getTitle();
		System.out.println("pageTitle: "+pageTitle);
		
		drv.findElement(By.id("firstName")).sendKeys("Firstname");
		drv.findElement(By.name("lastName")).sendKeys("lastname");
		drv.findElement(By.xpath(".//input[@name='Username']")).sendKeys("firstname.lastname");
		drv.findElement(By.xpath(".//input[@name='Passwd']")).sendKeys("password");
		drv.findElement(By.xpath(".//input[@name='ConfirmPasswd']")).sendKeys("password");
		drv.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[3]/div[3]/div/div[1]/div/div/div[1]/div/input")).click();
		drv.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
		
		
		Thread.sleep(20000);
		
		drv.close();
		drv.quit();
		
		
	}

}
