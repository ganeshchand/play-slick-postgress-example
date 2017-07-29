package controllers

import services.dao.UserDAO
import javax.inject._

import models.User
import play.api.i18n.I18nSupport
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class DBController @Inject()(
                              userDAO: UserDAO,
                              cc: ControllerComponents,
                            )(implicit ec: ExecutionContext)
  extends AbstractController(cc) with I18nSupport{

  /**
    * Create an action that responds with all [[User]]
    * The result is plain text. This `Action` is mapped to
    * `GET /users` requests by an entry in the `routes` config file.
    */

  def users = Action.async { implicit rs =>
    userDAO.all().map {
      case users => Ok((users.toString()))
    }
  }

  def index = Action { implicit request =>
    Ok(views.html.index("Hello"))
  }

}



