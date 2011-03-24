import org.specs.Specification

class BowlingSpecs extends Specification {

  "A Bowling scorer" should {

    "All misses" in {
      Bowling.score("-" * 20) must_== 0
    }

    "First down, rest misses" in {
      Bowling.score("1" + "-" * 19) must_== 1
    }

    "Three pins down on all rolls" in {
      Bowling.score("3" * 20) must_== 60
    }

    "One spare and a 5 after" in {
      Bowling.score("3/5" + "-" * 17) must_== 20
    }

    "All spares with fives" in {
      Bowling.score("5/" * 10 + "5") must_== 150
    }

    "Strike and the 3, 4" in {
      Bowling.score("X34" + "-" * 16) must_== 24
    }

    "Ten strikes and two misses" in {
      Bowling.score("X" * 10 + "--") must_== 270
    }

    "Strike then a 5  a spare then misses" in {
      Bowling.score("X5/" + "-" * 16) must_== 30
    }

    "Perfect roll" in {
      Bowling.score("X" * 12) must_== 300
    }

    "Eleven strikes and a 5 " in {
      Bowling.score("X" * 10 + "X5") must_== 295
    }

    "Ten strikes a miss and a five " in {
      Bowling.score("X" * 10 + "-5") must_== 275
    }

    "Ten strikes a five and a miss " in {
      Bowling.score("X" * 10 + "5-") must_== 280
    }

  }

}