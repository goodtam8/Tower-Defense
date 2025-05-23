package td;

import td.monster.Monster;
import td.tower.CatapultTower;
import td.tower.LaserTower;
import td.tower.ArcheryTower;
import td.tower.Tower;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * This is the controller class. It governs the game logic. 
 * 
 */
public class Game {
    /**
     * The height of the game. Use this constant whenever possible
     */
    public static final int HEIGHT = 4;
    /**
     * The width of the game. Use this constant whenever possible
     */
    public static final int WIDTH = 12;
    protected char[][] b=new char[HEIGHT][WIDTH];

    /**
     * How many monster killed
     */
    private int score;
    /**
     * How much money the player has. Money is required for building tower
     */
    private int money;
    /**
     * A list of tower/monster that the game is recording.
     * This list should be maintained a structure of first-tower-then-monster, i.e.
     * | Tower1 | Tower2 | Tower3 | Monster1 | Monster 2 | Monster 3 | Monster 4 |
     * There is no additional requirement for ordering the towers or ordering monsters, i.e.
     * the above list can also be recorded in your implementation as
     * | Tower3 | Tower1 | Tower2 | Monster4 | Monster3 | Monster 1 | Monster 2 |
     * 
     * 
     */
    List<Block> blocks;
    /**
     * A "View" so that it display the content to user and also take input from users.
     * The display should interact with Game properly. 
     */
    private Displayable display;
    /**
     * The constructor of the game
     */
    public Game(Displayable display) {
        this.blocks = new ArrayList<Block>();

        this.display=display;
        this.money=10;
        //TODO

    }
    /**
     * This governs the main logic of the game. 
     * This method has been done for you. 
     * You should not modify this method.
     * You are not allowed to modify this method.
     */
    public void run() {
        blocks.add(new Monster(ThreadLocalRandom.current().nextInt(0, HEIGHT), 0, 10)); //increase HP per each 3 turn

        for (int turn = 0; !gameOver(); turn++) {
            //1. User input
            display.display();
            display.userInput();
            //2. Block moves
            for (Block b: blocks) {
                b.action((blocks));
            }
            //3. Clean up towers and monsters
            for (int i = blocks.size() - 1; i >= 0 ; i--) {
                Block b = blocks.get(i);
                if (!b.isToRemove())
                    continue;
                if (b instanceof Monster) {
                    money += 5;
                    score++;
                }
                blocks.remove(b);
            }
            //4. Generate new monsters
            int row = ThreadLocalRandom.current().nextInt(0, HEIGHT);
            blocks.add(new Monster(row, 0, 10 + 2 * (turn / 3))); //increase 2 HP per each 3 turn
        }
        display.gameOver();
    }

    /**
     * Check if any monster reaches "Home".
     */
    private boolean gameOver() {
        for(int i=0;i< blocks.size();i++){
            if(blocks.get(i)instanceof Monster&&blocks.get(i).getCol()==12){
                return true;
            }
        }
        //TODO
    return false;}

