package racingcar.factory

import racingcar.domain.Car
import racingcar.policy.Message

object CarFactory {
	fun makeCarsList(nameListString: List<String>): List<Car> {
		require(nameListString.isNotEmpty()) { Message.EMPTY_NAMES_LIST }
		require(nameListString.any { it.isNotBlank() }) { Message.FOUND_EMPTY_NAME }
		return nameListString
			.filter { it.isNotBlank() }
			.map { Car(it) }
	}
}