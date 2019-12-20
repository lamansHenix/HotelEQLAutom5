package fr.ProjetHotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccueilPage {


	WebDriver driver;

	// Titre de la page 
	@FindBy(xpath="//h1")
	public WebElement TitrePage;

	//Première div de résa
	@FindBy(xpath="//div[@class='scheduler_default_scrollable']//div[2]//div[1]")
	public WebElement PremiereCaseResa;

	//Resa du lendemain
	@FindBy(xpath="//div[@id='dp']//div[2]//div[6]")
	public WebElement Resa2;
	
	//Pop up objet
	@FindBy(xpath="//iframe")
	public WebElement Popup;
	
	// Croix dans résa
	@FindBy(xpath="//div[@class='scheduler_default_event_delete']")
	public WebElement SupprResa;
	
	// Resa faite 
	@FindBy(xpath="//div[@class='scheduler_default_event_inner']")
	public WebElement resaFaite;
	
	
	//Champ texte pop-up
	@FindBy(xpath="//input[@id='name']")
	public WebElement ChampTextePU;
	
	//Bouton save popup
	@FindBy(xpath="//div[@class='space']//input")
	public WebElement BoutonSavePU;

	public AccueilPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

}
