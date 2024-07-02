package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BubbleSortVisualizer extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        SortingVisualizer visualizer = new SortingVisualizer();

        root.getChildren().add(visualizer);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Bubble Sort Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();

        visualizer.startSorting();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
