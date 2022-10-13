import java.util.LinkedList

const val UNEXPLORED_CELL = '.'
const val EXPLORED_CELL = '/'
const val MARKED_CELL = '*'
const val MINE_CELL = 'X'
const val MINE_INPUT = "How many mines do you want on the field?"
const val PROMPT_MESSAGE = "Set/unset mine marks or claim a cell as free:"
const val NUMBER_SIGNAL = "There is a number here!"
const val EXPLORED_SIGNAL = "This cell has already been explored!"
const val VICTORY_MESSAGE = "Congratulations! You found all the mines!"
const val FAIL_MESSAGE = "You stepped on a mine and failed!"
const val ACTION_DISCOVER = "free"
const val ACTION_MINE = "mine"

fun main() {
    println(MINE_INPUT)
    val numberOfMines = readln().toInt()
    val minefield = Minefield(9, 9, numberOfMines)
    minefield.playMinesweeper()
}

class Minefield(private val rows: Int, private val columns: Int, private val numberOfMines: Int) {

    private val grid: MutableList<MutableList<Char>> = MutableList(rows) { MutableList(columns) { UNEXPLORED_CELL } }
    private val mines = mutableMapOf<Pair<Int, Int>, String>()
    private val hints = mutableMapOf<Pair<Int, Int>, Char>()

    private fun displayMinefield() {
        println(
            " │123456789│\n" +
                    "—│—————————│"
        )
        grid.forEachIndexed { index, it ->
            println(it.joinToString("", prefix = "${index + 1}│", postfix = "│"))
        }
        println("—│—————————│")
    }

    private fun hideInfo() {
        for (row in 0 until rows) {
            for (column in 0 until columns) {
                if (grid[row][column] == MINE_CELL) {
                    mines.putIfAbsent(Pair(row, column), "NOT_FOUND")
                    grid[row][column] = UNEXPLORED_CELL
                }
                if (grid[row][column].isDigit()) {
                    hints.putIfAbsent(Pair(row, column), grid[row][column])
                    grid[row][column] = UNEXPLORED_CELL
                }
            }
        }
    }

    private fun addMines(firstDiscoveredCell: Pair<Int, Int>) {
        if (numberOfMines <= rows * columns) {
            while (mines.size < numberOfMines) {
                val row = (0 until rows).random()
                val column = (0 until columns).random()
                if (grid[row][column] != MINE_CELL || mines.containsKey(Pair(row, column))
                    && grid[row][column] != EXPLORED_CELL
                ) {
                    mines.putIfAbsent(Pair(row, column), "NOT_FOUND")
                    grid[row][column] = if (grid[row][column] == MARKED_CELL) MARKED_CELL else MINE_CELL
                    for (i in -1..1) for (j in -1..1) if (grid.getOrNull(firstDiscoveredCell.first + i)
                            ?.getOrNull(firstDiscoveredCell.second + j) != null
                    ) {
                        grid[firstDiscoveredCell.first + i][firstDiscoveredCell.second + j] = UNEXPLORED_CELL
                        mines.remove(Pair(firstDiscoveredCell.first + i, firstDiscoveredCell.second + j))
                    }
                }
            }
        }
    }

