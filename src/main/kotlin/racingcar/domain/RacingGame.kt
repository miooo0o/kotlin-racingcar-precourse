package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.race.RoundResult

class RacingGame(private val cars: List<Car>) {
	/* */
	private val _history = mutableListOf<List<RoundResult>>()
	val history: List<List<RoundResult>> get() = _history

	/* */
	fun getHistory(): List<List<RoundResult>> = history

	/**
	 *
	 */
	fun race(rounds: Int) {
		for (round in 1..rounds) {
			val result = collectRoundResult(round)
			_history.add(result)
		}
	}

	/* */
	private fun moveAllCars() {
		cars.forEach { it.moveIf(Randoms.pickNumberInRange(0, 9) >= 4) }
	}

	/**
	 *
	 */
	private fun collectRoundResult(currentRound: Int): List<RoundResult> {
		val maxPosition = findMaxPosition()
		return cars.map { toRoundResult(it, currentRound, maxPosition) }
	}

	/* */
	private fun findMaxPosition(): Int {
		return cars.maxOf { it.totalDistance() }
	}

	/* */
	private fun toRoundResult(car: Car, currentRound: Int, maxPosition: Int): RoundResult {
		return RoundResult(
			round = currentRound,
			name = car.name,
			position = car.totalDistance(),
			isWinner = car.totalDistance() == maxPosition
		)
	}

	/* */
	fun getFinalWinners(): List<Car> {
		val maxPosition = findMaxPosition()
		return cars.filter { it.totalDistance() == maxPosition }
	}
}