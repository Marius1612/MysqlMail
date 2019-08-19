package database;

public class RegisterAndLogin {
    AddDataInDatabase addData = new AddDataInDatabase();

    public void register(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            addData.addData(username, password);
        }
    }
}
