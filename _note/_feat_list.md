#### Feat-list
_last update: 16. April_

---

### priority 
- [x] Car
- [ ] InputHandler
- [ ] Validate
- [ ] CarFactory

### Ideas
- [x] Think about validate process

---

### Project Setup
- [ ] Confirm Kotlin version is 1.9.24
- [x] Ensure build.gradle.kts contains correct plugin version
- [ ] Run `./gradlew clean test` and confirm failure (baseline)

### Detail

### Application Logic
- [ ] Implement `Application.main()` to:
  - [ ] Get user input
  - [ ] Parse and validate names
  - [ ] Read number of rounds
  - [ ] Execute race and show results

#### InputHandler
- [ ] read input Console.readLine() -> input.Handler
- [ ] Create `Handler`
  - [ ] Handle conversion errors explicitly (e.g., round not a number)

#### Validator
- [ ] Create `Validator` object -> input.Validator
  - [ ] validate `name : List<String>`
    - [ ] if inputs are not alpha || number
    - [ ] name = split(,) -> if (!name is alphas && numbers)
    - [ ] if (name.length > 5)
  - [ ] validate `round`
    - [ ] if round < 1 && round > MAX_ROUND (!! do I need?)

---

#### Car
- [x] Create `Car` class (name, moves, moveIf)
  - [x] name
  - [x] _moves `mutableListOf<Int>` and  moves `List<Int>` (read-only)
  - [x] ~~positions `List<int>`~~ -> replaced with moves List<Int> to track raw movement history (0 or 1) per round, allowing flexible computation of position and easier logging

#### RacingGame
- [x] find better name -> RacingGame  
- [ ] Implement `RacingGame` (manage rounds, notify observers)

---

### Optional
#### Observer & Logger
- [ ] Define and implement `RaceObserver` interface
- [ ] Create `RaceLogger` to record state history

#### CarSnapshot
- [ ] Create `CarSnapshot` data class (immutable snapshot, Logging)

---

### Testing

Validator / InputHandler
- [ ] Unit test: invalid names (empty, >5 chars, special chars)
- [ ] Unit test: invalid round (non-numeric, <1, >MAX_ROUND)

Car class
- [ ] Unit test: moveIf(true) / moveIf(false)
- [ ] Unit test: position(round) returns correct value

CarRace
- [ ] Unit test: race logic across multiple rounds
- [ ] Unit test: handle multiple winners (equal position)
- 

---

### Exception Handling
- [ ] Create custom exception(s) if needed
- [ ] Throw `IllegalArgumentException` for invalid input

### Cleanup
- [ ] Check Kotlin formatting conventions
- [ ] Make sure indentation does not exceed 2 levels
- [ ] Remove debug prints before final submission