package model;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by husama on 15.11.2017.
 */
public class FormValidation {

    public static boolean textFieldNotEpmty (TextField i) {
        boolean r = false;

        if (i.getText() != null && !i.getText().isEmpty()) {
            r = true;
        }
        return r;
    }

    public static boolean textFieldNotEpmty (TextField i, Label l, String sValidationText) {
        boolean r = true;
        String c = null;

        if (!textFieldNotEpmty(i)) {
            r = false;
            c = sValidationText;
        }
        l.setText(c);
        return r;

    }
}
