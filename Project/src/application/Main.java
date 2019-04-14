package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setId("pane");
			Button car_btn = new Button("4-Wheeler");
			car_btn.setOnAction(e -> {
			    //NOTHING IS HERE...
				_carPark cp = new _carPark();
				cp.start(primaryStage);
			});
			Button bike_btn = new Button("2-Wheeler");
			bike_btn.setOnAction(e -> {
			    //NOTHING IS HERE...
				_bikePark bp = new _bikePark();
				bp.start(primaryStage);
			});
			Button extbtn = new Button("Parking Exit");
			extbtn.setOnAction(e ->{
				_Exit ext = new _Exit();
				ext.start(primaryStage);
			});
			Scene scene = new Scene(root,800,600);
			root.addRow(0, car_btn);
			root.addRow(1, bike_btn);
			root.addRow(5, extbtn);
			root.setHgap(10);
			root.setVgap(20);
			root.setAlignment(Pos.CENTER);
			scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Parking Manager");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
