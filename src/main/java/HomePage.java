
    import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

    public class HomePage extends Application {

        @Override
        public void start(Stage stage) {
            // Header (Navbar)
            HBox navbar = new HBox(40);
            navbar.setPadding(new Insets(20, 40, 20, 40));
            navbar.setStyle("-fx-background-color: transparent;");
            Label logo = new Label("OpenShelf");
            logo.setFont(Font.font("Arial", 18));
            logo.setStyle("-fx-font-weight: bold;");
            HBox navItems = new HBox(20);
            navItems.getChildren().addAll(new Label("Browse"), new Label("Upload"), new Label("My books"));
            Button signUpBtn = new Button("Sign Up");
            signUpBtn.setStyle("-fx-background-color: black; -fx-text-fill: white;");
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            navbar.getChildren().addAll(logo, spacer, navItems, signUpBtn);

            // Hero Section
            VBox hero = new VBox(15);
            hero.setPadding(new Insets(40));
            hero.setAlignment(Pos.CENTER);
            hero.setStyle("-fx-background-color: linear-gradient(to bottom right, #e8d3af, #f5f5f5);");

            TextField search = new TextField();
            search.setPromptText("Search");
            search.setMaxWidth(500);
            search.setStyle("-fx-background-radius: 8; -fx-padding: 10;");

            Label headline = new Label("Get Access To A World Of Free Books");
            headline.setFont(Font.font("Arial", 28));
            headline.setStyle("-fx-font-weight: bold;");
            headline.setWrapText(true);
            headline.setAlignment(Pos.CENTER);

            Label subtext = new Label("Browse and read a wide range of textbooks and educational materials for free!");
            subtext.setFont(Font.font("Arial", 14));
            subtext.setTextFill(Color.GRAY);
            subtext.setWrapText(true);
            subtext.setAlignment(Pos.CENTER);

            Button browseBtn = new Button("Browse books");
            browseBtn.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-border-color: #9B5DE5; -fx-border-width: 2;");
            hero.getChildren().addAll(search, headline, subtext, browseBtn);

            // Carousel (mock layout)
            HBox carousel = new HBox(30);
            carousel.setAlignment(Pos.CENTER);
            carousel.setPadding(new Insets(30));
            for (int i = 0; i < 3; i++) {
                Region card = new Region();
                card.setPrefSize(150 + i * 20, 200);
                card.setStyle("-fx-background-color: #efe1c5; -fx-background-radius: 10;");
                carousel.getChildren().add(card);
            }

            // Carousel indicators
            HBox indicators = new HBox(5);
            indicators.setAlignment(Pos.CENTER);
            for (int i = 0; i < 3; i++) {
                Region dot = new Region();
                dot.setPrefSize(8, 8);
                dot.setStyle("-fx-background-color: " + (i == 0 ? "#333" : "#ccc") + "; -fx-background-radius: 5;");
                indicators.getChildren().add(dot);
            }

            VBox carouselWrapper = new VBox(carousel, indicators);
            carouselWrapper.setAlignment(Pos.CENTER);

            // Popular Read Section
            Label popularTitle = new Label("Popular Read");
            popularTitle.setFont(Font.font("Arial", 20));
            popularTitle.setStyle("-fx-font-weight: bold;");
            Separator separator = new Separator();
            separator.setStyle("-fx-background-color: #e0cfa7;");
            VBox popularSection = new VBox(10, popularTitle, separator);
            popularSection.setPadding(new Insets(20, 40, 10, 40));

            GridPane bookGrid = new GridPane();
            bookGrid.setPadding(new Insets(20));
            bookGrid.setHgap(30);
            bookGrid.setVgap(30);
            bookGrid.setAlignment(Pos.CENTER);

            for (int i = 0; i < 4; i++) {
                VBox card = new VBox();
                Region image = new Region();
                image.setPrefSize(200, 120);
                image.setStyle("-fx-background-color: #e9d9ba; -fx-background-radius: 8;");
                Region textBox = new Region();
                textBox.setPrefSize(200, 80);
                textBox.setStyle("-fx-background-color: #f6f6f6; -fx-background-radius: 0 0 8 8;");
                card.getChildren().addAll(image, textBox);
                bookGrid.add(card, i % 2, i / 2);
            }

            // Book Grid Indicators
            HBox bookIndicators = new HBox(5);
            bookIndicators.setAlignment(Pos.CENTER);
            for (int i = 0; i < 3; i++) {
                Region dot = new Region();
                dot.setPrefSize(8, 8);
                dot.setStyle("-fx-background-color: " + (i == 0 ? "#333" : "#ccc") + "; -fx-background-radius: 5;");
                bookIndicators.getChildren().add(dot);
            }

            // Final Layout
            VBox layout = new VBox(navbar, hero, carouselWrapper, popularSection, bookGrid, bookIndicators);
            ScrollPane scrollPane = new ScrollPane(layout);
            scrollPane.setFitToWidth(true);
            scrollPane.setStyle("-fx-background: white;");

            Scene scene = new Scene(scrollPane, 900, 1200);
            stage.setTitle("OpenShelf");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

