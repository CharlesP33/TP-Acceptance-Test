Feature: Bar access and orders

    Scenario: Mr Pignon and Mr Leblanc are denied entry because the bar is almost full
        Given the bar has 9 customers
        When Mr Pignon and Mr Leblanc try to enter
        Then they are denied entry

    Scenario: Mr Pignon and Mr Leblanc enter and order, bar becomes full
        Given the bar has 8 customers
        When Mr Pignon and Mr Leblanc try to enter
        And they each order a cocktail of the month at 10 euros
        And Mr Leblanc pays for both cocktails
        Then the bar is full
        And the total bill for Mr Leblanc is 20 euros
        And Mr Pignon is happy

    Scenario: Mr Pignon and Mr Leblanc drink, pay separately, and Mr Leblanc orders more
        Given the bar has 3 customers
        When Mr Pignon and Mr Leblanc try to enter
        And they each order a cocktail of the month at 10 euros
        And Mr Leblanc orders 2 more cocktails of the month at 10 euros each
        Then the total bill for Mr Pignon is 10 euros
        And the total bill for Mr Leblanc is 30 euros
        And Mr Pignon is sad

