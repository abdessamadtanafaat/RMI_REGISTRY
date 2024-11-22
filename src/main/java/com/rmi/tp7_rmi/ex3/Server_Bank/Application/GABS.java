package com.rmi.tp7_rmi.ex3.Server_Bank.Application;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class GABS {
    public static void main(String[] args) {
        try {
            // Access the remote object
            Compte stubCompte = (Compte) Naming.lookup("rmi://localhost:1099/CompteCourant");

            // List to keep track of all threads
            List<Thread> threads = new ArrayList<>();

            // Launch 100 threads for concurrent operations
            for (int i = 0; i < 100; i++) {
                // Randomly choose between credit or debit and generate a random amount
                boolean isCredit = (i % 2 == 0);
                double montant = 100.0;

                // Create a thread for each operation
                Thread thread = new Thread(new Operations(stubCompte, isCredit, montant));
                threads.add(thread);
                thread.start();
            }

            // Wait for all threads to complete
            for (Thread thread : threads) {
                thread.join(); // Ensures the main thread waits for all threads to finish
            }

            // Check the final account balance
            double finalSolde = stubCompte.lireSolde();
            System.out.println("Final Account Balance: " + finalSolde + " DH");

        } catch (Exception e) {
            System.out.println("Error during concurrent operations: " + e);
            e.printStackTrace();
        }
    }
}

