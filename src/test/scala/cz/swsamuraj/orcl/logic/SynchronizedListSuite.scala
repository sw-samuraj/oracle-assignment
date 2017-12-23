package cz.swsamuraj.orcl.logic

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SynchronizedListSuite extends FunSuite {

  trait Fixture {
    val list = new SynchronizedList
  }

  test("pop empty list") {
    new Fixture {
      assert(!list.pop.isPresent)
    }
  }

  test("pushed element is the same as the popped one") {
    new Fixture {
      list.push("Firefly")

      assert(list.pop.get === "Firefly")
    }
  }

  test("insert after one-element list") {
    new Fixture {
      list.push("Firefly")
      list.insertAfter("Sandman", "Firefly")

      assert(list.pop.get === "Sandman")
      assert(list.pop.get === "Firefly")
      assert(!list.pop.isPresent)
    }
  }

  test("insert after 1st element of the two-element list") {
    new Fixture {
      list.push("Firefly")
      list.push("Ghost in the Shell")
      list.insertAfter("Sandman", "Firefly")

      assert(list.pop.get === "Ghost in the Shell")
      assert(list.pop.get === "Sandman")
      assert(list.pop.get === "Firefly")
      assert(!list.pop.isPresent)
    }
  }

  test("insert after 2nd element of the two-element list") {
    new Fixture {
      list.push("Firefly")
      list.push("Sandman")
      list.insertAfter("Ghost in the Shell", "Sandman")

      assert(list.pop.get === "Ghost in the Shell")
      assert(list.pop.get === "Sandman")
      assert(list.pop.get === "Firefly")
      assert(!list.pop.isPresent)
    }
  }

  test("insert after non-existing element") {
    new Fixture {
      list.push("Firefly")
      list.insertAfter("Sandman", "Non-existing")

      assert(list.pop.get === "Firefly")
      assert(!list.pop.isPresent)
    }
  }

}