import java.sql.*;
import java.util.ArrayList;

public class MoveLoader {

    public ArrayList<Move> moveList = new ArrayList<Move>();
    public Move[] movesReturned = new Move[4];

    public MoveLoader(int type1, int type2) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon_db", "root", "Gabriella10");


        Statement stmnt3 = con.createStatement();
        String u = "select * from moves";

        ResultSet resultSetMoves = stmnt3.executeQuery(u);


        while (resultSetMoves.next()){
                if (   (resultSetMoves.getInt("type_id") == type1 || (resultSetMoves.getInt("type_id") == type2)) && resultSetMoves.getInt("move_power") != 0){
                    moveList.add(new Move(resultSetMoves.getString("move_name"), resultSetMoves.getInt("type_id"), resultSetMoves.getInt("move_power"), resultSetMoves.getInt("move_accuracy")));
                }
        }

    }

    public Move[] returnMoves(){
        for (int i=0; i<4;i++){
            int random_int = (int)Math.floor(Math.random() * (moveList.size()-1 - 0 + 1) + 0);
            movesReturned[i] = moveList.get(random_int);
        }
        return movesReturned;
    }
}
