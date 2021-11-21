import java.awt.*;

public class Rectangle extends Figure {

    public int width;
    public int height;
    public int heightBB;
    public int widthBB;
    public Figure figure = null;

    public Rectangle(int px, int py, Color c){ // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1,1)); // Création de la figure calquée sur la class Figure
        setWidth(px);
        setHeight(py);
        this.setBoundingBox(px, py);
        this.color = c;
    }

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

    public int getWidth() {
        return width;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(origin.getX(),origin.getY(),Math.abs(width),Math.abs(height)); // Fonctionnement : Lors du relachement de la souris, on place l'origine au point "origine". De plus on définie la largeur et la hauteur en faisant l'abscisse du point fin - l'abscisse du point origine et de même pour les ordonnée.
    }
}
