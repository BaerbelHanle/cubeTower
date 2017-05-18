package cubeTower;

import java.util.ArrayList;

/**
 * Main-Klasse
 */
public class Main {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        System.out.println("==========================================");
        System.out.println("                  TEST 1");
        Cube cube1 = new Cube("blau",
                "rot", "grün", "grün", "gelb",
                "gelb");
        Cube cube2 = new Cube("rot",
                "grün", "gelb", "rot", "blau",
                "rot");
        Cube cube3 = new Cube("blau",
                "gelb", "rot", "blau", "grün",
                "gelb");
        Cube cube4 = new Cube("rot",
                "blau", "blau", "gelb", "rot",
                "grün");
        ArrayList cubes = new ArrayList<>();
        cubes.add(cube1);
        cubes.add(cube2);
        cubes.add(cube3);
        cubes.add(cube4);
        Tower tower = new Tower(cubes);
        tower.rotate();
        tower.printSolutions();
    }

    public static void test2() {
        System.out.println("==========================================");
        System.out.println("                  TEST 2");
        Cube cube1 = new Cube("gelb",
                "grün", "grün", "blau", "rot",
                "gelb");
        Cube cube2 = new Cube("blau",
                "rot", "rot", "rot", "gelb",
                "grün");
        Cube cube3 = new Cube("gelb",
                "rot", "blau", "gelb", "grün",
                "blau");
        Cube cube4 = new Cube("blau",
                "rot", "rot", "blau", "grün",
                "gelb");
        ArrayList cubes = new ArrayList<>();
        cubes.add(cube1);
        cubes.add(cube2);
        cubes.add(cube3);
        cubes.add(cube4);
        Tower tower = new Tower(cubes);
        tower.rotate();
        tower.printSolutions();
    }

    public static void testsWithNumbers() {
        /*
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
        /*
        Cube cube5 = new Cube(1, 2, 3, 0, 2, 1);
        Cube cube6 = new Cube(1, 1, 0, 3, 0, 1);
        Cube cube7 = new Cube(1, 1, 1, 1, 1, 1);
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


        */
        //TODO: check what to do is cube is equal to itself
        //Tower tower = new Tower(cubes);

        //tower.rotate();
        //tower.printSolutions();
        /*
        // "rot", "blau", "gruen", "gelb"
        //   0      1        2       3
        //gelb grun grun blau rot gelb
        Cube c1 = new Cube(3, 2, 2, 1, 0, 3);
        //blau rot rot rot gelb grun
        Cube c2 = new Cube(1, 0, 0, 0, 3, 2);
        // gelb rot blau gelb grun blau
        Cube c3 = new Cube(3, 0, 1, 3, 2, 1);
        //blau rot rot blau grun gelb
        Cube c4 = new Cube(1, 0, 0, 1, 2, 3);
        ArrayList<Cube> cus = new ArrayList<>();
        cus.add(c1);
        cus.add(c2);
        cus.add(c3);
        cus.add(c4);
        Tower to = new Tower(cus);
        to.rotate();
        to.printSolutions();
        */
    }


}
