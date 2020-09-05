Feature: Verify different PUT operation using Rest-assured

  Scenario: Verify PUT operation can be performed and resouce can be modified

    When I perform GET operation
    Then I should see the first name of user is "Janet"

    When I perform PUT operation
    Then I should be able to perform POST operation with status code 201 for user with id 2, First Name "morpheus" and Last Name "cruiz"
