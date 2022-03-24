Feature: To test the login functionality of the application

  Scenario Outline: Checking login functionality with valid credentials
    Given the user is on sign in page
    When the user enter valid "<username>" and "<password>"
    Then the user should be navigated to the homepage

    Examples: 
      | username                  | password |
      | rathishkuma@gmail.com | User@22  |

  Scenario: Search specific product and add to cart
    Given user is logged in and is on the homepage
    When user search for specific product
    Then user should be able to add the product to the cart
