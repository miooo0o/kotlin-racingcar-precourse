#### Feat-list
_last update: 19. April_

---

### priority 
- [x] Car
- [x] InputHandler
- [x] InputValidator
- [x] CarFactory
- [ ] RoundResult ->  RaceResult (DTOs)
- [ ] RacingGame
- [ ] OutputView
---

### Project Setup
- [ ] Confirm Kotlin version is 1.9.24
- [x] Ensure build.gradle.kts contains correct plugin version
- [ ] Run `./gradlew clean test` and confirm failure (baseline)

### Detail

### Application Logic
- [ ] Implement `Application.main()` to:
  - [x] Get user input
  - [x] Parse and validate names
  - [x] Read number of rounds
  - [ ] Execute race and show results
- [ ] Application.kt
    - [ ] Store racingGame instance for later reference
    - [ ] Call outputView.print(...) after race

#### InputHandler
- [x] read input Console.readLine() -> input.Handler
- [x] Create ` InputHandler`
  - [x] Handle conversion errors explicitly (e.g., round not a number)

#### InputValidator
- [x] Create ` InputValidator` object → `input. InputValidator`
  - [x] validate `name: List<String>`
    - [x] Reject if name contains non-alphanumeric characters (only letters and digits allowed)
    - [x] Split by `,` and trim whitespace from each name
    - [x] Reject if name length exceeds 5 characters
    - [x] Reject if duplicate names exist (case-insensitive)
  - [x] Validate `round: Int`
    - [x] Reject if round < 1
    - [ ] Reject if round > MAX_ROUND (still under consideration)

---

#### Car
- [x] Create `Car` class (name, moves, moveIf)
  - [x] `val name` — car's name, validated on creation (1~5 characters)
  - [x] `val _moves: MutableList<Int>` — internal record of movement history (0 or 1 per round)
  - [x] `val moves: List<Int>` — read-only view of `_moves` (used for position tracking and logging)
  - [x] ~~positions `List<Int>`~~ → replaced with `moves` to record raw movement (0 or 1) for flexibility
  - [x] `fun moveIf(condition: Boolean)` — adds 1 if moved, 0 if not
  - [x] `fun totalDistance(): Int` — total distance (sum of moves)
  - [x] `fun distanceUntil(round: Int): Int` — distance moved up to and including the given round (1-based)
  - [x] `fun didMoveAt(round: Int): Boolean` — check whether the car moved at a specific round (1-based)

#### RacingGame
- [x] Find better name -> `RacingGame`
- [x] Implement `RacingGame` logic and history tracking
- [ ] Update
  - [ ] Move _history to FinalResult DTO
  - [ ] Change race() return type to FinalResult

### RoundResult -> RaceResult (DTOs)
- [ ] Move RoundResult, CarSnapshot, FinalResult to individual files (or keep together if short)
- [ ] Rename RoundResult to RaceResult if needed (consistency)

#### OutputView
- [ ] Create `OutputView` object to display race history
  - [ ]	Create OutputView object
  - [ ]	Add printRoundResult(history: List<RaceResult>)
  - [ ]	Add printFinalWinners(winners: List<String>)
  - [ ]	Optional: decorate with titles like "Race Results" or "Winners: ..."

---

### Optional
#### Observer & Logger
- [ ] Define and implement `RaceObserver` interface
- [ ] Create `RaceLogger` to record state history


---

### Testing
#### InputValidator / InputHandler
- [ ] Unit test: invalid names (empty, >5 chars, special chars)
- [ ] Unit test: invalid round (non-numeric, <1, >MAX_ROUND)
- [ ] Unit test: duplicate names (case-insensitive check)
- [ ] Unit test: trimmed input parsing

#### Car class
- [x] Unit test: moveIf(true) / moveIf(false)
- [x] Unit test: totalDistance() returns correct sum
- [x] Unit test: distanceUntil(round) returns correct value
- [x] Unit test: didMoveAt(round) returns correct boolean
- [x] Unit test: hasMove() returns correct result

#### RacingGame
- [ ] Unit test: race logic across multiple rounds
- [ ] Unit test: handle multiple winners (equal position)

---

### Exception Handling
- [ ] Create custom exception(s) if needed
- [ ] Throw `IllegalArgumentException` for invalid input

### Cleanup
- [ ] Check Kotlin formatting conventions
- [ ] Make sure indentation does not exceed 2 levels
- [ ] Remove debug prints before final submission