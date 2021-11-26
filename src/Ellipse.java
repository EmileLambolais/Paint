
import java.awt.*;

/**
 *
 * @author Emile
 */
public class Ellipse extends Figure {

    private int width;
    private int height;
    protected int heightBB = 0; // protected car Cercle en héritera
    protected int widthBB = 0;

    /**
     * Constructeur 1 : sans point d'origine
     *
     * @param width : largeur de la zone contenant l'ellipse
     * @param height : hauteur de la zone contenant l'ellipse
     * @param c : couleur de l'intérieur de l'ellipse
     */
    public Ellipse(int width, int height, Color c) { // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1, 1));
        setSemiAxisX(width);
        setSemiAxisY(height);
        this.setBoundingBox(width, height);
    }

    /**
     * Constructeur 2 : avec point d'origine
     *
     * @param width : largeur de la zone contenant l'ellipse
     * @param height : hauteur de la zone contenant l'ellipse
     * @param c : couleur de l'intérieur de l'ellipse
     * @param p : point d'origine situé en haut à gauche de la figure
     */
    public Ellipse(int width, int height, Color c, Point p) { // Création du constructeur pour l'objet Rectangle
        super(c, p);
        setSemiAxisX(width);
        setSemiAxisY(height);
        this.origin = p;
        this.setBoundingBox(width, height);
        this.color = c;
    }

    public void setBoundingBox(int widthBB, int heightBB) {
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setSemiAxisX(int width) {
        this.width = width;
    }

    public void setSemiAxisY(int height) {
        this.height = height;
    }

    /**
     * Méthode d'affichage de l'ellipse
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.getX(), origin.getY(), Math.abs(width), Math.abs(height));
    }
}
