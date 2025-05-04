package baseball.domain

data class GuessStatus(
	val value: Int,
	val isStrike: Boolean = false,
	val isBall: Boolean = false,
	val isDuplicated: Boolean = false,
	)