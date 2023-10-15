Feature:Login page

  @Login
  Scenario Outline:Login unsuccessful in Nexudus website
    Given Login page is visible URL "https://dashboard.nexudus.com/"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Click on Sign in
    Then close the driver
    Examples:
      | Email            | Password |
      | bad@example.com  |badpassword |

  @Login
  Scenario Outline:Login successful in Nexudus website
    Given Login page is visible URL "https://dashboard.nexudus.com/"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Successful sign in
    Then close the driver
    Examples:
      | Email            | Password |
      | adrian+1004930927@nexudus.com   |414HHK9dxg--Gj |


