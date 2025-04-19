package racingcar.race

import racingcar.domain.Car

fun Car.toProgressBar(): String {
	return "-".repeat(totalDistance())
}

fun RoundSnapshot.toDisplayStrings(): List<String> {
	return cars.map { "${it.name} : ${"-".repeat(it.position)}" }
}

fun RaceResult.winnerText(): String {
	return "Winners : ${raceWinners.joinToString(", ")}"
}