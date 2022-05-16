import java.nio.file.NoSuchFileException
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lines = readBracketsSequenceFromFile()
    for (line in lines) {
        val checkResult = checkValidity(line)

        if (checkResult == 0) {
            println("Success")
        } else {
            println(checkResult)
        }
    }
}

fun readBracketsSequenceFromFile(): List<String> {
    while (true) {
        try {
            return Files.readAllLines(Paths.get("brackets.txt"))
        } catch (ex: NoSuchFileException) {
            print(
                "Создайте файл brackets.txt, запишите в него скобочную последовательность, " +
                        "затем нажмите любую клавишу!\n(Можно несколько последовательностей " +
                        "каждая на новой строке)"
            )
            readLine()
        }
    }
}

fun checkValidity(line: String): Int {
    val bracketsPairs = mapOf(')' to '(', '}' to '{', ']' to '[', '>' to '<')

    val bracketsStack: ArrayList<Char> = ArrayList()
    val openBracketIndex: ArrayList<Int> = ArrayList()

    for (i in line.indices) {
        if (line[i] !in bracketsPairs.keys && line[i] !in bracketsPairs.values) {
            continue
        }

        if (line[i] in bracketsPairs.values) {
            bracketsStack.add(line[i])
            openBracketIndex.add(i + 1)
        } else if (bracketsStack.isNotEmpty() && bracketsStack.last() == bracketsPairs[line[i]]) {
            bracketsStack.removeLast()
            openBracketIndex.removeLast()
        } else {
            return i + 1
        }
    }

    if (bracketsStack.isNotEmpty()) return openBracketIndex.first()

    return 0
}