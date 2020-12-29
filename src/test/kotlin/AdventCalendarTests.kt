import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class AdventCalendarTests {
  private val adventCalendar = AdventCalendar()

  @Test
  fun day1Part1Test() {
    val expenseReport = mutableListOf<Int>()

    File("src/test/input/Day1.txt").useLines {
      lines -> expenseReport.addAll(
        lines.map { it.toInt() })
    }

    // 366 + 1654 = 2020, hence 366 * 1654 = 605364
    assertEquals(605_364, adventCalendar.day1Part1(expenseReport))
  }

  @Test
  fun day1Part2Test() {
    val expenseReport = mutableListOf<Int>()

    File("src/test/input/Day1.txt").useLines {
      lines -> expenseReport.addAll(
      lines.map { it.toInt() })
    }

    // 1220 + 634 + 166 = 2020, hence 1220 * 634 * 166 = 128,397,680
    assertEquals(128_397_680, adventCalendar.day1Part2(expenseReport))
  }
}