package com.rmi.tp7_rmi.ex2.Server_Bank.Application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompteImpl extends UnicastRemoteObject implements Compte {

    private double solde;

    public CompteImpl () throws RemoteException {
        super();
        this.solde = 1000.0;
    }

    @Override
    public void debiter(double montant) throws RemoteException {
        if (montant <= solde) {
            solde -= montant;
            System.out.println("Debited: " + montant + " DH. New Balance: " + solde + " DH");

        }else {
            System.out.println("Insufficient funds for debiting " + montant + " DH.");
        }
    }

    @Override
    public void crediter(double montant) throws RemoteException{
        solde += montant;
        System.out.println("Credited: " + montant + " DH. New Balance: " + solde + " DH");
    }

    @Override
    public double lireSolde() throws RemoteException {
        return solde;
    }
}
