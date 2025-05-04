package baseball.game

import baseball.domain.strategy.DefaultNumberStrategy
import baseball.domain.strategy.NumberStrategy
import baseball.domain.GuessStatus

class GameMaster(    private val strategy: NumberStrategy = DefaultNumberStrategy()) {
	private val targetNumbers = strategy.generate()
	val numbers: List<Int> get() = targetNumbers

	private fun matchWith(input: List<Int>): List<GuessStatus> {
		val duplicatedValues = input
			.groupingBy { it }
			.eachCount()
			.filter { it.value > 1 }
			.keys

		return targetNumbers.zip(input).map { (target, guess) ->
			GuessStatus(
				value = guess,
				isStrike = target == guess,
				isDuplicated = guess in duplicatedValues
			)
		}
	}


	private fun haveWith(matchWith: List<GuessStatus>): List<GuessStatus> {
		val used = mutableSetOf<Int>()

		matchWith.forEachIndexed { i, guess ->
			if (guess.isStrike) used.add(i)
		}

		return matchWith.mapIndexed { i, guess ->
			if (!guess.isStrike) {
				val input = guess.value
				val index = targetNumbers.indexOfFirst { j ->
					targetNumbers[j] == input && j != i && j !in used
				}
				if (index != -1) {
					used.add(index)
					return@mapIndexed guess.copy(isBall = true)
				}
			}
			guess
		}
	}

}

fun List<GuessStatus>.countStrike(): Int {
	return this.count() {it.isStrike}
}

fun List<GuessStatus>.countBall(): Int {
	return this.count() {it.isBall}
}