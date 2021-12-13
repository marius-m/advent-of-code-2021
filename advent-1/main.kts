import java.io.File

val inputFile = File("input.txt")
if (!inputFile.exists())
    throw IllegalArgumentException("Must provide an input file!")

// Reading lines from kotlin
val inputNums = inputFile
    .bufferedReader(Charsets.UTF_8)
    .readLines()
    .map { numAsString -> numAsString.toInt() }

// Calculation
var incrementSum = 0
var decrementSum = 0
var equalSum = 0
var lastNum: Int? = null
for (num in inputNums) {
    if (lastNum == null) {
        lastNum = num
        continue
    }
    val _lastNum = lastNum!!
    when {
        (num > _lastNum) -> incrementSum += 1
        (num < _lastNum) -> decrementSum += 1
        (num == _lastNum) -> equalSum += 1
    }
    lastNum = num
}

println("Current input: ${inputNums.joinToString(",")}")
println("Changes: increments(${incrementSum}) / decrements (${decrementSum}) / equal (${equalSum})")