    /**
     * Getter for score
     */
    public int getScore() {
        return this.score;
        //TODO
    }
    /**
     * Getter for money
     */
    public int getMoney() {
        return this.money;
        //TODO
    }
    /**
     * Given a coordinate return the block at that position.
     * 
     * If there is no block is located at that position, return null
     * According to the game logic, there will be only one tower
     * or monster on a block at each time.
     * 
     * @param row - row 
     * @param col - column
     * @return - return the block which at that position.
     */
    public Block getBlockByLocation(int row, int col) {
        for (int i=0;i< blocks.size();i++){
            if(blocks.get(i).getRow()==row&&blocks.get(i).getCol()==col){
                if(blocks.get(i)instanceof Monster){
                    System.out.println("----------------");
                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){

                            b[r][c]=' ';


                        }
                    }

                    for(int r=0;r<blocks.size();r++){
                    b[blocks.get(r).getRow()][blocks.get(r).getCol()]=blocks.get(r).getSymbol();


                }

                for(int r=0;r<b.length;r++){
                    for(int c=0;c<b[r].length;c++){


                        System.out.print(b[r][c]);


                    }System.out.print("oooo");
                    System.out.println();
                }}
                if(blocks.get(i) instanceof CatapultTower){
                    System.out.println("----------------");

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){

                            b[r][c]=' ';


                        }
                    }
                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){
                            if(((CatapultTower) blocks.get(i)).isInRange(r,c)==true){
                                b[r][c]='#';
                                b[blocks.get(i).getRow()][blocks.get(i).getCol()]=blocks.get(i).getSymbol();
                            }}}
                    for(int r=0;r<blocks.size();r++){
                        b[blocks.get(r).getRow()][blocks.get(r).getCol()]=blocks.get(r).getSymbol();


                    }

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){


                            System.out.print(b[r][c]);


                        }System.out.print("oooo");
                        System.out.println();
                    }

                }
                if(blocks.get(i) instanceof ArcheryTower){
                    System.out.println("----------------");

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){

                            b[r][c]=' ';


                        }
                    }
                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){
                            if(((ArcheryTower) blocks.get(i)).isInRange(r,c)==true){
                                b[r][c]='#';
                                b[blocks.get(i).getRow()][blocks.get(i).getCol()]=blocks.get(i).getSymbol();
                            }}}
                    for(int r=0;r<blocks.size();r++){
                        b[blocks.get(r).getRow()][blocks.get(r).getCol()]=blocks.get(r).getSymbol();


                    }

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){


                            System.out.print(b[r][c]);


                        }System.out.print("oooo");
                        System.out.println();
                    }

                }
                if(blocks.get(i) instanceof LaserTower){
                    System.out.println("----------------");

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){

                            b[r][c]=' ';


                        }
                    }
                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){
                            if(((LaserTower) blocks.get(i)).isInRange(r,c)==true&&blocks.get(i).getRow()==r&&blocks.get(i).getCol()>c){
                                b[r][c]='#';
                                b[blocks.get(i).getRow()][blocks.get(i).getCol()]=blocks.get(i).getSymbol();
                            }}}
                    for(int r=0;r<blocks.size();r++){
                        b[blocks.get(r).getRow()][blocks.get(r).getCol()]=blocks.get(r).getSymbol();


                    }

                    for(int r=0;r<b.length;r++){
                        for(int c=0;c<b[r].length;c++){


                            System.out.print(b[r][c]);


                        }System.out.print("oooo");
                        System.out.println();
                    }

                }


                return blocks.get(i);
            }
        }return null;
        //TODO
    }

    /**
     * Called from Display to build a tower. 
     * Please note that a tower cannot be built
     * - on column 0;
     * - on a monster;
     * - on another tower; or
     * - if insufficient money.
     * 
     * @param tower - which tower. 1 = ArcheryTower; 2 = LaserTower; 3 = CatapultTower
     * @param row - which row to build
     * @param col - which column to build
     * 
     * @return true if success, false if fail. Fail can be due to incorrect coordinate 
     * (out-of-bound/build on a monster/build on another tower..) or insufficient money.
     */
    public boolean build(int tower, int row, int col) {
        boolean place=false;
        int count=0;
        Monster gg;
        Tower yy;
        int pen=0;

            if (tower == 1 && col != 0 && row >= 0 && row <= HEIGHT && col >= 1 && col <= WIDTH - 1 && b[row][col] == ' '&&money>=5) {
                place=true;
                money=money-5;
                blocks.add(0,new ArcheryTower(row,col,5,5,2,1,3));

                return place;
            }
            else if(tower == 2 && col != 0 && row >= 0 && row <= HEIGHT && col >= 1 && col <= WIDTH - 1 && b[row][col] == ' '&&money>=7){
                place=true;
                money=money-7;
                blocks.add(0,new LaserTower(row,col,4,7,3,2,99));
                return place;
            } else if(tower == 3 && col != 0 && row >= 0 && row <= HEIGHT && col >= 1 && col <= WIDTH - 1 && b[row][col] == ' '&&money>=7){
                place=true;
                money=money-7;
                blocks.add(0,new CatapultTower(row,col,4,7,3,2,6));
                return place;}


        return place;
        //TODO
    }

    /**
     * Called from Display to upgrade a tower.
     * 
     * @param row - the row of the tower be upgraded
     * @param col - the column of the tower be upgraded 
     * @return - true if upgrade is success, false if fail. 
     * Fail can be due to incorrect position or insufficient money.
     */
    public boolean upgrade(int row, int col) {
        boolean place=false;
        if(b[row][col]=='C'&&money>=3){
            for(int i=0;i< blocks.size();i++){
                if (blocks.get(i).getRow()==row&&blocks.get(i).getCol()==col&&blocks.get(i)instanceof Tower){
                    place=true;
                    ((Tower)blocks.get(i)).upgrade();
                    money=money-3;
                    return place;
                }

            }} else if(b[row][col]=='L'&&money>=3){
                for(int i=0;i< blocks.size();i++){
                    if (blocks.get(i).getRow()==row&&blocks.get(i).getCol()==col&&blocks.get(i)instanceof Tower){
                        place=true;
                        ((Tower)blocks.get(i)).upgrade();
                        money=money-3;
                        return place;
                    }

                }

        }
           else if(b[row][col]=='A'&&money>=2){
                for(int i=0;i< blocks.size();i++){
                    if (blocks.get(i).getRow()==row&&blocks.get(i).getCol()==col&&blocks.get(i)instanceof Tower){
                        place=true;
                        ((Tower)blocks.get(i)).upgrade();
                        money=money-2;
                        return place;
                    }

                }}
    return place;}
}
