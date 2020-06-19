package scala.me.zach

import org.json.{JSONArray, JSONObject}

object Webpage {

  //val playersOnline: Vector[String]

  /*def getMessages(content: String): Unit = {
    val jsonObject = new JSONObject(content)
    val jsonArray = jsonObject.getJSONArray("updates")
    for (i <- 0 until jsonArray.length) {
      val currentObject = jsonArray.getJSONObject(i)
      val actionType = jsonArray.getJSONObject(i).getString("type")
      actionType match {
        case "playerquit" =>
      }
      if (actionType.equalsIgnoreCase("playerquit")) {
        val player = currentObject.getString("account")
        if (playersOnline.contains(player)) {
          playersOnline.remove(player)
          updatePlayers()
          createNewMessage(currentObject, player + " has left the server!")
        }
      }
      else if (actionType.equalsIgnoreCase("playerjoin")) {
        val player = currentObject.getString("account")
        if (!playersOnline.contains(player)) {
          playersOnline.add(player)
          updatePlayers()
          createNewMessage(currentObject, player + " has joined the server!")
        }
      }
      else if (actionType.equalsIgnoreCase("chat")) createNewMessage(currentObject, currentObject.getString("message"))
    }
  }*/

}
