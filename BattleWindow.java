import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class BattleWindow {


    public Pokemon[] selectedPokemon = new Pokemon[2];
    public boolean fightIsClicked = false;
    public boolean pokemonIsClicked = false;
    public boolean bagIsClicked = false;
    public boolean runIsClicked = false;
    public float yourATK;
    public float yourHP;
    public float yourDEF;
    public float yourSPD;
    public float oppATK;
    public float oppHP;
    public float oppDEF;
    public float oppSPD;
    public float yourCurrentHP;
    public float oppCurrentHP;


    public void createBattleWindow(int width, int height, String title) throws SQLException {

        this.yourATK = 2 * selectedPokemon[0].getBaseATK() + 5;
        this.yourHP = 2 * selectedPokemon[0].getBaseHP() + 10;
        this.yourDEF = 2 * selectedPokemon[0].getBaseDEF() + 5;
        this.yourSPD = 2 * selectedPokemon[0].getBaseSpeed() + 5;
        this.oppATK = 2 * selectedPokemon[1].getBaseATK() + 5;
        this.oppHP = 2 * selectedPokemon[1].getBaseHP() + 10;
        this.oppDEF = 2 * selectedPokemon[1].getBaseDEF() + 5;
        this.oppSPD = 2 * selectedPokemon[1].getBaseSpeed() + 5;
        this.yourCurrentHP = this.yourHP;
        this.oppCurrentHP = this.oppHP;

        MoveLoader yourMoveLoader = new MoveLoader(selectedPokemon[0].getType1(), selectedPokemon[0].getType2());
        MoveLoader opponentMoveLoader = new MoveLoader(selectedPokemon[1].getType1(), selectedPokemon[1].getType2());

        Move[] yourPokemonMoves = yourMoveLoader.returnMoves();
        Move[] opponentPokemonMoves = opponentMoveLoader.returnMoves();

        for (int i = 0; i < 4; i++) {
            System.out.println(yourPokemonMoves[i].getMoveName() + " " + yourPokemonMoves[i].getMovePower() + " " + yourPokemonMoves[i].getMoveAccuracy());
        }

        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.println(opponentPokemonMoves[i].getMoveName() + " " + opponentPokemonMoves[i].getMovePower() + " " + opponentPokemonMoves[i].getMoveAccuracy());
        }


        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //Creates Top half of battle scene where the opponents Pokemon lies
        JPanel fightPanel = new JPanel();
        fightPanel.setBackground(Color.black);
        fightPanel.setLayout(new BorderLayout());

        JLayeredPane topPanel = new JLayeredPane();
        topPanel.setPreferredSize(new Dimension(800, 450));
        topPanel.setBackground(Color.lightGray);
        topPanel.setOpaque(true);
        topPanel.setLayout(null);


        //Creates the text within the black box.
        JLabel whatWillPokemonDoLabel = new JLabel();
        whatWillPokemonDoLabel.setText("What will ");
        whatWillPokemonDoLabel.setForeground(Color.white);
        whatWillPokemonDoLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        whatWillPokemonDoLabel.setBounds(70, 300, 1000, 900);
        topPanel.add(whatWillPokemonDoLabel);

        JLabel whatWillPokemonDoLabel2 = new JLabel();
        whatWillPokemonDoLabel2.setText(selectedPokemon[0].getName() + " do?");
        whatWillPokemonDoLabel2.setForeground(Color.white);
        whatWillPokemonDoLabel2.setFont(new Font("Monospaced", Font.PLAIN, 36));
        whatWillPokemonDoLabel2.setBounds(70, 356, 1000, 900);
        topPanel.add(whatWillPokemonDoLabel2);

        JLabel fightLabel = new JLabel();
        fightLabel.setText("Fight");
        fightLabel.setForeground(Color.black);
        fightLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        fightLabel.setBounds(550, 730, 170, 60);
        topPanel.add(fightLabel);

        JLabel bagLabel = new JLabel();
        bagLabel.setText("Bag");
        bagLabel.setForeground(Color.black);
        bagLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        bagLabel.setBounds(550, 805, 170, 60);
        topPanel.add(bagLabel);

        JLabel runLabel = new JLabel();
        runLabel.setText("Run");
        runLabel.setForeground(Color.black);
        runLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        runLabel.setBounds(725, 805, 200, 60);
        topPanel.add(runLabel);

        JLabel pokemonLabel = new JLabel();
        pokemonLabel.setText("Pokemon");
        pokemonLabel.setForeground(Color.black);
        pokemonLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        pokemonLabel.setBounds(725, 730, 200, 50);
        topPanel.add(pokemonLabel);


        JPanel actionsPanel = new JPanel();
        actionsPanel.setBackground(Color.white);
        actionsPanel.setPreferredSize(new Dimension(450, 172));
        actionsPanel.setOpaque(true);
        Border actionsPanelBorder = BorderFactory.createLineBorder(new Color(36, 48, 79), 5);
        actionsPanel.setBorder(actionsPanelBorder);
        actionsPanel.setBounds(500, 700, 450, 172);
        topPanel.add(actionsPanel);


        JPanel leftSide = new JPanel();
        leftSide.setBackground(new Color(107, 34, 142));
        leftSide.setPreferredSize(new Dimension(50, 900));
        leftSide.setBounds(0, 0, 50, 900);
        topPanel.add(leftSide);

        JPanel rightSide = new JPanel();
        rightSide.setBackground(new Color(107, 34, 142));
        rightSide.setPreferredSize(new Dimension(50, 900));
        rightSide.setBounds(950, 0, 50, 900);
        topPanel.add(rightSide);

        JPanel topSide = new JPanel();
        topSide.setBackground(new Color(107, 34, 142));
        topSide.setPreferredSize(new Dimension(1000, 35));
        topSide.setBounds(0, 0, 1000, 35);
        topPanel.add(topSide);


        JPanel whatWillPokemonDoFront = new JPanel();
        whatWillPokemonDoFront.setBackground(Color.black);
        whatWillPokemonDoFront.setPreferredSize(new Dimension(900, 150));
        whatWillPokemonDoFront.setOpaque(true);
        Border whatWillPokemonDoFrontBorder = BorderFactory.createLineBorder(Color.white, 5);
        whatWillPokemonDoFront.setBorder(whatWillPokemonDoFrontBorder);
        whatWillPokemonDoFront.setBounds(50, 710, 900, 150);
        topPanel.add(whatWillPokemonDoFront);

        JPanel whatWillPokemonDoBack = new JPanel();
        whatWillPokemonDoBack.setBackground(new Color(129, 42, 176));
        whatWillPokemonDoBack.setPreferredSize(new Dimension(1000, 250));
        whatWillPokemonDoBack.setOpaque(true);
        Border whatWillPokemonDoBackBorder = BorderFactory.createLineBorder(Color.black, 5);
        whatWillPokemonDoBack.setBorder(whatWillPokemonDoBackBorder);
        whatWillPokemonDoBack.setBounds(0, 700, 1000, 200);
        topPanel.add(whatWillPokemonDoBack);

        JLabel opponentPokemonName = new JLabel();
        opponentPokemonName.setText(selectedPokemon[1].getName());
        opponentPokemonName.setFont(new Font("Monospaced", Font.PLAIN, 30));
        opponentPokemonName.setBounds(65, -360, 1000, 1000);
        opponentPokemonName.setForeground(Color.black);
        topPanel.add(opponentPokemonName);


        JLabel opponentPokemonLevel = new JLabel();
        opponentPokemonLevel.setText("Lv100");
        opponentPokemonLevel.setFont(new Font("Monospaced", Font.PLAIN, 30));
        opponentPokemonLevel.setBounds(305, -360, 1000, 1000);
        opponentPokemonLevel.setForeground(Color.black);
        topPanel.add(opponentPokemonLevel);

        JLabel yourPokemonName = new JLabel();
        yourPokemonName.setText(selectedPokemon[0].getName());
        yourPokemonName.setFont(new Font("Monospaced", Font.PLAIN, 30));
        yourPokemonName.setBounds(610, 40, 1000, 1000);
        yourPokemonName.setForeground(Color.black);
        topPanel.add(yourPokemonName);

        JLabel yourPokemonLevel = new JLabel();
        yourPokemonLevel.setText("Lv100");
        yourPokemonLevel.setFont(new Font("Monospaced", Font.PLAIN, 30));
        yourPokemonLevel.setBounds(850, 40, 1000, 1000);
        yourPokemonLevel.setForeground(Color.black);
        topPanel.add(yourPokemonLevel);


        JLabel opponentPokemonHealth = new JLabel();
        ImageIcon opponentPokemonHealthIcon = new ImageIcon("src/BattleInterface/HealthBar.png");
        Image opponentPokemonHealthImage = opponentPokemonHealthIcon.getImage();
        Image opponentPokemonHealthImageScaled = opponentPokemonHealthImage.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        opponentPokemonHealthIcon = new ImageIcon(opponentPokemonHealthImageScaled);

        opponentPokemonHealth.setIcon(opponentPokemonHealthIcon);
        opponentPokemonHealth.setBounds(49, 7, 345, 800);

        topPanel.add(opponentPokemonHealth);


        JLabel yourPokemonHealth = new JLabel();
        ImageIcon yourPokemonHealthIcon = new ImageIcon("src/BattleInterface/HealthBar.png");
        Image yourPokemonHealthImage = yourPokemonHealthIcon.getImage();
        Image yourPokemonHealthImageScaled = yourPokemonHealthImage.getScaledInstance(1202, 805, Image.SCALE_SMOOTH);
        yourPokemonHealthIcon = new ImageIcon(yourPokemonHealthImageScaled);

        yourPokemonHealth.setIcon(yourPokemonHealthIcon);
        yourPokemonHealth.setBounds(603, 419, 345, 805);

        topPanel.add(yourPokemonHealth);


        JLabel yourCard = new JLabel();
        ImageIcon yourCardIcon = new ImageIcon("src/BattleInterface/YourCard.png");
        Image yourCardImage = yourCardIcon.getImage();
        Image yourCardScaled = yourCardImage.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        yourCardIcon = new ImageIcon(yourCardScaled);

        yourCard.setIcon(yourCardIcon);
        yourCard.setBounds(80, 0, 1000, 1000);

        topPanel.add(yourCard);


        JLabel opponentCard = new JLabel();
        ImageIcon opponentCardIcon = new ImageIcon("src/BattleInterface/OpponentCard.png");
        Image opponentCardImage = opponentCardIcon.getImage();
        Image opponentCardScaled = opponentCardImage.getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        opponentCardIcon = new ImageIcon(opponentCardScaled);

        opponentCard.setIcon(opponentCardIcon);
        opponentCard.setBounds(-225, -300, 1000, 1000);

        topPanel.add(opponentCard);

        ImageIcon type1Icon = new ImageIcon("src/PokemonTypesImages/"+selectedPokemon[1].getType1()+".png");
        Image type1Image = type1Icon.getImage();
        Image type1ImageScaled = type1Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type1Icon = new ImageIcon(type1ImageScaled);
        JLabel type1Label = new JLabel();
        type1Label.setIcon(type1Icon);
        type1Label.setBounds(600,80,75,40);
        type1Label.setVisible(false);
        topPanel.add(type1Label);

        ImageIcon type2Icon = new ImageIcon("src/PokemonTypesImages/"+ selectedPokemon[1].getType2() +".png");
        Image type2Image = type2Icon.getImage();
        Image type2ImageScaled = type2Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        type2Icon = new ImageIcon(type2ImageScaled);
        JLabel type2Label = new JLabel();
        type2Label.setIcon(type2Icon);
        type2Label.setBounds(680,80,75,40);
        type2Label.setVisible(false);

        topPanel.add(type2Label);

        ImageIcon yourtype1Icon = new ImageIcon("src/PokemonTypesImages/"+selectedPokemon[0].getType1()+".png");
        Image yourtype1Image = yourtype1Icon.getImage();
        Image yourtype1ImageScaled = yourtype1Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        yourtype1Icon = new ImageIcon(yourtype1ImageScaled);
        JLabel yourtype1Label = new JLabel();
        yourtype1Label.setIcon(yourtype1Icon);
        yourtype1Label.setBounds(150,500,75,40);
        yourtype1Label.setVisible(false);
        topPanel.add(yourtype1Label);

        ImageIcon yourtype2Icon = new ImageIcon("src/PokemonTypesImages/"+selectedPokemon[0].getType2()+".png");
        Image yourtype2Image = yourtype2Icon.getImage();
        Image yourtype2ImageScaled = yourtype2Image.getScaledInstance(75,40, Image.SCALE_SMOOTH);
        yourtype2Icon = new ImageIcon(yourtype2ImageScaled);
        JLabel yourtype2Label = new JLabel();
        yourtype2Label.setIcon(yourtype2Icon);
        yourtype2Label.setBounds(230,500,75,40);
        yourtype2Label.setVisible(false);
        topPanel.add(yourtype2Label);



        JLabel opponentPokemon = new JLabel();
        ImageIcon opponentPokemonIcon = new ImageIcon("src/PokemonFrontSprites/Spr_5b_" + selectedPokemon[1].getPictureID() + ".png");
        Image opponentPokemonImage = opponentPokemonIcon.getImage();
        Image opponentPokemonImageScaled = opponentPokemonImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        opponentPokemonIcon = new ImageIcon(opponentPokemonImageScaled);

        opponentPokemon.setIcon(opponentPokemonIcon);
        opponentPokemon.setBounds(550, 10, 400, 400);

        topPanel.add(opponentPokemon);

        JLabel opponentPokemonPlatform = new JLabel();
        ImageIcon opponentPokemonPlatformIcon = new ImageIcon("src/BattlePlatforms/" + selectedPokemon[1].getType1() + "Platform.png");
        Image opponentPokemonPlatformImage = opponentPokemonPlatformIcon.getImage();
        Image opponentPokemonPlatformImageScaled = opponentPokemonPlatformImage.getScaledInstance(450, 250, Image.SCALE_SMOOTH);
        opponentPokemonIcon = new ImageIcon(opponentPokemonPlatformImageScaled);

        opponentPokemonPlatform.setIcon(opponentPokemonIcon);
        opponentPokemonPlatform.setBounds(487, 140, 650, 250);

        topPanel.add(opponentPokemonPlatform);


        JLabel yourPokemon = new JLabel();
        ImageIcon yourPokemonIcon = new ImageIcon("src/PokemonBackImages/Spr_b_5b_" + selectedPokemon[0].getPictureID() + ".png");
        Image yourPokemonImage = yourPokemonIcon.getImage();
        Image yourPokemonImageScaled = yourPokemonImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        yourPokemonIcon = new ImageIcon(yourPokemonImageScaled);

        yourPokemon.setIcon(yourPokemonIcon);
        yourPokemon.setBounds(50, 425, 400, 400);

        topPanel.add(yourPokemon);


        JLabel yourPokemonPlatform = new JLabel();
        ImageIcon yourPokemonPlatformIcon = new ImageIcon("src/BattlePlatforms/" + selectedPokemon[1].getType1() + "Platform.png");
        Image yourPokemonPlatformImage = yourPokemonPlatformIcon.getImage();
        Image yourPokemonPlatformImageScaled = yourPokemonPlatformImage.getScaledInstance(650, 306, Image.SCALE_SMOOTH);
        yourPokemonPlatformIcon = new ImageIcon(yourPokemonPlatformImageScaled);

        yourPokemonPlatform.setIcon(yourPokemonPlatformIcon);
        yourPokemonPlatform.setBounds(-50, 525, 650, 250);

        topPanel.add(yourPokemonPlatform);


        JLabel background = new JLabel();
        ImageIcon backgroundIcon = new ImageIcon("src/Backgrounds/" + selectedPokemon[1].getType1() + ".png");
        Image backgroundImage = backgroundIcon.getImage();
        Image backgroundImageScaled = backgroundImage.getScaledInstance(1100, 900, Image.SCALE_SMOOTH);
        backgroundIcon = new ImageIcon(backgroundImageScaled);

        background.setIcon(backgroundIcon);
        background.setBounds(-50, 0, 1200, 900);

        topPanel.add(background);


        fightLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);


                fightLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
                pokemonLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
                bagLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
                runLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));

                fightLabel.setText(yourPokemonMoves[0].getMoveName());
                pokemonLabel.setText(yourPokemonMoves[1].getMoveName());
                bagLabel.setText(yourPokemonMoves[2].getMoveName());
                runLabel.setText(yourPokemonMoves[3].getMoveName());

                if (fightIsClicked) {
                    try {
                        fight(fightLabel, pokemonLabel, bagLabel, runLabel, whatWillPokemonDoLabel, whatWillPokemonDoLabel2, yourPokemonMoves, opponentPokemonMoves, 0, yourPokemonHealth, opponentPokemonHealth, frame);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else
                fightIsClicked = true;


            }
        });


        pokemonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                if (fightIsClicked) {
                    try {
                        fight(fightLabel, pokemonLabel, bagLabel, runLabel, whatWillPokemonDoLabel, whatWillPokemonDoLabel2, yourPokemonMoves, opponentPokemonMoves, 1, yourPokemonHealth, opponentPokemonHealth, frame);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else if(pokemonIsClicked){
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Are You Sure You Want To Change Pokemon?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Yes", "No"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        frame.dispose();
                        GameWindow gameWindow = new GameWindow();
                        try {
                            gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else;
                }

                pokemonIsClicked = true;

            }
        });


        bagLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ActionListener pokemonHealed = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        whatWillPokemonDoLabel.setText("Your " + selectedPokemon[0].getName());
                        whatWillPokemonDoLabel2.setText("was healed!");
                    }
                };

                ActionListener alreadyFull = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        whatWillPokemonDoLabel.setText(selectedPokemon[0].getName() + "'s health");
                        whatWillPokemonDoLabel2.setText(" is already full!");
                    }
                };

                ActionListener resetWhatWill = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        whatWillPokemonDoLabel.setText("What will");
                        whatWillPokemonDoLabel2.setText(selectedPokemon[0].getName() + " do?");

                    }
                };


                super.mouseClicked(e);
                if (fightIsClicked) {
                    try {
                        fight(fightLabel, pokemonLabel, bagLabel, runLabel, whatWillPokemonDoLabel, whatWillPokemonDoLabel2, yourPokemonMoves, opponentPokemonMoves, 2, yourPokemonHealth, opponentPokemonHealth, frame);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else if(bagIsClicked){
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Catch or Heal?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Catch", "Heal"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        int random_int = (int) Math.floor(Math.random() * (100 + 1) + 0);

                        JLabel pokeBall = new JLabel();
                        ImageIcon pokeBallIcon = new ImageIcon("src/PokeBall/PokeBallNotCaught.png");
                        Image pokeBallImage = pokeBallIcon.getImage();
                        Image pokeBallImageScaled = pokeBallImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        pokeBallIcon = new ImageIcon(pokeBallImageScaled);

                        opponentPokemon.setIcon(pokeBallIcon);
                        opponentPokemon.setBounds(680, 225, 50, 50);

                        topPanel.add(pokeBall);

                        ActionListener pokemonNotCaught = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                whatWillPokemonDoLabel.setText("Oh no!");
                                whatWillPokemonDoLabel2.setText(selectedPokemon[1].getName() + " broke free!");

                                ImageIcon opponentPokemonIcon = new ImageIcon("src/PokemonFrontSprites/Spr_5b_" + selectedPokemon[1].getPictureID() + ".png");
                                Image opponentPokemonImage = opponentPokemonIcon.getImage();
                                Image opponentPokemonImageScaled = opponentPokemonImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                                opponentPokemonIcon = new ImageIcon(opponentPokemonImageScaled);

                                opponentPokemon.setIcon(opponentPokemonIcon);
                                opponentPokemon.setBounds(550, 10, 400, 400);
                            }
                        };

                        ActionListener pokemonCaught = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                whatWillPokemonDoLabel.setText("You Caught the");
                                whatWillPokemonDoLabel2.setText("wild " + selectedPokemon[1].getName() + "!");


                                int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                                        "Play Again?", //Object message,
                                        "Choose an option", //String title
                                        JOptionPane.YES_NO_OPTION, //int optionType
                                        JOptionPane.INFORMATION_MESSAGE, //int messageType
                                        null, //Icon icon,
                                        new String[]{"Yes", "No"}, //Object[] options,
                                        "");//Object initialValue
                                if (choice == 0) {
                                    frame.dispose();
                                    GameWindow gameWindow = new GameWindow();
                                    try {
                                        gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                } else System.exit(0);
                            }
                        };



                        ActionListener repostPokemon = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {



                            }
                        };


                        if (random_int>=50){
                            Timer timer = new Timer(3000, pokemonCaught);
                            timer.setRepeats(false);
                            timer.start();
                        }
                        else{
                            Timer timer = new Timer(3000, pokemonNotCaught);
                            timer.setRepeats(false);
                            timer.start();

                            Timer timer2 = new Timer(4000, resetWhatWill);
                            timer2.setRepeats(false);
                            timer2.start();

                        }

                    }



                        else{

                            if (yourCurrentHP == yourHP){
                                Timer timer = new Timer(2000, alreadyFull);
                                timer.setRepeats(false);
                                timer.start();
                            }

                            yourCurrentHP = yourCurrentHP + (yourCurrentHP/2);
                            float healthBarSize = 345 * (yourCurrentHP / yourHP);
                            yourPokemonHealth.setBounds(603, 419, (int) healthBarSize, 805);

                            Timer timer = new Timer(1000, pokemonHealed);
                            timer.setRepeats(false);
                            timer.start();

                            Timer timer2 = new Timer(3000, resetWhatWill);
                            timer2.setRepeats(false);
                            timer2.start();
                        }
                    }


                bagIsClicked = true;
            }
        });


        runLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (fightIsClicked) {
                    try {
                        fight(fightLabel, pokemonLabel, bagLabel, runLabel, whatWillPokemonDoLabel, whatWillPokemonDoLabel2, yourPokemonMoves, opponentPokemonMoves, 3, yourPokemonHealth, opponentPokemonHealth, frame);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else {
                    JOptionPane.showMessageDialog(null, "You Successfully Ran.");
                    frame.dispose();
                    GameWindow gameWindow = new GameWindow();
                    try {
                        gameWindow.createWindow(1600, 900, "Choose Your Pokemon!");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        opponentPokemon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                    type1Label.setVisible(true);
                    type2Label.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                type1Label.setVisible(false);
                type2Label.setVisible(false);            }
        });


        yourPokemon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yourtype1Label.setVisible(true);
                yourtype2Label.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                yourtype1Label.setVisible(false);
                yourtype2Label.setVisible(false);            }
        });



        fightPanel.add(topPanel, BorderLayout.CENTER);

        frame.add(fightPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


    public void fight(JLabel fightLabel, JLabel pokemonLabel, JLabel bagLabel, JLabel runLabel, JLabel whatWill, JLabel pokemonDo, Move[] yourMoves, Move[] opponentMoves, int moveIndex, JLabel yourHealth, JLabel opponentHealth, JFrame frame) throws InterruptedException {

        fightLabel.setText("Fight");
        pokemonLabel.setText("Pokemon");
        bagLabel.setText("Bag");
        runLabel.setText("Run");

        fightLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        pokemonLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        bagLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));
        runLabel.setFont(new Font("Monospaced", Font.PLAIN, 36));


        this.fightIsClicked = false;
        this.pokemonIsClicked = false;


        if (this.yourSPD < this.oppSPD) {

            float yourMovesEffectiveness = (float) effectiveness(yourMoves[moveIndex].getTypeID(),selectedPokemon[1].getType1(),selectedPokemon[1].getType2());
            float oppMovesEffectiveness = (float) effectiveness(opponentMoves[moveIndex].getTypeID(),selectedPokemon[0].getType1(),selectedPokemon[0].getType2());

            whatWill.setText(selectedPokemon[1].getName() + " used");
            pokemonDo.setText(opponentMoves[moveIndex].getMoveName() + "!");

            int random_int = (int) Math.floor(Math.random() * (3 + 1) + 0);
            float damage1 = (float) (opponentMoves[random_int].getMovePower() * (this.oppATK / this.yourDEF) * effectiveness(opponentMoves[random_int].getTypeID(),selectedPokemon[0].getType1(),selectedPokemon[0].getType2()));
            this.yourCurrentHP = this.yourCurrentHP - damage1;
            float healthBarSize = 345 * (this.yourCurrentHP / this.yourHP);
            yourHealth.setBounds(603, 419, (int) healthBarSize, 805);



            float damage2 = (float) (yourMoves[moveIndex].getMovePower() * (this.yourATK / this.oppDEF) * effectiveness(yourMoves[moveIndex].getTypeID(),selectedPokemon[1].getType1(),selectedPokemon[1].getType2()));
            this.oppCurrentHP = this.oppCurrentHP - damage2;
            float healthBarSize2 = 345 * (this.oppCurrentHP / this.oppHP);


//            System.out.println(this.yourCurrentHP);
//            System.out.println(this.oppCurrentHP);


            ActionListener updateTextAttack = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText(selectedPokemon[0].getName() + " used");
                    pokemonDo.setText(yourMoves[moveIndex].getMoveName() + "!");
                    opponentHealth.setBounds(49, 7, (int) healthBarSize2, 800);
                }
            };


            ActionListener updateTextOpponenetFainted = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("The wild");
                    pokemonDo.setText(selectedPokemon[1].getName() + " fainted!");
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Play Again?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Yes", "No"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        frame.dispose();
                        GameWindow gameWindow = new GameWindow();
                        try {
                            gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else System.exit(0);
                }
            };

            ActionListener updateTextYouFainted = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("Your");
                    pokemonDo.setText(selectedPokemon[0].getName() + " fainted!");
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Play Again?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Yes", "No"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        frame.dispose();
                        GameWindow gameWindow = new GameWindow();
                        try {
                            gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else System.exit(0);
                }
            };

            ActionListener superEffective = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It's super");
                    pokemonDo.setText("effective!");
                }
            };

            ActionListener notVeryEffective = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It's not very");
                    pokemonDo.setText("effective!");

                }
            };

            ActionListener doesntEffect = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It had no effect.");
                    pokemonDo.setText(" ");

                }
            };

            ActionListener resetWhatWill = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("What will");
                    pokemonDo.setText(selectedPokemon[0].getName() + " do?");

                }
            };

            if (oppMovesEffectiveness == 0){
                Timer timer = new Timer(1500, doesntEffect);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (oppMovesEffectiveness < 1 && yourMovesEffectiveness>0){
                Timer timer = new Timer(1500, notVeryEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (oppMovesEffectiveness > 1){
                Timer timer = new Timer(1500, superEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (yourMovesEffectiveness == 0 && yourCurrentHP >0){
                Timer timer = new Timer(4500, doesntEffect);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (yourMovesEffectiveness <1 && yourMovesEffectiveness>0 && yourCurrentHP >0){
                Timer timer = new Timer(4500, notVeryEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (yourMovesEffectiveness >1 && yourCurrentHP >0){
                Timer timer = new Timer(4500, superEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }


            if (this.yourCurrentHP <= 0) {
                Timer timer = new Timer(3000, updateTextYouFainted);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (this.yourCurrentHP > 0 && (this.oppCurrentHP <= 0)) {

                Timer timer2 = new Timer(6000, updateTextOpponenetFainted);
                timer2.setRepeats(false);
                timer2.start();

                Timer timer = new Timer(3000, updateTextAttack);
                timer.setRepeats(false);
                timer.start();

                Timer timer3 = new Timer(7000, resetWhatWill);
                timer3.setRepeats(false);
                timer3.start();

            }

            if (this.yourCurrentHP > 0 && (this.oppCurrentHP > 0)) {
                Timer timer = new Timer(3000, updateTextAttack);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }
        }




        if (this.yourSPD > this.oppSPD) {

            float yourMovesEffectiveness = (float) effectiveness(yourMoves[moveIndex].getTypeID(),selectedPokemon[1].getType1(),selectedPokemon[1].getType2());
            float oppMovesEffectiveness = (float) effectiveness(opponentMoves[moveIndex].getTypeID(),selectedPokemon[0].getType1(),selectedPokemon[0].getType2());

            whatWill.setText(selectedPokemon[0].getName() + " used");
            pokemonDo.setText(yourMoves[moveIndex].getMoveName() + "!");


            float damage1 = (float) (yourMoves[moveIndex].getMovePower() * (this.yourATK / this.oppDEF) * effectiveness(yourMoves[moveIndex].getTypeID(),selectedPokemon[1].getType1(),selectedPokemon[1].getType2()));
            this.oppCurrentHP = this.oppCurrentHP - damage1;
            float healthBarSize = 345 * (this.oppCurrentHP / this.oppHP);
            opponentHealth.setBounds(49, 7, (int) healthBarSize, 800);


            int random_int = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
            float damage2 = (float) (opponentMoves[random_int].getMovePower() * (this.oppATK / this.yourDEF) * effectiveness(opponentMoves[moveIndex].getTypeID(),selectedPokemon[0].getType1(),selectedPokemon[0].getType2()));
            this.yourCurrentHP = this.yourCurrentHP - damage2;
            float healthBarSize2 = 345 * (this.yourCurrentHP / this.yourHP);


//            System.out.println(this.yourCurrentHP);
//            System.out.println(this.oppCurrentHP);


            ActionListener updateTextAttack = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText(selectedPokemon[1].getName() + " used");
                    pokemonDo.setText(opponentMoves[random_int].getMoveName() + "!");
                    yourHealth.setBounds(603, 419, (int) healthBarSize2, 805);
                }
            };


            ActionListener updateTextOpponenetFainted = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("The wild");
                    pokemonDo.setText(selectedPokemon[1].getName() + " fainted!");
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Play Again?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Yes", "No"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        frame.dispose();
                        GameWindow gameWindow = new GameWindow();
                        try {
                            gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else System.exit(0);
                }
            };

            ActionListener updateTextYouFainted = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("Your");
                    pokemonDo.setText(selectedPokemon[0].getName() + " fainted!");
                    int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                            "Play Again?", //Object message,
                            "Choose an option", //String title
                            JOptionPane.YES_NO_OPTION, //int optionType
                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                            null, //Icon icon,
                            new String[]{"Yes", "No"}, //Object[] options,
                            "");//Object initialValue
                    if (choice == 0) {
                        frame.dispose();
                        GameWindow gameWindow = new GameWindow();
                        try {
                            gameWindow.createWindow(1600,900, "Choose Your Pokemon!");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else System.exit(0);
                }
            };

            ActionListener superEffective = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It's super");
                    pokemonDo.setText("effective!");
                }
            };

            ActionListener notVeryEffective = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It's not very");
                    pokemonDo.setText("effective!");

                }
            };

            ActionListener doesntEffect = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("It had no effect.");
                    pokemonDo.setText(" ");

                }
            };

            ActionListener resetWhatWill = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whatWill.setText("What will");
                    pokemonDo.setText(selectedPokemon[0].getName() + " do?");

                }
            };

            if (yourMovesEffectiveness == 0){
                    Timer timer = new Timer(1500, doesntEffect);
                    timer.setRepeats(false);
                    timer.start();

                    Timer timer2 = new Timer(7000, resetWhatWill);
                    timer2.setRepeats(false);
                    timer2.start();
            }

            if (yourMovesEffectiveness < 1 && yourMovesEffectiveness>0){
                Timer timer = new Timer(1500, notVeryEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (yourMovesEffectiveness > 1){
                Timer timer = new Timer(1500, superEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (oppMovesEffectiveness == 0 && oppCurrentHP >0){
                Timer timer = new Timer(4500, doesntEffect);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (oppMovesEffectiveness <1 && oppMovesEffectiveness>0 && oppCurrentHP >0){
                Timer timer = new Timer(4500, notVeryEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (oppMovesEffectiveness >1 && oppCurrentHP >0){
                Timer timer = new Timer(4500, superEffective);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }




            if (this.oppCurrentHP <= 0) {
                Timer timer = new Timer(3000, updateTextOpponenetFainted);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }

            if (this.oppCurrentHP > 0 && (this.yourCurrentHP <= 0)) {

                Timer timer2 = new Timer(6000, updateTextYouFainted);
                timer2.setRepeats(false);
                timer2.start();

                Timer timer = new Timer(3000, updateTextAttack);
                timer.setRepeats(false);
                timer.start();

                Timer timer3 = new Timer(7000, resetWhatWill);
                timer3.setRepeats(false);
                timer3.start();

            }

            if (this.oppCurrentHP > 0 && (this.yourCurrentHP > 0)) {
                Timer timer = new Timer(3000, updateTextAttack);
                timer.setRepeats(false);
                timer.start();

                Timer timer2 = new Timer(7000, resetWhatWill);
                timer2.setRepeats(false);
                timer2.start();
            }
        }


    }

    public void setSelectedPokemonOne(Pokemon one) {
        this.selectedPokemon[0] = one;
    }

    public void setSelectedPokemonTwo(Pokemon two) {
        this.selectedPokemon[1] = two;
    }

    public double effectiveness(int attack, int defender1, int defender2) {

        double effectiveness = 1;

        double[][] typeAdvantages = {{1, 1, 1, 1, 1, 0.5, 1, 0, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5},
                {1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1, 1, 1, 1},
                {1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1, 1, 1, 2},
                {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1, 1, 1, 1},
                {1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1, 1, 2, 1, 1, 1},
                {1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1, 1, 2, 0.5},
                {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2, 1, 1, 2},
                {1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2, 0.5, 1, 1},
                {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0.5, 1, 1},
                {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 0.5, 2, 0.5, 1, 1, 1, 0.5, 1, 1},
                {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 0.5, 1, 1},
                {1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1, 1, 0, 1},
                {1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 1, 1, 2, 1, 0},
                {1, 0.5, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5},
                {1, 2, 1, 0.5, 1, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 1, 1, 2, 2, 1}};

        if(defender2==0){
            effectiveness = effectiveness * (typeAdvantages[attack-1][defender1-1]);
        }
        else {
            effectiveness = effectiveness * (typeAdvantages[attack-1][defender1-1]);

            effectiveness = effectiveness * (typeAdvantages[attack-1][defender2-1]);
        }
        return effectiveness;

    }





}
