package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Solution{

    private ArrayList<int[]> solutionMatrix; // int[] speichert die Ansicht von einer Seite

    public Solution (Tower tower){

        solutionMatrix = new ArrayList<>();

        int[] side1 = new int[4];
        int[] side2 = new int[4];
        int[] side3 = new int[4];
        int[] side4 = new int[4];

        for( int j = 0; j < 4; j++ ){
            side1[j] = tower.getCubes().get(j).getActualSideToRotate().get(0);
            side2[j] = tower.getCubes().get(j).getActualSideToRotate().get(1);
            side3[j] = tower.getCubes().get(j).getActualSideToRotate().get(2);
            side4[j] = tower.getCubes().get(j).getActualSideToRotate().get(3);
        }

        solutionMatrix.add(side1);
        solutionMatrix.add(side2);
        solutionMatrix.add(side3);
        solutionMatrix.add(side4);

    }


    public ArrayList<int[]> getSolutionMatrix() {
        return solutionMatrix;}

    public boolean isNewSolution(Solution solutionToCompare){

        int rotationCounter = 0;

        while(rotationCounter < 4){
            if(!sidesDifferent(solutionToCompare)){
                return false;
            }else{
                rotationCounter++;
                solutionToCompare.rotate();
            }
        }

        return true;
    }

    public boolean sidesDifferent(Solution solutionToCompare){

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(solutionToCompare.getSolutionMatrix().get(i)[j] != solutionMatrix.get(i)[j]){
                    return true;
                }
            }
        }

        return false;
    }


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


    public void rotate(){
        solutionMatrix.add(solutionMatrix.get(0));
        solutionMatrix.remove(0);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                sb.append(solutionMatrix.get(j)[i] + ", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
