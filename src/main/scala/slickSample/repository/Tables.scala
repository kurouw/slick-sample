package slickSample.repository

import slick.driver.H2Driver.api._
import slick.lifted.Tag
import slickSample.models.{Book, User}

object Tables {
  val users = TableQuery[Users]
  val books = TableQuery[Books]
}

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey)

  def name = column[String]("name")

  def mail = column[String]("mail")

  def * = (id, name, mail) <> (User.tupled, User.unapply)
}

class Books(tag: Tag) extends Table[Book](tag, "books") {
  def id = column[Int]("id", O.PrimaryKey)

  def name = column[String]("name")

  def price = column[Int]("price")

  def userId = column[Int]("user_id")

  def * = (id, name, price, userId) <> (Book.tupled, Book.unapply)

  def users = foreignKey("user_fk", userId, TableQuery[Users])(_.id)
}





