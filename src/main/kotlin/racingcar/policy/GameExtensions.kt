package racingcar.policy

import racingcar.domain.Car

fun List<Car>.requireNotEmpty() {
	require(this.isNotEmpty()) { Message.EMPTY_NAMES_LIST }
	require(this.any { it.name.isNotBlank() }) { Message.FOUND_EMPTY_NAME }
}