// Copyright Tony Morris 2008
// This software is released under an open source BSD licence.

// $LastChangedRevision$
// $LastChangedDate$


package scalaz

/**
 * A digit from 0 to 9.
 *
 * @author <a href="mailto:code@tmorris.net">Tony Morris</a>
 * @version $LastChangedRevision$<br>
 *          $LastChangedDate$<br>
 *          $LastChangedBy$
 */
sealed trait Digit {
  /**
   * A long value for this digit.
   */
  val toLong: Long

  /**
   * Compare two digits for equality.
   */
  override def equals(o: Any) = o != null && o.isInstanceOf[Digit] && toLong == o.asInstanceOf[Digit].toLong

  /**
   * A hash code for this digit.
   */
  override def hashCode = toLong.hashCode

  /**
   * A String representation of this digit.
   */
  override def toString = toLong.toString
}
/**
 * Zero.
 */
final case object _0 extends Digit {
  /**
   * <code>0</code>.
   */
  override val toLong = 0L
}
/**
 * One.
 */
final case object _1 extends Digit {
  /**
   * <code>1</code>.
   */
  override val toLong = 1L
}
/**
 * Two.
 */
final case object _2 extends Digit {
  /**
   * <code>2</code>.
   */
  override val toLong = 2L
}
/**
 * Three.
 */
final case object _3 extends Digit {
  /**
   * <code>3</code>.
   */
  override val toLong = 3L
}
/**
 * Four.
 */
final case object _4 extends Digit {
  /**
   * <code>4</code>.
   */
  override val toLong = 4L
}
/**
 * Five.
 */
final case object _5 extends Digit {
  /**
   * <code>5</code>.
   */
  override val toLong = 5L
}
/**
 * Six.
 */
final case object _6 extends Digit {
  /**
   * <code>6</code>.
   */
  override val toLong = 6L
}
/**
 * Seven.
 */
final case object _7 extends Digit {
  /**
   * <code>7</code>.
   */
  override val toLong = 7L
}
/**
 * Eight.
 */
final case object _8 extends Digit {
  /**
   * <code>8</code>.
   */
  override val toLong = 8L
}
/**
 * Nine.
 */
final case object _9 extends Digit {
  /**
   * <code>9</code>.
   */
  override val toLong = 9L
}

/**
 * Functions over digits.
 *
 * @author <a href="mailto:code@tmorris.net">Tony Morris</a>
 * @version $LastChangedRevision$<br>
 *          $LastChangedDate$<br>
 *          $LastChangedBy$
 */
object Digit {
  /**
   * All digits.
   */
  val digits = List(_0, _1, _2, _3, _4, _5, _6, _7, _8, _9)

  /**
   * A long value for the given digit.
   */
  implicit def DigitLong(d: Digit) = d.toLong

  /**
   * A digit for the right-most digit of the given long value.
   */
  implicit def LongDigit(n: Long): Digit = n match {
    case 0L => _0
    case 1L => _1
    case 2L => _2
    case 3L => _3
    case 4L => _4
    case 5L => _5
    case 6L => _6
    case 7L => _7
    case 8L => _8
    case 9L => _9
    case _ => Math.abs(n) % 10L
  }

  import control.{FoldLeft, MonadEmptyPlus}
  import control.FoldLeftW.foldleft
  import control.MonadEmptyPlus.unfold

  /**
   * Converts the given long value to a sequence of digits.
   */
  def longDigits[T[_]](n: Long)(implicit f: FoldLeft[T], m: MonadEmptyPlus[T]): T[Digit] =
    foldleft[T](unfold[T]((b: Long) => if(b == 0) None else Some (b % 10L: Digit, b / 10L), n)).rev[T]

  /**
   * Converts the given sequence of digits to a long value.
   */
  def digitsLong[T[_]](ds: T[Digit])(implicit f: FoldLeft[T]) =
    f.foldLeft[Long, Digit](ds, 0L, (a, b) => a * 10L + b)
}