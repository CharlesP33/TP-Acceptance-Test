package com.sqli.isc.iut.courses.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author chapinet
 */
public class BarSteps {
    
    private boolean canEnter;
    private final int MAX_NUMBER_OF_PEOPLE = 10;
    private Bar bar = new Bar(MAX_NUMBER_OF_PEOPLE);

    @Given("the bar has {int} customers")
    public void the_bar_has_customers(int count) {
        bar.setNumberOfCustomer(count);
    }

    @When("Mr Pignon and Mr Leblanc try to enter")
    public void try_to_enter() {
        canEnter = bar.peopleTryToEnter(2);
    }
    
    @When("they each order a cocktail of the month at {int} euros")
    public void each_order_cocktail(int price) {
        bar.setCocktailPrice(price);
    }
    
    @When("Mr Leblanc pays for both cocktails")
    public void leblanc_pay_both() {
        bar.addCocktailToBill(2);
    }
    
    @When("they finish their drinks")
    public void drink_finished() {
        bar.drinkFinished();
    }

    @Then("they are denied entry")
    public void denied_entry() {
        assertEquals(canEnter, false);
    }
    
    @Then("the bar is full")
    public void bar_is_full() {
            assertEquals(MAX_NUMBER_OF_PEOPLE, bar.getNumberOfPeople());
    }
    
    @Then("the total bill for Mr Leblanc is {int} euros")
    public void leblanc_total_bill(int price) {
        assertEquals(price, bar.getBill());
    }
    
    @Then("Mr Pignon is happy")
    public void pignon_is_happy() {
        assertEquals(true, bar.isPignonHappy());
    }
}
