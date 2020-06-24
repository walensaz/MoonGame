import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.Socket

object Application extends App {

  val socket: Socket = new Socket("0.0.0.0", Config.PORT)
  val writer: PrintWriter = new PrintWriter(socket.getOutputStream)
  val reader: BufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream))

}
