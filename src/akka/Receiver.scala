//edited: 12/03/2018
package akka

import akka.actor.Actor
import akka.actor.Actor.Receive
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

// create an object based on the Receiver Class and run it straight away
object Receiver {

  def main(args: Array[String]): Unit = {

    // load receiver.conf
    val system = ActorSystem("Sys", ConfigFactory.load("receiver"))

    // add this actor to Props
    system.actorOf(Props[Receiver], "rcv")

  } // end of main method

} // end of Receiver object

class Receiver extends Actor {

  import Sender._
  var numOfMsg = 0

  def receive = {

    // sender() => Actor that sent this latest message
    case m: Echo =>
      sender ! m
      // make message a string
      val message = self ! m.toString()

    // print message
    case message: String =>
      println(s"Message received: $message")
      // increment counter
      numOfMsg += 1

    // shutdown the ActorSystem
    case Shutdown =>
      context.system.shutdown()
      // print number of messages received
      println(s"Number of messages received: $numOfMsg")
    // anything else, do nothing
    case _ =>

  } // end of receive

} // end of Receiver class