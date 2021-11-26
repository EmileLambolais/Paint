
import java.awt.*;

/**
 *
 * @author Emile
 */
public class Square extends Rectangle {

    /**
     * Constructeur 1 : sans point d'origine
     *
     * @param width : entier (largeur du carré)
     * @param c : couleur du carré
     */
    public Square(int width, Color c) { // Constructeur du carré
        super(width, width, c); // On réutilise le constructeur du rectangle, en mettant en argument uniquement les valeurs px afin de former un carré
    }

    /**
     * Constructeur 2 : avec point d'origine
     *
     * @param width : entier (largeur du carré)
     * @param c : couleur du carré
     * @param point : origine en haut à gauche
     */
    public Square(int width, Color c, Point point) { // Constructeur du carré avec un point en argument pour son origine
        super(width, width, c, point);
    }

    public void setBoundingBox(int widthBB, int heightBB) {
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    /**
     * Méthode d'affichage du carré
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
