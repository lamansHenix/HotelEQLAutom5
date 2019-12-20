package fr.ProjetHotel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestHotel1 {

	WebDriver driver; 
	String adresseWeb = "http://localhost/tutorialHtml5HotelPhp";
	AccueilPage accueil;

	@Before
	public void SeConnecter () throws Exception {

		driver=SocleTechnique.OpenNav(adresseWeb, ENav.chrome);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BDDconnexion.insertData("src\\main\\resources\\datasets\\datasetHotel.xml");
	}

	@After
	public void closeNav () throws Exception {
		SocleTechnique.fermerNav();
		BDDconnexion.deleteAllData("src\\main\\resources\\datasets\\DataSetCleanRoom.xml");
		BDDconnexion.deleteAllData("src\\main\\resources\\datasets\\DataSetCleanResa.xml");
	}


	@Test
	public void TestHotel () throws InterruptedException {
		accueil = new AccueilPage(driver);
		assertEquals("La page ne s'est pas bien chargée", "HTML5 Hotel Room Booking (JavaScript/PHP)", accueil.TitrePage.getText());
		accueil.PremiereCaseResa.click();
		assertTrue("La pop up ne s'est pas affichée", accueil.Popup.isDisplayed());
		driver.switchTo().frame(accueil.Popup);
		accueil.ChampTextePU.clear();
		accueil.ChampTextePU.sendKeys("Resa 1");
		accueil.BoutonSavePU.click();
		driver.switchTo().defaultContent();
		accueil.resaFaite.click();
		driver.switchTo().frame(accueil.Popup);
		assertEquals("La reservation n'est pas effective", "Edit Reservation", accueil.TitrePage.getText());
		accueil.BoutonSavePU.click();
		driver.switchTo().defaultContent();

		Actions a = new Actions(driver);
		a.clickAndHold(accueil.resaFaite).moveToElement(accueil.Resa2).release().build().perform();
		Thread.sleep(7000);
		Actions b = new Actions(driver);
		b.moveToElement(accueil.resaFaite).build().perform();
//		b.moveToElement(accueil.SupprResa).build().perform();
		accueil.SupprResa.click();



	}


}
