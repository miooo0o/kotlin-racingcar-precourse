package baseball.view

//import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
object InputView {
	fun readDigitList(): List<Int> {
		val rawInput = Console.readLine()?.takeIf {it.isNotEmpty() && it.isNotBlank()}
		require(rawInput != null) {"error: wrong input: empty/blank"}
		val listOfDigits = rawInput.map { it.digitToIntOrNull() }.toList()
		require(listOfDigits.all {it != null}) {"error: wrong input: found null in list of numbers"}
		return (listOfDigits.filterNotNull())
	}
}
