package cz.swsamuraj.orcl.collection

/**
  * A multi-thread singly linked list, implemented as an immutable list.
  */
case class LinkedList[T](val last: T, val head: List[T]) extends List[T] {

  /**
    * @inheritdoc
    */
  def isEmpty: Boolean = false

  /**
    * @inheritdoc
    */
  override def push(x: T): List[T] = new LinkedList[T](x, this)

  /**
    * @inheritdoc
    */
  override def pop: T = last

  /**
    * @inheritdoc
    */
  override def insertAfter(x: T, after: T): List[T] = {
    def loop(list: List[T], acc: List[T]): List[T] = list match {
      case EmptyList() => this
      case LinkedList(last, head) =>
        if (last == after) {
          combineLists(new LinkedList[T](x, list), acc)
        } else {
          loop(head, acc.push(last))
        }
    }

    loop(this, new EmptyList[T])
  }

  private def combineLists(head: List[T], acc: List[T]): List[T] = {
    if (acc.isEmpty) head
    else combineLists(head.push(acc.pop), acc.head)
  }

}
