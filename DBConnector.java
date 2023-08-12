import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector{

    public int counter = 0;
    public Pokemon[] pokemons = new Pokemon[722];
    ArrayList<Pokemon> pokemonFiltered = new ArrayList<>();

    public DBConnector() throws SQLException {




        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon_db", "root", "Gabriella10");


        //Create statement
        Statement stmnt = con.createStatement();
        String s = "select * from pokemon";

        Statement stmnt2 = con.createStatement();
        String t = "select * from base_stats";



        //Execute statement
        ResultSet resultSet = stmnt.executeQuery(s);
        ResultSet resultSetStats = stmnt2.executeQuery(t);



        while(resultSet.next() && resultSetStats.next() && counter<722){

            String str = resultSet.getString("pok_name");
            String cap = str.substring(0, 1).toUpperCase() + str.substring(1);

            pokemons[counter] = new Pokemon(cap, resultSet.getInt("type1"), resultSet.getInt("type2"), (counter+1),
                    resultSetStats.getInt("b_hp"), resultSetStats.getInt("b_atk"), resultSetStats.getInt("b_def"),
                    resultSetStats.getInt("b_sp_atk"), resultSetStats.getInt("b_sp_def"), resultSetStats.getInt("b_speed")
                    );






            counter++;

        }

        //Close connection
        con.close();
        System.out.println("Query executed");



    }






}

