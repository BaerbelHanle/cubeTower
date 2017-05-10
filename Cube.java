package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Cube {

    //private int[] sides = new int[6];
    private ArrayList<ArrayList<Integer>> sidesToRotate;
    //private ArrayList<Integer> actualSideToRotate;
    private int axisIndex;
    private int sidePosition;
    public static String[] colours = {"rot", "blau", "gruen", "gelb"};


    public Cube(int side1, int side2, int side3, int side4, int side5, int side6){

        /*
        sides[0] = side1;
        sides[1] = side2;
        sides[2] = side3;
        sides[3] = side4;
        sides[4] = side5;
        sides[5] = side6;
        */

        sidesToRotate = new ArrayList<ArrayList<Integer>>();
        axisIndex = 0;
        sidePosition = 0;

        setSides(side2, side3, side5, side4);
        setSides(side1, side4, side6, side3);
        setSides(side1, side2, side6, side5);
        setSides(side1, side5, side6, side2);
        setSides(side1, side3, side6, side4);
        setSides(side2, side4, side5, side3);

        //actualSideToRotate = sidesToRotate.get(0);

    }


    public ArrayList<ArrayList<Integer>> getSidesToRotate() {
        return sidesToRotate;
    }

    public ArrayList<Integer> getActualSideToRotate() {
        return sidesToRotate.get(axisIndex);
    }

    public int getAxisIndex(){
        return axisIndex;
    }

    private void setSides(int colour1, int colour2, int colour3, int colour4){

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(colour1);
        list.add(colour2);
        list.add(colour3);
        list.add(colour4);

        sidesToRotate.add(list);

    }

    public void rotate(){

        if(sidePosition == 3){
            axisIndex++;
            sidePosition = 0;
            //actualSideToRotate = sidesToRotate.get(axisIndex);
        }else{
            rotate(sidesToRotate.get(axisIndex));
            sidePosition++;
        }

    }

    private void rotate(ArrayList<Integer> sides){
        sides.add(sides.get(0));
        sides.remove(0);
    }

    public boolean sidesDifferent(Cube cubeToCompare){

        for(int i = 0; i < 3; i++){
            if(cubeToCompare.getSidesToRotate().get(getAxisIndex()).get(i) == sidesToRotate.get(axisIndex).get(i)){
                return false;
            }
        }

        return true;
    }

    public boolean sidesDifferent(ArrayList<Cube> cubesToCompare){

        for(Cube cube : cubesToCompare){
            if(!sidesDifferent(cube)){
                return false;
            }
        }

        return true;
    }

    public String toString(){

        return  colours[sidesToRotate.get(axisIndex).get(0)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(1)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(2)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(3)];


    }

    /*
    public String toString(){

        return colours[sides[axisIndex]]+ "\n"
                + colours[sixSides.get(axisIndex).get(0)] + ", "
                + colours[sixSides.get(axisIndex).get(1)] + ", "
                + colours[sixSides.get(axisIndex).get(2)] + ", "
                + colours[sixSides.get(axisIndex).get(3)] + "\n"
                + colours[sides[5 - axisIndex]]+ "\n" ;


    }
    */
}


