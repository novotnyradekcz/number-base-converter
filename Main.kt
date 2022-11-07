package converter
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

fun power(x: Int, a: Int): BigInteger {
    var result = BigInteger("1")
    if (a != 0) for (i in 1..a) result *= x.toBigInteger()
    return result
}

fun negativePower(x: Int, a: Int): BigDecimal {
    var result = BigDecimal("1").setScale(5, RoundingMode.HALF_UP)
    if (a != 0) for (i in 1..a) result /= x.toBigDecimal()
    return result
}

fun numToStr(num: Int): String {
    var str = ""
    if (num == 35) {
        str = "Z"
    } else if  (num == 34) {
        str = "Y"
    } else if  (num == 33) {
        str = "X"
    } else if  (num == 32) {
        str = "W"
    } else if  (num == 31) {
        str = "V"
    } else if  (num == 30) {
        str = "U"
    } else if  (num == 29) {
        str = "T"
    } else if  (num == 28) {
        str = "S"
    } else if  (num == 27) {
        str = "R"
    } else if  (num == 26) {
        str = "Q"
    } else if  (num == 25) {
        str = "P"
    } else if  (num == 24) {
        str = "O"
    } else if  (num == 23) {
        str = "N"
    } else if  (num == 22) {
        str = "M"
    } else if  (num == 21) {
        str = "L"
    } else if  (num == 20) {
        str = "K"
    } else if  (num == 19) {
        str = "J"
    } else if  (num == 18) {
        str = "I"
    } else if  (num == 17) {
        str = "H"
    } else if  (num == 16) {
        str = "G"
    } else if  (num == 15) {
        str = "F"
    } else if  (num == 14) {
        str = "E"
    } else if  (num == 13) {
        str = "D"
    } else if  (num == 12) {
        str = "C"
    } else if  (num == 11) {
        str = "B"
    } else if  (num == 10) {
        str = "A"
    } else {
        str = num.toString()
    }
    return str
}

fun charToNum(letter: Char): Int {
    var num = 0
    if (letter == '0') num = 0
    if (letter == '1') num = 1
    if (letter == '2') num = 2
    if (letter == '3') num = 3
    if (letter == '4') num = 4
    if (letter == '5') num = 5
    if (letter == '6') num = 6
    if (letter == '7') num = 7
    if (letter == '8') num = 8
    if (letter == '9') num = 9
    if (letter == 'A' || letter == 'a') num = 10
    if (letter == 'B' || letter == 'b') num = 11
    if (letter == 'C' || letter == 'c') num = 12
    if (letter == 'D' || letter == 'd') num = 13
    if (letter == 'E' || letter == 'e') num = 14
    if (letter == 'F' || letter == 'f') num = 15
    if (letter == 'G' || letter == 'g') num = 16
    if (letter == 'H' || letter == 'h') num = 17
    if (letter == 'I' || letter == 'i') num = 18
    if (letter == 'J' || letter == 'j') num = 19
    if (letter == 'K' || letter == 'k') num = 20
    if (letter == 'L' || letter == 'l') num = 21
    if (letter == 'M' || letter == 'm') num = 22
    if (letter == 'N' || letter == 'n') num = 23
    if (letter == 'O' || letter == 'o') num = 24
    if (letter == 'P' || letter == 'p') num = 25
    if (letter == 'Q' || letter == 'q') num = 26
    if (letter == 'R' || letter == 'r') num = 27
    if (letter == 'S' || letter == 's') num = 28
    if (letter == 'T' || letter == 't') num = 29
    if (letter == 'U' || letter == 'u') num = 30
    if (letter == 'V' || letter == 'v') num = 31
    if (letter == 'W' || letter == 'w') num = 32
    if (letter == 'X' || letter == 'x') num = 33
    if (letter == 'Y' || letter == 'y') num = 34
    if (letter == 'Z' || letter == 'z') num = 35
    return num
}

fun main() {
    do {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        val userInput = readln()
        if (userInput != "/exit") {
            val (sourceBase, targetBase) = userInput.split(" ")
            do {
                print("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back) ")
                val sourceNumber = readln()
                if (sourceNumber != "/back") {
                    if (sourceNumber.indexOf('.') == -1) {
                        val sourceNumList = sourceNumber.toMutableList()
                        val numbersNumList = MutableList(sourceNumList.size) { 0 }
                        for (i in sourceNumList.indices) {
                            numbersNumList[i] = charToNum(sourceNumList[i])
                        }
                        var decimal = BigInteger("0")
                        for (i in numbersNumList.indices) {
                            decimal += power(sourceBase.toInt(), numbersNumList.lastIndex - i) * numbersNumList[i].toBigInteger()
                        }
                        var targetNumber = ""
                        while (decimal >= 1.toBigInteger()) {
                            val remainder = numToStr((decimal % targetBase.toBigInteger()).toInt())
                            targetNumber = remainder + targetNumber
                            decimal /= targetBase.toBigInteger()
                        }
                        println("Conversion result: $targetNumber")
                    } else {
                        val (integerPart, fractionalPart) = sourceNumber.split(".")
                        val sourceIntList = integerPart.toMutableList()
                        val sourceFracList = fractionalPart.toMutableList()
                        val numbersIntList = MutableList(sourceIntList.size) { 0 }
                        val numbersFracList = MutableList(sourceFracList.size) { 0 }
                        for (i in sourceIntList.indices) {
                            numbersIntList[i] = charToNum(sourceIntList[i])
                        }
                        for (i in sourceFracList.indices) {
                            numbersFracList[i] = charToNum(sourceFracList[i])
                        }
                        var intDecimal = BigInteger("0")
                        var fracDecimal = BigDecimal("0")
                        for (i in numbersIntList.indices) {
                            intDecimal += power(sourceBase.toInt(), numbersIntList.lastIndex - i) * numbersIntList[i].toBigInteger()
                        }
                        for (i in numbersFracList.indices) {
                            fracDecimal += negativePower(sourceBase.toInt(), i + 1) * numbersFracList[i].toBigDecimal()
                        }
                        var targetNumber = ""
                        while (targetNumber.length < 5) {
                            val remainder = numToStr((fracDecimal * targetBase.toBigDecimal()).toInt())
                            targetNumber += remainder
                            fracDecimal = fracDecimal * targetBase.toBigDecimal() - (fracDecimal * targetBase.toBigDecimal()).toInt().toBigDecimal()
                        }
                        targetNumber = "." + targetNumber
                        while (intDecimal >= 1.toBigInteger()) {
                            val remainder = numToStr((intDecimal % targetBase.toBigInteger()).toInt())
                            targetNumber = remainder + targetNumber
                            intDecimal /= targetBase.toBigInteger()
                        }
                        println("Conversion result: $targetNumber")
                    }

                }
            } while (sourceNumber != "/back")
        }
    } while (userInput != "/exit")
}