package service

import play.api.Logger

class RealMessageService extends MessageService {

    override def performService(): Unit = {
        Logger.info("Performing real message service")
    }
}
