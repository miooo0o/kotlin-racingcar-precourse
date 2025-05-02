package racingcar.view

import racingcar.policy.*

object InputView {
	fun readCarName(): List<String> {
		println(Message.ENTER_NAMES)
		val input = readLine()
		require(!input.isNullOrBlank()) { Message.EMPTY_NAME }

		val carNames = input.split(",").map { it.trim() }
		carNames.forEach {
			require(it.length <= Rule.MAX_CHAR_LIMIT) { Message.NAME_TOO_LONG }
			require(it.all { char -> char.isLetterOrDigit() }) { Message.INVALID_NAME_FORMAT }
		}
		return carNames
	}

	fun readRoundAmount(): Int {
		println(Message.ENTER_ROUND)
		val input = readLine()?.toIntOrNull()
		require(input!= null) { Message.EMPTY_ROUND }
		require(input >= Rule.MIN_ROUND) { Message.ROUND_TOO_SMALL }
		return input
	}
}