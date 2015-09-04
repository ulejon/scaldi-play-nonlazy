import org.specs2.execute.AsResult
import play.api.test.{FakeRequest, Helpers, PlaySpecification}
import scaldi.play.ScaldiApplicationBuilder
import scaldi.{Injectable, Module}
import service.{MessageService, BootService}
import controller.routes.Application

class SomeTest extends PlaySpecification {
    "RealBootService" should {
        "not be executed if binding BootService to another class" in {
            val testModule = new Module {
                bind[BootService] toNonLazy new NoopBootService
            }

            implicit lazy val inj =  new ScaldiApplicationBuilder().prependModule(testModule).buildInj()

            Helpers.running(Injectable.inject[play.api.Application]) {
                AsResult.effectively {
                    true mustEqual true
                }
            }
        }
    }

    "RealMessageService" should {
        "not be executed if binding MessageService to another class" in {
            val testModule = new Module {
                bind[MessageService] to new NoopMessageService
            }

            implicit lazy val inj =  new ScaldiApplicationBuilder().prependModule(testModule).buildInj()

            Helpers.running(Injectable.inject[play.api.Application]) {
                AsResult.effectively {
                    route(FakeRequest(Application.index()))
                    true mustEqual true
                }
            }
        }
    }
}
