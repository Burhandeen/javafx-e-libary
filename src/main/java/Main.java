import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        // Top Navbar
        HBox navbar = new HBox(20);
        navbar.setPadding(new Insets(10));
        Label brand = new Label("OpenShelf");
        brand.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Button browseBtn = new Button("Browse");
        Button uploadBtn = new Button("Upload");
        Button myBooksBtn = new Button("My books");
        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        navbar.getChildren().addAll(brand, spacer, browseBtn, uploadBtn, myBooksBtn, signUpBtn);

        // Header
        HBox header = new HBox(10);
        header.setPadding(new Insets(20, 20, 10, 20));
        header.setAlignment(Pos.CENTER_LEFT);
        Label bookIcon = new Label("📖");
        bookIcon.setFont(Font.font(40));
        VBox titleBox = new VBox();
        Label title = new Label("Browse books");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        Label subtitle = new Label("Discover books by category and make reading a habit!");
        subtitle.setStyle("-fx-text-fill: gray;");
        titleBox.getChildren().addAll(title, subtitle);
        header.getChildren().addAll(bookIcon, titleBox);

        // Search bar
        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        searchField.setMaxWidth(600);
        searchField.setPrefHeight(35);

        HBox searchBox = new HBox(searchField);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setPadding(new Insets(10));

        // Category cards
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);

        String[][] categories = {
                {"🎨", "Arts", "50 books"},
                {"📚", "Humanities", "200 books"},
                {"🧪", "Science", "500 books"},
                {"💖", "Health", "200 books"},
                {"🧠", "Psychology", "200 books"},
                {"⏳", "History", "200 books"},
                {"🔬", "STEM", "200 books"}
        };

        int row = 0, col = 0;
        for (String[] cat : categories) {
            VBox card = new VBox(5);
            card.setAlignment(Pos.CENTER_LEFT);
            card.setPadding(new Insets(15));
            card.setPrefSize(160, 80);
            card.setStyle("-fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10; -fx-effect: dropshadow(gaussian, lightgray, 5, 0, 0, 2);");

            Label icon = new Label(cat[0]);
            icon.setFont(Font.font(20));
            Label name = new Label(cat[1]);
            name.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            Label count = new Label(cat[2]);
            count.setTextFill(Color.GRAY);

            card.getChildren().addAll(icon, name, count);
            grid.add(card, col, row);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        // Layout
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #fafafa, #f9f0e1);");
        layout.getChildren().addAll(navbar, header, searchBox, grid);

        Scene scene = new Scene(layout, 800, 1000);
        primaryStage.setTitle("OpenShelf - Browse Books");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
