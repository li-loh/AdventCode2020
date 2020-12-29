
class AdventCalendar {

  /*
      Day 1: https://adventofcode.com/2020/day/1
      Before you leave, the Elves in accounting just need you to fix your expense report
      (your puzzle input); apparently, something isn't quite adding up.

      Specifically, they need you to find the two entries that sum to 2020
      and then multiply those two numbers together.
   */
  fun day1Part1(expenseReportList: List<Int>): Long {
    val sumTotal = 2020

    for (i in expenseReportList.indices) {
      for (j in expenseReportList.indices) {
        if ( i == j) {
          continue
        }

        if (expenseReportList[i] + expenseReportList[j] == sumTotal) {
          // found it!
          println("The value ${expenseReportList[i]} + ${expenseReportList[j]} = ${sumTotal}")
          return (expenseReportList[i] * expenseReportList[j]).toLong()
        }
      }
    }

    return -1L
  }

  fun day1Part2(expenseReportList: List<Int>): Long {
    val sumTotal = 2020

    for (i in expenseReportList.indices) {
      for (j in expenseReportList.indices) {
        for (k in expenseReportList.indices) {
          if ( i == j || j == k || i == k) {
            continue
          }

          if (expenseReportList[i] + expenseReportList[j] + + expenseReportList[k]== sumTotal) {
            // found it!
            println("The value ${expenseReportList[i]} + ${expenseReportList[j]} " +
              "+ ${expenseReportList[k]} = ${sumTotal}")
            return (expenseReportList[i] * expenseReportList[j] * expenseReportList[k]).toLong()
          }
        }
      }
    }

    return -1L
  }
}