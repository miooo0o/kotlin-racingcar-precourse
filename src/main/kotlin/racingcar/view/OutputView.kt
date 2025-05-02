package racingcar.view

import racingcar.domain.Car
import racingcar.policy.Message
import racingcar.policy.Rule
import racingcar.policy.requireNotEmpty

object OutputView {
	fun displayGameResult(carList: List<Car>) {
		carList.requireNotEmpty()
		require(carList.all { car -> car.round >= Rule.MIN_ROUND }) { Message.CARS_NO_RECODE }
		println("Race Results")
		carList.map { car ->
			car.display()
		}
		carList.displayWinners()
	}
}

private fun Car.display(){
	val progress = "-".repeat(position)
	println("$name : $progress")
}

private fun List<Car>.displayWinners(){
	val maxPosition = this.maxOf { it.position }
	val winners = this.filter { it.position == maxPosition }
	val winnerNames = winners.joinToString(", ") { it.name }
	println("Winners : $winnerNames")
}