package slickSample.app

import slickSample.models.{Book, User}
import slickSample.repository.{BookRepository, Context, UserRepository}

object SlickSample{
  def main(args: Array[String]): Unit = {
    UserRepository.setup
    val users: List[User] = UserRepository.findAll
    users.foreach(println)

    val books: List[Book] = BookRepository.findAll
    books.foreach(println)

    val userOpt: Option[User] = UserRepository.findById(1)
    userOpt.foreach(println)

    val bookOpt: Option[Book] = BookRepository.findById(2)
    bookOpt.foreach(println)

    Context.destory
  }
}

