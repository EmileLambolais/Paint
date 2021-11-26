
import java.io.Serializable;

/**
 *
 * @author Emile
 */
public class Point implements Serializable {

    private int x;
    private int y;
    public static int totalNumberOfPoints;

    /**
     * Constructeur 1 : création d'un point de coodonnées x et y
     *
     * @param x entier
     * @param y entier
     */
    public Point(int x, int y) { // Création du constructeur qui va permettre de créer tous types de points
        setX(x);
        setY(y);
        totalNumberOfPoints++;
    }
    /**
     * Constructeur 2 : réinitailisation des coordonnées en (0,0)
     */
    public Point() { // Création du constructeur qui va permettre de créer tous types de points
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void getTotalNumberOfPoints() {
        System.out.println(totalNumberOfPoints);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
