/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author SE140861
 */
public class CreateNewAccount extends ArrayList<NewAccount> {

    Scanner sc = new Scanner(System.in);

    public int searchID(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).ID.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchAccound(String id, String pass) {
        id = id.trim();
        pass = pass.trim();
        for (int i = 0; i < this.size(); i++) {
            if (id.equals(this.get(i).ID) && pass.equals(this.get(i).password)) {
                return i;
            }
        }
        return -1;
    }

    public int searchPWD(String pass) {
        pass = pass.trim();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).password.equals(pass)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewAccount() {
        String ID;
        String username;
        String password;
        String cpassword;
        double amound = 0;
        boolean chekID;
        do {
            System.out.println("");
            ID = MyScanner.getNonBlankStr("Input ID");
            ID = ID.trim().toUpperCase();
            chekID = (this.searchID(ID) >= 0);
            if (chekID) {
                System.out.println("ID is duplicated!");
            }
        } while (chekID);
        username = MyScanner.getNonBlankStr("Input username");
        boolean checkpassword;
        do {
            password = MyScanner.getPwdStr("Input password");
            checkpassword = MyScanner.password(password);
        } while (checkpassword == false);
        do {
            cpassword = MyScanner.getNonBlankStr("Input confirm password");
            System.out.println("");
        } while (!cpassword.equals(password));
        password = MyScanner.ceasarCode(password);
        NewAccount Account = new NewAccount(ID, username, password, amound);
        this.add(Account);
    }

    public int Login() {
        String id;
        String pwd;
        id = MyScanner.getNonBlankStr("ID ");
        pwd = MyScanner.getNonBlankStr("Password ");
        for (NewAccount a : this) {
            a.password = MyScanner.ceasarDecode(a.password);
        }
        int ok = this.searchAccound(id, pwd);
        if (ok < 0) {
            System.out.println(ok);
            System.out.println("You have entered your id or password incorrecly!");
            return -1;
        }
        System.out.println("Login successfuly");
        return ok;

    }

    public void Withdraw(int i) {
//        int i = Login();
        double addmoney;
        System.out.println("Enter the ammount you want to withdraw: ");
        addmoney = sc.nextDouble();
        if (addmoney > this.get(i).amount) {
            System.out.println("ERROR!");
        } else {
            this.get(i).amount -= addmoney;
        }
    }

    public void Deposit(int i) {
//        int i = Login();
        double addmoney;
        System.out.print("Enter the amount you want to deposit: ");
        addmoney = sc.nextDouble();
        boolean ok;
        System.out.print("ARE YOU STILL WANT TO DEPOSIT $" + addmoney + " INTO ACCOUNT ID:" + this.get(i).ID + "(Yes/No): ");
        ok = sc.nextBoolean();
        if (ok) {
            this.get(i).amount += addmoney;
        }
    }

    public void TransferMoney(CreateNewAccount newAccount, int i) {
//        int i = Login();
        String recipientID;
        double addmoney;
        int check;
        System.out.println("Enter the account you want to transfer.");
        do {
            recipientID = MyScanner.getNonBlankStr("Input ID");
            check = newAccount.searchID(recipientID);
            if (check < 0) {
                System.out.println("The account doesn't exist!");
            }
        } while (check < 0);
        System.out.println(newAccount.get(check).username);

        System.out.print("Enter the ammount you want to transfer money:");
        addmoney = sc.nextDouble();
        if (addmoney > this.get(i).amount) {
            System.out.println("ERROR: ");
        } else {
            boolean ok;
            System.out.print("ARE YOU STILL WANT TO DEPOSIT $?" + addmoney + " INTO ACCOUNT ID:" + this.get(i).ID + "? (Yes/No): ");
            ok = sc.nextBoolean();
            if (ok == true) {
                this.get(i).amount -= addmoney;
                newAccount.get(check).amount += addmoney;
            }
        }
    }

    public void deleteAccount(int i) {
//        int i=Login();
        boolean ok;
        System.out.print("ARE YOU STILL WANT TO DELETE THE ACCOUNT ID:" + this.get(i).ID + "? (Yes-No)?: ");
        ok = sc.nextBoolean();
        if (ok == true) {
            this.remove(i);
        }
    }

}
