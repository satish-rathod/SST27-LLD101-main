# ATM System - Low Level Design

A comprehensive ATM (Automated Teller Machine) system implementation demonstrating SOLID principles, State Pattern, Strategy Pattern, and Dependency Injection.

# UML Daigram
![UML Diagram](atm-system.drawio)

## Package Structure

```
src/
└── com/
    └── atm/
        ├── Main.java                    // Application entry point
        ├── core/
        │   └── ATM.java                 // Main ATM controller
        ├── domain/
        │   ├── Account.java             // Bank account entity
        │   ├── Card.java                // ATM card entity
        │   ├── Transaction.java         // Transaction record
        │   ├── Denomination.java        // Currency denominations
        │   └── TransactionType.java     // Transaction types
        ├── states/
        │   ├── ATMState.java            // State interface
        │   ├── IdleState.java           // Initial state
        │   ├── CardInsertedState.java   // Card inserted state
        │   ├── AuthenticatedState.java  // Authenticated state
        │   └── OutOfServiceState.java   // Maintenance state
        ├── hardware/
        │   ├── CardReader.java          // Card reader interface
        │   ├── CashDispenser.java       // Cash dispenser
        │   ├── DepositSlot.java         // Deposit interface
        │   ├── PinPad.java              // PIN pad interface
        │   ├── Printer.java             // Printer interface
        │   └── impl/                    // Hardware implementations
        │       ├── SimpleCardReader.java
        │       ├── SimpleDepositSlot.java
        │       ├── SimplePinPad.java
        │       └── SimplePrinter.java
        ├── services/
        │   ├── BankService.java         // Banking service interface
        │   └── impl/
        │       └── InMemoryBankService.java
        └── util/
            └── CashInventory.java       // Cash management utility
```
## Features

### ✅ Implemented Features
- **Card Management**: Insert/eject card with validation
- **PIN Authentication**: Secure PIN verification
- **Cash Withdrawal**: Smart cash dispensing with optimal denomination distribution
- **Balance Inquiry**: Check account balance
- **Transaction History**: Track all transactions
- **State Management**: Clean state transitions using State Pattern
- **Hardware Abstraction**: Pluggable hardware components
- **Error Handling**: Comprehensive error scenarios