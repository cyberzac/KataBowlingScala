object Bowling {

  def score(rolls: String): Int = scoreRemainder(1, rolls.toList)

  def scoreRemainder(frame: Int, rolls: Seq[Char]): Int = {
    if (frame > 10) {
      0
    } else {
      rolls.toList match {
        case List('X', tail@_*) => strike(tail) + scoreRemainder(frame + 1, tail)
        case List(a, '/', tail@_*) => spare(tail) + scoreRemainder(frame + 1, tail)
        case List(a, b, tail@_*) => intValue(a) + intValue(b) + scoreRemainder(frame + 1, tail)
        case _ => 0
      }
    }
  }

  def strike(rolls: Seq[Char]): Int = {
    10 + (rolls match {
      case Nil => 0
      case List(n) => intValue(n)
      case List(n, '/', _*) => 10
      case List(n, m, _*) => intValue(n) + intValue(m)
    })
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

}