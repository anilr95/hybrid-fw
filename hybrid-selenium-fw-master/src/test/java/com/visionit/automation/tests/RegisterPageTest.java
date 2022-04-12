package com.visionit.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.visionit.automation.base.BaseTest;
import com.visionit.automation.utils.AppConstants;

public class RegisterPageTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(RegisterPageTest.class);
	
	@Test
	public void tc_08_verify_new_user_registration_with_newsletter_and_specialOffer_Subscribed() {
		
		logger.info("Test case started: tc_08_verify_new_user_registration_with_newsletter_and_specialOffer_Subscribed");
		
		boolean isUserGotRegistered = registerPage.registerUserInApp(true, true);
		Assert.assertEquals(isUserGotRegistered, true);
		
		logger.info("Test case ended: tc_08_verify_new_user_registration_with_newsletter_and_specialOffer_Subscribed");
	}
	
	@Test
	public void tc_081_verify_new_user_registration_without_newsletter_and_specialOffer_Subscribed() {
		
		logger.info("Test case started: tc_081_verify_new_user_registration_without_newsletter_and_specialOffer_Subscribed");
		
		boolean isUserGotRegistered = registerPage.registerUserInApp(false, false);
		Assert.assertEquals(isUserGotRegistered, true);
		
		logger.info("Test case ended: tc_081_verify_new_user_registration_without_newsletter_and_specialOffer_Subscribed");
	}

}
