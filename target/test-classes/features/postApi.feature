@tag
Feature: Verify the Get POst in the API

  @tag1
  Scenario Outline: Get all posts from the API
    Given Get methodto "<urls>"
    Then Response new is <statusCodes>

    Examples: 
      | urls       | statusCodes |
      | /getHeroes |         200 |

  @tag2
  Scenario: posts from the API
    Given post the data
      | id | name |
      | 20 | pavi |
   
    Then Response StatusCode is 201
