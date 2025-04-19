package racingcar

import racingcar.domain.Car
import racingcar.input.InputHandler
import racingcar.factory.CarFactory
import racingcar.domain.RacingGame

fun main() {
	try {
		// get lines from console and validate
		val names : List<String> = InputHandler.getValidateCarNames()
		val rounds: Int = InputHandler.getValidateRound()

		// init cars from names
		val cars : List<Car> = CarFactory.fromNames(names)

		// run RacingGame.race()
		val game = RacingGame(cars)


	} catch (e: IllegalArgumentException) {
		println("Error: Invalid input: ${e.message}")
	}
}