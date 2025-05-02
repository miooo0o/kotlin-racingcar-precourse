package racingcar

import racingcar.domain.GameController
import racingcar.factory.CarFactory
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
	val carNamesList = InputView.readCarName()
	val gameRoundAmount = InputView.readRoundAmount()
	val cars = CarFactory.makeCarsList(carNamesList)
	val gameResult = GameController.run(cars, gameRoundAmount)
	OutputView.displayGameResult(gameResult)
}