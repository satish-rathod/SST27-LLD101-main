# Exercise ex01

How to run:
```bash
cd src
javac Demo01.java.java
java Demo01
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

solution:
Decouple the email sending logic from OrderService.
Use dependency injection to pass an email sender interface to OrderService.
This way, OrderService only handles order logic, and email logic is handled elsewhere.
