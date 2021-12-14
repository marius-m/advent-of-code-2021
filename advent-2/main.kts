import java.io.File

val inputFile = File("input.txt")
if (!inputFile.exists())
    throw IllegalArgumentException("Must provide an input file!")

// Reading lines from kotlin
val inputMovements = inputFile
    .bufferedReader(Charsets.UTF_8)
    .readLines()
    .map { inputLine -> Movement.fromStringLine(inputLine) }

var depth = 0
var horizontalPos = 0
inputMovements.forEach { movement ->
    when (movement.type) {
        MovementType.UNKNOWN -> {
            println("Invalid movement")
        }
        MovementType.FORWARD -> {
            println("Moving forward by ${movement.size}")
            horizontalPos += movement.size
        }
        MovementType.DOWN -> {
            println("Moving down by ${movement.size}")
            depth += movement.size
        }
        MovementType.UP -> {
            println("Moving up by ${movement.size}")
            depth -= movement.size
        }
    }
}

// println("Current input: ${inputMovements.joinToString(",")}")
println("Current movement results: horizontalPos(${horizontalPos}) / depth(${depth})")

val finalPos = horizontalPos * depth
println("Final horizontal pos: ${finalPos}")

enum class MovementType {
    UNKNOWN,
    FORWARD,
    DOWN,
    UP,
    ;

    companion object {
        fun fromString(inputRaw: String): MovementType {
            return values()
                .firstOrNull { inputRaw.equals(it.name, ignoreCase = true) }
                ?: UNKNOWN
        }
    }
}

data class Movement(
    val type: MovementType,
    val size: Int,
) {

    fun isInvalid(): Boolean = type == MovementType.UNKNOWN || size <= 0

    companion object {
        val regexMovement = "(forward|down|up) ([0-9]{1,2})".toRegex()
        fun asEmpty(): Movement {
            return Movement(
                type = MovementType.UNKNOWN,
                size = 0,
            )
        }
        fun fromStringLine(inputStringLine: String): Movement {
            val movementMatch = regexMovement.find(inputStringLine)
            return if (movementMatch != null) {
                val movementTypeAsString = movementMatch.groupValues[1]
                val movementSize = movementMatch.groupValues[2]
                Movement(
                    type = MovementType.fromString(movementTypeAsString),
                    size = movementSize.toInt(),
                )
            } else {
                asEmpty()
            }
        }
    }
}
