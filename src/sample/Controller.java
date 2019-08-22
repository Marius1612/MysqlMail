package sample;

import database.RegisterAndLogin;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import utility.GetAllItems;

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
    public Button loginBtn;
    public Label usernameLoginLbl;
    public Label passwordLoginLbl;
    public Button sendBtn;
    public ComboBox<String> messagesComboBox;
    public TextArea textAreaMessages;
    public ComboBox receivedComboBox;
    public TextArea textAreaReceived;
    private RegisterAndLogin registerAndLogin = new RegisterAndLogin();

    public void initialize() {
        tabPane.getTabs().remove(messagesTab);
        tabPane.getTabs().remove(receivedTab);
    }

    public void register() {
          registerAndLogin.register(registerUsernameTxt.getText(), registerPasswordTxt.getText());
    }

    public void loginAction() {
        if(registerAndLogin.LogIn(loginUsernameTxt.getText(), loginPasswordTxt.getText())) {
            tabPane.getTabs().add(messagesTab);
            tabPane.getSelectionModel().select(messagesTab);
            tabPane.getTabs().add(receivedTab);

            tabPane.getTabs().remove(loginTab);
            tabPane.getTabs().remove(registerTab);

            GetAllItems getAllItems = new GetAllItems();
            messagesComboBox.getItems().addAll(getAllItems.getItems());
        }
        else {
            usernameLoginLbl.setTextFill(Color.RED);
            passwordLoginLbl.setTextFill(Color.RED);
        }
    }

    public void sendMessqge() {
    }
}