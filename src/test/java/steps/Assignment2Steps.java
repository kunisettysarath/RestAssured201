package steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import utils.CommonUtils;

public class Assignment2Steps {
	@Steps
	CommonUtils commonSteps;

	String baseUri = "http://restcountries.eu/rest/v1/name/{country}";
	Response response = null;

	@Given("^I get the response from the api and store the details obtained for \"([^\"]*)\"$")
	public void i_get_the_response_from_the_api_and_store_the_details_obtained(String arg1) throws Throwable {
		response = commonSteps.getCountriesDetails(arg1, baseUri);
		response.then().log().all();
	}

	@Then("^I verify that the capital is \"([^\"]*)\" in the response$")
	public void i_verify_that_the_capital_value_is_from_the_response(String arg1) {
		assertTrue(response.then().extract().jsonPath().getList("capital").get(0).equals(arg1));
	}

}
