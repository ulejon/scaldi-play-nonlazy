import play.api.Logger
import service.MessageService

class NoopMessageService extends MessageService {
    override def performService(): Unit = {
        Logger.info("Performing noop message service")
    }
}
