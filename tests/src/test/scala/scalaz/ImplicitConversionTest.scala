package scalaz

// compiles == green
object ImplicitConversionTest {
  import Scalaz._
  import Predef.{implicitly => i}

  def MAs[A, B, C, D, E, F, G, H] {
    i[List[A] <%< MA[List, A]]
    i[Option[A] <%< MA[Option, A]]
    i[(A => B) <%< MACofunctor[PartialApply1Of2[Function1, B]#Flip, A]]
    i[(A => B) <%< MA[PartialApply1Of2[Function1, A]#Apply, B]]
    i[((A, B) => C) <%< MA[PartialApply2Of3[Function2, A, B]#Apply, C]]
    i[((A, B, C) => D) <%< MA[PartialApply3Of4[Function3, A, B, C]#Apply, D]]
    i[((A, B, C, D) => E) <%< MA[PartialApply4Of5[Function4, A, B, C, D]#Apply, E]]
    i[((A, B, C, D, E) => F) <%< MA[PartialApply5Of6[Function5, A, B, C, D, E]#Apply, F]]
    i[((A, B, C, D, E, F) => G) <%< MA[PartialApply6Of7[Function6, A, B, C, D, E, F]#Apply, G]]
    i[Validation[A, B] <%< MA[PartialApply1Of2[Validation, A]#Apply, B]]
    i[FailProjection[A, B] <%< MA[PartialApply1Of2[FailProjection, B]#Flip, A]]
    i[Either.LeftProjection[A, B] <%< MA[PartialApply1Of2[Either.LeftProjection, B]#Flip, A]]
    i[Either.RightProjection[A, B] <%< MA[PartialApply1Of2[Either.RightProjection, A]#Apply, B]]
    i[(A, B) <%< MA[PartialApply1Of2[Tuple2, A]#Apply, B]]
    i[(A, B, C) <%< MA[PartialApply2Of3[Tuple3, A, B]#Apply, C]]
    i[(A, B, C, D) <%< MA[PartialApply3Of4[Tuple4, A, B, C]#Apply, D]]
    i[(A, B, C, D, E) <%< MA[PartialApply4Of5[Tuple5, A, B, C, D]#Apply, E]]
    i[(A, B, C, D, E, F) <%< MA[PartialApply5Of6[Tuple6, A, B, C, D, E]#Apply, F]]
    i[(A, B, C, D, E, F, G) <%< MA[PartialApply6Of7[Tuple7, A, B, C, D, E, F]#Apply, G]]

    // via higher kind inference
    trait T[A]
    i[T[A] <%< MACofunctor[T, A]]
    i[T[A] <%< MA[T, A]]
  }

  def apply[A, B, R, S, T, U, V, W, X] {
    i[Apply[Identity]]
    i[Apply[List]]
    i[Apply[Function0]]
    i[Apply[Option]]
    i[Apply[PartialApply1Of2[State, A]#Apply]]
    i[Apply[Function0]]
    i[Apply[PartialApply1Of2[Function1, R]#Apply]]
    i[Apply[PartialApply2Of3[Function2, R, S]#Apply]]
    i[Apply[PartialApply3Of4[Function3, R, S, T]#Apply]]
    i[Apply[PartialApply4Of5[Function4, R, S, T, U]#Apply]]
    i[Apply[PartialApply5Of6[Function5, R, S, T, U, V]#Apply]]
    i[Apply[PartialApply6Of7[Function6, R, S, T, U, V, W]#Apply]]
    i[Apply[PartialApply1Of2[Either.LeftProjection, X]#Flip]]
    i[Apply[PartialApply1Of2[Either.RightProjection, X]#Apply]]
    import java.util.Map.Entry
    i[Apply[PartialApply1Of2[Entry, Int]#Apply]]
    i[Apply[PartialApply1Of2[Validation, Int]#Apply]]
    i[Apply[PartialApply1Of2[FailProjection, X]#Flip]]
  }

  def applicative[A, B, R, S, T, U, V, W, X] {
    i[Applicative[Identity]]
    i[Applicative[List]]
    i[Applicative[Function0]]
    i[Applicative[Option]]
    i[Applicative[PartialApply1Of2[State, A]#Apply]]
    i[Applicative[Function0]]
    i[Applicative[PartialApply1Of2[Function1, R]#Apply]]
    i[Applicative[PartialApply2Of3[Function2, R, S]#Apply]]
    i[Applicative[PartialApply3Of4[Function3, R, S, T]#Apply]]
    i[Applicative[PartialApply4Of5[Function4, R, S, T, U]#Apply]]
    i[Applicative[PartialApply5Of6[Function5, R, S, T, U, V]#Apply]]
    i[Applicative[PartialApply6Of7[Function6, R, S, T, U, V, W]#Apply]]
    i[Applicative[PartialApply1Of2[Either.LeftProjection, X]#Flip]]
    i[Applicative[PartialApply1Of2[Either.RightProjection, X]#Apply]]
    import java.util.Map.Entry
    i[Applicative[PartialApply1Of2[Entry, Int]#Apply]]
    i[Applicative[PartialApply1Of2[Validation, Int]#Apply]]
    i[Applicative[PartialApply1Of2[FailProjection, X]#Flip]]
  }

  def pointed[A, B, R, S, T, U, V, W, X] {
    i[Pointed[Identity]]
    i[Pointed[List]]
    i[Pointed[Function0]]
    i[Pointed[Option]]
    i[Pointed[PartialApply1Of2[State, A]#Apply]]
    i[Pointed[Function0]]
    i[Pointed[PartialApply1Of2[Function1, R]#Apply]]
    i[Pointed[PartialApply2Of3[Function2, R, S]#Apply]]
    i[Pointed[PartialApply3Of4[Function3, R, S, T]#Apply]]
    i[Pointed[PartialApply4Of5[Function4, R, S, T, U]#Apply]]
    i[Pointed[PartialApply5Of6[Function5, R, S, T, U, V]#Apply]]
    i[Pointed[PartialApply6Of7[Function6, R, S, T, U, V, W]#Apply]]
    i[Pointed[PartialApply1Of2[Either.LeftProjection, X]#Flip]]
    i[Pointed[PartialApply1Of2[Either.RightProjection, X]#Apply]]
    import java.util.Map.Entry
    i[Pointed[PartialApply1Of2[Entry, Int]#Apply]]
    i[Pointed[PartialApply1Of2[Validation, Int]#Apply]]
    i[Pointed[PartialApply1Of2[FailProjection, X]#Flip]]
  }

  def bind {
    i[Bind[List]]
    i[Bind[ArraySeq]]
    i[Bind[java.util.ArrayList]]
  }

  def monoid {
    i[Monoid[List[Int]]]
    i[Monoid[Iterable[Int]]]
    i[Monoid[Seq[Int]]]
  }

  def zero {
    i[Zero[Map[Int, Int]]]
  }

  def monad[A, B, R, S, T, U, V, W, X] {
    i[Monad[List]]
    i[Monad[Stream]]
    i[Monad[NonEmptyList]]
    i[Monad[PartialApply1Of2[State, A]#Apply]]
    i[Monad[Function0]]
    i[Monad[PartialApply1Of2[Function1, R]#Apply]]
    i[Monad[PartialApply2Of3[Function2, R, S]#Apply]]
    i[Monad[PartialApply3Of4[Function3, R, S, T]#Apply]]
    i[Monad[PartialApply4Of5[Function4, R, S, T, U]#Apply]]
    i[Monad[PartialApply5Of6[Function5, R, S, T, U, V]#Apply]]
    i[Monad[PartialApply6Of7[Function6, R, S, T, U, V, W]#Apply]]
    i[Monad[PartialApply1Of2[Either.LeftProjection, X]#Flip]]
    i[Monad[PartialApply1Of2[Either.RightProjection, X]#Apply]]
    import java.util.Map.Entry    
    i[Monad[PartialApply1Of2[Entry, Int]#Apply]]
    i[Monad[PartialApply1Of2[Validation, X]#Apply]]
    i[Monad[PartialApply1Of2[FailProjection, X]#Flip]]
  }

  def functor {
    i[Functor[java.util.PriorityQueue]]
  }

  def pure {
    i[Pure[Iterable]]
    i[Pure[List]]
    i[Pure[Vector]]
  }

  def foldRight[A] {
    i[Foldable[Stream]]
    i[Foldable[List]]
    i[Foldable[Set]]
  }

  def equal {
    type A = Int
    type B = Int
    i[Equal[(A, B)]]
    i[Equal[Seq[A]]]
    i[Equal[List[A]]]
    i[Equal[ArraySeq[A]]]
    i[Equal[Stream[A]]]
    i[Equal[Map[A, B]]]
    i[Equal[collection.SortedMap[A, B]]]
    i[Equal[java.util.Map[A, B]]]
    i[Equal[java.util.List[A]]]
    i[Equal[java.lang.Iterable[A]]]
    i[Equal[IntMultiplication]]
  }

  def show {
    type A = Int
    type B = Int
    i[Show[(A, B)]]
    i[Show[Seq[A]]]
    i[Show[List[A]]]
    i[Show[ArraySeq[A]]]
    i[Show[Stream[A]]]
    i[Show[Map[A, B]]]
    i[Show[collection.SortedMap[A, B]]]
    i[Show[java.util.Map[A, B]]]
    i[Show[java.util.List[A]]]
    i[Show[java.lang.Iterable[A]]]
    i[Show[IntMultiplication]]
  }

  def partialApply {
    trait A
    trait B
    trait C
    trait D
    trait E
    trait F
    trait G

    trait T1[A]
    trait T2[A, B]
    trait T3[A, B, C]
    trait T4[A, B, C, D]
    trait T5[A, B, C, D, E]
    trait T6[A, B, C, D, E, F]
    trait T7[A, B, C, D, E, F, G]

    i[PartialApply1Of2[T2, A]#Apply[B] =:= T2[A, B]]
    i[PartialApply1Of2[T2, A]#Flip[B] =:= T2[B, A]]

    i[PartialApply2Of3[T3, A, B]#Apply[C] =:= T3[A, B, C]]
    i[PartialApply2Of3[T3, A, B]#ApplyA[C] =:= T3[C, A, B]]
    i[PartialApply2Of3[T3, A, B]#ApplyB[C] =:= T3[A, C, B]]

    i[PartialApply3Of4[T4, A, B, C]#Apply[D] =:= T4[A, B, C, D]]

    i[PartialApply4Of5[T5, A, B, C, D]#Apply[E] =:= T5[A, B, C, D, E]]

    i[PartialApply5Of6[T6, A, B, C, D, E]#Apply[F] =:= T6[A, B, C, D, E, F]]

    i[PartialApply6Of7[T7, A, B, C, D, E, F]#Apply[G] =:= T7[A, B, C, D, E, F, G]]
  }
  
  def strategy {
    i[concurrent.Strategy]
  }
}
