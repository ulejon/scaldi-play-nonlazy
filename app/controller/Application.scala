package controller

import play.api.mvc.{Action, Controller}
import scaldi.{Injector, Injectable}
import service.MessageService

class Application(implicit inj: Injector) extends Controller with Injectable {
    val messageService = inject[MessageService]

    def index() = Action {
        messageService.performService()
        Ok("Hello!")
    }
}
