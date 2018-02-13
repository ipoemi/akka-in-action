package ipoemi.aia.chapter02

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.testkit.{DefaultTimeout, ImplicitSender, TestKit}
import ipoemi.aia.chapter02.BoxOffice._
import ipoemi.aia.chapter02.TicketSeller._
import org.scalatest.{MustMatchers, WordSpecLike}

class WorksheetTest extends TestKit(ActorSystem("worksheetTest"))
  with WordSpecLike
  with MustMatchers
  with ImplicitSender
  with DefaultTimeout
  with StopSystemAfterAll
{
  object EchoActor {
    def props = Props(new EchoActor)

    case class Msg(msg: String)
  }

  class EchoActor extends Actor {
    import EchoActor._

    def receive: Receive = {
      case Msg(msg) =>
        sender() ! Msg(msg)
    }
  }

  "Test" must {

    "run" in {

      /*
      val boxOffice = system.actorOf(BoxOffice.props)
      val eventName = "RHCP"
      boxOffice ! CreateEvent(eventName, 10)
      expectMsg(EventCreated(Event(eventName, 10)))

      boxOffice ! GetEvents
      expectMsg(Events(Vector(Event(eventName, 10))))

      boxOffice ! BoxOffice.GetEvent(eventName)
      expectMsg(Some(Event(eventName, 10)))

      boxOffice ! GetTickets(eventName, 1)
      expectMsg(Tickets(eventName, Vector(Ticket(1))))

      boxOffice ! GetTickets("DavidBowie", 1)
      expectMsg(Tickets("DavidBowie"))
      */
      val echoActor = system.actorOf(EchoActor.props)
      echoActor ! EchoActor.Msg("test111")
      expectMsg(EchoActor.Msg("test111"))
    }

  }

}
