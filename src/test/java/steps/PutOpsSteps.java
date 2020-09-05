package steps;

import Util.BDDStyledMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PutOpsSteps {
    @Given("I should be able to perform PUT operation with status code {int} for user with id {int}, First Name {string} and Last Name {string}")
    public void iShouldBeAbleToPerformPUTOperationWithStatusCodeForUserWithIdFirstNameAndLastName(int status_code, int id, String firstName, String lastName) {
        BDDStyledMethod.PerformPOSTwihtBodyParameter( status_code, id, firstName, lastName );
    }

    @Then("I should see the first name of user is {string}")
    public void iShouldSeeTheFirstNameOfUserIs(String user) {
        BDDStyledMethod.PerformGETforUser( user );
    }

    @When("I perform PUT operation")
    public void iPerformPUTOperation() {
    }
}