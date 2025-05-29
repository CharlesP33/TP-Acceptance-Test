package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chapinet
 */
public class Bar {
    
    private ArrayList<Customer> customers;    
    private final int MAX_CAPACITY;
    
    Bar(int maxCapacity){
        this.customers = new ArrayList<>();
        this.MAX_CAPACITY = maxCapacity;
    }
    
    public void fillBar(int customersNb){
        for (int i = 0; i < customersNb; i++) {
            customers.add(new Customer());
        }
    }
    
    public boolean tryEnter(Customer... customersTryingEnter){
        boolean canEnter = customersTryingEnter.length <= (MAX_CAPACITY - customers.size());
        if (canEnter){
            customers.addAll(Arrays.asList(customersTryingEnter));
        }
        return canEnter;
    }
    
    int getNumberOfPeople() {
        return this.customers.size();
    }
    
    void orderCockail(Customer c, int price){
        c.drunkCocktail(1, price);
    }
    
    void transferBill(Customer rich, Customer poor){
        rich.setBill(rich.getBill() + poor.getBill());
        poor.setBill(0);
    }
    
    void transferOneCocktail(Customer rich, Customer poor, int priceOneCocktail){
        rich.setBill(rich.getBill() + priceOneCocktail);
        poor.setBill(poor.getBill() - priceOneCocktail);
    }
}
