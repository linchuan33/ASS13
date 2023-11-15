import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label inputLabel = new Label("Enter Value:");
        GridPane.setConstraints(inputLabel, 0, 0);

        TextField inputValue = new TextField();
        GridPane.setConstraints(inputValue, 1, 0);

        Label unitLabel = new Label("Select Unit:");
        GridPane.setConstraints(unitLabel, 0, 1);

        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Kilometers", "Miles");
        unitComboBox.setValue("Kilometers"); // Set default value
        GridPane.setConstraints(unitComboBox, 1, 1);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 1, 2);
        convertButton.setOnAction(e -> {
            // Implement your conversion logic here
            String inputValueStr = inputValue.getText();
            double input = Double.parseDouble(inputValueStr);
            String selectedUnit = unitComboBox.getValue();

            // Perform conversion based on selected unit
            double result = (selectedUnit.equals("Kilometers")) ? convertToMiles(input) : convertToKilometers(input);

            // Display the result (you might want to use labels or another TextField)
            System.out.println("Converted Value: " + result);
        });

        grid.getChildren().addAll(inputLabel, inputValue, unitLabel, unitComboBox, convertButton);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Implement conversion methods based on your needs
    private double convertToMiles(double kilometers) {
        return kilometers / 1.60934;
    }

    private double convertToKilometers(double miles) {
        return miles * 1.60934;
    }
}
