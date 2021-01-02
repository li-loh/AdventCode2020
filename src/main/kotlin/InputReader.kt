import java.io.File

class InputReader {

  companion object {
    fun readDay1Input(filePath: String): List<Int> {
      val expenseReport = mutableListOf<Int>()

      File(filePath).useLines {
        lines -> expenseReport.addAll(
        lines.map { it.toInt() })
      }
      return expenseReport
    }

    fun readDay2Part1Input(filePath: String): List<Pair<SledRentalPasswordPolicy, String>> {
      val policyAndPasswordList = mutableListOf<Pair<SledRentalPasswordPolicy,String>>()
      File(filePath).useLines {
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
      return policyAndPasswordList
    }

    fun readDay2Part2Input(filePath: String): List<Pair<PasswordPolicy, String>> {
      val policyAndPasswordList = mutableListOf<Pair<PasswordPolicy,String>>()
      File(filePath).useLines {
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
      return policyAndPasswordList
    }

    fun readDay3Input(filePath: String): Triple<List<Boolean>, Int, Int> {
      val treePresenceList = mutableListOf<Boolean>()
      var numberOfColumns = 0
      var numberOfRows = 0

      File(filePath).forEachLine { it ->
        val charOnRow = it.toCharArray()
        numberOfColumns = charOnRow.count()
        numberOfRows++
        charOnRow.map {
          treePresenceList.add(it == '#')
        }
      }
      return Triple(treePresenceList, numberOfColumns, numberOfRows)
    }
  }

}