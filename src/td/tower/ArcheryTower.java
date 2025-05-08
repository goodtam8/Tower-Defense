package td.tower;

import td.Block;
import td.monster.Monster;

import java.util.List;

/**
 * Archery 
 * 
 * The archery tower will aim only one monster that has positive, non-zero 
 * health point. If there are multiple monster that are in range,
 * pick the one that is nearest to "home".
 * 
 * Propoerty of Archery tower:
 * Symbol : 'A'
 * Inital power: 5
 * Range : 3
 * cost : 5
 * upgrade power: 1 
 * upgrade cost: 2
 */
public class ArcheryTower extends Tower {
    private final char symbol='A';
    private int range;
    public ArcheryTower(int row, int col, int power, int cost, int upgradeCost, int upgradePower, int range){
        super(row, col, power, cost, upgradeCost, upgradePower, range);
        this.range=range;

    }


    @Override
    public char getSymbol() {
        return symbol;
    }
    public boolean isInRange(int b,int c) {
        return distance(b,c) <= range;
    }

    public void action(List<Block> blocks){
        int max=0;
        int stat=-1;
        for(int i=0;i< blocks.size();i++){
            if(blocks.get(i) instanceof Monster&&this.isInRange(blocks.get(i))==true&&blocks.get(i).isToRemove()==false){
                 max=blocks.get(i).getCol();
                 stat=i;
                break;

            }
        }
        for(int i=0;i< blocks.size();i++){
            if(this.isInRange(blocks.get(i))==true&&blocks.get(i) instanceof Monster&&blocks.get(i).isToRemove()==false){

                if(max<blocks.get(i).getCol()){
                    max=blocks.get(i).getCol();
                    stat=i;
        }}}
if(stat!=-1){
    System.out.println(blocks.get(stat).toString());

    ((Monster)blocks.get(stat)).setLife(((Monster)blocks.get(stat)).getLife()-super.getPower());}







        for(int i=0;i< blocks.size();i++){

if(blocks.get(i) instanceof Monster&&((Monster)blocks.get(i)).getLife()<=0){
    blocks.get(i).remove();
}
        }

    }}
//TODO

