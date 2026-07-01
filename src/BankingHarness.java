import model.Account;
import model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BankingHarness {
    public static void main(String[] args) {
        HashSet<Account> registry = new HashSet<>();
        List<Transaction> transactions = new ArrayList<>();
        Account acct1 = new Account("ACC-888", new BigDecimal("1000.00"), transactions);
        Account acct2 = new Account("ACC-888", new BigDecimal("5000.00"), transactions);

        registry.add(acct1);
        if (registry.contains(acct2)) {
            System.out.println("return true");
        } else {
            System.out.println("false");
        }

        ArrayList<Transaction> testHistory = new ArrayList<>();
        Transaction deposit = new Transaction("a01", new BigDecimal("1000"), "DEPOSIT");
        testHistory.add(deposit);

        Account acct3 = new Account("ACC-888", new BigDecimal("5000.00"), testHistory);
        Transaction withdrawal = new Transaction("a02", new BigDecimal("1000"), "WITHDRAWAL");
        testHistory.add(withdrawal);

        System.out.println(acct3.history());

        try {
            acct3.history().add(new Transaction("a04", new BigDecimal("2000"), "DEPOSIT"));
        } catch(UnsupportedOperationException e) {
            System.out.println("Blocked direct list mutation!");
        }

    }
}