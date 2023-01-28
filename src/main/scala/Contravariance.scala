import models.{Animal, Cat, Dog}

object Contravariance extends App {
  /**
   * Contravariance is the exact opposite of Covariance:
   * given some class Contra[-T], then if A is a subtype of B, Contra[B] is a subtype of Contra[A]
   */
  abstract class Serializer[-A] {
    def serialize(a: A): String
  }

  val animalSerializer: Serializer[Animal] = new Serializer[Animal] {
    def serialize(animal: Animal): String = s"""{ "name": "${animal.name}" }"""
  }
  /**
   * Given the definition of Contravariance Animal is a subtype of Cat and so this is allowed
   */
  val catSerializer: Serializer[Cat] = animalSerializer
  //catSerializer.serialize(Dog("Felix"))
  catSerializer.serialize(Cat("Felix"))
}
