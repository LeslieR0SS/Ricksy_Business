package edu.poniperro.ricksy.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    //Test unitario del constructor
    @Test
    public void CreditCardConstructorTest(){
        CreditCard tarjetaCredito = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals("Abradolph Lincler", tarjetaCredito.getOwner());
        assertEquals("4916119711304546", tarjetaCredito.getNumber());
    }

    @Test
    public void CreditCardConstructorTest2(){
        CreditCard tarjetaCredito = new CreditCard("Leslie", "12345678");
        assertEquals("Leslie", tarjetaCredito.getOwner());
        assertEquals("12345678", tarjetaCredito.getNumber());
    }

    //Test unitario del método PAY

    @Test
    public void payTest(){
        CreditCard tarjetaCredito = new CreditCard("Abradolph Lincler", "4916119711304546");
        tarjetaCredito.pay(1000);
        assertEquals(2000, tarjetaCredito.getCredit());

    }

    @Test
    public void payTest2(){
        CreditCard tarjetaCredito = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals(false, tarjetaCredito.pay(5000));
    }
}

