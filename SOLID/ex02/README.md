# Exercise ex02

How to run:
```bash
cd src
javac Demo02.java.java
java Demo02
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

solution:
Decoding and UI logic are separated via interfaces (Decoder, PlayerUI).
Player is now open for extension and has a single responsibility.
The demo (Demo02.java) now includes a tiny test by playing two files.