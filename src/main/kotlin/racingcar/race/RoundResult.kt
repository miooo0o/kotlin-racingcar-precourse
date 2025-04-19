package racingcar.race

data class RoundResult(
	val round: Int,
	val name: String,
	val position: Int,
	val isWinner: Boolean = false
)