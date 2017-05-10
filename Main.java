package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Main {

    public static void main(String[] args){

        Cube cube1 = new Cube(0, 1, 0, 0, 0, 3);
        Cube cube2 = new Cube(2 , 3, 1, 1, 1, 0);
        Cube cube3 = new Cube(3 , 0, 2, 2, 2, 0);
        Cube cube4 = new Cube(0,0,1,1,3,3);

        ArrayList<Cube> cubes1 = new ArrayList<>();
        ArrayList<Cube> cubes2 = new ArrayList<>();
        ArrayList<Cube> cubes3 = new ArrayList<>();

        cubes1.add(cube1);
        cubes1.add(cube2);
        cubes1.add(cube3);
        cubes1.add(cube4);

        cubes2.add(cube1);
        cubes2.add(cube1);
        cubes2.add(cube3);
        cubes2.add(cube4);

        cubes3.add(cube1);
        cubes3.add(cube2);
        cubes3.add(cube3);
        cubes3.add(cube4);

        Tower tower1 = new Tower(cubes1);
        Tower tower2 = new Tower(cubes2);
        Tower tower3 = new Tower(cubes3);

        Solution solution1 = new Solution(tower1);
        Solution solution2 = new Solution(tower2);
        Solution solution3 = new Solution(tower3);

        System.out.println(solution1);

        /*
        System.out.println(solution1.compareTo(solution2));
        System.out.println(solution1.compareTo(solution3));
        */

        /*
        ArrayList<Cube> cubesToCompare = new ArrayList<>();
        cubesToCompare.add(cube2);
        cubesToCompare.add(cube3);


        System.out.println(cube1.toString());
        System.out.println(cube2.toString());
        System.out.println(cube3.toString());
        System.out.println();

        //System.out.println(cube1.sidesDifferent(cube2));
        System.out.println(cube1.sidesDifferent(cubesToCompare));
        System.out.println();

        cube2.rotate();

        System.out.println(cube1.toString());
        System.out.println(cube2.toString());
        System.out.println(cube3.toString());
        System.out.println();

        //System.out.println(cube1.sidesDifferent(cube2));
        System.out.println(cube1.sidesDifferent(cubesToCompare));
        System.out.println();
*/



        /*
        for(int i = 0; i < 24; i++) {

            System.out.println("" + i + ": " + cube.toString());
            System.out.println();

            cube.rotate();
        }
        */

    }


}
