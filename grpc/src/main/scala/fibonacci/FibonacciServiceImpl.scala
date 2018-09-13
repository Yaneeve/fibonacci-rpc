package fibonacci

import akka.NotUsed
import akka.stream.Materializer
import akka.stream.scaladsl.Source
import fibonacci.grpc._

class FibonacciServiceImpl (materializer: Materializer) extends  FibonacciService {

  import materializer.executionContext
  private implicit val mat: Materializer = materializer

  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  override def streamFibonacci(in: FibRequest): Source[FibReply, NotUsed] = {
    val value: Source[Int, NotUsed] = Source.fromIterator({ () => fibs.toIterator })
    value.map(FibReply(_))
  }
}
