package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
            FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("MyScene1.fxml"));
	        AnchorPane root = (AnchorPane) loader.load();
	        MyController1 myScene1Controller = loader.getController();
			Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
			primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
