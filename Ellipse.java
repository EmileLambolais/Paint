import java.awt.*;

public class Ellipse extends Figure{
    public int width;
    public int height;
    public int heightBB=0;
    public int widthBB=0;


    /*************************************************/
    // Constructeur 1 : sans point d'origine
    public Ellipse(int px, int py, Color c){ // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1,1));
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px, py);
    }

    /*************************************************/
    // Constructeur 2 : avec point d'origine
    public Ellipse(int px, int py, Color c, Point p){ // Création du constructeur pour l'objet Rectangle
        super(c, p);
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.origin = p;
        this.setBoundingBox(px, py);
        this.color = c;
    }

    public void setBoundingBox (int widthBB, int heightBB){
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setSemiAxisX(int width) {
        this.width = width;
    }

    public void setSemiAxisY(int height) {
        this.height = height;
    }

    /*************************************************/
    // Méthode d'affichage de l'ellipse
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(origin.getX(),origin.getY(),Math.abs(width),Math.abs(height));
    }
}
