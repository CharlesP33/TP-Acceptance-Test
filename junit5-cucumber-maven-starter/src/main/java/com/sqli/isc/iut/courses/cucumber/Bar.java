package com.sqli.isc.iut.courses.cucumber;

/**
 *
 * @author chapinet
 */
public class Bar {
    
    private int numberOfPeople;
    private int maxNumberOfPeople;
    private int bill;
    private int cocktailPrice;
    private int numberOfCocktail;
    private boolean isPignonHappy;
    
    Bar(int maxNumberOfPeople){
        this.numberOfPeople = 0;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.bill = 0;
        this.cocktailPrice = 0;
        this.numberOfCocktail = 0;
        this.isPignonHappy = true;
    }
    
    int getNumberOfPeople() {
        return this.numberOfPeople;
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
