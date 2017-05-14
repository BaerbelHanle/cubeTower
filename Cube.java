package cubeTower;

import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Created by Bärbel on 07.05.2017.
 */
public class Cube {

    //TODO: check how the colors are interpreted to ints by creation of a cube
    /**
     * Die inneren ArrayLists speichern alle möglichen Mantelflaechen.
     * Der Wuerfel hat 3 Achsen um die gedreht wird mit je 2 Orientierungen.
     * Zu jeder dieser orientierter Achsen gehoert eine Mantelflaeche, also die 4 Flaechen, durch die die Achse nicht geht im Drehsinn angeordnet.
     * Die 1. Seite der Mantelflaeche entspricht dann der Seite, die gerade nach vorne zeigt.
     */
    private ArrayList<ArrayList<Integer>> sidesToRotate;

    /**
     * axisIndex gibt den Index der aktuellen Drehachse an - entspricht einer Mantelflaeche aus sidesToRotate
     */
    private int axisIndex;

    /**
     * sidePosition gibt an, wie oft der Wuerfel um seine aktuelle Achse schon gedreht wurde
     */
    private int sidePosition;

    /**
     * Diese ArrayList stellt den Zusammenhang her zwischen den Farben auf dem Wuerfel und den int-Zahlen, die die Farben repraesentieren.
     * Wird fuer toString benoetigt
     */
    public static String[] colours = {"rot", "blau", "gruen", "gelb"};

    public Cube(String side1, String side2, String side3, String side4, String side5, String side6){
        sidesToRotate = new ArrayList<ArrayList<Integer>>();
        axisIndex = 0;
        sidePosition = 0;

        int _side1= colorToInt(side1);
        int _side2= colorToInt(side2);
        int _side3= colorToInt(side3);
        int _side4= colorToInt(side4);
        int _side5= colorToInt(side5);
        int _side6= colorToInt(side6);

        setSides(_side2, _side3, _side4, _side5);
        setSides(_side2, _side5, _side4, _side3);
        setSides(_side1, _side3, _side6, _side5);
        setSides(_side1, _side5, _side6, _side3);
        setSides(_side1, _side4, _side6, _side2);
        setSides(_side1, _side2, _side6, _side4);


        /* //Baerbel
        setSides(_side2, _side3, _side5, _side4);
        setSides(_side1, _side4, _side6, _side3);
        setSides(_side1, _side2, _side6, _side5);
        setSides(_side1, _side5, _side6, _side2);
        setSides(_side1, _side3, _side6, _side4);
        setSides(_side2, _side4, _side5, _side3);
        */

    }

    private Integer colorToInt(String side){
        if(side.toLowerCase().equals("rot")){
            return 0;
        } else if(side.toLowerCase().equals("blau")){
            return 1;
        } else if(side.toLowerCase().equals("gruen") || side.toLowerCase().equals("grün")){
            return 2;
        } else if(side.toLowerCase().equals("gelb")){
            return 3;
        } else {
            System.out.println("Die Farben passen leider nicht.");
            exit(0);
            return -1;
        }
    }

    /**
     * Der Konstruktor von Cube erstellt die Mantelflaechen eines Wuerfels mit den uebergebenen Farben.
     * außerden initialisert er axisIndex und sidePosition mit 0.
     *
     * @param side1 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 1 enthaelt
     * @param side2 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 2 enthaelt
     * @param side3 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 3 enthaelt
     * @param side4 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 4 enthaelt
     * @param side5 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 5 enthaelt
     * @param side6 Farbe (als int repraesentiert) auf der Seite des Wuerfels, die bei einem Standard-Spielwuerfel die 6 enthaelt
     */
    public Cube(int side1, int side2, int side3, int side4, int side5, int side6){

        sidesToRotate = new ArrayList<ArrayList<Integer>>();
        axisIndex = 0;
        sidePosition = 0;

        setSides(side2, side3, side5, side4);
        setSides(side1, side4, side6, side3);
        setSides(side1, side2, side6, side5);
        setSides(side1, side5, side6, side2);
        setSides(side1, side3, side6, side4);
        setSides(side2, side4, side5, side3);

    }

