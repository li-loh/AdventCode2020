import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class AdventCalendarTests {
  private val adventCalendar = AdventCalendar()

  @Test
  fun day1Part1Test() {
    val expenseReport = readDay1Input()

    val result = adventCalendar.day1Part1(expenseReport)

    // 366 + 1654 = 2020, hence 366 * 1654 = 605364
    assertEquals(605_364, result)
  }

  @Test
  fun day1Part2Test() {
    val expenseReport = readDay1Input()

    val result = adventCalendar.day1Part2(expenseReport)

    // 1220 + 634 + 166 = 2020, hence 1220 * 634 * 166 = 128,397,680
    assertEquals(128_397_680, result)
  }

  @Test
  fun day2Part1Test() {
    val policyAndPasswordList = mutableListOf<Pair<SledRentalPasswordPolicy,String>>()
    File("src/test/input/Day2.txt").useLines {
      lines -> policyAndPasswordList.addAll(
      lines.map {

        // can be refactored to use regex instead of this mess
        val splitPolicy = it.split(' ')
        val min = splitPolicy[0].split('-')[0].toInt()
        val max = splitPolicy[0].split('-')[1].toInt()
        val character = (splitPolicy[1])[0]
        val password = it.split(':')[1].trimStart()

        Pair(SledRentalPasswordPolicy(min, max, character), password)
      })
    }

    val result = adventCalendar.day2Part1(policyAndPasswordList)

    assertEquals(467, result)
  }

  @Test
  fun day2Part2Test() {
    val policyAndPasswordList = mutableListOf<Pair<PasswordPolicy,String>>()
    File("src/test/input/Day2.txt").useLines {
      lines -> policyAndPasswordList.addAll(
      lines.map {

        // can be refactored to use regex instead of this mess
        val splitPolicy = it.split(' ')
        val position1 = splitPolicy[0].split('-')[0].toInt()
        val position2 = splitPolicy[0].split('-')[1].toInt()
        val character = (splitPolicy[1])[0]
        val password = it.split(':')[1].trimStart()

        Pair(PasswordPolicy(position1, position2, character), password)
      })
    }

    val result = adventCalendar.day2Part2(policyAndPasswordList)

    assertEquals(441, result)
  }

  @Test
  fun day3Test() {
    val treePresenceList = mutableListOf<Boolean>()
    var numberOfColumns = 0
    var numberOfRows = 0

    File("src/test/input/Day3.txt").forEachLine { it ->
      val charOnRow = it.toCharArray()
      numberOfColumns = charOnRow.count()
      numberOfRows++
      charOnRow.map {
        treePresenceList.add(it == '#')
      }
    }

    val result = adventCalendar.day3(treePresenceList, numberOfRows, numberOfColumns)

    assertEquals(189, result)
  }

  private fun readDay1Input(): List<Int> {
    val expenseReport = mutableListOf<Int>()

    File("src/test/input/Day1.txt").useLines {
      lines -> expenseReport.addAll(
      lines.map { it.toInt() })
    }
    return expenseReport
  }
}