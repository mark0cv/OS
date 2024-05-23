package operatingSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application {
    private TextArea top;
    private TextField bottom;
    private Button close;
    private Button minimize;
    private Button maximize;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        close = new Button("X");
        close.setPrefSize(5, 5);
        minimize = new Button("_");
        minimize.setPrefSize(5, 5);
        maximize = new Button("❐");

        HBox buttons = new HBox(5);
        buttons.setAlignment(Pos.TOP_RIGHT);
        buttons.getChildren().addAll(minimize, maximize, close);

        // Tekstualno polje za prikaz poruka
        top = new TextArea();
        top.setMinSize(900, 450);
        top.setEditable(false);
        top.setText("Welcome to the OS emulator!\n");

        // Tekstualno polje za unos komandi
        bottom = new TextField();
        bottom.setMinSize(900, 62);

        VBox root = new VBox(15);
        root.setPadding(new Insets(10, 30, 30, 30));
        root.getChildren().setAll(buttons, top, bottom);
        VBox.setVgrow(top, Priority.ALWAYS);

        // Kreiranje scene i podešavanje stage-a
        Scene scene = new Scene(root, 1200, 700);
        scene.getStylesheets().add("application.css");

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        bottom.requestFocus();
    }
}
