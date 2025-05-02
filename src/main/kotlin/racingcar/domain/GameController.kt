package racingcar.domain

import racingcar.domain.strategy.RandomMoveStrategy
import racingcar.policy.Message
import racingcar.policy.Rule
import racingcar.policy.requireNotEmpty

object GameController {
	fun run(carList: List<Car>, round: Int): List<Car> {
		carList.requireNotEmpty()
		require(round >= Rule.MIN_ROUND) { Message.ROUND_TOO_SMALL }
		repeat(round) {
			carList.forEach { car ->
				car.moved(RandomMoveStrategy())
			}
		}
		require(carList.all { car -> car.round == round}) { Message.ROUND_NOT_MATCH }
		return carList
	}
}
