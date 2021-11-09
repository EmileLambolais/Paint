import java.awt.*;

public abstract class Figure {

    protected Color color;
    public Point point;

    public Figure(Color c, Point p){ // Constructeur pour l'objet "Figure" avec un point
        this.color = c;
        this.point = p;
    }

    public Figure(Color c){ // Constructeur pour l'objet "Figure" avec uniquement la couleur
        this.color = c;
    }

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);

    public Color getColor() {
        return color;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "("+color+","+point+")";
    }
}



