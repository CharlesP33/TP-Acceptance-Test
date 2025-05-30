package com.sqli.isc.iut.courses.cucumber;

/**
 *
 * @author depinfo
 */
public class Customer {
    
    private final String name;
    
    private int drunkCocktails;
    private int bill;
    private final int NB_COCKTAILS_BEFORE_SICK;
    
    /*
    Constructeur générique
    */
    public Customer(){
        this.name = "Inconnu";
        this.drunkCocktails = 0;
        this.bill = 0;
        this.NB_COCKTAILS_BEFORE_SICK = 10;
    }
    
    public Customer(String name, int nb_cocktails_before_sick){
        this.name = name;
        this.drunkCocktails = 0;
        this.bill = 0;
        this.NB_COCKTAILS_BEFORE_SICK = nb_cocktails_before_sick;
    }
    
    public void drunkCocktail(int amount, int price){
        drunkCocktails += amount;
        bill += price * amount;
    }
    
    public void setBill(int price){
        bill = price;
    }
    
    public int getBill(){
        return bill;
    }
    
    public boolean isHappy(){
        return drunkCocktails < NB_COCKTAILS_BEFORE_SICK;
    }
    
}
