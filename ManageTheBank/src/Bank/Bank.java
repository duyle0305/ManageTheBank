/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

/**
 *
 * @author SE140861
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("MANAGING BANK");
        System.out.println("");
        Menu mnu = new Menu("Main Menu");
        mnu.add("Create new account");
        mnu.add("Login function");
        int mainchoose;
        Menu Loginmnu = new Menu("Choose function");
        Loginmnu.add("Withdrawal function");
        Loginmnu.add("Deposit function");
        Loginmnu.add("Transfer function");
        Loginmnu.add("Remove account");
        int login;
        CreateNewAccount list = new CreateNewAccount();
        do {
            mainchoose = mnu.getUserChoice();
            switch (mainchoose) {
                case 1:
                    list.addNewAccount();
                    break;
                case 2:
                    int i = list.Login();
                    if (i >= 0) {
                        do {
                            login = Loginmnu.getUserChoice();
                            switch (login) {
                                case 1:
                                    list.Withdraw(i);
                                    break;
                                case 2:
                                    list.Deposit(i);
                                    break;
                                case 3:
                                    list.TransferMoney(list, i);
                                    break;
                                case 4:
                                    list.deleteAccount(i);
                                    break;
                            }
                        } while (login > 0 && login <= Loginmnu.size());
                        break;
                    } else {
                        break;
                    }
            }
        } while (mainchoose > 0 && mainchoose <= mnu.size());

    }

}
