package steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import utils.CommonUtils;

public class Assignment4Steps {
	@Steps
	CommonUtils commonSteps;

	String baseUri = "http://restapi.demoqa.com/authentication/CheckForAuthentication/";
	Response response = null;	
	
	@When("^I create the toolsQa login service response with valid credentials$")
	public void i_create_the_toolsQa_login_service_response_with_valid_credentials(DataTable arg1) {
	   response = commonSteps.createUserLoginResponse(arg1.raw().get(0).get(0), arg1.raw().get(0).get(1), baseUri);
	}

	@Then("^I verify the response that user is able to login successfully$")
	public void i_verify_the_response_that_user_is_able_to_login_successfully() {
	   response.then().log().all().statusCode(200).contentType(ContentType.JSON);
		assertTrue(response.then().extract().jsonPath().get("Fault").equals("Operation completed successfully"));
	    
	}

	@Then("^I verify the login failed error details in response$")
	public void i_verify_the_login_failed_error_details_in_response() {
		response.then().log().all().statusCode(401).contentType(ContentType.JSON);
		assertTrue(response.then().extract().jsonPath().get("fault").equals("Invalid username or password"));   
	}
}
