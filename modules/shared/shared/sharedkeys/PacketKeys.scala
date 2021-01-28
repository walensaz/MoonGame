package sharedkeys

trait PacketKeys {

  object FromServer {
    val UpdateMapPacketKey = "update.map.server"

    val FailureConnectionPacketKey = "connection.failure"
    val SuccessfulConnectionPacketKey = "connection.success"
    val LoginPacketKey = "login.server"
    val RegisterPacketKey = "register.server"
    val PlayerInfoPacketKey = "player.info.server"
  }

  object FromClient {
    val LoginPacketKey = "login.client"
    val RegisterPacketKey = "login.client"
    val PlayerInfoPacketKey = "player.info.client"
  }

}
