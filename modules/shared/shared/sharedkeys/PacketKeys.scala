package sharedkeys

trait PacketKeys {

  object FromServer {
    val FailureConnectionOutBoundPacketKey = "connection.failure"
    val SuccessfulConnectionOutBoundPacketKey = "connection.success"
    val LoginOutBoundPacketKey = "login.server"
    val RegisterOutBoundPacketKey = "register.server"
  }

  object FromClient {
    val LoginOutBoundPacketKey = "login.client"
    val RegisterOutBoundPacketKey = "login.client"
  }

}
