package racingcar.input

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputHandlerTest : NsTest() {

	@Test
	fun `should parse and trim names from comma-separated input`() {
		assertSimpleTest {
			run("guri, gugu, ggu")
			val names = InputHandler.getValidateCarNames()
			assertThat(names).containsExactly("guri", "gugu", "ggu")
		}
	}

	@Test
	fun `should fail when using invalid delimiter instead of comma`() {
		assertSimpleTest {
			run("guri|gugu|ggu")
			val exception = assertThrows<IllegalArgumentException> {
				InputHandler.getValidateCarNames()
			}
			assertThat(exception.message).contains("Car name must be 5 characters or fewer")
		}
	}

	override fun runMain() {}
}