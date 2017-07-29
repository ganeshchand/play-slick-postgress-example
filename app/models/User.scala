package models

import java.sql.Date

case class User(
                 id: Int,
                 username: String,
                 password: String,
                 full_name: String,
                 email: String,
                 gender: String,
                 dob: Date,
                 joined_date: Date
               )

import play.api.libs.json._

object Person {
  implicit val userJsonFormat = Json.format[User]
}
