package controller

import play.api.mvc.{Action, Controller}

class Application extends Controller {
    def index() = Action {
        Ok("Hello!")
    }
}