
import java.awt.*;

/**
 *
 * @author Emile
 */
public class Circle extends Ellipse {

    /**
     * Constucteur 1 : Création d'un disque sans point d'origine
     *
     * @param rayon : rayon en pixels
     * @param c : couleur de l'intérieur du cercle
     */
    public Circle(int rayon, Color c) { // Constructeur du carré
        super(rayon, rayon, c);
    }

    /**
     * Constructeur 2 : Création d'un disque avec point d'origine
     *
     * @param rayon : rayon en pixels
     * @param c : couleur de la surface du disque
     * @param point : point d'origine en haut à gauche
     */
    public Circle(int rayon, Color c, Point point) { // Constructeur du carré avec un point d'origine
        super(rayon, rayon, c, point);
    }

    /**
     * Définit la bounding box du disque.
     *
     * @param heightBB
     * @param widthBB
     */
    public void setBoundingBox(int heightBB, int widthBB) {
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    /**
     * Méthode d'affichage du cercle
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

}
