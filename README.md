# kotlin-racingcar-precourse

### Mission Requirements

#### Process
1. Fork the repo and clone it
2. List planned features in README.md
3. Commit in small, feature-focused steps
4. Follow AngularJS-style commit messages
5. Submit via GitHub, then finalize on the platform

#### Functional Requirements
- User enters car names (comma-separated) and number of rounds
- Each car moves forward `if random( 0 ~ 9 ) >= 4`
- Print each car's progress: `pobi : ---`
- At the end, print winner(s): `Winners : pobi`, or `Winners : pobi, jun`
- If input is invalid (`empty` or `> 5 characters`), **throw** `IllegalArgumentException`

#### Programming Requirements
- Kotlin **1.9.24 only** (no Java)
- Entry point must be `main()` in **Application**
- Do not modify `build.gradle.kts`, and do not use external libraries
- Do not use `System.exit()` or `exitProcess()`
- Follow Kotlin Coding Conventions (max 2-level nesting)
- Use small, focused functions

#### Testing
- Must pass all tests using:
  - macOS/Linux: `./gradlew clean test`
  - Windows: `gradlew.bat clean test`
- Output format **must** match spec exactly, or you get 0 points

#### Required APIs
- Use `Randoms.pickNumberInRange(0, 9)`
- Use `Console.readLine()` for user input

---

### Project Purpose & Priorities

#### Purpose
Implement a simple car racing game in Kotlin.

#### Primary Goals
- Learn to write **testable code** (with emphasis on unit testing)
- Apply **clean architecture** principles
- Practice proper **Git usage** (feature-based commits)
- Emphasize observability and traceability (e.g., via logging)

---

### Initial Class Responsibilities

(to be filled as implementation progresses)

---

### Considered & Ideas
- Should be easy to test
- Should be extensible
- Should support logging/history
- Should not grow too large

#### Design Patterns
- **Factory Pattern**:
  - for generating `data class` instances of `Car`
- **Observer Pattern**:
  - to decouple game logic from logging (`interface` + `Logger` class)
---
### Architecture

(to be described later)

---

### Test Strategy
- Unit-testable components

---
### Git Strategy
(to be described later)

---

### Code
```txt
 Tag Guide
 [input]    user input
 [IO]       input-output
 [test]     test-related logic
 [logic]    core game logic
 [observer] observer pattern components