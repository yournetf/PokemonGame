import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class OpponentSelectionScreen{

    public Pokemon[] selectedPokemon = new Pokemon[1];

    int counter = 0;
    int imageCounter = counter + 10001;
    ArrayList<Pokemon> pokemonFiltered = new ArrayList<Pokemon>();
    ArrayList<Pokemon> pokemonFiltered2 = new ArrayList<Pokemon>();

    public void createWindow(int width, int height, String title) throws SQLException {

        //Connects to database and fills array with pokemon data.
        DBConnector connector = new DBConnector();

        for(int i =0; i<connector.pokemons.length;i++){
            pokemonFiltered.add(connector.pokemons[i]);
            pokemonFiltered2.add(connector.pokemons[i]);
        }


        //Loads image for the pokemon, resizes is and then saves it.

        ImageIcon yourPokemonIcon = new ImageIcon("src/PokemonFrontSprites/Spr_5b_"+ pokemonFiltered2.get(counter).pictureID +".png");
        Image yourPokemonImage = yourPokemonIcon.getImage();
        Image yourPokemonImageScaled = yourPokemonImage.getScaledInstance(500,500, Image.SCALE_SMOOTH);
        yourPokemonIcon = new ImageIcon(yourPokemonImageScaled);



        JLabel label = new JLabel();
        label.setText(pokemonFiltered.get(counter).getName());
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIcon(yourPokemonIcon);

        JButton leftPokemon = new JButton("Previous");
        JButton rightPokemon = new JButton("Next");






        //Creates the background panel
        JPanel blackPanel = new JPanel();
        blackPanel.setLayout(new BorderLayout());
        blackPanel.setBackground(Color.black);
        blackPanel.setBounds(0,0,1600,900);
        blackPanel.setPreferredSize(new Dimension(1500,600));





        //Creates the gray panel with red border. Add buttons and images.
        JPanel centerPlane = new JPanel();
        centerPlane.setBackground(Color.lightGray);
        Border centerPlaneBorder = BorderFactory.createLineBorder(Color.red);
        centerPlane.setPreferredSize(new Dimension(200,580));
        centerPlane.setBorder(centerPlaneBorder);
        centerPlane.add(leftPokemon);
        centerPlane.add(label);
        centerPlane.add(rightPokemon);
        blackPanel.add(centerPlane, BorderLayout.CENTER);






        //Creates the west panel with a black background
        JPanel westPlane = new JPanel();
        westPlane.setPreferredSize(new Dimension(150,550));
        westPlane.setLayout(new BorderLayout());
        westPlane.setBackground(Color.black);

        JPanel westPlaneTop = new JPanel();
        westPlaneTop.setBackground(Color.black);
        westPlaneTop.setForeground(Color.white);
        westPlaneTop.setLayout(new BoxLayout(westPlaneTop, BoxLayout.PAGE_AXIS));
        westPlane.add(westPlaneTop, BorderLayout.PAGE_START);

        JLabel searchByNameLabel = new JLabel("Search By Name: ");
        JTextField searchByName = new JTextField();
        JButton search = new JButton("Search");
        searchByName.setPreferredSize(new Dimension(20,30));
        searchByNameLabel.setForeground(Color.white);
        westPlaneTop.add(searchByNameLabel);
        westPlaneTop.add(searchByName);


        JCheckBox normalCheckBox = new JCheckBox("Normal");
        JCheckBox fightingCheckBox = new JCheckBox("Fighting");
        JCheckBox flyingCheckBox = new JCheckBox("Flying");
        JCheckBox poisonCheckBox = new JCheckBox("Poison");
        JCheckBox groundCheckBox = new JCheckBox("Ground");
        JCheckBox rockCheckBox = new JCheckBox("Rock");
        JCheckBox bugCheckBox = new JCheckBox("Bug");
        JCheckBox ghostCheckBox = new JCheckBox("Ghost");
        JCheckBox steelCheckBox = new JCheckBox("Steel");
        JCheckBox fireCheckBox = new JCheckBox("Fire");
        JCheckBox waterCheckBox = new JCheckBox("Water");
        JCheckBox grassCheckBox = new JCheckBox("Grass");
        JCheckBox electricCheckBox = new JCheckBox("Electric");
        JCheckBox psychicCheckBox = new JCheckBox("Psychic");
        JCheckBox iceCheckBox = new JCheckBox("Ice");
        JCheckBox dragonCheckBox = new JCheckBox("Dragon");
        JCheckBox darkCheckBox = new JCheckBox("Dark");
        JCheckBox fairyCheckBox = new JCheckBox("Fairy");

        normalCheckBox.setForeground(Color.white);
        fightingCheckBox.setForeground(Color.white);
        flyingCheckBox.setForeground(Color.white);
        poisonCheckBox.setForeground(Color.white);
        groundCheckBox.setForeground(Color.white);
        rockCheckBox.setForeground(Color.white);
        bugCheckBox.setForeground(Color.white);
        ghostCheckBox.setForeground(Color.white);
        steelCheckBox.setForeground(Color.white);
        fireCheckBox.setForeground(Color.white);
        waterCheckBox.setForeground(Color.white);
        grassCheckBox.setForeground(Color.white);
        electricCheckBox.setForeground(Color.white);
        psychicCheckBox.setForeground(Color.white);
        iceCheckBox.setForeground(Color.white);
        dragonCheckBox.setForeground(Color.white);
        darkCheckBox.setForeground(Color.white);
        fairyCheckBox.setForeground(Color.white);

        westPlaneTop.add(normalCheckBox);
        westPlaneTop.add(fightingCheckBox);
        westPlaneTop.add(flyingCheckBox);
        westPlaneTop.add(poisonCheckBox);
        westPlaneTop.add(groundCheckBox);
        westPlaneTop.add(rockCheckBox);
        westPlaneTop.add(bugCheckBox);
        westPlaneTop.add(ghostCheckBox);
        westPlaneTop.add(steelCheckBox);
        westPlaneTop.add(fireCheckBox);
        westPlaneTop.add(waterCheckBox);
        westPlaneTop.add(grassCheckBox);
        westPlaneTop.add(electricCheckBox);
        westPlaneTop.add(psychicCheckBox);
        westPlaneTop.add(iceCheckBox);
        westPlaneTop.add(dragonCheckBox);
        westPlaneTop.add(darkCheckBox);
        westPlaneTop.add(fairyCheckBox);
        westPlaneTop.add(search);







        blackPanel.add(westPlane, BorderLayout.LINE_START);







        //Creates the east panel with black background and sorting methods
        JPanel eastPlane = new JPanel();
        eastPlane.setPreferredSize(new Dimension(150,550));
        eastPlane.setBackground(Color.black);
        eastPlane.setLayout(new BoxLayout(eastPlane, BoxLayout.PAGE_AXIS));

        eastPlane.add(Box.createRigidArea(new Dimension(0,8 )));

        JLabel sortersLabel = new JLabel();
        sortersLabel.setText("Sort By");
        sortersLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        sortersLabel.setForeground(Color.white);
        eastPlane.add(sortersLabel);

        eastPlane.add(Box.createRigidArea(new Dimension(50,75)));

        JButton pokedexNumber = new JButton("  Dex#   ");
        eastPlane.add(pokedexNumber);

        eastPlane.add(Box.createRigidArea(new Dimension(50,75)));

        JButton legendary = new JButton("Legends");
        eastPlane.add(legendary);

        eastPlane.add(Box.createRigidArea(new Dimension(50,75)));

//        JButton aZ = new JButton("   A-Z   ");
//        eastPlane.add(aZ);
//
//        eastPlane.add(Box.createRigidArea(new Dimension(50,50)));

        JButton random = new JButton("Random");
        eastPlane.add(random);

        eastPlane.add(Box.createRigidArea(new Dimension(50,75)));

        JLabel pickYourPokemonLabel = new JLabel();
        pickYourPokemonLabel.setText("   Choose !");
        pickYourPokemonLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        pickYourPokemonLabel.setForeground(Color.white);
        eastPlane.add(pickYourPokemonLabel);

        JButton submitPokemon = new JButton("Submit");
        eastPlane.add(submitPokemon);

        blackPanel.add(eastPlane, BorderLayout.LINE_END);










        //Creates the south panel with black background
        JPanel southPlane = new JPanel();
        southPlane.setBackground(Color.black);
        southPlane.setPreferredSize(new Dimension(200, 100));
        southPlane.setLayout(new FlowLayout());


        ImageIcon type1Icon = new ImageIcon("src/PokemonTypesImages/"+pokemonFiltered2.get(counter).getType1()+".png");
        Image type1Image = type1Icon.getImage();
        Image type1ImageScaled = type1Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type1Icon = new ImageIcon(type1ImageScaled);

        ImageIcon type2Icon = new ImageIcon("src/PokemonTypesImages/"+ pokemonFiltered2.get(counter).getType2() +".png");
        Image type2Image = type2Icon.getImage();
        Image type2ImageScaled = type2Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type2Icon = new ImageIcon(type2ImageScaled);

        JLabel type1Label = new JLabel();
        type1Label.setIcon(type1Icon);
        JLabel type2Label = new JLabel();
        type2Label.setIcon(type2Icon);
        southPlane.add(type1Label);
        southPlane.add(type2Label);

        blackPanel.add(southPlane, BorderLayout.PAGE_END);











        //Creates the north panel with black background
        JPanel northPlane = new JPanel();
        northPlane.setBackground(Color.black);
        blackPanel.add(northPlane, BorderLayout.PAGE_START);









        //Creates the frame
        JFrame frame;
        frame =  new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.black);
        frame.setVisible(true);
        frame.add(blackPanel);







        //Adds Functionality for previous Pokemon button
        ActionListener leftPokemonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter>0) {
                    counter--;
                    imageCounter--;
                }
                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        leftPokemon.addActionListener(leftPokemonListener);


        //Adds Functionality for next Pokemon button
        ActionListener rightPokemonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter < pokemonFiltered2.size()-2) {
                    counter++;
                    imageCounter++;
                }
                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        rightPokemon.addActionListener(rightPokemonListener);



        //Adds Functionality for the left-side search checklist and text-field
        ActionListener searchFunctionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pokemonFiltered2.clear();
                for(int i =0; i<connector.pokemons.length;i++){
                    pokemonFiltered2.add(connector.pokemons[i]);
                }

                ArrayList<Integer> typeCheckBoxTracker = new ArrayList<Integer>();

                if (normalCheckBox.isSelected()) typeCheckBoxTracker.add(1);
                if (fightingCheckBox.isSelected()) typeCheckBoxTracker.add(2);
                if (flyingCheckBox.isSelected()) typeCheckBoxTracker.add(3);
                if (poisonCheckBox.isSelected()) typeCheckBoxTracker.add(4);
                if (groundCheckBox.isSelected()) typeCheckBoxTracker.add(5);
                if (rockCheckBox.isSelected()) typeCheckBoxTracker.add(6);
                if (bugCheckBox.isSelected()) typeCheckBoxTracker.add(7);
                if (ghostCheckBox.isSelected()) typeCheckBoxTracker.add(8);
                if (steelCheckBox.isSelected()) typeCheckBoxTracker.add(9);
                if (fireCheckBox.isSelected()) typeCheckBoxTracker.add(10);
                if (waterCheckBox.isSelected()) typeCheckBoxTracker.add(11);
                if (grassCheckBox.isSelected()) typeCheckBoxTracker.add(12);
                if (electricCheckBox.isSelected()) typeCheckBoxTracker.add(13);
                if (psychicCheckBox.isSelected()) typeCheckBoxTracker.add(14);
                if (iceCheckBox.isSelected()) typeCheckBoxTracker.add(15);
                if (dragonCheckBox.isSelected()) typeCheckBoxTracker.add(16);
                if (darkCheckBox.isSelected()) typeCheckBoxTracker.add(17);
                if (fairyCheckBox.isSelected()) typeCheckBoxTracker.add(18);



                if (typeCheckBoxTracker.size()>2) JOptionPane.showMessageDialog(null, "A Pokemon can only have a max of 2 types!");


                if (typeCheckBoxTracker.size()==1){
                    pokemonFiltered2.clear();
                    for (int i = 0;i<pokemonFiltered.size()-1;i++){
                        if(   (pokemonFiltered.get(i).getType1() == typeCheckBoxTracker.get(0))   ||   (pokemonFiltered.get(i).getType2()==typeCheckBoxTracker.get(0))  ){
                            counter = 0;
                            pokemonFiltered2.add(pokemonFiltered.get(i));
                        }

                    }
                }


                if (typeCheckBoxTracker.size()==2){
                    pokemonFiltered2.clear();
                    for (int i = 0;i<pokemonFiltered.size()-1;i++){
                        if(    (pokemonFiltered.get(i).getType1() == typeCheckBoxTracker.get(0) && pokemonFiltered.get(i).getType2() == typeCheckBoxTracker.get(1) )   ||   (pokemonFiltered.get(i).getType1() == typeCheckBoxTracker.get(1) && pokemonFiltered.get(i).getType2() == typeCheckBoxTracker.get(0) )){
                            counter = 0;
                            pokemonFiltered2.add(pokemonFiltered.get(i));
                        }

                    }
                }

                String searchInput = searchByName.getText().toLowerCase();
                if(searchInput != ""){
                    for (int i=0;i<pokemonFiltered2.size()-1;i++){
                        String pokemonName = pokemonFiltered2.get(i).getName().toLowerCase();
                        if (!(pokemonName.contains(searchInput))){
                            pokemonFiltered2.remove(i);
                            --i;
                        }
                    }
                    counter = 0;
                }

                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        };
        search.addActionListener(searchFunctionListener);




        //Adds functionality for right side dex forwards filter button
        ActionListener dexForwardsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                pokemonFiltered2.clear();
                for(int i = 0; i< pokemonFiltered.size()-1;i++){
                    pokemonFiltered2.add(pokemonFiltered.get(i));
                }
                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        pokedexNumber.addActionListener(dexForwardsListener);



        ActionListener submitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                BattleWindow battleWindow = new BattleWindow();
                battleWindow.setSelectedPokemonOne(selectedPokemon[0]);
                battleWindow.setSelectedPokemonTwo(pokemonFiltered2.get(counter));
                try {
                    battleWindow.createBattleWindow(1000, 900, "Fight!");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        };
        submitPokemon.addActionListener(submitListener);



        ActionListener legendsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                pokemonFiltered2.clear();
                for(int i = 0; i< pokemonFiltered.size()-1;i++){
                    if (pokemonFiltered.get(i).isLegendary){
                        pokemonFiltered2.add(pokemonFiltered.get(i));
                    }
                }
                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        legendary.addActionListener(legendsListener);

        ActionListener randomListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int random_int = (int) Math.floor(Math.random() * (721 - 0 + 1) + 0);
                counter = random_int;
                pokemonFiltered2.clear();
                for(int i = 0; i< pokemonFiltered.size()-1;i++){
                    pokemonFiltered2.add(pokemonFiltered.get(i));
                }
                try {
                    repostImage(label, type1Label, type2Label);
                } catch (noMatchesFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        random.addActionListener(randomListener);




        frame.pack();


    }











