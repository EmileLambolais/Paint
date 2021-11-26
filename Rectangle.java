
import java.awt.*;

/**
 * 
 * @author Emile
 */
public class Rectangle extends Figure {

    private int width;
    private int height;
    protected int heightBB; // protected car Carre en héritera
    protected int widthBB;

    /**
     * Constructeur 1 : sans point d'origine.
     *
     * @param width : largeur
     * @param height : hauteur
     * @param c : couleur de remplissage
     */
    public Rectangle(int width, int height, Color c) { // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1, 1)); // Création de la figure calquée sur la class Figure
        setWidth(width);
        setHeight(height);
        this.setBoundingBox(width, height);
        this.color = c;
    }

    /**
     * Constructeur 2 : avec point d'origine
     *
     * @param width : largeur
     * @param height : hauteur
     * @param c : couleur de remplissage
     * @param p : point d'origine en haut à gauche du rectangle
     */
    public Rectangle(int width, int height, Color c, Point p) { // Création du constructeur pour l'objet Rectangle
        super(c, p);
        setWidth(width);
        setHeight(height);
        this.origin = p;
        this.setBoundingBox(width, height);
        this.color = c;
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Méthode d'affichage du rectangle
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(origin.getX(), origin.getY(), Math.abs(width), Math.abs(height)); // Affichage du rectangle avec comme paramètres ceux renseignés lors de la création du rectangle dans la class "Drawing"
    }
}
