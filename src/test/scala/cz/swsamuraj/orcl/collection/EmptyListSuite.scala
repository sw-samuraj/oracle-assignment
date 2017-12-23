package cz.swsamuraj.orcl.collection;

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EmptyListSuite extends FunSuite {

  trait Fixture {
    val emptyList = new EmptyList[Int]
  }

  test("newly created list is empty") {
    new Fixture {
      assert(emptyList.isEmpty)
    }
  }

  test("poping of the empty list throws an exception") {
    new Fixture {
      assertThrows[NoSuchElementException] {
        emptyList.pop
      }
    }
  }

  test("head on the empty list throws an exception") {
    new Fixture {
      assertThrows[NoSuchElementException] {
        emptyList.head
      }
    }
  }

  test("insert after on the empty list throws an exception") {
    new Fixture {
      assertThrows[UnsupportedOperationException] {
        emptyList.insertAfter(1, 2)
      }
    }
  }

  test("push on empty list is not empty") {
    new Fixture {
      assert(!emptyList.push(1).isEmpty)
    }
  }

  test("pushed element is the same as the popped one") {
    new Fixture {
      assert(emptyList.push(1).pop === 1)
    }
  }

  test("pop on the one element list leaves the list empty") {
    new Fixture {
      val listOfOne = emptyList.push(1)

      assert(listOfOne.pop === 1)
      assert(listOfOne.head.isEmpty)
    }
  }
}