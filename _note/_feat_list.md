#### Feat-list
_last update: 15. April_


### Project Setup
- [ ] Confirm Kotlin version is 1.9.24
- [x] Ensure build.gradle.kts contains correct plugin version
- [ ] Run `./gradlew clean test` and confirm failure (baseline)

### Ideas
- [ ] Crate validate process

### Validate Process should includes...
- [ ] if inputs are not alpha || number 
- [ ] name = split(,) -> if (!name is alphas)
- [ ] if (name.length > 5)
- [ ] if round < 1

---

## class
#### Car
- [ ] Create `Car` class (name, position, moveIf)
  - [ ] name
  - [ ] moved `List<int>`
  - [x] ~~positions `List<int>`~~ -> replaced with moves List<Int> to track raw movement history (0 or 1) per round, allowing flexible computation of position and easier logging
#### CarSnapshot
- [ ] Create `CarSnapshot` data class (immutable snapshot, Logging)
#### Optional 
- [ ] (Optional) Create `CarFactory` for input parsing

#### RacingCar (`CarRace` <- find better nam )
- [ ] Implement `CarRace` (manage rounds, notify observers)
#### Observer & Logger
- [ ] Define and implement `RaceObserver` interface
- [ ] Create `RaceLogger` to record state history

### Testing
- [ ] Add input validation tests (invalid name, length)

### Application Logic
- [ ] Implement `Application.main()` to:
    - [ ] Get user input
    - [ ] Parse and validate names
    - [ ] Read number of rounds
    - [ ] Execute race and show results

---

### Exception Handling
- [ ] Create custom exception(s) if needed
- [ ] Throw `IllegalArgumentException` for invalid input

### Cleanup
- [ ] Check Kotlin formatting conventions
- [ ] Make sure indentation does not exceed 2 levels
- [ ] Remove debug prints before final submission