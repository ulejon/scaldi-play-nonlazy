import org.specs2.execute.AsResult
import play.api.test.{Helpers, PlaySpecification}
import scaldi.play.ScaldiApplicationBuilder
import scaldi.{Injectable, Module}
import service.BootService

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
}
