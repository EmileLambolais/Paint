import java.awt.*;

public class Circle extends Ellipse{
     
    public Circle(int px, Color c){ // Constructeur du carré
        super(px,px,c);
    }

    public Circle(int px, Color c, Point point){ // Constructeur du carré avec un point d'origine
        super(px,px,c,point);
    }
    
    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    @Override
    public String toString() {
        return "("+heightBB+","+widthBB+")"+"("+length+","+width+")"+" et d'origine "+point;
    }

}
