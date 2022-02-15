package edu.poniperro.ricksy.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UfosPark implements GuestDispacher {

    //atributos
    private float fee = 500;
    private Map<String, String> flota;

    //setters y getters

    public String getOvni(int pos) {
        return flota.get(pos);
    }

    public int getNumeroOvnis(){
        return flota.size();
    }

    // constructor
    public UfosPark(){
    flota =new HashMap<String, String>();
    }

    //método para añadir ovnis a ala flota de ovnis
    public void add(String ovni){
        flota.put(ovni,"0");
    }


    // 2n Método: para cobrar y asignar un ovnia al cliente.
    @Override
    public void dispatch(CreditCard creditCard) {
        //vamos a de declarar dos variables para hacer la búsqueda de los ufos id dentro del map de flota
        String clave, valor;
        boolean tieneOvni = false;
        //si con la tarjeta  de  credito se puede pagar  500 EZIS, entonces le asignamos un ovni
        String ovni = getUfoOf(creditCard.number());
        //si el valor es null, significa que  a esa tarjeta de credito nose ha asignasdo un ovni.
        if (ovni == null) {
            if (creditCard.pay(fee) == true) {
                for (Map.Entry<String, String> elemento : flota.entrySet()) {
                    clave = elemento.getKey();
                    valor = elemento.getValue();
                    if (valor == "0") {
                        flota.put(clave, creditCard.number());
                        tieneOvni = true;
                        break;
                    }
                }
                // Si no tiene un ovni
                if(tieneOvni==false){
                    creditCard.setCredit(3000);
                }
            }
        }
    }

    //3r Método: la entrada de este método es un número de la tarjeta de crédito.
    // y devolvemos el ovni asignado a la tarjeta  de crédito.
    public String getUfoOf(String numCreditCard){
        //declaramos las 3 variables siguientes:
        String clave, valor, claveEncontrada =null;

        //recorremos el diccionario
        for(Map.Entry<String, String> elemento : flota.entrySet()){
            clave = elemento.getKey();
            valor = elemento.getValue();
            if(valor==numCreditCard) {
                claveEncontrada = clave;
                break;
            }
        }
        return claveEncontrada;

    }

    @Override
    public String toString(){
        Set<String> listaOvnis  = flota.keySet();
        String ovnis = listaOvnis.toString();
        return ovnis;
    }

}
