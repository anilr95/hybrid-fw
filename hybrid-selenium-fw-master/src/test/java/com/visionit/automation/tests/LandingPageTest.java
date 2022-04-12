package com.visionit.automation.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.visionit.automation.base.BaseTest;
import com.visionit.automation.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LandingPageTest.class);
	
	@Test
	public void tc_01_verify_landing_page_url_redirection() {
		
		logger.info("Test case started: tc_01_verify_landing_page_url_redirection");
		
		String landingPageActulaRedirectedUrl = landingPage.getLandingPageUrl();
		logger.info("Landing page actual redirected URl is : " + landingPageActulaRedirectedUrl);
		Assert.assertEquals(landingPageActulaRedirectedUrl, AppConstants.LANDING_PAGE_REDIRECTED_URL);
		
		logger.info("Test case ended: tc_01_verify_landing_page_url_redirection");
	}
	
	@Test
	public void tc_02_verify_landing_page_title() {
		
		logger.info("Test case started: tc_02_verify_landing_page_title");
		
		String landingPageActualTitle = landingPage.getLandingTitle();
		logger.info("Landing page actual title is : " + landingPageActualTitle);
		Assert.assertEquals(landingPageActualTitle, AppConstants.LANDING_PAGE_TITLE);
		
		logger.info("Test case ended: tc_02_verify_landing_page_title");
	}
	
	@Test(enabled=true)
	public void tc_03_verify_product_category_landing_page() {
		
		logger.info("Test case started: tc_03_verify_product_category_landing_page");
		
		// adding actual product categories from landing page to the logs
		List<WebElement> landingPageProdCategoryActual = landingPage.getLandingPageProdCategory();
		logger.info("Landing page actual prod category list contains : ");
		for (int i = 0; i < landingPageProdCategoryActual.size(); i++) {
			logger.info((i+1) + ". " + landingPageProdCategoryActual.get(i).getText());
		}
		
		// adding expected product categories for the landing page to the logs
		ArrayList<String> landingPageProdCategoryExpected = AppConstants.landingPageProdCategoryExpected();
		logger.info("Landing page exepcted prod category list contains : ");
		for (int i = 0; i < landingPageProdCategoryExpected.size(); i++) {
			logger.info((i+1) + ". " + landingPageProdCategoryExpected.get(i));
		}
		
		// Validating the actual vs expected product categories
		for (int i = 0; i < landingPageProdCategoryExpected.size(); i++) {
			if (landingPageProdCategoryExpected.get(i).contentEquals(landingPageProdCategoryActual.get(i).getText())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}	
		
		logger.info("Test case ended: tc_03_verify_product_category_landing_page");
	}
	
	@Test
	public void tc_04_verify_landing_page_logo_visiblity() {
		
		logger.info("Test case started: tc_04_verify_landing_page_logo_visiblity");
		
		boolean landingPageLogoVisiblity = landingPage.getLandingPageLogo();
		logger.info("Visibility status of application logo is : " + landingPageLogoVisiblity);
		Assert.assertEquals(landingPageLogoVisiblity, true);
		
		logger.info("Test case ended: tc_04_verify_landing_page_logo_visiblity");
	}
}
