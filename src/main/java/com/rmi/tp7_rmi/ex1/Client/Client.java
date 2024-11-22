package com.rmi.tp7_rmi.ex1.Client;

import com.rmi.tp7_rmi.ex1.application.Hello;

import java.rmi.*;
public class Client {
    public static void main(String[] args) {
        try {
            /* trouver une référence vers l’objet distant */
            Hello stub = (Hello) Naming.lookup("rmi://localhost:1099/BK");
            /* appel de méthode à distance */
            System.out.println(stub.sayHello());
        }

        catch(Exception e) {System.out.println("Serveur erreur :"+e); }}
}
