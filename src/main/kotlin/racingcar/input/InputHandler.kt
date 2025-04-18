package racingcar.input

// [IO] Provided API for reading user input (used in Application.main as Console.Readline() )
import camp.nextstep.edu.missionutils.Console

object InputHandler {
	/**
	 * Prompts user for car names and returns a validated list.
	 *
	 * @return List of validated car names
	 * @throws IllegalArgumentException if names are invalid
	 * @see Validator.validateNames
	 */
	fun getValidateCarNames(): List<String> {
		try {
			println("Enter the names of the cars (comma-separated):")
			val names : List<String> = parseNames(Console.readLine())
			return Validator.validateNames(names)
		} catch (e: IllegalArgumentException) {
			throw e
		}
	}
	/* Splits input by comma and removes blank or empty names */
	private fun parseNames(input: String): List<String> {
		return input.split(",").map { it.trim() }
	}

	/**
	 * Prompts user for round count and returns a validated number.
	 *
	 * @return number of rounds as validated Int
	 * @throws IllegalArgumentException if input is not a valid round number
	 *  @see Validator.validateRound
	 */
	fun getValidateRound(): Int {
		try {
			println("Enter the number of racing round(1-based): ")
			val input = readInput()
			val round = parseRound(input)
			return Validator.validateRound(round)
		} catch (e: IllegalArgumentException) {
			throw e
		}
	}

	/** Reads raw input and checks it's not blank */
	private fun readInput(): String {
		val input = Console.readLine()
		if (input.isNullOrBlank()) {
			throw IllegalArgumentException("Input cannot be empty.")
		}
		return input
	}

	/** Converts string to Int or throws if invalid */
	private fun parseRound(input: String): Int {
		return input.toIntOrNull()
			?: throw IllegalArgumentException("Input must be a valid number.")
	}
}