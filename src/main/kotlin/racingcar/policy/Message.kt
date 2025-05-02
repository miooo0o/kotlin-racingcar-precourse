package racingcar.policy

object Message {

	// readline
	const val ENTER_NAMES = "Please enter the names of the cars to race (separated by commas):"
	const val ENTER_ROUND = "How many rounds will the race have?"

	// input
	const val EMPTY_NAME = "Car name required"
	const val INVALID_NAME_FORMAT = "Car names must only contain letters and digits"
	const val NAME_TOO_LONG = "Car name too long"

	//
	const val EMPTY_ROUND = "Round required"
	const val ROUND_TOO_SMALL = "Round must be >= ${Rule.MIN_ROUND}"
	const val EMPTY_NAMES_LIST = "At least one car name is required"

	const val FOUND_EMPTY_NAME = "nameList can not contain empty name"
	const val ROUND_NOT_MATCH = "given round is not match with number of round which car run"

	const val CARS_NO_RECODE = "car has been moved"
}