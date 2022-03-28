package code_formes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueForme {
	private Scene scene = null;
	private BorderPane root = null;
	
	public VueForme() {
		root = new BorderPane();
		root.setId("root");
		scene = new Scene(root, 725, 520);
		
		root.setBottom(getBottom());
		root.setRight(getRight());
		root.setCenter(getCenter());
		
		scene.getStylesheets().setAll(this.getClass().getResource("/style/style_forme.css").toString());
	}
	
	public Scene getScene() {
		return scene;
	}
	
	private Node getBottom() {
		HBox hbox = new HBox();
		Button generer = new Button("G�n�rer");
		generer.setId("generer");
		Button reinitialiser = new Button("R�initialiser");
		reinitialiser.setId("reinitialiser");
		Button quitter = new Button("Quitter");
		quitter.setId("quitter");
		
		hbox.getChildren().addAll(generer, reinitialiser, quitter);
		HBox.setMargin(generer, new Insets(20, 0, 20, 0));
		HBox.setMargin(reinitialiser, new Insets(20, 0, 20, 0));
		HBox.setMargin(quitter, new Insets(20, 0, 20, 0));
		
		return hbox;
	}
	
	private Node getRight() {
		VBox rootVbox = new VBox(10);
		rootVbox.setId("option");
		
		// Conteneur1
		VBox forme = new VBox();
		Label labelForme = new Label("Formes");
		ListView<String> listeForme = new ListView<String>();

		ObservableList<String> obsFormes = FXCollections.observableArrayList("Ovale", "Ligne", "Rectangle", "Triangle");
		listeForme.setItems(obsFormes);
		listeForme.setMaxWidth(140);
		listeForme.setMaxHeight(125);
		
		forme.getChildren().addAll(labelForme, listeForme);
		
		
		// Conteneur2
		VBox couleur = new VBox();
		Label labelCouleur = new Label("Couleur");
		ColorPicker cp = new ColorPicker(Color.ORANGE);
		
		couleur.getChildren().addAll(labelCouleur, cp);
		
		
		// Conteneur3
		VBox effet = new VBox();
		Label labelEffet = new Label("Effet");
		CheckBox checkEffet = new CheckBox();
		
		effet.getChildren().addAll(labelEffet, checkEffet);
		
		// Conteneur4
		HBox position = new HBox();
		VBox posX = construireTextLabel("Position x", "10", false);
		VBox posY = construireTextLabel("Position y", "10", false);
		
		HBox.setMargin(posX, new Insets(0, 10, 0, 10));
		HBox.setMargin(posY, new Insets(0, 10, 0, 20));
		
		position.getChildren().addAll(posX, posY);
		
		
		// Conteneur5
		HBox dimension = new HBox();
		VBox largeur = construireTextLabel("Largeur", "0", true);
		VBox hauteur = construireTextLabel("Hauteur", "0", true);
		VBox cote = construireTextLabel("C�t� C", "0", true);
		
		HBox.setMargin(largeur, new Insets(0, 8, 0, 0));
		HBox.setMargin(hauteur, new Insets(0, 8, 0, 0));
		
		dimension.getChildren().addAll(largeur, hauteur, cote);
		
		
		// Conteneur6
		VBox opacite = new VBox();
		Label labelOpa = new Label("Opacit�");
		Slider slider = new Slider(0, 90, 100);
		slider.setMaxWidth(145);
		
		opacite.getChildren().addAll(labelOpa, slider);
		
		// Ajout rootVbox
		rootVbox.getChildren().addAll(forme, couleur, effet, position, dimension, opacite);
		BorderPane.setMargin(rootVbox, new Insets(0, 0, 0, 20));
		
		return rootVbox;
	}
	
	private Node getCenter() {
		Pane pane = new Pane();
		
		Circle cercle = new Circle();
		
		cercle.setCenterX(200);
		cercle.setCenterY(200);
		cercle.setRadius(100);
		cercle.setFill(Color.RED);
		
		pane.getChildren().add(cercle);
		pane.setId("panel");
		
		return pane;
	}
	
	private VBox construireTextLabel(String nom, String chiffre, boolean disable) {
		VBox vbox = new VBox();
		
		Label label = new Label(nom);
		TextField text = new TextField(chiffre);
		text.setMaxWidth(40);
		text.setDisable(disable);
		vbox.getChildren().addAll(label, text);
		
		return vbox;
	}
}
