package steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import utils.CommonUtils;

public class Assignment3Steps {
	@Steps
	CommonUtils commonSteps;

	String baseUri = "http://restapi.demoqa.com/customer/register";
	Response response = null;
	UserModel randomUser = null;

	@Given("^I get the response from the api and store the details obtained for \"([^\"]*)\"$")
	public void i_get_the_response_from_the_api_and_store_the_details_obtained(String arg1) throws Throwable {
		response = commonSteps.getCountriesDetails(arg1, baseUri);
		response.then().log().all();
	}

	@Then("^I verify that the capital is \"([^\"]*)\" in the response$")
	public void i_verify_that_the_capital_value_is_from_the_response(String arg1) {
		assertTrue(response.then().extract().jsonPath().getList("capital").get(0).equals(arg1));
	}

	@Given("^I generate a random user to register into the application$")
	public void i_generate_a_random_user_to_register_into_the_application() {
		String firstName = commonSteps.randomStringGenerator(5, "text");
		String lastName = commonSteps.randomStringGenerator(5, "text");
		String userName = commonSteps.randomStringGenerator(8, "alphaNumeric");
		String password = "Test@1234";
		String email = commonSteps.randomStringGenerator(8, "alphaNumeric") + "@gmail.com";
		randomUser = new UserModel(firstName, lastName, userName, password, email);
		
	}

	@Then("^I register the created user using service and validate the success code in the response$")
	public void i_register_the_created_user_using_service_and_validate_the_user_created_response() {
		response = SerenityRest.given().contentType(ContentType.JSON).baseUri(baseUri).body(randomUser).when().log().all().post();
		response.then().log().all().statusCode(201).contentType(ContentType.JSON);
		assertTrue(response.then().extract().jsonPath().get("SuccessCode").equals("OPERATION_SUCCESS"));
	}

	@Then("^I register with the existing user and validate the error response$")
	public void i_register_with_the_existing_user_and_validate_the_error_response() {
		response = SerenityRest.given().contentType(ContentType.JSON).baseUri(baseUri).body(randomUser).when().log().all().post();
		response.then().log().all().statusCode(200).contentType(ContentType.JSON);
		assertTrue(response.then().extract().jsonPath().get("fault").equals("FAULT_USER_ALREADY_EXISTS"));
	}
}
