package com.rmi.tp7_rmi.ex3.Server_Bank.Application;

import com.rmi.tp7_rmi.ex3.Server_Bank.Application.Compte;

public class Operations implements Runnable {
    private final Compte compte;
    private final boolean isCredit;
    private final double montant;

    // Constructor
    public Operations(Compte compte, boolean isCredit, double montant) {
        this.compte = compte;
        this.isCredit = isCredit;
        this.montant = montant;
    }

    // Run method for the thread
    @Override
    public void run() {
        try {
            if (isCredit) {
                // Credit operation
                compte.crediter(montant);
                System.out.println(Thread.currentThread().getName() + " credited " + montant + " DH.");
            } else {
                // Debit operation
                compte.debiter(montant);
                System.out.println(Thread.currentThread().getName() + " debited " + montant + " DH.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
