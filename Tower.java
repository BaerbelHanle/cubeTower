package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Tower {

    private ArrayList<Cube> cubes;

    public Tower(ArrayList<Cube> cubes) {
        this.cubes = cubes;
    }

    public ArrayList<Cube> getCubes() {
        return cubes;
    }
}
