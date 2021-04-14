package programs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSignup {

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

		drv.get("https://www.facebook.com/");

		String pageTitle = drv.getTitle();
		System.out.println("page title: " + pageTitle);
		
		drv.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		drv.findElement(By.name("firstname")).sendKeys("Firstname");
		drv.findElement(By.name("lastname")).sendKeys("lastname");
		drv.findElement(By.name("reg_email__")).sendKeys("firstname.lastname@gmail.com");
		
		WebDriverWait wait = new WebDriverWait(drv,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email_confirmation__")));
		drv.findElement(By.name("reg_email_confirmation__")).sendKeys("firstname.lastname@gmail.com");

		drv.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("pAASSword");
		
		Select month = new Select(drv.findElement(By.name("birthday_month")));
		month.selectByValue("3");
		
		Select day = new Select(drv.findElement(By.name("birthday_day")));
		day.selectByIndex(20);
		
		Select year = new Select(drv.findElement(By.name("birthday_year")));
		year.selectByVisibleText("1966");
		
		drv.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[3]/input")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("preferred_pronoun")));
		
		
		Select custom = new Select(drv.findElement(By.name("preferred_pronoun")));
		custom.selectByVisibleText("They: \"Wish them a happy birthday!\"");
		
		drv.close();
		drv.quit();
	}

}
