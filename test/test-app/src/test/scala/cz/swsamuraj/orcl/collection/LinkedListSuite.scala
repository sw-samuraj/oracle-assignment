package cz.swsamuraj.orcl.collection

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LinkedListSuite extends FunSuite {

  trait Fixture {
    val emptyList = new EmptyList[Int]
    val listOfOne = emptyList.push(1)
    val listOfTwo = listOfOne.push(2)
    val listOfThree = listOfTwo.push(3)
  }

  test("non-empty list is not empty") {
    new Fixture {
      assert(!listOfOne.isEmpty)
    }
  }

  test("head of one-element list is empty") {
    new Fixture {
      assert(listOfOne.head.isEmpty)
    }
  }

  test("head of two-element list is not empty") {
    new Fixture {
      assert(!listOfTwo.head.isEmpty)
    }
  }

  test("pushed element is the same as the popped one") {
    new Fixture {
      assert(listOfOne.push(2).pop === 2)
    }
  }

  test("insert after one-element list") {
    new Fixture {
      assert(listOfOne.insertAfter(2, 1) === listOfTwo)
    }
  }

  test("insert after 1st element of the two-element list") {
    new Fixture {
      val listOfOneAndThree = listOfOne.push(3)

      assert(listOfOneAndThree.insertAfter(2, 1) === listOfThree)
    }
  }

  test("insert after 2nd element of the two-element list") {
    new Fixture {
      assert(listOfTwo.insertAfter(3, 2) === listOfThree)
    }
  }

  test("insert after non-existing element") {
    new Fixture {
      assert(listOfTwo.insertAfter(3, 3) === listOfTwo)
    }
  }

}
