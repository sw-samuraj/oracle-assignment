package cz.swsamuraj.orcl.logic

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@RunWith(classOf[JUnitRunner])
class MultiThreadAccessSuite extends FunSuite {

  trait Fixture {
    val list = new SynchronizedList
  }

  test("concurrent access via future") {
    new Fixture {
      list.push("Firefly")
      list.push("Sandman")

      val f = Future {
        assert(list.pop.get === "Sandman")
        list.push("Ghost in the Shell")
      }

      Thread.sleep(1000)

      assert(list.pop.get === "Ghost in the Shell")
      assert(list.pop.get === "Firefly")
      assert(!list.pop.isPresent)
    }
  }

}