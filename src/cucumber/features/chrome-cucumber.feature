Feature: Placing order
 Scenario Outline: Placing order on mystore. After completing order screenshot is taken.
   Given Opened browse
   Then Opened site
   And User is logged. Email <email> password <password>
   And Item is added. Size <size> quantity <quantity>
   And Order is finished
   And Screenshot is taken number <number>
   And Price and status of order is checked order status <order status>
   And Browser is closed
   Examples:
   | email                          | password           | size | quantity | number | order status           |
   | chomikdzungarski007@gmail.com  | takiesamojakemail  | M    | 5        | 1      | Awaiting check payment |
   | chomikdzungarski007@vp.pl      | takiesamojakemail  | S    | 2        | 2      | Awaiting check payment |
   | chomikdzungarski007@autograf.pl| takiesamojakemail  | XL   | 3        | 3      | Awaiting check payment |

