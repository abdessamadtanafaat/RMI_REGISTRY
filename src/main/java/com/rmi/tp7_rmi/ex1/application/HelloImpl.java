package com.rmi.tp7_rmi.ex1.application;

import java.rmi.*;
import java.rmi.server.*;
public class HelloImpl extends UnicastRemoteObject implements Hello
{
    private String message;
    public HelloImpl(String s) throws RemoteException {
        super();
        message = s;
    }
    public String sayHello() throws RemoteException, InterruptedException {
        Thread.sleep(5000);
        return message;
    }}
