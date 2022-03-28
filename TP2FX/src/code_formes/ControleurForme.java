package code_formes;

import javafx.application.Application;
import javafx.stage.Stage;

public class ControleurForme extends Application{
	private VueForme vue;
	
	@Override
	public void start(Stage stage) throws Exception {
		vue = new VueForme();
		
		stage.setTitle("Dessin de formes");
		
		stage.setScene(vue.getScene());
		
		stage.sizeToScene();
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
