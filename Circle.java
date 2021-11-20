import java.awt.*;

public class Circle extends Ellipse{
     
    public int px;

    public Circle(int px, Color c){ // Constructeur du carré
        super(px,px,c);
        this.px = px;
    }

    public Circle(int px, Color c, Point point){ // Constructeur du carré avec un point d'origine
        super(px,px,c,point);
        this.px = px;
    }
    
    public void setBoundingBox (int heightBB, int widthBB){
        this.heightBB = heightBB;
        this.widthBB = heightBB;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

}
