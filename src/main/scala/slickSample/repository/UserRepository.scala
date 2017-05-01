package slickSample.repository

import slick.driver.H2Driver.api._
import slickSample.models.{Book, User}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object UserRepository {
  def findAll: List[User] = Await.result(Context.db.run(Tables.users.result), Duration.Inf).toList

  def findById(userId: Int): Option[User] = Await.result(Context.db.run(Tables.users.filter(_.id === userId).result), Duration.Inf).headOption

  def setup: Unit = {
    val users = TableQuery[Users]
    val books = TableQuery[Books]
    val create = DBIO.seq(
      (users.schema ++ books.schema).create,
      users ++= Seq(
        new User(1, "kuro", "scala@gmail.com"),
        new User(2, "jiro", "java@gmail.com")
      ),
      books ++= Seq(
        new Book(1, "Beginning Scala", 3000, 1),
        new Book(2, "Scalable Scala", 5000, 2),
        new Book(3, "Pocket Reference Scala", 4000, 1),
        new Book(4, "Programming Java", 3400, 1),
        new Book(5, "Rails Tutorial", 4200, 1)
      )
    )
    val setUpFuture = Context.db.run(create)
    Await.result(setUpFuture, Duration.Inf)
  }
}
