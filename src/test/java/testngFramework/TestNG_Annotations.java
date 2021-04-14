package testngFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotations {
	@Test(dataProvider = "dp")
	public void testMethod(Integer n, String s) {
		
		System.out.println("\t\t\t\t test Method");
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
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, new Object[] { 3, "c" },};
	}

}
