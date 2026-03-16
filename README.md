# 🍃 Spring Boot Revision: Dependency Injection & Configuration

This guide covers the implementation of **Inversion of Control (IoC)**, **Dependency Injection (DI)**, and **Conditional Bean Loading** using a Payment Service example.

---

## 🏗️ 1. The Strategy (Interface)
By using an interface, we decouple the "what" (paying) from the "how" (Razorpay vs. Stripe).

```java
package com.rahulgudu2003.tutorial.LearningSpringBoot;

public interface PaymentService {
    String pay();
}
```

## 2. The Implementations (The Beans)
We use @Component to tell Spring, "Manage this class for me." The @ConditionalOnProperty annotation acts as a switch based on your application.properties.

### Razorpay Implementation
```java
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorpayPaymentService implements PaymentService {
@Override
public String pay() {
return "Razorpay Payment";
}
}
```
### Stripe Implementation
```java
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService {
@Override
public String pay() {
return "Stripe Payment";
}
}
```

## 3. The Orchestrator (Dependency Injection)
This is where the magic happens. We use Constructor Injection, which is the industry standard for several reasons:

### Immutability: You can use the final keyword.

### Testability: You can easily pass a "mock" service during unit testing.

### Safety: The app won't start if the required bean is missing (fail-fast).

```java
@SpringBootApplication
public class LearningSpringBootApplication implements CommandLineRunner {

    // 1. Define the dependency as 'final' for immutability
    private final PaymentService paymentService;

    // 2. Constructor Injection (No @Autowired needed on constructors in modern Spring)
    public LearningSpringBootApplication(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Payment Status: " + paymentService.pay());
    }
}
```

## 4. Configuration (application.properties)
To toggle between your services, you simply change this one line in src/main/resources/application.properties:

### Properties
#### To use Razorpay
```java 
payment.provider=razorpay
```

#### To use Stripe
```java 
payment.provider=stripe
```