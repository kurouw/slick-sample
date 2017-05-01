package slickSample.repository

import slick.driver.H2Driver.api._

object Context {
  val db =  Database.forConfig("h2mem")

  def destory: Unit = {
    db.close()
  }
}
