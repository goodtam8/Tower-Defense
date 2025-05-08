package td.tower;

import td.Block;
import td.monster.Monster;

import java.util.List;

/**
 * Catapult
 * 
 * A catapult works in the following way. It will target on
 * one monster among all monsters that are in range. When there
 * are more than one monsters in range, pick ANY monster with 
 * highest remaining health point.
 * 
 * Then, it hits the target monster and other monsters located in
 * its 8 neighthor adjacent cells. For example,
 * ----------------------
 * | a | b | c | e |
 * | d | f | g | h |
 * | i | j | k | l |  ...
 * | m | n | o | p |
 * ----------------------
 * * If g is the target monster, monsters <b, c, e, f, g, h, j, k, l>
 * will receive damage.
 * * If m is the target monster, monsters <i, j, m, n>
 * will receive damage.
 * 
 * Note: In the first example, even if monster b is out of the range 
 * of the Tower, as long as Tower can hit g, b will also receive damage.
 * 
 * Propoerty of Catapult:
 * Symbol : 'C'
 * Inital power: 4
 * Range : 6
 * cost : 7
 * upgrade power: 2 
 * upgrade cost: 3
 * 
 */
public class CatapultTower extends Tower {
    private final char symbol='C';
    private int range;
    public CatapultTower(int row, int col, int power, int cost, int upgradeCost, int upgradePower, int range){
        super(row, col, power, cost, upgradeCost, upgradePower, range);
        this.range=range;
    }
    public boolean isInRange(int b,int c) {
        return this.distance(b,c) <= range;
    }


    @Override
    public char getSymbol() {
        return symbol;
    }
    public void action(List<Block> blocks){
        int max=0;
        int stat=-1;
        for(int i=0;i< blocks.size();i++){
            if(blocks.get(i) instanceof Monster&&this.isInRange(blocks.get(i))==true){
                max=((Monster) blocks.get(i)).getLife();
                stat=i;
                break;

            }
        }
        for(int i=0;i< blocks.size();i++){
            if(this.isInRange(blocks.get(i))==true&&blocks.get(i) instanceof Monster){

                if(max<((Monster) blocks.get(i)).getLife()){
                    max=((Monster) blocks.get(i)).getLife();
                    stat=i;
                }}}
        if(stat!=-1){
            System.out.println(blocks.get(stat).toString());

            ((Monster)blocks.get(stat)).setLife(((Monster)blocks.get(stat)).getLife()-super.getPower());
            for(int i=0;i<blocks.size();i++){
            if(blocks.get(stat).getCol()+1==blocks.get(i).getCol()&&blocks.get(stat).getRow()==blocks.get(i).getRow()&&//check left
            blocks.get(i) instanceof Monster){
                ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());

            }
                if(blocks.get(stat).getRow()+1==blocks.get(i).getRow()&&blocks.get(stat).getCol()==blocks.get(i).getCol()&&//check down
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
            }
                if(blocks.get(stat).getCol()-1==blocks.get(i).getCol()&&blocks.get(stat).getRow()==blocks.get(i).getRow()&&//check right
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());

                }
                if(blocks.get(stat).getRow()-1==blocks.get(i).getRow()&&blocks.get(stat).getCol()==blocks.get(i).getCol()&&//check up
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
                }
                if(blocks.get(stat).getRow()+1==blocks.get(i).getRow()&&blocks.get(stat).getCol()+1==blocks.get(i).getCol()&&//check down
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
                }
                if(blocks.get(stat).getRow()-1==blocks.get(i).getRow()&&blocks.get(stat).getCol()-1==blocks.get(i).getCol()&&//check down
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
                }
                if(blocks.get(stat).getRow()+1==blocks.get(i).getRow()&&blocks.get(stat).getCol()-1==blocks.get(i).getCol()&&//check down
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
                }
                if(blocks.get(stat).getRow()-1==blocks.get(i).getRow()&&blocks.get(stat).getCol()+1==blocks.get(i).getCol()&&//check down
                        blocks.get(i) instanceof Monster){
                    ((Monster)blocks.get(i)).setLife(((Monster)blocks.get(i)).getLife()-super.getPower());
                }
            }}








        for(int i=0;i< blocks.size();i++){

            if(blocks.get(i) instanceof Monster&&((Monster)blocks.get(i)).getLife()<=0){
                blocks.get(i).remove();
            }
        }

    }}