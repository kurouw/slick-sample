package slickSample.repository

import slickSample.models.Book
import slick.driver.H2Driver.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object BookRepository {
  def findAll: List[Book] = Await.result(Context.db.run(Tables.books.result), Duration.Inf).toList

  def findById(bookId: Int): Option[Book] = Await.result(Context.db.run(Tables.books.filter(_.id === bookId).result), Duration.Inf).headOption
}
