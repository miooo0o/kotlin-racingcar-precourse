package racingcar.domain.strategy

import camp.nextstep.edu.missionutils.Randoms
import racingcar.policy.Rule

class RandomMoveStrategy: MoveStrategy {
	override fun shouldMove(): Boolean {
		return Randoms.pickNumberInRange(
			Rule.MIN_RANDOM_NUM,
			Rule.MAX_RANDOM_NUM
		) >= Rule.RAMDOM_NUM_DELIM
	}
}