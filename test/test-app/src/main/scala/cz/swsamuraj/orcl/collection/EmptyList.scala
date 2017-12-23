package cz.swsamuraj.orcl.collection

/**
  * An empty list.
  */
case class EmptyList[T]() extends List[T] {

  /**
    * @inheritdoc
    */
  def isEmpty: Boolean = true

  /**
    * @inheritdoc
    */
  override def push(x: T): List[T] = new LinkedList[T](x, this)

  /**
    * @inheritdoc
    */
  override def pop = throw new NoSuchElementException("Pop on the empty list.")

  /**
    * @inheritdoc
    */
  override def insertAfter(x: T, after: T): List[T] =
    throw new UnsupportedOperationException("Can't insert after on the empty list.")

  /**
    * @inheritdoc
    */
  def head: List[T] = throw new NoSuchElementException("Head on the empty list.")
}
