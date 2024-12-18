package com.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UdemyLoginPageObjects;

public class UdemyLoginStepDefinitions extends UdemyLoginPageObjects {
	
	@Given("User lanches the udemy mobile homepage")
	public void user_lanches_the_udemy_mobile_homepage() {
		String CurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(CurrentMethod);
	    setup();
//	    driver.get("https://www.udemy.com/");
	}
	@Given("User navigated to loginpage")
	public void user_navigated_to_loginpage() {
		
	}
	@When("user enters the email id {string} and password {string}")
	public void user_enters_the_email_id_and_password(String string, String string2) {
	    
	}
	@Then("User views the invalid login errors")
	public void user_views_the_invalid_login_errors() {
	    
	}

}
