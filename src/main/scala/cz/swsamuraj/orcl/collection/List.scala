package cz.swsamuraj.orcl.collection

/**
  * An ordered immutable collection of `T` elements.
  *
  * @see [[LinkedList]]
  */
trait List[T] {

  /**
    * Returns `true` if the list is empty,
    * otherwise `false`.
    */
  def isEmpty: Boolean

  /**
    * Adds a node to the end of the list.
    *
    * @param x a node to be added
    * @return a list with newly added node
    */
  def push(x: T): List[T]

  /**
    * Removes the last node from the list.
    *
    * @return a removed node
    */
  def pop: T

  /**
    * Inserts a node next to `after` node.
    *
    * @param x a node to be added
    * @param after an upcoming predecessor node
    * @return a list with newly added node
    */
  def insertAfter(x: T, after: T): List[T]

  /**
    * Returns a list of elements before (one-element) tail.
    *
    */
  def head: List[T]

}
