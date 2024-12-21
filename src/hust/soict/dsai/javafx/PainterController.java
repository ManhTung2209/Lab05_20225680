package hust.soict.dsai.javafx;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PainterController {  

	@FXML  
	private Pane drawingAreaPane;  

	@FXML  
	void clearButtonPressed(ActionEvent event) {  
		drawingAreaPane.getChildren().clear();
	}  


	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
	    Circle newCircle = new Circle(event.getX(),
	            event.getY(), 4, Color.BLACK);
	    drawingAreaPane.getChildren().add(newCircle);
	    {
	    }
