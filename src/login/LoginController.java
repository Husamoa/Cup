package login;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.*;
import javafx.scene.control.*;

public class LoginController {

    @FXML private TextField user;
    @FXML private TextField password;
    @FXML private Button loginButton;

    public void initialize() {}

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                String sessionID = authorize();
                if (sessionID != null) {
                    loginManager.authenticated();
                } else {
                    loginManager.noAuthenticated(sessionID);
                }
            }
        });
    }

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session
     * otherwise, return null.
     */
    private String authorize() {
        if (!"pawel".equals(user.getText()) || !"pawel".equals(password.getText())) return
                null;
        else return
                generateSessionID();
    }

    private static int sessionID = 0;

    private String generateSessionID() {
        sessionID++;
        return "Witaj " + sessionID;
    }


}
