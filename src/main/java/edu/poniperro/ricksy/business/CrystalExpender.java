package edu.poniperro.ricksy.business;

public class CrystalExpender implements GuestDispacher {
    //Atributos
    private int stock;
    private double itemCost;

    //constructor
    public CrystalExpender(int stock, double itemCost){
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard creditCard){
        if( creditCard.pay(itemCost) == true){
            this.stock--;

        }

    }

    public int stock(){
        return this.stock;
    }

    @Override
    public String toString(){
        return "stock: " + this.stock + "\n" + "cost: " + this.itemCost;
    }
}
