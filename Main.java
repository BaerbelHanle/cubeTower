package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        // "rot", "blau", "gruen", "gelb"
        //   0      1        2       3
        // blau, rot, grün, grün, gelb, gelb
        Cube cube1 = new Cube(1, 0, 2, 2, 3, 3);
        // rot, grün, gelb, rot, blau, rot
        Cube cube2 = new Cube(0, 2, 3, 0, 1, 0);
        //blau, gelb, rot, blau, grün, gelb
        Cube cube3 = new Cube(1, 3, 0, 1, 2, 3);
        // rot, blau, blau, gelb, rot, grün
        Cube cube4 = new Cube(0, 1, 1, 3, 0, 2);
        ArrayList<Cube> cubes = new ArrayList<>();
        cubes.add(cube1);
        cubes.add(cube2);
        cubes.add(cube3);
        cubes.add(cube4);

        /*
        System.out.println(cube1.sidesDifferent(cubes));
        System.out.println(cube1.sidesDifferent(cube1));
        System.out.println(cube1.sidesDifferent(cube3));
        */

        //side2, side3, side5, side4

        Cube cube5 = new Cube (1, 2, 3, 0, 2, 1);
        Cube cube6 = new Cube (1, 1, 0, 3, 0, 1);
        Cube cube7 = new Cube (1, 1, 1, 1, 1, 1);
        Cube cube8 = new Cube(1, 0, 2, 2, 3, 1);
        ArrayList<Cube> cubes2 = new ArrayList<>();
        cubes2.add(cube6);
        cubes2.add(cube7);
        cubes2.add(cube5);
        cubes2.add(cube8);
        Tower tower2 = new Tower(cubes2);
        System.out.println(cube5.sidesDifferent(cubes2));
        System.out.println(cube6.sidesDifferent(cubes2));
        System.out.println(cube7.sidesDifferent(cubes2));
        System.out.println(cube8.sidesDifferent(cubes2));

        System.out.println(tower2.isValidTower());

        //TODO: check what to do is cube is equal to itself
        Tower tower = new Tower(cubes);

        tower.rotate();
        tower.printSolutions();

    }


}
