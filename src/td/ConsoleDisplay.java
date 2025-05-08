package td;

import java.util.Scanner;

import td.monster.Monster;
import td.tower.*;

/**
 * A View class. To display the information on screen and also 
 * to take user's control.
 */
public class ConsoleDisplay implements Displayable {
    /**
     * The controller object game.
     */
    protected Game game;

    /**
     * Entry point. Don't touch
     */
    public static void main(String[] args) {
        new ConsoleDisplay();
    }

    /**
     * Constructor. To construct the game object and call game.run();
     */
    public ConsoleDisplay() {
        this.game = new Game(this);
        game.run();
    }

    /**
     * To display the score, money, map and character on screen.
     */
    @Override
    public void display() {
        System.out.println("Score:"+game.getScore()+"|"+"Money:"+game.getMoney());
        System.out.println();
        System.out.println("----------------");

        for(int i=0;i<game.b.length;i++){
            for(int j=0;j<game.b[i].length;j++){

                game.b[i][j]=' ';


            }
        }
        for(int i=0;i<game.blocks.size();i++){
            game.b[game.blocks.get(i).getRow()][game.blocks.get(i).getCol()]=game.blocks.get(i).getSymbol();


        }

        for(int i=0;i<game.b.length;i++){
            for(int j=0;j<game.b[i].length;j++){

                System.out.print(game.b[i][j]);


        }System.out.print("oooo");
            System.out.println();
        }
        //TODO
    }
    /**
     * To accept user input (build tower, upgrade tower, view blocks).
     * 
     * This method has been done for you.
     * You should not modify it.
     * You are not allowed to modify it.
     */
    @Override
    public void userInput() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            printInstruction();
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        option1();
                        break;
                    case 2:
                        option2();
                        break;
                    case 3:
                        option3();
                        break;
                    case 4:
                        return;
                    default:
                        throw new InvalidInputException("Invalid option! Pick only 1-4");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            display();
        }
    }

    /**
     * Given method.
     * 
     * You are not supposed to change this method.
     * But you can change if you wish.
     */
    private void printInstruction() {
        System.out.println("Please pick one of the following: ");
        System.out.println("1. View a tower/monster");
        System.out.println("2. Build a new Tower");
        System.out.println("3. Upgrade a Tower");
        System.out.println("4. End a turn");
    }
    public void gameOver(){
        System.out.println("Game Over");

    }
    public void option1(){
        System.out.println("Enter the coordinate of the tower/monster row followed by column");
        Scanner why=new Scanner(System.in);
        Scanner out=new Scanner(System.in);
        int w=why.nextInt();
        int o=why.nextInt();
        System.out.println(game.getBlockByLocation(w,o).toString());
    }
    public void option2(){
        Scanner why=new Scanner(System.in);
        Scanner out=new Scanner(System.in);
        Scanner t=new Scanner(System.in);
        System.out.println("You can build the following towers:");
        System.out.println("1.ArcheryTower($5);2.LaserTower($7);3.CatapultTower($7)");
        int wh=why.nextInt();
        System.out.println("Which row?");
        int ou=out.nextInt();
        System.out.println("Which column");
        int tt=t.nextInt();
        if(game.build(wh,ou,tt)==false){
            System.out.println("Sorry,the option is invalid.Please check if you have enough money.You can only build on a cell without any monster or tower");
            System.out.println(".You cannot build on column 0 too!");


        }

    }
    public void option3(){
        Scanner why=new Scanner(System.in);
        Scanner out=new Scanner(System.in);
        System.out.print("Enter the row of your tower:");
        int wh= why.nextInt();
        System.out.println();
        System.out.print("Enter the column of your tower");
        int t= out.nextInt();
        System.out.println();
        if(game.upgrade(wh,t)==false){
            System.out.println("Sorry,the option is invalid.Please check if you have engouh money to upgrade and there is already a tower for you to");
            System.out.println("upgrade");
        }

    }


    //TODO
}
