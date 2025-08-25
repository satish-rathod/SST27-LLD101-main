# Design Document

## Overview

This design addresses the SOLID principle violations in the current OrderService implementation by decomposing it into focused, loosely-coupled components. The current OrderService violates multiple SOLID principles:

- **SRP Violation**: Handles tax calculation, email notification, and order persistence
- **OCP Violation**: Adding new tax rates or notification methods requires modifying existing code
- **DIP Violation**: Directly instantiates EmailClient, creating tight coupling

The refactored design introduces abstractions and dependency injection to create a flexible, testable, and maintainable system.

## Architecture

The refactored system follows a layered architecture with clear separation of concerns:

```
OrderService (Orchestrator)
    ↓ depends on abstractions
├── TaxCalculator (Tax calculation responsibility)
├── NotificationService (Communication responsibility)  
└── OrderRepository (Persistence responsibility)
```

Each component is accessed through interfaces, enabling dependency injection and easy testing.

## Components and Interfaces

### Core Interfaces

**TaxCalculator Interface**
```java
public interface TaxCalculator {
    double calculateTax(double subtotal);
    double calculateTotal(double subtotal);
}
```

**NotificationService Interface**
```java
public interface NotificationService {
    void sendOrderConfirmation(String customerEmail, double total);
}
```

**OrderRepository Interface**
```java
public interface OrderRepository {
    void saveOrder(String customerEmail, double total);
}
```

### Concrete Implementations

**StandardTaxCalculator**
- Implements TaxCalculator with configurable tax rate
- Handles tax calculation logic
- Follows SRP by focusing solely on tax-related calculations

**EmailNotificationService**
- Implements NotificationService using EmailClient
- Wraps the existing EmailClient functionality
- Can be easily extended for different email templates

**ConsoleOrderRepository**
- Implements OrderRepository with console output
- Simulates database storage
- Can be replaced with actual database implementation

### Refactored OrderService

The new OrderService becomes a coordinator that:
- Depends on abstractions (interfaces) rather than concrete classes
- Receives dependencies through constructor injection
- Orchestrates the checkout process without handling implementation details

## Data Models

**Order Processing Flow**
```
Input: customerEmail (String), subtotal (double)
    ↓
1. Calculate total using TaxCalculator
    ↓
2. Send confirmation using NotificationService  
    ↓
3. Save order using OrderRepository
    ↓
Output: Completed order processing
```

**Dependency Injection Structure**
```java
public class OrderService {
    private final TaxCalculator taxCalculator;
    private final NotificationService notificationService;
    private final OrderRepository orderRepository;
    
    // Constructor injection
    public OrderService(TaxCalculator taxCalculator, 
                       NotificationService notificationService,
                       OrderRepository orderRepository) {
        // Assignment logic
    }
}
```

## Error Handling

**Validation Strategy**
- Constructor validation ensures all dependencies are non-null
- Method parameter validation for customerEmail and subtotal
- Graceful handling of service failures without breaking the entire flow

**Exception Propagation**
- Service-specific exceptions bubble up to OrderService
- OrderService can implement retry logic or fallback mechanisms
- Clear error messages for debugging and monitoring

## Testing Strategy

**Unit Testing Approach**
- Each component can be tested in isolation
- Mock implementations for all interfaces
- Test coverage for edge cases and error conditions

**Integration Testing**
- Test the complete flow with real implementations
- Verify dependency injection works correctly
- Validate that behavior matches original implementation

**Test Structure**
```java
// Example test structure
class OrderServiceTest {
    @Mock TaxCalculator mockTaxCalculator;
    @Mock NotificationService mockNotificationService;
    @Mock OrderRepository mockOrderRepository;
    
    OrderService orderService;
    
    // Test methods for various scenarios
}
```

**Behavioral Verification**
- Ensure refactored code produces identical output to original
- Verify all service methods are called with correct parameters
- Test that the 18% tax rate calculation remains accurate

## Design Benefits

**SOLID Compliance**
- **SRP**: Each class has a single, well-defined responsibility
- **OCP**: New implementations can be added without modifying existing code
- **LSP**: All implementations are substitutable through their interfaces
- **ISP**: Interfaces are focused and client-specific
- **DIP**: High-level OrderService depends on abstractions, not concretions

**Maintainability Improvements**
- Easy to modify tax calculation logic without affecting other components
- Simple to add new notification channels (SMS, push notifications)
- Straightforward to implement different persistence mechanisms
- Clear separation makes debugging and troubleshooting easier

**Testability Enhancements**
- All dependencies can be mocked for unit testing
- Each component can be tested independently
- Integration tests can verify the complete flow
- Easy to test error scenarios and edge cases