package com.visionit.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.utils.ElementActions;

public class LoginRegisteredUser extends BasePage{


	private static final Logger logger = LogManager.getLogger(LoginRegisteredUser.class);

	ElementActions elementActions;

	// By Locators - Landing Page
	private By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");

	// By Locators - Login Page
	private By emailIdInputTextBox = By.id("email");
	private By passwordInputTextBox = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");

	// By  Locators - After logged in Page
	private By registeredUserNameDisplayElement = By.xpath("//a[@title='View my customer account']/span");

	// Constructor of the page:
	public LoginRegisteredUser(WebDriver driver) {
		elementActions = new ElementActions(driver);
	}

	// Page Actions:
	public boolean loginRegisteredUserToApp(String Username, String Password, String Firstname, String Lastname)
	{
		logger.info("Waiting for SigninButtonElement clickable");
		elementActions.waitForElementClickable(SigninButtonElement);
		elementActions.doClick(SigninButtonElement);
		logger.info("Clicked On SigninButtonElement");
		logger.info("Waiting for emailIdInputTextBox clickable");
		elementActions.waitForElementClickable(emailIdInputTextBox);
		elementActions.doSendKeys(emailIdInputTextBox, Username);
		logger.info("Send keys to emailIdInputTextBox as " + Username);
		logger.info("Waiting for passwordInputTextBox clickable");
		elementActions.waitForElementClickable(passwordInputTextBox);
		logger.info("Send keys to passwordInputTextBox as " + Password);
		elementActions.doSendKeys(passwordInputTextBox, Password);
		logger.info("Waiting for signInButton clickable");
		elementActions.waitForElementClickable(signInButton);
		elementActions.doClick(signInButton);
		logger.info("Clicked On signInButton");
		logger.info("Waiting for registeredUserNameDisplayElement visible after clicking on Signin button");
		elementActions.waitForElementVisible(registeredUserNameDisplayElement);
		String userFirstNameNLastName = elementActions.doGetText(registeredUserNameDisplayElement);
		// Validating Expected FirstName and LastName with Expected FirstName and LastName of User
		if(userFirstNameNLastName.equals(Firstname + " " + Lastname))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
