package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.race.RaceResult
import racingcar.race.RoundSnapshot
import racingcar.race.CarSnapshot

/**
 * RacingGame manages the simulation of a car race.
 *
 * @property cars List of participating cars (immutable after creation)
 * @property history Stores the result of the last race (access via getHistory())
 */
class RacingGame(private val cars: List<Car>) {

	/**
	 * Internal storage for race result history.
	 * Immutable snapshot accessible via public `history` or `getHistory()`.
	 */
	private var _history = RaceResult()

	/** Public getter for last recorded race result */
	val history: RaceResult get() = _history

	/** Returns the latest race result (same as accessing `history` property) */
	fun getHistory(): RaceResult = history

	/**
	 * Runs the race for the given number of rounds.
	 * Moves all cars each round and records their positions.
	 *
	 * @param rounds Number of rounds to simulate (must be >= 1)
	 * @return Final RaceResult including round-by-round positions and winners
	 */
	fun race(rounds: Int): RaceResult {
		require(rounds >= 1) {
			"Rounds must be at least 1."
		}
		val roundResults = runAllRounds(rounds)
		val result = createRaceResult(rounds, roundResults)
		_history = result
		return result
	}

	/**
	 * Creates a final RaceResult from the completed rounds.
	 *
	 * @param rounds Number of total rounds (used for result metadata)
	 * @param results List of RoundSnapshot containing each round's result
	 * @return RaceResult with winners and all round data
	 */
	private fun createRaceResult(rounds: Int, results: List<RoundSnapshot>): RaceResult {
		val leadingDistance = getLeadingDistance()
		val winners = getWinners(leadingDistance)
		return RaceResult(
			totalRounds = rounds,
			raceWinners = winners,
			roundResults = results
		)
	}

	/**
	 * Simulates the race over multiple rounds.
	 *
	 * @param rounds Total number of rounds to simulate
	 * @return List of RoundSnapshot representing the state after each round
	 */
	private fun runAllRounds(rounds: Int): List<RoundSnapshot> {
		val snapshots = mutableListOf<RoundSnapshot>()
		for (round in 1..rounds) {
			moveAllCars()
			val snapshot = takeRoundSnapshot(round)
			snapshots.add(snapshot)
		}
		return snapshots
	}

	/**
	 * Takes a snapshot of the current state of all cars.
	 *
	 * @param round The current round number (1-based)
	 * @return RoundSnapshot with each car's name and current position
	 */
	private fun takeRoundSnapshot(round: Int): RoundSnapshot {
		val carSnapshots = cars.map { createCarSnapshot(it) }
		return RoundSnapshot(round, carSnapshots)
	}

	/**
	 * Converts a Car into a CarSnapshot (without winner flag).
	 * Winner marking is handled globally in the RaceResult.
	 *
	 * @param car The car to snapshot
	 * @return CarSnapshot with name and position
	 */
	private fun createCarSnapshot(car: Car): CarSnapshot {
		val currentPosition = car.totalDistance()
		return CarSnapshot(
			name = car.name,
			position = currentPosition,
		)
	}

	/**
	 * Moves all cars one step based on random strategy.
	 * Uses Randoms.pickNumberInRange(0, 9) >= 4 as threshold.
	 */
	private fun moveAllCars() {
		cars.forEach { it.moveIf(Randoms.pickNumberInRange(0, 9) >= 4) }
	}

	/**
	 * Calculates the furthest distance reached among all cars.
	 *
	 * @return The leading distance
	 */
	private fun getLeadingDistance(): Int {
		return cars.maxOf { it.totalDistance() }
	}

	/**
	 * Gets the names of all cars who achieved the leading distance.
	 *
	 * @param leadingDistance The maximum distance
	 * @return List of car names that won the race
	 */
	private fun getWinners(leadingDistance: Int): List<String> {
		return cars.filter { it.totalDistance() == leadingDistance }
			.map { it.name }
	}
}