
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

  /*
    https://adventofcode.com/2020/day/2
    Example:
     1-3 a: abcde      [valid]
     1-3 b: cdefg      [invalid]
     2-9 c: ccccccccc  [valid]

    How many passwords are valid according to their policies?
   */
  fun day2Part1(policyAndPasswordList: List<Pair<SledRentalPasswordPolicy,String>>): Int {
    var validPasswordCount = 0
    for (policyAndPassword in policyAndPasswordList) {
      val policy = policyAndPassword.first
      val password = policyAndPassword.second

      // Count number of times character appears in the password
      password.toCharArray().count{ it == policy.character }
        .also {
          // And check if the count matches the policy
          if (it >= policy.min && it <= policy.max)
          {
            validPasswordCount++
          }
      }

    }
    println("The number of valid passwords is ${validPasswordCount}")
    return validPasswordCount
  }

  fun day2Part2(policyAndPasswordList: List<Pair<PasswordPolicy,String>>): Int {
    var validPasswordCount = 0
    for (policyAndPassword in policyAndPasswordList) {
      val policy = policyAndPassword.first
      val password = policyAndPassword.second

      // Check that the password matches the policy where the character can only be present
      // in exactly 1 position
      password.toCharArray().also{
        val index1 = policy.position1 - 1 // zero-based index
        val index2 = policy.position2 - 1
        if ( (it[index1] == policy.character && it[index2] != policy.character) ||
             (it[index1] != policy.character && it[index2] == policy.character) ) {
          validPasswordCount++
        }
      }
    }
    println("The number of valid passwords is ${validPasswordCount}")
    return validPasswordCount
  }

  /*
    https://adventofcode.com/2020/day/3
    Starting at the top-left corner of your map and following a slope of right 3 and down 1,
    how many trees would you encounter?
   */
  fun day3(treePresenceList: List<Boolean>, numberOfRows: Int, numberOfColumns: Int):Int {
    var currentXIndex = 0
    var currentYIndex = 0
    var numberOfTreesFound = 0

    // continue moving through the map until we reach the end of the y-axis
    while (currentYIndex < numberOfRows - 1) {

      // move right by 3, but wrap around if necessary since the map pattern repeats on the right
      currentXIndex = (currentXIndex + 3) % numberOfColumns
      currentYIndex+=1 // move down by 1

      val currentIndex = (currentXIndex) + (currentYIndex * numberOfColumns)
      if (treePresenceList[currentIndex]) {
        // a tree has been found!
        numberOfTreesFound++
      }
    }
    return numberOfTreesFound
  }
}