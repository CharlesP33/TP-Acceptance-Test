package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 *
 * @author chapinet
 */
public class Bar {
    
    private ArrayList<Customer> customers;
    private ArrayList<Customer> queue;
    private HashMap<Customer, Integer> orders;
    
    private final int MAX_CAPACITY;
    
    Bar(int maxCapacity){
        this.customers = new ArrayList<>();
        this.queue = new ArrayList<>();
        this.orders = new HashMap<>();
        this.MAX_CAPACITY = maxCapacity;
    }
    
    public void fillBar(int customersNb){
        for (int i = 0; i < customersNb; i++) {
            customers.add(new Customer());
        }
    }
    
    /*public void tryEnter(Customer... customersTryingEnter){
        boolean canEnter = customersTryingEnter.length > (MAX_CAPACITY - customers.size());
        for (Customer c : customersTryingEnter){
            if (canEnter){
                customers.add(c);
            }else{
                queue.add(c);
            }
        }
    }*/
    
    public boolean tryEnter(Customer... customersTryingEnter){
        boolean canEnter = customersTryingEnter.length > (MAX_CAPACITY - customers.size());
        if (canEnter){
            customers.addAll(Arrays.asList(customersTryingEnter));
        }
        return canEnter;
    }
    
    int getNumberOfPeople() {
        return this.customers.size();
    }
    
    void orderCockail(Customer c, int price){
        orders.put(c, price);
    }

    void setNumberOfCustomer(int count) {
        numberOfPeople = count;
    }

    boolean peopleTryToEnter(int i) {
        boolean canEnter = numberOfPeople + i <= maxNumberOfPeople;
        if (canEnter) numberOfPeople += i;
        return canEnter;
    }

    void setCocktailPrice(int price) {
        cocktailPrice = price;
    }

    void addCocktailToBill(int numberOfCocktail) {
        bill += cocktailPrice * numberOfCocktail;
    }

    int getBill() {
        return bill;
    }

    void drinkFinished() {
        isPignonHappy = numberOfCocktail/2 <= 1;
    }

    boolean isPignonHappy() {
        return isPignonHappy;
    }

}
