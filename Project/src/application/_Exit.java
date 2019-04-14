package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class _Exit extends Application {
	String s, t, np;
	TextField spotCode;
	TextField num;
	Text cost = new Text(null);
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setId("pane");
			ChoiceBox<String> type = new ChoiceBox<String>();
			Button extbtn = new Button("Generate");
			extbtn.setOnAction(e -> {
				s = spotCode.getText();
				t = type.getValue();
				np = num.getText();
			    //NOTHING IS HERE...
				long f = dbtest.update(s, t, np);
				String fa = Long.toString(f*10);
				cost.setText("Your Bill: "+fa);
			});
			Button py = new Button("Payment Successful");
			py.setOnAction(e ->{
				Main mn = new Main();
				mn.start(primaryStage);
			});
			
			Text spotLabel = new Text("SpotCode: ");
			//Takes name of person
			spotCode = new TextField(null);
			Text numPlate = new Text("Number Plate: ");
			//Takes  number plate
			//Add Pattern matching here....
			num = new TextField(null);
			Text vtype = new Text("Select type: ");
			type.getItems().addAll("car", "bike");
			Scene scene = new Scene(root,800,600);
			root.add(extbtn, 1, 7);
			GridPane.setHalignment(extbtn, HPos.CENTER);
			root.add(spotLabel, 0, 3);
			root.add(spotCode, 1, 3);
			root.add(numPlate, 0, 5);
			root.add(num, 1, 5);
			root.add(vtype, 0, 6);
			root.add(type, 1, 6);
			GridPane.setHalignment(type, HPos.CENTER);
			root.add(cost, 1, 8);
			root.add(py, 1, 10);
			GridPane.setHalignment(py, HPos.CENTER);
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
