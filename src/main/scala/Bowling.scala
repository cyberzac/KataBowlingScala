object Bowling {

  def score(rolls: String): Int = scoreRemainder(rolls.toList)

  def scoreRemainder(rolls: Seq[Char]): Int = {
    rolls.toList match {
      case List('X', 'X') => 0
      case List('X', _, '/', tail@_*) => 10 + 10 + spare(tail) + scoreRemainder(tail)
      case List('X', tail@_*) => strike(tail) + scoreRemainder(tail)
      case List(a, '/', tail@_*) => spare(tail) + scoreRemainder(tail)
      case List(a, b, tail@_*) => intValue(a) + intValue(b) + scoreRemainder(tail)
      case _ => 0
    }
  }

  def strike(rolls: Seq[Char]): Int = {
    10 +(rolls match {
      case Nil => 0
      case List(n) => intValue(n)
      case List(n, m, _*) => intValue(n) + intValue(m)
    } )
  }

  def spare(rolls: Seq[Char]): Int = {
    10 + intValue(rolls head)
  }

  def intValue(char: Char): Int = {
    char match {
      case '-' => 0
      case 'X' => 10
      case _ => char - '0'
    }
  }

  case class ScoreState(score: Int, lastRoll: Char)

}