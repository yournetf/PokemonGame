import javax.swing.*;

public class noMatchesFoundException extends Exception{
    public noMatchesFoundException(){
        JOptionPane.showMessageDialog(null, "No such pokemon found !");
    }
}