    /**
     * Hilfsfunktion fuer den Konstruktor
     * fuegt die Farben einer Mantelflaeche in dei entsprechende ArrayList ein
     *
     * @param colour1
     * @param colour2
     * @param colour3
     * @param colour4
     */
    private void setSides(int colour1, int colour2, int colour3, int colour4){

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(colour1);
        list.add(colour2);
        list.add(colour3);
        list.add(colour4);

        sidesToRotate.add(list);

    }

    /**
     * Getter fuer SidesToRotate
     *
     * @return sidesToRotate
     */
    public ArrayList<ArrayList<Integer>> getSidesToRotate() {
        return sidesToRotate;
    }

    /**
     * Gibt die Mantelflaeche zurueck, die gerade gedreht wird
     *
     * @return Mantelflaeche, die gerade gedreht wird
     */
    public ArrayList<Integer> getActualSideToRotate() {
        return sidesToRotate.get(axisIndex);
    }

    /**
     * Gibt den Index der Achse an, um die gerade gedreht wird
     *
     * @return
     */
    public int getAxisIndex(){
        return axisIndex;
    }

    /**
     * Abhaengig von axisIndex und sidePosition sorgt rotate() dafuer, dass der Wuerfel in eine Position gedreht wird, in der er noch nicht war.
     * Ueber 24-faches Aufrufen von rotate() laesst sich sicherstellen, dass ein Wuerfel alle moegliche Stellungen einnimmt.
     */
    public void rotate(){

        if(sidePosition == 4){
            sidePosition = 0;
            axisIndex++;
            if (axisIndex==6){
                axisIndex=0;
            }

        }else{
            rotate(sidesToRotate.get(axisIndex));
            sidePosition++;
        }

    }

    /**
     * Hilfsfunktion fuer rotate()
     * nimmt eine ArrayList und vertauscht ihre Elemente zyklisch, indem es das erste Element ans Ende verschiebt.
     *
     * @param sides Mantelflaeche, die zu der Achse gehoert, um die gerade gedreht wird
     */
    private void rotate(ArrayList<Integer> sides){
        sides.add(sides.get(0));
        sides.remove(0);
    }

    /**
     * vergleicht die aktuellen Seitenflächen zweier Wuerfel und gibt false zurueck, falls mindestens ein paar korrespondierender Seiten gleiche Farbe hat
     *
     * @param cubeToCompare anderer Wuerfel, mit dem verglichen werden soll
     * @return true falls alle Seiten verschieden
     */
    public boolean sidesDifferent(Cube cubeToCompare){

        if (this.equals(cubeToCompare)){
            return true;
        }
        for (int i = 0; i <= 3; i++) {
            int sideOne = cubeToCompare.getActualSideToRotate().get(i);
            int sideTwo = getActualSideToRotate().get(i);
            if (sideOne == sideTwo) {
                return false;
            }
        }
        /*
        System.out.println("====== NoT DIFFERENT: =============");
        System.out.println(toString());
        System.out.println(cubeToCompare.toString());
        */
        return true;
    }

    /**
     * vergleicht eine ArrayList von Wuerfeln mit diesem Wuerfel und gibt true zurueck, falls alle anderen Wuerfel auf allen Seiten andere Farben haben als dieser
     *
     * @param cubesToCompare ArrayList der Wuerfel, die auf Kompatibilitaet geprueft werden sollen
     * @return true, falls alle Seiten eine andere Farbe haben
     */
    public boolean sidesDifferent(ArrayList<Cube> cubesToCompare){

        for(Cube cube : cubesToCompare){
            if(!sidesDifferent(cube)){
                return false;
            }
        }

        return true;
    }

    /**
     * gibt die Farben der aktuelle Mantelflaeche als String zurueck
     *
     * @return aktuelle Mantelflaeche
     */
    @Override
    public String toString(){

        return  colours[sidesToRotate.get(axisIndex).get(0)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(1)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(2)] + ", "
                + colours[sidesToRotate.get(axisIndex).get(3)];

    }

}


