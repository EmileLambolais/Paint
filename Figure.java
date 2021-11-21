import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {

    public Color color;
    public Point origin;

    /*************************************************/
    // Constructeur 1 : avec couleur et point d'origine
    public Figure(Color c, Point p){ 
        this.color = c;
        this.origin = p;
    }

    /*************************************************/
    // Constructeur 2 : avec couleur
    public Figure(Color c){ 
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