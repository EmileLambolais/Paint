import java.awt.*;

public class Ellipse extends Figure{
    public int length=0;
    public int width=0;
    public int heightBB=0;
    public int widthBB=0;
    public Figure figure = null;

    public Ellipse(int px, int py, Color c){ // Création du constructeur pour l'objet Rectangle
        super(c, new Point(1,1));
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px, py);
        this.draw(null);
    }

    public Ellipse(int px, int py, Color c, Point p){ // Création du constructeur pour l'objet Rectangle
        super(c, p);
        setSemiAxisX(px);
        setSemiAxisY(py);
        this.setBoundingBox(px, py);
        this.draw(null);
    }

    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = widthBB;
    }

    public void setSemiAxisX(int length) {
        this.length = length/2;
    }

    public void setSemiAxisY(int width) {
        this.width = width/2;
    }

    public void draw (Graphics g){

    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "("+length+","+width+")"+" et d'origine "+point;
    }
}
