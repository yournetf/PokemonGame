import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        GameWindow gameWindow = new GameWindow();
        gameWindow.createWindow(1600, 900, "Choose Your Pokemon!");
    }
}