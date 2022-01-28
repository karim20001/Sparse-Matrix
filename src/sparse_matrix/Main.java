package sparse_matrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("view/SparseMatrix.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Sparse Matrix");
        stage.setMinWidth(600);
        stage.setMinHeight(520);
        stage.setMaximized(true);
        stage.show();
    }

}
