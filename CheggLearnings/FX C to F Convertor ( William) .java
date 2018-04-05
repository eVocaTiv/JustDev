import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
	TextField celsiusFld , fFld;
	int fahrenheitTemp, celsiusTemp;
	EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			
			
				{
					
					String fahrenheitresult="-1";
					String text = celsiusFld.getText();
					celsiusTemp = Integer.parseInt (text);
					System.out.println(celsiusTemp);
					
					fahrenheitTemp = (9*celsiusTemp)/5 + 32;
					System.out.println(fahrenheitTemp);
					fahrenheitresult = Integer.toString(fahrenheitTemp);
				    fFld.setText(fahrenheitresult);
				
			}
			// TODO Auto-generated method stub
			
		}
	};
	Label messageLbl = new Label("Enter the temperature in Celsius");
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	public void start(Stage stage)
	{
		celsiusFld = new TextField();
		fFld = new TextField();
		
		celsiusFld.setPrefColumnCount(15);
		fFld.setPrefColumnCount(15);
		
		
		
		
		Button convertBtn = new Button("_Convert");
		convertBtn.setVisible(true);
		convertBtn.setDefaultButton(true);
		convertBtn.setOnAction(eh);
		
		
		GridPane root = new GridPane();
		root.addRow(3 , convertBtn);
		root.setHgap(10);
		root.setVgap(5);
		root.addRow(0, messageLbl);
		root.addRow(1, new Label("Temperature in Celsius"), celsiusFld);
		//Node fT = new 
		root.addRow(2, new Label("Temperature in Fahrenheit"), fFld);
		
		root.setMinSize(350, 250);
		
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Celsius Converter");
		stage.show();
		
	}





}
