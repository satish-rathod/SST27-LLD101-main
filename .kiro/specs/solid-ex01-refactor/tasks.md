# Implementation Plan

- [ ] 1. Create core interfaces for dependency abstraction
  - Define TaxCalculator interface with calculateTax and calculateTotal methods
  - Define NotificationService interface with sendOrderConfirmation method
  - Define OrderRepository interface with saveOrder method
  - _Requirements: 2.1, 4.1, 5.1_

- [ ] 2. Implement TaxCalculator component
  - Create StandardTaxCalculator class implementing TaxCalculator interface
  - Implement constructor accepting tax rate parameter for configurability
  - Implement calculateTax method to compute tax amount from subtotal
  - Implement calculateTotal method to return subtotal plus tax
  - Write unit tests verifying tax calculations with 18% rate match original behavior
  - _Requirements: 1.2, 2.1, 3.1, 6.2_

- [ ] 3. Implement NotificationService component
  - Create EmailNotificationService class implementing NotificationService interface
  - Accept EmailClient dependency through constructor injection
  - Implement sendOrderConfirmation method that formats and sends email using EmailClient
  - Ensure email message format matches original "Thanks! Your total is [total]" format
  - Write unit tests verifying correct email content and recipient
  - _Requirements: 1.2, 2.2, 5.2, 6.1_

- [ ] 4. Implement OrderRepository component
  - Create ConsoleOrderRepository class implementing OrderRepository interface
  - Implement saveOrder method that prints "Order stored (pretend DB)." message
  - Ensure output format exactly matches original implementation
  - Write unit tests verifying console output behavior
  - _Requirements: 1.2, 2.3, 6.1_

- [ ] 5. Refactor OrderService to use dependency injection
  - Modify OrderService constructor to accept TaxCalculator, NotificationService, and OrderRepository dependencies
  - Remove direct instantiation of EmailClient and hardcoded tax rate
  - Update checkout method to use injected TaxCalculator for total calculation
  - Update checkout method to use injected NotificationService for email sending
  - Update checkout method to use injected OrderRepository for order persistence
  - Add null validation for all constructor parameters
  - _Requirements: 1.1, 5.1, 5.2, 5.3_

- [ ] 6. Create dependency factory or configuration class
  - Create OrderServiceFactory class to handle dependency wiring
  - Implement createOrderService method that instantiates all dependencies with original configuration
  - Use 0.18 tax rate for StandardTaxCalculator to maintain original behavior
  - Wire EmailClient into EmailNotificationService
  - Wire ConsoleOrderRepository for order persistence
  - _Requirements: 5.2, 6.1_

- [ ] 7. Update Demo01 to use refactored OrderService
  - Modify Demo01 main method to use OrderServiceFactory for OrderService creation
  - Ensure the same method call (checkout("a@shop.com", 100.0)) produces identical output
  - Verify that tax calculation, email sending, and order storage all work as before
  - _Requirements: 6.1, 6.2, 6.3_

- [ ] 8. Create comprehensive unit tests for OrderService
  - Write unit tests for OrderService using mock dependencies
  - Test checkout method with various subtotal values
  - Verify that all dependency methods are called with correct parameters
  - Test error handling when dependencies are null
  - Test edge cases like zero subtotal and negative values
  - _Requirements: 7.1, 7.2_

- [ ] 9. Create integration test demonstrating extensibility
  - Create alternative implementations (e.g., HighTaxCalculator with different rate)
  - Create test showing how OrderService works with different TaxCalculator implementations
  - Demonstrate that new implementations can be substituted without modifying OrderService
  - Write test verifying Liskov Substitution Principle compliance
  - _Requirements: 2.1, 3.1, 7.3_

- [ ] 10. Add demonstration of SOLID principles compliance
  - Create enhanced Demo01 class showing original behavior preservation
  - Add comments explaining how each SOLID principle is now satisfied
  - Include example of how to extend the system (e.g., adding SMS notifications)
  - Demonstrate dependency injection and interface-based design benefits
  - _Requirements: 7.1, 7.2, 7.3_