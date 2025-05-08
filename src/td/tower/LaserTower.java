package td.tower;

import td.Block;
import td.monster.Monster;

import java.util.List;

/**
 * Laser Tower
 * <p>
 * A Laser tower can shoot all monsters on its left (whose has a
 * smaller col than the tower) on the same row.
 * <p>
 * All monster will receive the same number of damage.
 * <p>
 * Propoerty of laser tower:
 * Symbol : 'L'
 * Inital power: 4
 * Range : N/A (you can place any value here)
 * cost : 7
 * upgrade power: 2
 * upgrade cost: 3
 */
public class LaserTower extends Tower {
    private final char symbol = 'L';
    private int range;

    public LaserTower(int row, int col, int power, int cost, int upgradeCost, int upgradePower, int range) {
        super(row, col, power, cost, upgradeCost, upgradePower, range);
        this.range = range;
    }
    public boolean isInRange(int b,int c) {
        return this.distance(b,c) <= range;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    public void action(List<Block> blocks) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getCol() < this.getCol() && this.getRow() == blocks.get(i).getRow()&&blocks.get(i)instanceof Monster) {
                ((Monster) blocks.get(i)).setLife(((Monster) blocks.get(i)).getLife() - super.getPower());


            }
            if (blocks.get(i) instanceof Monster && ((Monster) blocks.get(i)).getLife() <= 0) {
                blocks.get(i).remove();
            }
        }

    }
    //TODO
}
