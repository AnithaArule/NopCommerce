Feature:Purchase Process
  Customer place an order

#  Scenario:As a Customer, I should be able to add items to the shopping cart
#
#    Given the Customer is Registered
#    Given the Customer is logged out
#    Given the Customer is logged in
#    When the Customer attempts to add an item to the shopping cart
#    Then the Customer should be able to view the items in the shopping Cart
#
#
#  Scenario:As a Customer, I should be able to checkout the products in the shopping cart
#
#    Given the Customer is in shopping cart page
#    When the Customer attempts the checkbox
#    When Customer attempts to checkout
#    Then the Customer should be able to view the billing address window
#
#  Scenario:As a Customer, I should be able to define the billing address
#
#    Given the Customer is in billing address page
#    When the Customer attempts to enter the billing options using billing address drop down list or attempts to create new billing address in the relevant field, and attempts to continue,
#    Then the Customer should be able to view the shipping address window.
#
#  Scenario:As a Customer, I should be able to define or choose the Shipping address
#
#    Given the Customer is in Shippong address page
#    When the Customer attempts to choose the required shipping address details or attempts to create a new shipping address using the Select shipping address drop down list, and attempts to continue,
#    Then the Customer should be able to view the shipping Method window.
#
#  Scenario:As a Customer, I should be able to choose Shipping method
#
#    Given the Customer is in shipping method page
#    When the Customer attempts to choose one of the options (either In-store Pickup or By Ground or By Air),
#    When the Customer Attempts to Continue,
#    Then the Customer should be able to view the Payment Method window.
#
#  Scenario:As a Customer, I should be able to choose payment method
#
#    Given the Customer is in payment method page
#    Given the Customer has reward points to use,
#    When the Customer attempts to Use my reward points,
#    When the Customer attempts to choose the payment method (Cash on Delivery, or Check/Money Order or Credit Card or Purchase Order or Pay in Store),
#    When the Customer attempts to continue1,
#    Then the Customer should be able to view Payment Information Window.
#
#  Scenario:As a Customer, I should be able to define payment information
#
#    Given the Customer is in payment information page
#    When the Customer enters Valid Payment Information,
#    When the Customer attempts to Continue3
#    Then the Customer should be able to view the Confirmation window.

  Scenario:As a Customer, I should be able to place the order

    Given the Customer is in confirmation page
    When the Customer Attempts to Confirm,
    Then the Customer should be able to view the the window showing your order has been Successfully placed.

  Scenario:As a Customer, I should be able to view the order details

    Given the Customer is in order successfully placed page

    When the Customer  attempts order details,
    Then the Customer should be able to view the order information



