package service

import play.api.Logger

class RealBootService extends BootService {
    performBootTasks()

    override def performBootTasks(): Unit = {
        Logger.info("Performing some hardcore tasks on app boot")
    }
}
