import play.api.Logger
import service.BootService

class NoopBootService extends BootService {
    performBootTasks()

    override def performBootTasks(): Unit = {
        Logger.info("Noop boot service tast")
    }
}