    private fun addHints() {
        var count = 0
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                if (grid[i][j] == UNEXPLORED_CELL || grid[i][j] == MARKED_CELL) {
                    for (k in -1..1) {
                        for (l in -1..1) {
                            if (grid.getOrNull(i + k)?.getOrNull(j + l) == MINE_CELL
                                || Pair(i + k, j + l) in mines
                            ) count++
                        }
                    }
                    if (count > 0) {
                        grid[i][j] = if (grid[i][j] == MARKED_CELL) MARKED_CELL else "$count".single()
                        hints.putIfAbsent(Pair(i, j), "$count".single())
                    }
                    count = 0
                }
            }
        }
    }

    private fun revealAllMines() {
        mines.forEach {
            grid[it.key.first][it.key.second] = MINE_CELL
        }
        displayMinefield()
    }

    private fun allFreeCellsDiscovered(): Boolean {
        var numberOfExploredCells = 0 // Explored free cells and explored hint cells
        for (row in 0 until rows) {
            for (column in 0 until columns) {
                if (grid[row][column] == EXPLORED_CELL || grid[row][column].let { if (it.isDigit()) it.digitToInt() else it } in 1 until 9)
                    numberOfExploredCells++
            }
        }
        return numberOfExploredCells == rows * columns - numberOfMines
    }

    private fun initialGameSetup() {
        displayMinefield()
        println(PROMPT_MESSAGE)
        val userFirstInput = readln()
        var firstAction = userFirstInput.filter { it in ACTION_DISCOVER || it in ACTION_MINE }
        var firstInputX = userFirstInput.last { it.isDigit() }.digitToInt() - 1
        var firstInputY = userFirstInput.first { it.isDigit() }.digitToInt() - 1
        grid[firstInputX][firstInputY] = if (firstAction == ACTION_DISCOVER) EXPLORED_CELL else MARKED_CELL
        while (firstAction == ACTION_MINE) {
            displayMinefield()
            println(PROMPT_MESSAGE)
            val userNewInput = readln()
            firstAction = userNewInput.filter { it in ACTION_DISCOVER || it in ACTION_MINE }
            firstInputX = userNewInput.last { it.isDigit() }.digitToInt() - 1
            firstInputY = userNewInput.first { it.isDigit() }.digitToInt() - 1
            grid[firstInputX][firstInputY] =
                if (firstAction == ACTION_DISCOVER) EXPLORED_CELL
                else if (grid[firstInputX][firstInputY] == MARKED_CELL) UNEXPLORED_CELL
                else MARKED_CELL
        }
        addMines(Pair(firstInputX, firstInputY))
        addHints()
        hideInfo()
        discoverCells(firstInputX, firstInputY)
        displayMinefield()
    }

    private fun discoverCells(cellX: Int, cellY: Int) {
        if (hints.containsKey(Pair(cellX, cellY))) {
            grid[cellX][cellY] = hints.getValue(Pair(cellX, cellY))
        } else if (!hints.containsKey(Pair(cellX, cellY)) && !mines.containsKey(Pair(cellX, cellY))) {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(Pair(cellX, cellY))
            while (queue.isNotEmpty()) {
                val currentCell = queue.pop()
                grid[currentCell.first][currentCell.second] = EXPLORED_CELL
                for (i in (-1..1)) {
                    for (j in (-1..1)) {
                        // Check for out of bounds exceptions
                        if (grid.getOrNull(currentCell.first + i)
                                ?.getOrNull(currentCell.second + j) != null
                        ) {
                            grid[currentCell.first + i][currentCell.second + j] =
                                if (Pair(currentCell.first + i, currentCell.second + j) in hints.keys) {
                                    hints.getValue(Pair(currentCell.first + i, currentCell.second + j))
                                } else if (Pair(currentCell.first + i, currentCell.second + j) in mines.keys) {
                                    if (grid[currentCell.first + i][currentCell.second + j] == MARKED_CELL ) MARKED_CELL else UNEXPLORED_CELL
                                } else {
                                    if (grid[currentCell.first + i][currentCell.second + j] != EXPLORED_CELL) {
                                        // Set the next cell to be checked
                                        if (!queue.contains(Pair(currentCell.first + i, currentCell.second + j)))
                                            queue.push(Pair(currentCell.first + i, currentCell.second + j))
                                        EXPLORED_CELL
                                    }
                                    EXPLORED_CELL
                                }
                        }
                    }
                }

            }

        }
    }

    fun playMinesweeper() {
        initialGameSetup()
        var gameOverMessage = VICTORY_MESSAGE
        val allMinesFound = !mines.containsValue("NOT_FOUND")
        playLoop@ while (!allFreeCellsDiscovered() && !allMinesFound) {
            println(PROMPT_MESSAGE)
            val userInput = readln()
            val action = userInput.filter { it in ACTION_DISCOVER || it in ACTION_MINE }
            val inputX = userInput.last { it.isDigit() }.digitToInt() - 1
            val inputY = userInput.first { it.isDigit() }.digitToInt() - 1
            val selectedCell = grid[inputX][inputY]
            when {
                // Player marks or discovers a cell containing a number
                selectedCell.let { if (it.isDigit()) it.digitToInt() else it } in (1 until 9) -> println(NUMBER_SIGNAL)
                // Player marks a cell already discovered
                selectedCell == EXPLORED_CELL && action == ACTION_MINE -> {
                    grid[inputX][inputY] = MARKED_CELL
                    displayMinefield()
                }
                // Player discovers a cell already discovered
                selectedCell == EXPLORED_CELL && action == ACTION_DISCOVER -> println(EXPLORED_SIGNAL)
                // Player unmarks or discovers a marked cell
                selectedCell == MARKED_CELL -> {
                    if (action == ACTION_MINE) {
                        if (mines.containsKey(Pair(inputX, inputY))) mines[Pair(inputX, inputY)] = "NOT_FOUND"
                        for (i in -1..1) for (j in -1..1)
                            if (grid.getOrNull(inputX + i)?.getOrNull(inputY + j) != null)
                                grid[inputX][inputY] =
                                    if (grid[inputX + i][inputY + j] == EXPLORED_CELL) EXPLORED_CELL else UNEXPLORED_CELL
                    } else {
                        if (mines.containsKey(Pair(inputX, inputY))) {
                            gameOverMessage = FAIL_MESSAGE
                            revealAllMines()
                            break@playLoop
                        } else {
                            discoverCells(inputX, inputY)
                        }
                    }
                    displayMinefield()
                }
                // Player marks or discovers an unexplored cell
                selectedCell == UNEXPLORED_CELL -> {
                    if (action == ACTION_MINE) {
                        if (mines.contains(Pair(inputX, inputY))) mines[Pair(inputX, inputY)] = "FOUND"
                        grid[inputX][inputY] = MARKED_CELL
                    } else {
                        if (mines.containsKey(Pair(inputX, inputY))) {
                            gameOverMessage = FAIL_MESSAGE
                            revealAllMines()
                            break@playLoop
                        } else {
                            discoverCells(inputX, inputY)
                        }
                    }
                    displayMinefield()
                }
            }
        }
        println(gameOverMessage)
    }
}