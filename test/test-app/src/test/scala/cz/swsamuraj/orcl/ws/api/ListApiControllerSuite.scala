package cz.swsamuraj.orcl.ws.api

import cz.swsamuraj.orcl.logic.SynchronizedList
import cz.swsamuraj.orcl.ws.model.{Element, InsertAfter}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.springframework.http.{HttpStatus, ResponseEntity}

@RunWith(classOf[JUnitRunner])
class ListApiControllerSuite extends FunSuite {

  trait Fixture {
    val controller = new ListApiController
    controller.setList(new SynchronizedList)

    val firefly = new Element
    firefly.setValue("Firefly")

    val sandman = new Element
    sandman.setValue("Sandman")

    val gits = new Element
    gits.setValue("Ghost in the Shell")

    val serenity = new Element
    serenity.setValue("Serenity")

    val serenityAfterFirefly = new InsertAfter
    serenityAfterFirefly.setElement(serenity)
    serenityAfterFirefly.setAfter(firefly)
  }

  test("integration test of push and pop") {
    new Fixture {
      controller.push(firefly)
      controller.push(sandman)
      controller.push(gits)
      controller.insertAfter(serenityAfterFirefly)

      assertResponse(controller.pop, gits)
      assertResponse(controller.pop, sandman)
      assertResponse(controller.pop, serenity)
      assertResponse(controller.pop, firefly)
    }
  }

  test("pop on the empty list") {
    new Fixture {
      assertResponse(controller.pop, new Element)
    }
  }

  test("insertAfter on the empty list") {
    new Fixture {
      assert(controller.insertAfter(serenityAfterFirefly).getStatusCode === HttpStatus.OK)
      assertResponse(controller.pop, new Element)
    }
  }

  def assertResponse(response: ResponseEntity[Element], element: Element) = {
    assert(response.getStatusCode === HttpStatus.OK)
    assert(response.getBody === element)
  }

}
