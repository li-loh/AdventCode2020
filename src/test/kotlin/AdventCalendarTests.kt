import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class AdventCalendarTests {
  private val adventCalendar = AdventCalendar()

  @Test
  fun day1Part1Test() {
    val expenseReport = InputReader.readDay1Input("src/test/input/Day1.txt")

    val result = adventCalendar.day1Part1(expenseReport)

    // 366 + 1654 = 2020, hence 366 * 1654 = 605364
    assertEquals(605_364, result)
  }

  @Test
  fun day1Part2Test() {
    val expenseReport = InputReader.readDay1Input("src/test/input/Day1.txt")

    val result = adventCalendar.day1Part2(expenseReport)

    // 1220 + 634 + 166 = 2020, hence 1220 * 634 * 166 = 128,397,680
    assertEquals(128_397_680, result)
  }

  @Test
  fun day2Part1Test() {
    val policyAndPasswordList = InputReader.readDay2Part1Input("src/test/input/Day2.txt")

    val result = adventCalendar.day2Part1(policyAndPasswordList)

    assertEquals(467, result)
  }

  @Test
  fun day2Part2Test() {
    val policyAndPasswordList = InputReader.readDay2Part2Input("src/test/input/Day2.txt")

    val result = adventCalendar.day2Part2(policyAndPasswordList)

    assertEquals(441, result)
  }

  @Test
  // Starting at the top-left corner of your map and following a slope of
  // mvoe right 3 and down 1, how many trees would you encounter?
  fun day3Part1Test() {
    val moveDownCount = 1
    val moveRightCount = 3

    val input = InputReader.readDay3Input("src/test/input/Day3.txt")
    val treePresenceList = input.first
    val numberOfColumns = input.second
    val numberOfRows = input.third

    val result = adventCalendar.day3(treePresenceList, numberOfRows, numberOfColumns,
      moveRightCount, moveDownCount)

    assertEquals(189, result)
  }

  @Test
  // What do you get if you multiply together the number of trees encountered on each of the listed slopes?
  // Right 1, down 1.
  // Right 3, down 1.
  // Right 5, down 1.
  // Right 7, down 1.
  // Right 1, down 2.
  fun day3Part2Test() {
    val slopes = mutableListOf<Pair<Int, Int>>()
    slopes.add(Pair(1,1))
    slopes.add(Pair(3,1))
    slopes.add(Pair(5,1))
    slopes.add(Pair(7,1))
    slopes.add(Pair(1,2))

    val input = InputReader.readDay3Input("src/test/input/Day3.txt")
    val treePresenceList = input.first
    val numberOfColumns = input.second
    val numberOfRows = input.third

    var result = 0

    for (slope in slopes) {
      val numberOfTrees = adventCalendar.day3(treePresenceList, numberOfRows, numberOfColumns,
        slope.first, slope.second)

      if (result == 0){
        result = numberOfTrees
      }
      else {
        result *= numberOfTrees
      }

    }
    assertEquals(1_718_180_100, result)
  }
  
}