package racingcar.domain

/**
 * Represents a car participating in the race.
 *
 * @property name the identifier of the car (must be validated externally)
 * @property moves immutable view of movement history per round
 *     - Index = round number
 *     - Value = moved distance in that round (0 or 1)
 *
 * The car moves forward only when `moveIf(true)` is called,
 * recording either 1 (moved) or 0 (stayed) in the history.
 *   - The current position is the sum of all moves.
 *   - A partial position (up to a round) can be queried for logging or testing.
 */
class Car(val name: String) {
	init {
		require(name.length in 1..5) {
			"The car name must be at least 1 character and no more than 5 characters. Input value: '$name'"
		}
	}

	private val _moves = mutableListOf<Int>()
	val         moves: List<Int> get() = _moves.toList()

	fun moveIf(shouldMove: Boolean) {
		if (shouldMove) _moves.add(1) else _moves.add(0)
	}

	fun position(): Int = _moves.sum()

	fun position(round: Int): Int {
		require(round >= 0) { "Round cannot be negative" }
		return moves.take(round).sum()
	}
}