package com.rmi.tp7_rmi.ex2.Server_Bank.Application.Custmor_Bank;

import com.rmi.tp7_rmi.ex2.Server_Bank.Application.Compte;

import java.rmi.Naming;

public class CompteClient {
    public static void main (String[] args) {
        try {
            Compte stubCompte = ((Compte) Naming.lookup("rmi://localhost:1099/CompteCourant"));

            stubCompte.debiter(500.0);
            stubCompte.crediter(800.00);
            double solde = stubCompte.lireSolde();

            System.out.println("Current Balance: " + solde + " DH");
        } catch (Exception e) {
            System.out.println("Client error: " + e);
            e.printStackTrace();
        }
    }
}
