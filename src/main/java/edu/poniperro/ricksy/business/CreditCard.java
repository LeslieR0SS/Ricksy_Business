package edu.poniperro.ricksy.business;

public class CreditCard {

    private String owner;
    private String number;


    private int credit;
    private String SYMBOL;

    //constructor

    public CreditCard(String owner, String number){
        this.owner  = owner;
        this.number = number;
        this.credit = 3000;
    }

    //setters y getters
    public String getOwner() {
        return owner;
    }

    public String getNumber() {
        return number;
    }

    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }


    // Metodos
    public boolean pay (double charge){
        if(charge<= this.credit){
            this.credit-=charge;
            return true;
        }
        else return false;
    }

    public String number(){
        return this.number; //**
    }
    public double credit(){
        return this.credit;
    }

    @Override
    public String toString(){
    return  "owner: " + this.owner + "\n" + "number: " + this.number + "\n" + "credit: " + this.credit + " EZI";
    }
}
