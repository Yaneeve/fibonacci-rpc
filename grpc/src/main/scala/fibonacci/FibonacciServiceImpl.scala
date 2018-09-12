package fibonacci

import akka.NotUsed
import akka.stream.Materializer
import akka.stream.scaladsl.Source
import fibonacci.grpc._

class FibonacciServiceImpl (materializer: Materializer) extends  FibonacciService {

  import materializer.executionContext
  private implicit val mat: Materializer = materializer

  override def streamFibonacci(in: FibRequest): Source[FibReply, NotUsed] = ???
}
