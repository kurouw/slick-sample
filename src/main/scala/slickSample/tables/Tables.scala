import slick.lifted.Tag
import slick.driver.H2Driver.api._
import slickSample.models.User

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey)

  def name = column[String]("name")

  def mail = column[String]("mail")

  def * = (id, name, mail) <> (User.tupled, User.unapply)
}
//class Books(tag: Tag) extends Table[Book](tag, "books") {
//  def id = column[Int]("id", O.PrimaryKey)
//
//  def name = column[String]("name")
//
//  def price = column[Int]("price")
//
//  def * = (id, name, price) <> (Book.tupled, Book.unapply)
//}




