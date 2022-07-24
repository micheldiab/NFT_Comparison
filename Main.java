package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {

	@Override
	   public void start(Stage primaryStage) {
			
			try {

			    Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		        Scene scene1 = new Scene(root);
		        primaryStage.setTitle("HomePage");
		        primaryStage.setScene(scene1);
		        primaryStage.show();
	    	} catch (Exception e) {
			    e.printStackTrace();
		   }

		}

	
	public static void main(String[] args) {
		launch(args);

}
}
