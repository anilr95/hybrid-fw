package com.visionit.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.visionit.automation.base.BaseTest;
import com.visionit.automation.variables.SocialMediaPagesVariables;


public class SocialMediaPagesTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(SocialMediaPagesTest.class);
	
	@Test
	public void tc_13_verify_facebook_link() {
		
		logger.info("Test case started: tc_13_verify_facebook_link");
		
		String actualFacebookLinkChannelNameText = socialMediaPages.getFacebookLinkChannelName();
		Assert.assertEquals(actualFacebookLinkChannelNameText, SocialMediaPagesVariables.facebookChannelNameText);
		
		logger.info("Test case ended: tc_13_verify_facebook_link");
	}
	
	@Test
	public void tc_14_verify_twitter_link() {
		
		logger.info("Test case started: tc_14_verify_twitter_link");
		
		String actualTwitterLinkChannelNameText = socialMediaPages.getTwitterLinkChannelName();
		Assert.assertEquals(actualTwitterLinkChannelNameText, SocialMediaPagesVariables.twitterChannelNameText);
		
		logger.info("Test case ended: tc_14_verify_twitter_link");
	}
	
	@Test
	public void tc_15_verify_youtube_link() {
		
		logger.info("Test case started: tc_15_verify_youtube_link");
		
		String actualYoutubeLinkChannelNameText = socialMediaPages.getYoutubeLinkChannelName();
		Assert.assertEquals(actualYoutubeLinkChannelNameText, SocialMediaPagesVariables.youtubeChanneNameText);
		
		logger.info("Test case ended: tc_15_verify_youtube_link");
	}
	
}
