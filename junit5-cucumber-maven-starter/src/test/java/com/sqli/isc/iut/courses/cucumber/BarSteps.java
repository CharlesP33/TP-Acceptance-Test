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
    
    private Customer mr_pignon = new Customer("Mr Pignon", 2);
    private Customer mr_leblanc = new Customer("Mr Leblanc", 10);

    @Given("the bar has {int} customers")
    public void the_bar_has_customers(int count) {
        bar.fillBar(count);
    }

    @When("Mr Pignon and Mr Leblanc try to enter")
    public void try_to_enter() {
        canEnter = bar.tryEnter(mr_pignon, mr_leblanc);
    }
    
    @When("they each order a cocktail of the month at {int} euros")
    public void each_order_cocktail(int price) {
        bar.orderCockail(mr_leblanc, price);
        bar.orderCockail(mr_pignon, price);
    }
    
    @When("Mr Leblanc pays for both cocktails")
    public void leblanc_pay_both() {
        bar.transferBill(mr_leblanc, mr_pignon);
    }
    
    @When("Mr Leblanc orders 2 more cocktails of the month at {int} euros each")
    public void leblanc_order_and_pay_both(int price) {
        bar.orderCockail(mr_leblanc, price);
        bar.orderCockail(mr_pignon, price);
        bar.transferOneCocktail(mr_leblanc, mr_pignon, price);
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
        assertEquals(price, mr_leblanc.getBill());
    }
    
    @Then("the total bill for Mr Pignon is {int} euros")
    public void pignon_total_bill(int price) {
        assertEquals(price, mr_pignon.getBill());
    }
    
    @Then("Mr Pignon is happy")
    public void pignon_is_happy() {
        assertEquals(true, mr_pignon.isHappy());
    }
    
    @Then("Mr Pignon is sad")
    public void pignon_is_sad() {
        assertEquals(false, mr_pignon.isHappy());
    }
}
