package steps;

import Util.BDDStyledMethod;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetPostSteps {

    @Then("I should see that a GET request can be posted to the API to get the expected details of single user with id {int}")
    public void iShouldVerifyThatAGETRequestCanBePostedToTheAPIToGetTheExpectedDetailsOfSingleUserWithId(int user_id) {
        BDDStyledMethod.SimpleGETPost( user_id );
    }

    @Then("I should see status code {int} for user with id {int} which does not exist")
    public void iShouldSeeStatusCodeForUserWithIdWhichDoesNotExist(int status_code, int user_id) {
        BDDStyledMethod.VerifyStatusCodeForGivenUserId( status_code, user_id );
    }

    @Then("I should see that upon posting GET request on PAGE {int} I can see user name {string} exist")
    public void iShouldVerifyThatUponPostingGETRequestOnPAGEICanSeeUserNameExist(int page, String user_name) {
        BDDStyledMethod.VerifyUserDetailsOnGivenPage( page, user_name );
    }

    @Then("I should see that PAGE {int} is NOT empty")
    public void iShouldVerifyPAGEIsNOTEmpty(int page) {
        BDDStyledMethod.VerifyPageIsNotEmpty( page );
    }

    @Then("I should see status code {int} for page {int}")
    public void iShoudSeeStatusCodeForPage(int status_code, int page) {
        BDDStyledMethod.VerifyStatusCodeForGivenRequest( status_code, page );
    }

    @Then("I should see that I can perform  Path Parameter for user {int}")
    public void iShouldVerifyThatICanPerformPathParameterForUser(int user) {
        BDDStyledMethod.PerformPathParameter( user );
    }

    @Then("I should see that I can perform  Query Parameter for user {int}")
    public void iShouldVerifyThatICanPerformQueryParameterForUser(int user) {
        BDDStyledMethod.PerformQueryParameter( user );
    }

    @Then("I should be able to perform POST operation with status code {int} for user with id {int}, First Name {string} and Last Name {string}")
    public void iShouldBeAbleToPerformPOSTOperationWithStatusCodeForUserWithIdFirstNameAndLastName(int status_code, int id, String firstName, String lastName) {
        BDDStyledMethod.PerformPOSTwihtBodyParameter( status_code, id, firstName, lastName );
    }

    @When("I perform POST operation")
    public void iPerformPOSTOperation() {
    }

    @When("^I perform GET operation$")
    public void iShouldPerformGETOperationFor() throws Throwable {
    }

}