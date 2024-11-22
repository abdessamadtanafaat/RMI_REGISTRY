package com.rmi.tp7_rmi.ex3.Server_Bank.Application;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CompteServeur {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            CompteImpl compte = new CompteImpl();
            Naming.rebind("rmi://localhost:1099/CompteCourant", compte );

            System.out.println("Bank server ready");
        }catch (Exception e){
            System.out.print("Server error"+e);
            e.printStackTrace();
        }
    }
}
