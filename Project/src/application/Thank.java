package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Thank extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();
			root.setId("pane");
			Button btn = new Button("Home");
			btn.setOnAction(e -> {
			    //NOTHING IS HERE...
				Main mn = new Main();
				mn.start(primaryStage);
			});
			Scene scene = new Scene(root,800,600);
			Text label = new Text("THANK YOU");
			Text label1 = new Text("DO VISIT AGAIN");
			ObservableList<Node> list = root.getChildren();
			list.addAll(label, label1, btn);
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
