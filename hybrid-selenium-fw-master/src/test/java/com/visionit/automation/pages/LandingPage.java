package com.visionit.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.utils.AppConstants;
import com.visionit.automation.utils.ElementActions;

public class LandingPage extends BasePage  {

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	ElementActions elementActions;
	
	
	// By Locators - Landing Page
	private By landingPageLogoImage = By.xpath("//img[@class='logo img-responsive']");
	private By landingPageProdCategoryList = By.xpath("//div[@id='block_top_menu']/ul/li/a");
	
	// Constructor of the page:
	public LandingPage(WebDriver driver) {
		elementActions = new ElementActions(driver);
	}
	
	
	// Page Actions:
	public String getLandingPageUrl()
	{
		elementActions.waitForUrlWithTextContains(AppConstants.LANDING_PAGE_REDIRECTED_URL);
		String currentUrl = elementActions.doGetcurrentURL();
		return currentUrl;
		
	}
	
	public String getLandingTitle()
	{
		String landingPageTitle = elementActions.waitForPageTitleToBe(AppConstants.LANDING_PAGE_TITLE);
		return landingPageTitle;
	}
	
	public List<WebElement> getLandingPageProdCategory()
	{
		List<WebElement> landingPageProdCategoryActual = elementActions.getElementsList(landingPageProdCategoryList);
		return landingPageProdCategoryActual;
	}
	
	public boolean getLandingPageLogo()
	{
		elementActions.waitForElementVisible(landingPageLogoImage);
		boolean landingPageLogoStatus = elementActions.doIsDisplayed(landingPageLogoImage);
		return landingPageLogoStatus;
	}
	
	
	
}
