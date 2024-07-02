package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class SortingVisualizer extends Canvas {
    private final int[] array;
    private final GraphicsContext gc;
    private final int width = 800;
    private final int height = 600;
    private final int barWidth = 5;

    public SortingVisualizer() {
        super(800, 600);
        this.array = generateRandomArray(width / barWidth);
        this.gc = this.getGraphicsContext2D();
        drawArray();
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * height);
        }
        return arr;
    }

    public void startSorting() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(50), event -> {
            if (!bubbleSortStep()) {
                timeline.stop();
            }
            drawArray();
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private boolean bubbleSortStep() {
        boolean swapped = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = true;
            }
        }
        return swapped;
    }

    private void drawArray() {
        gc.clearRect(0, 0, width, height);
        for (int i = 0; i < array.length; i++) {
            gc.setFill(Color.GREEN);
            gc.fillRect(i * barWidth, height - array[i], barWidth, array[i]);
        }
    }
}
