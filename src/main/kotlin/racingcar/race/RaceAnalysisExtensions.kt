package racingcar.race

// TODO: Kdocs
/**
 *
 */
fun List<RoundSnapshot>.leadingDistance(): Int {
	return this.last().cars.maxOf { it.position }
}

/**
 *
 */
fun List<RoundSnapshot>.winnerNames(): List<String> {
	val max = this.leadingDistance()
	return this.last().cars.filter { it.position == max }
		.map { it.name }
}

/**
 *
 */
fun List<RoundSnapshot>.toRaceResult(rounds: Int): RaceResult {
	val leadingDistance = this.leadingDistance()
	val winners = this.winnerNames()

	return RaceResult(
		totalRounds = rounds,
		raceWinners = winners,
		roundResults = this,
		leadingDistance = leadingDistance
	)
}
