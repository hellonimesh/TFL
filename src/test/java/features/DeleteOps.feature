Feature: Verify DELETE operation using Rest-assured

  Scenario: Verify DELETE operation can be performed with the correct status code
    When I perform DELETE operation for user id 2
    Then I should get a response code 204 if there is nothing to delete for user id 2