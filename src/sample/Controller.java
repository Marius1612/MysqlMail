package sample;

import database.RegisterAndLogin;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Controller {
    public TextField registerUsernameTxt;
    public PasswordField registerPasswordTxt;
    public Button registerBtn;
    public TextField loginUsernameTxt;
    public PasswordField loginPasswordTxt;
    public TabPane tabPane;
    public Tab registerTab;
    public Tab loginTab;
    public Tab messagesTab;
    public Tab receivedTab;
    RegisterAndLogin registerAndLogin = new RegisterAndLogin();
    public void initialize() {
        tabPane.getTabs().remove(messagesTab);
        tabPane.getTabs().remove(receivedTab);
    }

    public void register() {
          registerAndLogin.register(registerUsernameTxt.getText(), registerPasswordTxt.getText());
    }
}
