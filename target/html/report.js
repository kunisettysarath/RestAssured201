$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Assignment4.feature");
formatter.feature({
  "name": "This feature is used to login and validate the response from the api",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login using the service and validate the response for valid and invalid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I create the toolsQa login service response with valid credentials",
  "rows": [
    {
      "cells": [
        "ToolsQA",
        "TestPassword"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "Assignment4Steps.i_create_the_toolsQa_login_service_response_with_valid_credentials(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the response that user is able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Assignment4Steps.i_verify_the_response_that_user_is_able_to_login_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I create the toolsQa login service response with valid credentials",
  "rows": [
    {
      "cells": [
        "DummyUserName",
        "DummyPassword"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "Assignment4Steps.i_create_the_toolsQa_login_service_response_with_valid_credentials(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the login failed error details in response",
  "keyword": "Then "
});
formatter.match({
  "location": "Assignment4Steps.i_verify_the_login_failed_error_details_in_response()"
});
formatter.result({
  "status": "passed"
});
});