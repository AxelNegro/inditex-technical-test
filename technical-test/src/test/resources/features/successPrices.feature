Feature: Success cases when getting product prices

  Scenario Outline: As a customer i want to get the product's prices by brand, product and application date.
    Then I should be able to get price by product <productId> brand <brandId> and application date <applicationDate> and be price id <expectedPriceId>

    Examples:
    | productId | brandId | applicationDate     | expectedPriceId |
    | 35455     | 1       | 2020-06-14T10:00:00 | 1               |
    | 35455     | 1       | 2020-06-14T16:00:00 | 2               |
    | 35455     | 1       | 2020-06-14T21:00:00 | 1               |
    | 35455     | 1       | 2020-06-15T10:00:00 | 3               |
    | 35455     | 1       | 2020-06-16T21:00:00 | 4               |