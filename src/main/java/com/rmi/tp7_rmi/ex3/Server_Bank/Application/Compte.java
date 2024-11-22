package com.rmi.tp7_rmi.ex3.Server_Bank.Application;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compte extends Remote {
    void debiter(double montant) throws RemoteException;
    void crediter(double montant) throws RemoteException;
    double lireSolde() throws RemoteException;
}

