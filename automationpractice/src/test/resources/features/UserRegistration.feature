Feature: User Registration

  Scenario: Successful User registration
    Given User is on Homepage
    And User has required information to complete registration
      | title | customerFirstName | customerLastName | email  | password | dob        | newsletter | specialOffers | firstName | lastName | company | address1         | address2 | city  | state | postcode | country       | additionalInfo | homePhone      | mobilePhone    | addressAlias |
      | Mr    | David             | Sanders          | random | random   | 02/02/1970 | true       | true          | David     | Sanders  | Google  | 1812 Ranger St , | Midland  | Texas | Texas | 78653    | United States | NA             | (806) 669-6756 | (806) 669-6746 | TX           |