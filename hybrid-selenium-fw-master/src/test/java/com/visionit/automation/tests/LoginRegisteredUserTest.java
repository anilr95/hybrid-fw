package com.visionit.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionit.automation.utils.ExcelUtil;
import com.visionit.automation.base.BaseTest;
import com.visionit.automation.pages.LoginRegisteredUser;

public class LoginRegisteredUserTest extends BaseTest{
	
	private static final Logger logger = LogManager.getLogger(LoginRegisteredUserTest.class);
	
	@Test(dataProvider = "registeredUserData")
	public void tc_20_verify_registered_user_login_to_app(String SrNo, String Username, String Password, String Firstname, String Lastname) {
		//System.out.println("Test Is running for following data set : " + SrNo);
		//System.out.println(" | Username: " + Username + " | Password: " + Password + " | Firstname: " + Firstname + " | Lastname: " + Lastname + " | ");
		logger.info("Test Is running for following data set : " + SrNo);
		logger.info(" | Username: " + Username + " | Password: " + Password + " | Firstname: " + Firstname + " | Lastname: " + Lastname + " | ");
		boolean isUserAbleToLogIn = loginRegisteredUser.loginRegisteredUserToApp(Username, Password, Firstname, Lastname);
		Assert.assertEquals(isUserAbleToLogIn, true, "User is unable to login with given credentials");
	}

	
	@DataProvider(name = "registeredUserData")
	public Object registeredUserTestData()
	{
		Object loginUserData = ExcelUtil.excelDataProvider("loginData");
		return loginUserData;
	}
}
