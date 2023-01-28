import models.{Animal, Cat, Dog}

object Covariance extends App {
  class Box[A](var content: A)


  /**
   * If you try to remove the comment you'll have the following error:
   * "Covariant type A occurs in contravariant position in type A of value content", since mutable values
   * are contravariant and so the attribute content cannot be assigned with a covariant value
   */
  //class ImmutableBox[+A](var content: A)
  class ImmutableBox[+A](val content: A)

  val myCatBox: ImmutableBox[Cat] = new ImmutableBox[Cat](Cat("Felix"))
  // Given some class Cov[+T], then if A is a subtype of B, Cov[A] is a subtype of Cov[B]
  val myAnimalBox: ImmutableBox[Animal] = myCatBox // now with covariance this compiles

  def printAnimalNames(animals: List[Animal]): Unit =
    animals.foreach {
      animal => println(animal.name)
    }

  val listOfCats: List[Cat] = List(Cat("Cleo"), Cat("Gin"))
  val listOfDogs: List[Dog] = List(Dog("Fuffi"), Dog("Fido"))
  val listOfAnimals: List[Animal] = List(Dog("Fuffi"), Cat("Cleo"))

  printAnimalNames(listOfCats)
  printAnimalNames(listOfDogs)
  printAnimalNames(listOfAnimals)
}