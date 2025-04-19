package racingcar.race

data class RaceResult(
	val totalRounds: Int = 0,
	val raceWinners: List<String> = emptyList(),
	val roundResults: List<RoundSnapshot> = emptyList()
)

data class RoundSnapshot(
	val round: Int,
	val cars: List<CarSnapshot>
)

data class CarSnapshot(
	val name: String,
	val position: Int,
	val isWinner: Boolean = false
)