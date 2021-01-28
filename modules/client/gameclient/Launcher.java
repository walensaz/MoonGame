import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.SceneController;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        SceneController.onAppStartup(stage);
    }

    public static void main(String[] args) {
        ScalaApplication.run();
        launch(args);
    }
}
