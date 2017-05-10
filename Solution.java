package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Solution{//} implements Comparable{

    private ArrayList<int[]> solutionMatrix; // int[] speichert die ansicht einer Seite

    public Solution (Tower tower){

        solutionMatrix = new ArrayList<>();

        int[] side = new int[4];

        for( int i = 0; i < 4; i++ ){
            for( int j = 0; j < 4; j++ ){
                side[i] = tower.getCubes().get(j).getActualSideToRotate().get(i);
            }
            solutionMatrix.add(side);
        }

    }

    /*
    //private ArrayList<int[]> solutionMatrix = new ArrayList<>();// = new int[4][4];
    private ArrayList<ArrayList<Integer>> solutionMatrix = new ArrayList<>();

    public Solution(Tower tower){

        Cube cube;
        ArrayList<Integer> sides;
        int side;

        for(int j = 0; j < 4; j++){

            cube = tower.getCubes().get(j);
            sides = cube.getSidesToRotate().get(cube.getAxisIndex());

            for(int i = 0; 0 < 4; i++){
                side = sides.get(i);
                solutionMatrix.get(i).add(side);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getSolutionMatrix() {
        return solutionMatrix;
    }

    /*
    public ArrayList<int[]> getSolutionMatrix() {
        return solutionMatrix;
    }
    */

    /*
    private boolean isNewSolution(Solution solutionToCompare){
        for(int i = 0; i < 4; i++){
            solutionToCompare.rotate();
            if(solutionToCompare.compareTo(this) == 0){
                return false;
            }
        }
        return true;
    }
    */

    /*
    public boolean isNewSolution(ArrayList<Solution> solutionsToCompare){
        for(Solution solutionToCompare : solutionsToCompare){
            if(!isNewSolution(solutionToCompare)){
                return false;
            }
        }
        return true;
    }
    */

    /*
    private void rotate(){
        solutionMatrix.add(solutionMatrix.get(0));
        solutionMatrix.remove(0);
    }

    @Override
    public int compareTo(Object toCompare){

        Solution solutionToCompare = (Solution) toCompare;

        for(int i = 0; i < 4; i++){
            if(!solutionToCompare.getSolutionMatrix().get(i).equals(solutionMatrix.get(i))){
                return -1;
            }
        }

        return 0;

    }
    */

}
