import models.{Animal, Cat}

object Invariance {
  class Box[A](var content: A)

  val myAnimal: Animal = Cat("Felix")
  val myCatBox: Box[Cat] = new Box[Cat](Cat("Felix"))
  // Box[Cat] and Box[Animal] can’t have a subtyping relationship when using Invariance
  // this won't compile: val myAnimalBox: Box[Animal] = myCatBox
  //val myAnimalContent: Animal = myAnimalBox.content
}