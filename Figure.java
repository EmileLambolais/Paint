import java.awt.*;

public abstract class Figure {

    public Color color;
    public Point origin;

    public Figure(Color c, Point p){ // Constructeur pour l'objet "Figure" avec un point
        this.color = c;
        this.origin = p;
    }

    public Figure(Color c){ // Constructeur pour l'objet "Figure" avec uniquement la couleur
        this.color = c;
    }

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);

    public Color getColor() {
        return color;
    }

    public Point getOrigin() {
        return origin;
    }

}



