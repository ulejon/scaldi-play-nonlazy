package ioc

import scaldi.Module
import service.{RealBootService, BootService}

class AppModule extends Module {
    bind[BootService] toNonLazy new RealBootService
}
