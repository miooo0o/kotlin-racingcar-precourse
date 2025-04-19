package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.race.RaceResult
import racingcar.race.RoundSnapshot
import racingcar.race.CarSnapshot

class RacingGame(private val cars: List<Car>) {
	/* */
	private var _history = RaceResult()
	val history: RaceResult get() = _history

	/* */
	fun getHistory(): RaceResult = history

	/**
	 *
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

	/* */
	private fun takeRoundSnapshot(round: Int, leadingDistance: Int): RoundSnapshot {
		val carSnapshots = cars.map { createCarSnapshot(it, leadingDistance) }
		return RoundSnapshot(round, carSnapshots)
	}

	/* */
	private fun createCarSnapshot(car: Car, leadingDistance: Int): CarSnapshot {
		val currentPosition = car.totalDistance()
		return CarSnapshot(
			name = car.name,
			position = currentPosition,
			isWinner = currentPosition == leadingDistance
		)
	}

	/* */
	private fun moveAllCars() {
		cars.forEach { it.moveIf(Randoms.pickNumberInRange(0, 9) >= 4) }
	}

	/* */
	private fun getLeadingDistance(): Int {
		return cars.maxOf { it.totalDistance() }
	}

	private fun getWinners(leadingDistance: Int): List<String> {
		return cars.filter { it.totalDistance() == leadingDistance }
			.map { it.name }
	}
}