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
	 * Simulates the race over multiple rounds.
	 *
	 * @param rounds Total number of rounds to simulate
	 * @return List of RoundSnapshot representing the state after each round
	 */
	fun race(rounds: Int) {
		(1..rounds).fold(RaceResult()) { acc, round ->
			moveAllCars()
			val leadingDistance = cars.maxOf { it.totalDistance() }
			val roundSnapshot = takeRoundSnapshot(round, leadingDistance)
			val finalWinners = getWinners(leadingDistance)

			acc.copy(
				roundResults = acc.roundResults + roundSnapshot,
				totalRounds = round,
				raceWinners = finalWinners
			)
		}.also { _history = it }
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
			isWinner = currentPosition == leadingDistance
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