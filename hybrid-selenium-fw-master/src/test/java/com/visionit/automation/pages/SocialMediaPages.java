package com.visionit.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.tests.SocialMediaPagesTest;
import com.visionit.automation.utils.ElementActions;

public class SocialMediaPages extends BasePage {
	
	private static final Logger logger = LogManager.getLogger(SocialMediaPagesTest.class);

	ElementActions elementActions;

	// Locators - Social Media Links at footer of landing page
	private By faceBookLink = By.xpath("//span[text()='Facebook']/parent::a");
	private By twitterLink = By.xpath("//span[text()='Twitter']/parent::a");
	private By youTubeLink = By.xpath("//span[text()='Youtube']/parent::a");

	// Locators - Social Media Page Account Name 
	private By youtubeChannelNameElement = By.xpath("//div[@id='text-container']/yt-formatted-string[@id='text' and text()='Selenium Framework']");
	private By twitterChannelNameElement = By.xpath("//div[@data-testid='titleContainer']//span[text()='Selenium Framework']");
	private By facebookChannelNameElement = By.xpath("(//span[text()='Selenium Framework'])[1]");

	// Constructor of the page:
	public SocialMediaPages(WebDriver driver) {
		elementActions = new ElementActions(driver);
	}
	
	// Page Actions:
	public String getFacebookLinkChannelName()
	{
		elementActions.waitForElementClickable(faceBookLink);
		elementActions.doClick(faceBookLink);
		elementActions.switchToWindowId(1);
		elementActions.waitForElementVisible(facebookChannelNameElement);
		String facebookChannelName = elementActions.doGetText(facebookChannelNameElement);
		return facebookChannelName;	
	}
	
	public String getTwitterLinkChannelName()
	{
		elementActions.waitForElementClickable(twitterLink);
		elementActions.doClick(twitterLink);
		elementActions.switchToWindowId(1);
		elementActions.waitForElementVisible(twitterChannelNameElement);
		String twitterChannelName = elementActions.doGetText(twitterChannelNameElement);
		return twitterChannelName;	
	}
	
	public String getYoutubeLinkChannelName()
	{
		elementActions.waitForElementClickable(youTubeLink);
		elementActions.doClick(youTubeLink);
		elementActions.switchToWindowId(1);
		elementActions.waitForElementVisible(youtubeChannelNameElement);
		String youtubeChannelName = elementActions.doGetText(youtubeChannelNameElement);
		return youtubeChannelName;	
	}

}
