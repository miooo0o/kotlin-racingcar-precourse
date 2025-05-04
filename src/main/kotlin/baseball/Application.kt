package baseball

import baseball.game.GameMaster
import baseball.view.InputView

fun main() {
	val gameMaster = GameMaster()
	val listOfDigits = InputView.readDigitList()
}

