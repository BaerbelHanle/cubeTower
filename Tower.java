package cubeTower;

import java.util.ArrayList;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Tower {

    private ArrayList<Cube> cubes;
    private ArrayList<Solution> solutions;

    public Tower() {
        cubes = new ArrayList<>();
        solutions = new ArrayList<>();
    }

    public Tower(ArrayList<Cube> cubes) {
        this.cubes = cubes;
        solutions = new ArrayList<>();
    }

    public void addCube(Cube cube) {
        cubes.add(cube);
    }

    //TODO: check logic
    private void addSolutionIfUnique() {
        Solution possibleSolution = new Solution(this);
        if (solutions.isEmpty()){
            solutions.add(possibleSolution);
        } else {
            if (possibleSolution.isNewSolution(solutions)){
                solutions.add(possibleSolution);
            }
        }
    }

    public ArrayList<Cube> getCubes() {
        return cubes;
    }

    public ArrayList<Solution> getSolutions(){
        return solutions;
    }

    public void rotate() {
        rotateRecursive(0);
    }

    private void rotateRecursive(int indexOfCube) {
        if (indexOfCube >= 4) {
            if (isValidTower()){
                addSolutionIfUnique();
            }

        } else {
            for (int i = 0; i < 24; i++) {
                cubes.get(indexOfCube).rotate();
                if (furtherRotationsMakeSense(indexOfCube)){
                    rotateRecursive(indexOfCube+1);
                }
            }
        }
    }

    private boolean isValidTower(){
        for (Cube cube: cubes){
            if (!cube.sidesDifferent(cubes)){
                return false;
            }
        }
        return true;
    }

    private boolean furtherRotationsMakeSense(int indexOfCube){
        Cube currentCube = cubes.get(indexOfCube);
        if (indexOfCube == 0){
            return true;
        } else if(indexOfCube==1){
            if (currentCube.sidesDifferent(cubes.get(0))){
                return true;
            } else {
                return false;
            }
        } else {
            ArrayList<Cube> cubesToCompare = new ArrayList<>();
            for (int i = 0; i<indexOfCube; i++){
                cubesToCompare.add(cubes.get(i));
            }
            for (int i =0; i<indexOfCube; i++){
                currentCube=cubesToCompare.get(i);
                if (!currentCube.sidesDifferent(cubesToCompare)){
                    return false;
                }
            }
            return true;
        }
    }

    public void printSolutions(){
        if (!solutions.isEmpty()) {
            int i=1;
            for (Solution solution : solutions) {
                System.out.println("=================SOLUTION=================");
                System.out.println(i++);
                System.out.println(solution.toString());
            }
        }
    }

}
