Feature:Product page

@AddDeleteProduct
  Scenario Outline:Add and delete a product from the products list
    Given Login page is visible URL "https://dashboard.nexudus.com/billing/products"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Successful sign in
    And Add the Product and fill the details name "<Name>","<Description>" and "<Price>" fields
  And Delete added product
Examples:
      | Email                           | Password      |Name|Description|Price|
      | adrian+1004930927@nexudus.com   |414HHK9dxg--Gj |test1|Verify automation test is working for additional product.|10|