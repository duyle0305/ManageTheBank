/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.Scanner;

/**
 *
 * @author SE140861
 */
public class NewAccount {

    String ID;
    String username;
    String password;
    double amount;
    Scanner sc = new Scanner(System.in);

    public NewAccount() {
    }

    public NewAccount(String ID, String username, String password, double amount) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "NewAccount{" + "ID=" + ID + ", username=" + username + ", password=" + password + ", amount=" + amount + '}';
    }

}
