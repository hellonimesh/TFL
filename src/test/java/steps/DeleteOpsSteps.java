package steps;

import Util.BDDStyledMethod;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteOpsSteps {
    @When("I perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url) {
    }

    @When("I perform DELETE operation for user id {int}")
    public void iPerformDELETEOperationForUserId(int id) {
        BDDStyledMethod.PerformDeleteOperation( id );
    }

    @Then("I should get a response code {int} if there is nothing to delete for user id {int}")
    public void iShouldGetAResponseCodeIfThereIsNothingToDeleteForUserId(int response_code, int id) {
        BDDStyledMethod.VerifyResponseCodeIfThereIsNothingToDelete( response_code, id );
    }
}