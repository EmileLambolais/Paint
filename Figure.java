
import java.awt.*;
import java.io.Serializable;

/**
 *
 * @author Emile
 */
public abstract class Figure implements Serializable {

    protected Color color;
    protected Point origin;

    /**
     * Constructeur 1 : avec couleur et point d'origine
     *
     * @param c Couleur de la figure
     * @param p Point d'origine (en haut à gauche)
     */
    public Figure(Color c, Point p) {
        this.color = c;
        this.origin = p;
    }

    /**
     * Constructeur 2 : avec couleur
     *
     * @param c Couleur de la figure
     */
    public Figure(Color c) {
        this.color = c;
    }

    public abstract void setBoundingBox(int heightBB, int widthBB);

    public abstract void draw(Graphics g);

    public Color getColor() {
        return color;
    }

    public Point getOrigin() {
        return origin;
    }

}
