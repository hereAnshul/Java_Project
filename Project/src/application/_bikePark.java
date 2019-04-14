package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import java.util.regex.Pattern;
public class _bikePark extends Application{
	String s, nm, np;
	TextField name;
	TextField num;
		@Override
		public void start(Stage primaryStage) {
			try {
				GridPane root = new GridPane();
				root.setId("pane");
				Label c = new Label();
				Label a = new Label();
				Label b = new Label();
				a.setTextFill(Color.RED);
				b.setTextFill(Color.RED);
				c.setTextFill(Color.RED);
				a.setFont(new Font(11));
				b.setFont(new Font(11));
				c.setFont(new Font(11));
				GridPane.setHalignment(c, HPos.CENTER);
				Button subbtn = new Button("Confirm Spot");
				subbtn.setOnAction(e -> {
					nm = name.getText();
					np = num.getText();
					String pattern = "[a-zA-Z][a-zA-Z][0-9][0-9][a-zA-Z][a-zA-Z][0-9][0-9][0-9][0-9]";
					boolean result = Pattern.matches(pattern,np);	
					System.out.println(nm);
					System.out.println(np);
					if(s!=null && nm!=null && np!=null) { 
						dbtest.update(s, "bike", nm, np);
						Thank th = new Thank();
						th.start(primaryStage);
					}
					if(nm==null) {
							a.setText("Add name.");					
					}if(np==null) {
							b.setText("Cant left blank");
					}if(s==null) {
							c.setText("Select one spot");
					}
					if(result == false) {
						c.setText("Invalid Format");
							}
				});
				GridPane.setHalignment(subbtn, HPos.CENTER);
				Button bckbtn = new Button("Back");
				bckbtn.setOnAction(e -> {
					Main mn = new Main();
					mn.start(primaryStage);
				});
				GridPane.setHalignment(bckbtn, HPos.CENTER);
				Button rstbtn = new Button("Reset Form");
				rstbtn.setOnAction(e -> {
				    //NOTHING IS HERE...
					name.setText("");
					num.setText("");
				});
				GridPane.setHalignment(rstbtn, HPos.CENTER);
				ToggleGroup group = new ToggleGroup();

				RadioButton rb1 = new RadioButton("B101");
				rb1.setUserData("B101");
				rb1.setToggleGroup(group);

				RadioButton rb2 = new RadioButton("B102");
				rb2.setUserData("B102");
				rb2.setToggleGroup(group);

				RadioButton rb3 = new RadioButton("B103");
				rb3.setUserData("B103");
				rb3.setToggleGroup(group);

				RadioButton rb4 = new RadioButton("B104");
				rb4.setUserData("B103");
				rb4.setToggleGroup(group);
				GridPane.setHalignment(rb4, HPos.CENTER);

				RadioButton rb5 = new RadioButton("B105");
				rb5.setUserData("B103");
				rb5.setToggleGroup(group);
				GridPane.setHalignment(rb5, HPos.CENTER);

				RadioButton rb6 = new RadioButton("B106");
				rb6.setUserData("B103");
				rb6.setToggleGroup(group);
				GridPane.setHalignment(rb6, HPos.CENTER);
				
				RadioButton rb7 = new RadioButton("B107");
				rb7.setUserData("B103");
				rb7.setToggleGroup(group);
				
				RadioButton rb8 = new RadioButton("B108");
				rb8.setUserData("B103");
				rb8.setToggleGroup(group);
				
				RadioButton rb9 = new RadioButton("B109");
				rb9.setUserData("B103");
				rb9.setToggleGroup(group);
				
				group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
		        { 
		            public void changed(ObservableValue<?extends Toggle> ob, Toggle o, Toggle n) 
		            { 
		                RadioButton rb = (RadioButton)group.getSelectedToggle(); 		  
		                if (rb != null) { 
		                    s = rb.getText();  
		                    System.out.println(s);
		                } 
		            } 
		        }); 
				
				Text nameLabel = new Text("Name: ");
				name = new TextField();
				Text numPlate = new Text("Number Plate: ");
				num = new TextField();
				
				Scene scene = new Scene(root, 800, 600);
				root.add(nameLabel, 0, 3);
				root.add(numPlate, 0, 4);
				root.add(name, 1, 3);
				root.add(num, 1, 4);
				root.add(rstbtn, 1, 5);
				root.add(rb1, 0, 6);
				root.add(rb2, 0, 7);
				root.add(rb3, 0, 8);
				root.add(rb4, 1, 6);
				root.add(rb5, 1, 7);
				root.add(rb6, 1, 8);
				root.add(rb7, 2, 6);
				root.add(rb8, 2, 7);
				root.add(rb9, 2, 8);
				root.add(subbtn, 1, 9);
				root.add(bckbtn, 1, 10);
				root.setHgap(10);
				root.setVgap(20);
				root.setAlignment(Pos.CENTER);
				
				Connection con=null;
				Statement stmt=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
					final String USER = "root";
					final String PASS = "";
					final String DB_URL = "jdbc:mysql://127.0.0.1:3306/javaproj";
					con = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM bspot");
					while(rs.next()) {	
						String slt = rs.getString(1);
						if(slt.equals("B101")) 
							rb1.setDisable(true);
						if(slt.equals("B102"))
							rb2.setDisable(true);
						if(slt.equals("B103"))
							rb3.setDisable(true);
						if(slt.equals("B104"))
							rb4.setDisable(true);
						if(slt.equals("B105"))
							rb5.setDisable(true);
						if(slt.equals("B106"))
							rb6.setDisable(true);
						if(slt.equals("B107"))
							rb7.setDisable(true);
						if(slt.equals("B108"))
							rb8.setDisable(true);
						if(slt.equals("B109"))
							rb9.setDisable(true);
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				scene.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Bike Parking Availability");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}
