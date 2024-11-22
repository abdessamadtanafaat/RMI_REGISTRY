package com.rmi.tp7_rmi.ex1.application;

public interface Hello extends java.rmi.Remote {
    public String sayHello() throws java.rmi.RemoteException, InterruptedException;
}