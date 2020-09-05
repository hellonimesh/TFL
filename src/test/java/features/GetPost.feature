Feature: Verify different GET and POST operation using Rest-assured

  Scenario: Verify that a GET request can be posted to the API to get the expected details of single user
    When I perform GET operation
    Then I should see that a GET request can be posted to the API to get the expected details of single user with id 1

  Scenario: Verify that a GET request can be posted to the API to return a single user not found
    When I perform GET operation
    Then I should see status code 404 for user with id 12345 which does not exist

  Scenario: Verify that a GET request can be posted to the API to get list of users on specific page
    When I perform GET operation
    Then I should see that upon posting GET request on PAGE 2 I can see user name "Michael" exist

  Scenario: Verify that users list is NOT empty on specific page
    When I perform GET operation
    Then I should see that PAGE 2 is NOT empty

  Scenario: Verify GET request on specific page displays correct status code
    When I perform GET operation
    Then I should see status code 200 for page 1

  Scenario: Verify Path Parameter is working for GET to get the expected details of single user
    When I perform GET operation
    Then I should see that I can perform  Path Parameter for user 2

  Scenario: Verify Query Parameter is working for GET to get the expected details of single user
    When I perform GET operation
    Then I should see that I can perform  Query Parameter for user 2

  Scenario: Verify POST operation can be performed with the correct status code
    When I perform POST operation
    Then I should be able to perform POST operation with status code 201 for user with id 100, First Name "Nimesh" and Last Name "Soni"
