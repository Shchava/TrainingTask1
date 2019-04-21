package view;

import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "Messages";

    public ResourceBundle Messages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);

    public void print(String message){
        System.out.println(message);
    }
}
