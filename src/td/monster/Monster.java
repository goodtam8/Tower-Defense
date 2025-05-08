package td.monster;

import td.Block;
import td.tower.Tower;


import java.util.List;

/**
 * Monster class.
 * 
 * On each turn it moves to the right by one cell. If it steps on 
 * a tower (i.e., share the same coordinate as the tower), the tower
 * will be destroyed.
 * 
 * A monster reaches home will end the game. 
 * 
 * If a monster has health point 0 or negative, it cannot move anymore
 * and shall be removed from the game.
 * 
 * A monster shall return the last digit of its health as its symbol.
 * For example, if a monster has a health 10, it should return the character '0'
 * If a monster has a health of 31, it should return the character '1'
 * 
 * 
 * There are some methods to be included in this class. Yet, you need to 
 * deduce what methods are needed from other java files.
 * 
 * 
 */
public class Monster extends Block {

    private  int life;
    public Monster(int row,int col,int hp){
        super(row ,col);
        life=hp;

    }
    public void setLife(int b){
        this.life=b;

    }
    public int getLife(){
        return this.life;
    }
    public String toString(){
        return "Monster " + getSymbol() + " [" + getLife() + " ] " ;
    }

    @Override
    public  char getSymbol() {
        String s=String.valueOf(life);
        char yy=s.charAt(s.length()-1);
        return yy;
    }
    public void action(List<Block> blocks) {
        if (this instanceof Monster&&this.getLife()>0) {
            super.col++;

        }
        for(int j=0;j< blocks.size();j++){
            if (blocks.get(j).getCol()==this.getCol()&&blocks.get(j) instanceof Tower&&blocks.get(j).getRow()==this.getRow())
                blocks.get(j).remove();

        }
    }


    //TODO
}
