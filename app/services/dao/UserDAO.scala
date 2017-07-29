package services.dao

import java.sql.Date
import javax.inject.Inject

import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
  * User Data Access
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  * @param executionContext Execution Context provied by Scala for concurrency
  */
class UserDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  /**
    * Table representation of [User] class.
    * @param tag
    */
  private class UserTable(tag: Tag) extends Table[models.User](tag, "users") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc) // primary key and auto-incrementing

    def username = column[String]("username")

    def password = column[String]("password")

    def full_name = column[String]("full_name")

    def email = column[String]("email")

    def gender = column[String]("gender")

    def dob = column[Date]("dob")

    def joined_date = column[Date]("joined_date")

    /**
      * Default table projection. It defines how the columns are concerted to and from the User object
      *
      * @return
      */
    def * = (id, username, password, full_name, email, gender, dob, joined_date) <> (User.tupled, User.unapply)
  }

  /**
    * The starting point for all queries on the people table.
    */
  private val Users = TableQuery[UserTable]


  /**
    * List all the users in the database table.
    */
  def all(): Future[Seq[User]] = db.run(Users.result)
}
