package sharedkeys

trait PacketKeys {

  object FromServer {
    val FailureConnectionPacketKey = "connection.failure"
    val SuccessfulConnectionPacketKey = "connection.success"
    val LoginPacketKey = "login.server"
    val RegisterPacketKey = "register.server"
  }

  object FromClient {
    val LoginPacketKey = "login.client"
    val RegisterPacketKey = "login.client"
  }

}
