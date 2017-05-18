package cubeTower;

import java.util.ArrayList;

/**
 * Snapshot eines Wuerfelturms
 */
public class Solution {

    /**
     * Die ArrayList enthaelt die verschiendenen Seitenansichten
     */
    private ArrayList<int[]> solutionMatrix; // int[] speichert die Ansicht von einer Seite
    /**
     * dekodiert die Farben - nuetzlich fuer die toString-Methode
     */
    public static String[] colours = {"rot", "blau", "gruen", "gelb"};

    /**
     * Der Konstruktor konstruiert solutionMatrix aus einem Wuerfelturm
     * @param tower - der Wuerfelturm, der als Matrix dargestellt werden soll
     */
    public Solution(Tower tower) {

        solutionMatrix = new ArrayList<>();

        int[] side1 = new int[4];
        int[] side2 = new int[4];
        int[] side3 = new int[4];
        int[] side4 = new int[4];

        for (int j = 0; j < 4; j++) {
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

    /**
     * Getter fuer solutionMatrix
     * @return solutionMatrix
     */
    public ArrayList<int[]> getSolutionMatrix() {
        return solutionMatrix;
    }

    /**
     * ueberprueft, ob eine Loesung nur die Rotation einer anderen Loesung ist
     * @param solutionToCompare andereLoesung
     * @return true, falls die Loesung keine Rotation der anderen ist
     */
    public boolean isNewSolution(Solution solutionToCompare) {

        int rotationCounter = 0;

        while (rotationCounter < 4) {
            if (!sidesDifferent(solutionToCompare)) {
                return false;
            } else {
                rotationCounter++;
                solutionToCompare.rotate();
            }
        }

        return true;
    }

    /**
     * ueberprueft, ob zwei Loesungen in allen Seiten uebereinstimmen
     * @param solutionToCompare andere Loesung
     * @return true, falls jede Seite gleich ist
     */
    private boolean sidesDifferent(Solution solutionToCompare) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (solutionToCompare.getSolutionMatrix().get(i)[j] != solutionMatrix.get(i)[j]) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Ueberprueft, ob in der uebergebenen ArrayList von Loesungen eine rotationsinvariante dabei ist
     * @param solutionsToCompare ArrayList von Loesungen, die verglichen werden sollen
     * @return true, falls keine der uebergebenen Loesungen rotationsinvariant ist
     */
    public boolean isNewSolution(ArrayList<Solution> solutionsToCompare) {

        for (Solution solutionToCompare : solutionsToCompare) {
            if (!isNewSolution(solutionToCompare)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Hilfsfunktion fuer isNewSolution(Solution)
     * dreht einen Wuerfelturm
     */
    private void rotate() {
        solutionMatrix.add(solutionMatrix.get(0));
        solutionMatrix.remove(0);
    }

    /**
     * gibt die Farben an den Seiten des Wuerfelturms aus
     * @return Farben des Wuerfelturms als Matrix
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(colours[solutionMatrix.get(j)[i]] + "     \t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
