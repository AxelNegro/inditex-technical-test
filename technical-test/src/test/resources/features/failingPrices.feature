Feature: Failing cases when getting product prices

  Scenario Outline: As a customer i want to get the product's prices by brand, product and application date, but that price doesn't exist.
    Then I should be able to get price by product <productId> brand <brandId> and application date <applicationDate>

    Examples:
    | productId | brandId | applicationDate     |
    | 35455     | 1       | 2022-06-14T10:00:00 |