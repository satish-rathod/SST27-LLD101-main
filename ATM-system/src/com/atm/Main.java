package com.atm;

import com.atm.core.ATM;
import com.atm.domain.Account;
import com.atm.domain.Card;
import com.atm.domain.Denomination;
import com.atm.domain.TransactionType;
import com.atm.hardware.CardReader;
import com.atm.hardware.CashDispenser;
import com.atm.hardware.PinPad;
import com.atm.hardware.Printer;
import com.atm.hardware.impl.SimpleCardReader;
import com.atm.hardware.impl.SimplePinPad;
import com.atm.hardware.impl.SimplePrinter;
import com.atm.services.BankService;
import com.atm.services.impl.InMemoryBankService;
import com.atm.util.CashInventory;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Bank Service and Accounts
        BankService bankService = new InMemoryBankService();
        Account account1 = new Account("123456789", "1234", 10000.00);
        Account account2 = new Account("987654321", "4321", 5000.00);
        ((InMemoryBankService) bankService).addAccount(account1);
        ((InMemoryBankService) bankService).addAccount(account2);

        // 2. Setup ATM Cash Inventory
        CashInventory inventory = new CashInventory();
        inventory.addCash(Denomination.D_2000, 20);
        inventory.addCash(Denomination.D_500, 50);
        inventory.addCash(Denomination.D_200, 100);
        inventory.addCash(Denomination.D_100, 200);

        // 3. Setup Hardware Components
        CardReader cardReader = new SimpleCardReader();
        PinPad pinPad = new SimplePinPad();
        Printer printer = new SimplePrinter();
        CashDispenser cashDispenser = new CashDispenser(inventory);

        // 4. Initialize the ATM
        ATM atm = new ATM(cardReader, pinPad, cashDispenser, printer, bankService);
        System.out.println("ATM is now online.");
        System.out.println("=====================================");

        // --- Simulate a User Interaction ---
        Card userCard = new Card("123456789", "John Doe");

        atm.insertCard(userCard);
        atm.enterPin("1234"); // Correct PIN

        // Perform a withdrawal
        atm.selectTransaction(TransactionType.WITHDRAWAL);
        atm.withdraw(2700); // e.g., 1x2000, 1x500, 1x200

        // Check balance
        atm.selectTransaction(TransactionType.BALANCE_INQUIRY);
        atm.checkBalance();

        // Try to withdraw more than balance
        atm.selectTransaction(TransactionType.WITHDRAWAL);
        atm.withdraw(8000);

        atm.ejectCard();
        System.out.println("=====================================");
        System.out.println("Thank you for using our ATM!");
    }
}