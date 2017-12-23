package cz.swsamuraj.orcl.logic

import java.util.Optional

import org.springframework.stereotype.Component
import cz.swsamuraj.orcl.collection.EmptyList
import cz.swsamuraj.orcl.collection.List

/**
  * Class ''SynchronizedList'' holds an instance of the
  * immutable [[List]]. All exposed methods are
  * synchronized to provide a safe multi-thread access.
  */
@Component
class SynchronizedList extends ListDao {

  private var list: List[String] = new EmptyList

  /**
    * Adds an element to the end of the list.
    *
    * @param element a node to be added
    */
  def push(element: String): Unit = {
    this.synchronized {
      list = list.push(element)
    }
  }

  /**
    * Removes the last element from the list if it's
    * presented, otherwise optional
    *
    * @return a removed element
    */
  def pop(): Optional[String] = {
    this.synchronized {
      if (list.isEmpty) Optional.empty()
      else {
        val last = list.pop
        list = list.head
        Optional.of(last)
      }
    }
  }

  /**
    * Inserts an element next to `after` element.
    *
    * @param element an element to be added
    * @param after   an upcoming predecessor element
    */
  def insertAfter(element: String, after: String): Unit = {
    this.synchronized {
      list = list.insertAfter(element, after)
    }
  }

}
