package baseball.domain.strategy

import baseball.game.Rule
import camp.nextstep.edu.missionutils.Randoms

class DefaultNumberStrategy: NumberStrategy {
	override fun generate(): List<Int> {
		return List(Rule.AMOUNT_OF_TARGET_NUMBERS) { Randoms.pickNumberInRange(0, 9) }
	}
}