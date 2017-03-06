package com.example.matthewbrown.testapp;

public class FoodItem {

    private String itemName;
    private int ID;
    private double daysLeft;
    private double daysSincePurchased;
    private double usagePerDay;
    private double amount;
    private double oldAmount;
    private double oldDays;
    private boolean alreadyBought = false;
    private boolean trendFormed = false;

    public FoodItem()
    {

    }

    public FoodItem(String n, double qty)
    {
        itemName = n;
        setAmount(qty);
    }

    public FoodItem(int i, String n, double qty)
    {
        ID = i;
        itemName = n;
        amount = qty;
    }

    public void setID(int i)
    {
        ID = i;
    }

    public int getID()
    {
        return ID;
    }

    public void buy(double qty)
    {
        oldAmount = amount; //Keep track of previous amount before buying more
        setAmount(getAmount() + qty);
        oldDays = daysSincePurchased;
        if(alreadyBought)
        {
            usagePerDay = (amount - oldAmount) / ( oldDays );
            trendFormed = true;
        }
        daysSincePurchased = 0;
    }

    public double getDaysLeft() {
        daysLeft = amount / usagePerDay;
        return daysLeft;
    }
    public void setDaysLeft(double daysLeft) {
        this.daysLeft = daysLeft;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getDaysSincePurchased() {
        return daysSincePurchased;
    }
    public void setDaysSincePurchased(double d) {
        daysSincePurchased = d;
        if(trendFormed)
        {
            amount -= daysSincePurchased * usagePerDay;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double a) {
        amount = a;
    }


    public boolean isAlreadyBought() {
        return alreadyBought;
    }

    public void setAlreadyBought(boolean alreadyBought) {
        this.alreadyBought = alreadyBought;
    }

    public double getUsagePerDay()
    {
        return usagePerDay;
    }



}