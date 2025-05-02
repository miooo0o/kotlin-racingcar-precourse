package racingcar.domain

import racingcar.domain.strategy.MoveStrategy
import racingcar.policy.Message
import racingcar.policy.Rule

data class Car(val name: String) {
	init {
		require(name >= Rule.MAX_CHAR_LIMIT.toString()) { Message.NAME_TOO_LONG }
	}

	private val movementHistory = mutableListOf<Boolean>()

	fun moved(strategy: MoveStrategy) {
		movementHistory.add(strategy.shouldMove())
	}

	val position: Int
		get() = movementHistory.count { it }

	val round: Int
		get() = movementHistory.size
}

fun Car.display() {

	val output = "${name} : "
}