//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void repostImage(JLabel label, JLabel type1Label, JLabel type2Label) throws noMatchesFoundException {

        if (pokemonFiltered2.size()==0) throw new noMatchesFoundException();

        label.setText(pokemonFiltered2.get(counter).getName());
        ImageIcon yourPokemonIcon = new ImageIcon("src/PokemonFrontSprites/Spr_5b_"+ pokemonFiltered2.get(counter).getPictureID() +".png");
        Image yourPokemonImage = yourPokemonIcon.getImage();
        Image yourPokemonImageScaled = yourPokemonImage.getScaledInstance(500,500, Image.SCALE_SMOOTH);
        yourPokemonIcon = new ImageIcon(yourPokemonImageScaled);

        ImageIcon type1Icon = new ImageIcon("src/PokemonTypesImages/" + pokemonFiltered2.get(counter).getType1() + ".png");
        Image type1Image = type1Icon.getImage();
        Image type1ImageScaled = type1Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type1Icon = new ImageIcon(type1ImageScaled);

        ImageIcon type2Icon = new ImageIcon("src/PokemonTypesImages/" + pokemonFiltered2.get(counter).getType2()+ ".png");
        Image type2Image = type2Icon.getImage();
        Image type2ImageScaled = type2Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type2Icon = new ImageIcon(type2ImageScaled);


        type1Label.setIcon(type1Icon);
        type2Label.setIcon(type2Icon);
        label.setIcon(yourPokemonIcon);
    }

    public void setSelectedPokemonOne(Pokemon one){
        this.selectedPokemon[0] = one;
    }

    public void setSelectedPokemonTwo(Pokemon two){
        this.selectedPokemon[1] = two;
    }


}
