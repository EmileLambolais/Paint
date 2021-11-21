import java.awt.*;

public class Rectangle extends Figure {

    public int width;
    public int height;
    public int heightBB;
    public int widthBB;

    /*************************************************/
    // Constructeur 1 : sans point d'origine
    public Rectangle(int px, int py, Color c){ // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1,1)); // Création de la figure calquée sur la class Figure
        setWidth(px);
        setHeight(py);
        this.setBoundingBox(px, py);
        this.color = c;
    }

    /*************************************************/
    // Constructeur 2 : avec point d'origine
    public Rectangle(int px, int py, Color c, Point p){ // Création du constructeur pour l'objet Rectangle
        super(c, p);
        setWidth(px);
        setHeight(py);
        this.origin = p;
        this.setBoundingBox(px, py);
        this.color = c;
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*************************************************/
    // Méthode d'affichage du rectangle
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(origin.getX(),origin.getY(),Math.abs(width),Math.abs(height)); // Affichage du rectangle avec comme paramètres ceux renseignés lors de la création du rectangle dans la class "Drawing"
    }
}
