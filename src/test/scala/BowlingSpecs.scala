import org.specs.Specification

class BowlingSpecs  extends Specification {

  "A Bowling scorer" should {

    "be 0 for all misses" in {
      Bowling.score("-"*20) must_==  0
    }

    "be 1 for first down"  in {
      Bowling.score("1"+"-" * 19) must_== 1
    }

    "be 60 three pins down on all rolls"  in {
         Bowling.score("3" * 20) must_== 60
       }

    "be 20 on 1 spare and a 5 after"  in {
         Bowling.score("3/5" + "-"* 17) must_== 20
       }

    "be 150 on all spares with fives"  in {
         Bowling.score("5/"*10+"5") must_== 150
       }

    "be 24 on X34---------" in {
      Bowling.score("X34"+"-"*16) must_== 24
    }

    "be 270 on ten strikes and two misses" in {
      Bowling.score("X"*10 + "--")  must_== 270
    }

    "Strike 5 spare" in {
      Bowling.score("X5/"+"-"*16) must_== 30
    }

    "Perfect roll" in {
      Bowling.score("X"*12) must_== 300
    }

    "Bonus issues " in {
      Bowling.score("X"*10 + "X5")  must_== 295
    }

     "Bonus issues " in {
      Bowling.score("X"*10 + "-5") must_== 285
    }
  }

}