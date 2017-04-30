import slick.driver.H2Driver.api._
import slickSample.models.User

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SlickSample{
  def main(args: Array[String]): Unit = {
    val db = Database.forConfig("h2mem")

    try{
      setup(db)
      val users = findAll(db)
      users.foreach(println)

      val user = findById(db, 1)
      user.foreach(println)
    }finally db.close

  }

  def setup(db: Database): Unit = {
    val users = TableQuery[Users]
    val create = DBIO.seq(
      users.schema.create,
      users += new User(1, "kuro", "scala@gmail.com"),
      users += new User(2, "jiro", "java@gmail.com")
    )
    val setUpFuture = db.run(create)
    Await.result(setUpFuture, Duration.Inf)
  }

  def findAll(db: Database): List[User] = {
    val users = TableQuery[Users]
    val allFuture = db.run(users.result)
    return Await.result(allFuture, Duration.Inf).toList
  }

  def findById(db: Database, userId: Int): Option[User] = {
    val users = TableQuery[Users]
    val findByIdFuture = db.run(users.filter(_.id === userId).result)
    return Await.result(findByIdFuture, Duration.Inf).headOption
  }
}

