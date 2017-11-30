package login;

import java.io.IOException;
import java.util.logging.*;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/** Manages control flow for logins */
public class LoginManager {
    private Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void authenticated() {
        showMain();
    }

    public void noAuthenticated(String sessionID) {
        showErrorView(sessionID);
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the login application screen.
     */
    @FXML
    public void logout() {
        showLoginScreen();
    }

    @FXML
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            scene.setRoot(loader.load());
            LoginController controller =
                    loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showMain() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("CupTableTSD");
            primaryStage.setScene(new Scene(root, 1280, 800));
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showErrorView(String sessionID) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("errorview.fxml")
            );
            scene.setRoot((Parent) loader.load());
            MainViewController controller =
                    loader.getController();
            controller.initSessionID(this, sessionID);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}