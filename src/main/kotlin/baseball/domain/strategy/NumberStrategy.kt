package baseball.domain.strategy

interface NumberStrategy {
	fun generate(): List<Int>
}