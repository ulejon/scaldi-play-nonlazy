package ioc

import scaldi.Module
import service.{RealMessageService, MessageService, RealBootService, BootService}

class AppModule extends Module {
    bind[BootService] toNonLazy new RealBootService
    bind[MessageService] to new RealMessageService
}
