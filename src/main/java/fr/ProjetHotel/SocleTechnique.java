package fr.ProjetHotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SocleTechnique {



	static WebDriver driver;

	public static WebDriver OpenNav (String adresseWeb, ENav navigateur) {

		switch (navigateur) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(adresseWeb);
			return driver;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(adresseWeb);
			return driver;

		default :
			return null;
		}
	}

	public  static void fermerNav () {
		driver.close();
	}

}
