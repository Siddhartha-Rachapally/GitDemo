Feature: Search and Place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home an Offers page
    Given User is on GreenCart Landing Page
    When user Searched with Shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name Offers page matched with Landing page

    Examples:
    |  Name |
    |  Tom  |
    | Beet  |

