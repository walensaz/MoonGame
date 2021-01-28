package scenes

import event.OnCloseEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.{AnchorPane, Pane}
import javafx.stage.{Stage, WindowEvent}

object SceneController {

  var currentScene: Scene = _
  var stage: Stage = _

  def onAppStartup(stage: Stage): Unit = {
    this.stage = stage
    val root = new Pane
    currentScene = new Scene(root, 1200, 800)
    stage.setScene(currentScene)
    stage.setOnCloseRequest((event: WindowEvent) => new OnCloseEvent(event))
    stage.show()
    changeToLoginScene()
  }

  def changeToLoginScene(): Unit = {
      val root: AnchorPane = FXMLLoader.load(getClass.getResource("login.fxml"))
      stage.setTitle("Login")
      currentScene = new Scene(root, 1200, 800)
      stage.setScene(currentScene)
      stage.show()
  }

  def getCurrentScene = currentScene
}
