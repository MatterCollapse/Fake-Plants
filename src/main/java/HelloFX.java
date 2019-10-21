import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        // Create the Components
        Text output = new Text("Plant Descriptions will appear in this box");
        Button createPlant = new Button("New");

        // Create the Pane
        HBox buttons = new HBox();
        BorderPane root = new BorderPane();

        // Add the Components to the VBox
        root.setTop(buttons);
        buttons.getChildren().addAll(createPlant, output);

        // Event Handlers
        createPlant.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                createPlantDialog(() -> {
                    output.setText("");
                }).show();
            }
        });

        // Set the Size of the Pane
        root.setMinSize(350, 250);

        // Create the Scene
        Scene scene = new Scene(root);

        // Set the Properties of the Stage
        stage.setX(100);
        stage.setY(200);
        stage.setMinHeight(300);
        stage.setMinWidth(400);

        // Add the scene to the Stage
        stage.setScene(scene);

        // Set the title of the Stage
        stage.setTitle("Plant Generator");

        // Display the Stage
        stage.show();
    }

    public static Stage createPlantDialog(Runnable onSuccessCallback) {
        final Stage creator = new Stage();
        creator.setTitle("New Plant Array");

        CheckBox subSpecies = new CheckBox("Include Subspecies");
        Slider plantQuantity = new Slider(1, 100, 20);
        plantQuantity.setShowTickLabels(true);
        plantQuantity.setShowTickMarks(true);
        Slider subPercentage = new Slider(0, 500, 0);
        subPercentage.setShowTickLabels(true);
        subPercentage.setShowTickMarks(true);
        subPercentage.setDisable(true);
        subPercentage.setVisible(false);
        Button confirmCreation = new Button("Confirm");
        Button cancelCreation = new Button("Cancel");
        Text warning = new Text("!This Will Erase All Previous Data!");

        BorderPane popupPane = new BorderPane();
        VBox popupSettings = new VBox();
        HBox popupResult = new HBox(2);

        popupPane.setTop(warning);
        popupPane.setBottom(popupResult);
        popupPane.setCenter(popupSettings);
        popupSettings.getChildren().addAll(subSpecies, plantQuantity, subPercentage);
        popupResult.getChildren().addAll(confirmCreation, cancelCreation);

        subSpecies.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                if (subPercentage.isDisable()) {
                    subPercentage.setDisable(false);
                    subPercentage.setVisible(true);
                } else {
                    subPercentage.setDisable(true);
                    subPercentage.setVisible(false);
                }
            }
        });
        confirmCreation.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                creator.hide();
                if (null != onSuccessCallback)
                    onSuccessCallback.run();
                // TODO: Call a method arrayNewPlants(plantQuantity.value(),
                // subPercentage.value()); It will take the subpercentage of plantquantity and
                // create appropriate amounts of plants and subplants
            }
        });
        cancelCreation.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                creator.hide();
            }
        });

        // Set up a scene
        Scene popup = new Scene(popupPane);
        creator.setScene(popup);
        return creator;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
