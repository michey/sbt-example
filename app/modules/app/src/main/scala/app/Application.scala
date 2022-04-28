package app

import iface.experimentation_service.Message

object Application {
  def main(args: Array[String]): Unit = {
    val query = Message("first_field")
    System.out.println(query.toString)
  }
}