import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MovementTest {

    @Test
    fun forwardNum() {
        // Assemble
        val inputString = "forward 5"

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement(
                type = Main.MovementType.FORWARD,
                size = 5
            )
        )
    }

    @Test
    fun downNum() {
        // Assemble
        val inputString = "down 3"

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement(
                type = Main.MovementType.DOWN,
                size = 3
            )
        )
    }

    @Test
    fun upNum() {
        // Assemble
        val inputString = "up 10"

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement(
                type = Main.MovementType.UP,
                size = 10
            )
        )
    }

    @Test
    fun invalidMovement() {
        // Assemble
        val inputString = "invalid 5"

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement(
                type = Main.MovementType.UNKNOWN,
                size = 0
            )
        )
        assertThat(result.isInvalid()).isTrue()
    }

    @Test
    fun emptyString() {
        // Assemble
        val inputString = ""

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement.asEmpty()
        )
    }

    @Test
    fun noMovementSize() {
        // Assemble
        val inputString = "forward"

        // Act
        val result = Main.Movement.fromStringLine(inputString)

        // Assert
        assertThat(result).isEqualTo(
            Main.Movement.asEmpty()
        )
    }
}