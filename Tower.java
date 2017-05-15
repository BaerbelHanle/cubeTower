package cubeTower;

import java.util.ArrayList;

/**
 * Die Representation eines Turms, die aus vier Würfel entsteht.
 */
public class Tower {
    /**
     * Die Wuerfel des Turms.
     */
    private ArrayList<Cube> cubes;
    /**
     * Alle rotationsinvariantefreie Loesungen fuer diesen Turm, die durch die Mantelflaeche eines Turms representiert sind.
     */
    private ArrayList<Solution> solutions;

    /**
     * Konstruktor fuer den Turm.
     * @param cubes ArrayList von den Wuerfel, die zu dem Turm gehören.
     */
    public Tower(ArrayList<Cube> cubes) {
        this.cubes = cubes;
        solutions = new ArrayList<>();
    }

    /**
     * Ueberpruerft ob die Loesung die einzige ist und falls ja, fuegt sie zu den Loesungen der Aufgabe.
     */
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

    /**
     * Getter fuer die Wuerfel
     * @return ArrayList von Wuerfeln
     */
    public ArrayList<Cube> getCubes() {
        return cubes;
    }

    /**
     * Start-Methode fuer die Rotation des Turmes, die einen rekursiven Lauf des Programms startet.
     */
    public void rotate() {
        rotateRecursive(0);
    }

    /**
     * Man rotiert erstmal 0. Wuerfel so, dass er alle moegliche Positionen annimt, dann fuer jeden 0. Wuerfel rotiert man 1. durch alle Positionen usw.
     * Nach der Rotation des naechsten Wuerfels prueft man, ob es ueberhaupt noetig ist,
     * weitere Wuerfel des Turms zu rotieren (ob schon die ersten Wuerfels passen).
     * Wenn 4. (letzter) Wuerfel rotiert ist, ueberprueft man, ob die folgende Turmstellung eine gueltige Loesung ist.
     * @param indexOfCube Nummer des Wuerfels im Turm
     */
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

    /**
     * Ueberprueft, ob alle Wuerfel an den Seiten verschiedene Farben haben.
     * @return true, falls es eine gueltige Loesung ist
     */
    private boolean isValidTower(){
        for (Cube cube: cubes){
            if (!cube.sidesDifferent(cubes)){
                return false;
            }
        }
        return true;
    }

    /**
     * Ueberprueft, ob die Wuerfel, die schon rotiert werden, fuer die Loesung passen
     * @param indexOfCube nummer des Wuerfels im Turm
     * @return true, falls gueltige Loesung
     */
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

    /**
     * Druckt alle Loesungen aus.
     */
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
